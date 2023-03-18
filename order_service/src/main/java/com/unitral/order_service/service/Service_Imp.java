package com.unitral.order_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.unitral.order_service.repositories.Proxynotification;
import com.unitral.order_service.dao.Product;
import com.unitral.order_service.repositories.Order_Repository;
import com.unitral.order_service.repositories.ProxtyUser;
import com.unitral.order_service.repositories.ProxyCart;
import com.unitral.order_service.repositories.ProxyPayment;

@org.springframework.stereotype.Service
public class Service_Imp implements Service {
	boolean b = true;

	@Autowired
	private Order_Repository orepo;

	@Autowired
	private ProxtyUser proxuser;

	@Autowired
	private ProxyCart proxycatalogue;

	@Autowired
	private ProxyPayment proxypayment;

	@Autowired
	private Proxynotification proxynotification;

	public Service_Imp() {

	}

	@Override
	public List<Product> getAll() {
		if (b) {
			f();
			b = false;
		}

		return orepo.findAll();
	}

	@Override
	public Product updateProduct(@RequestBody Product newProduct) {

		return orepo.findById(newProduct.getId()).map(dbProduct -> {
			dbProduct.setProductAvQuantity(newProduct.getProductAvQuantity());
			dbProduct.setProductPrice(newProduct.getProductPrice());
			return orepo.save(dbProduct);
		}).orElseGet(() -> {
			return addProduct(newProduct);
		});

	}

	@Override
	public Product addProduct(Product newProduct) {

		Product product = orepo.findByProductNameAndSellerId(newProduct.getProductName(), newProduct.getSellerId());
		// System.out.println(product==null?"NULL":product.getProductName());
		return product == null ? orepo.save(newProduct) : product;

	}

	@Override
	public void deleteProduct(int deleteId) {
		if (!orepo.existsById(deleteId))
			return;
		orepo.deleteById(deleteId);

	}

	void f() {
//		orepo.save(new Product("R112","Physics",100,45,"Study",1));
//		orepo.save(new Product("R113","Led",105,25,"Electric",5));
//		orepo.save(new Product("R114","Pen",160,457,"Study",2));
//		orepo.save(new Product("R115","Clothes",190,450,"Others",9));
	}

	// find product by product id
	@Override
	public List<Product> getCat(List<String> ls) {
		if (b) {
			f();
			b = false;
		}
		List<Product> prodls = new ArrayList<>();
		ls.forEach(prodId -> {
			Optional<Product> p = orepo.findById(Integer.parseInt(prodId));
			if (p.isPresent())
				prodls.add(p.get());
		});

		return prodls;
	}

	@Override
	public String checkoutWithUserId(int userId) {
		int TotalPrice = 0;
		String mailId = proxuser.isThereUserPresent(userId);
		if (mailId.equals("NO"))
			return "wrong User";
		System.out.println(mailId);
		if (mailId.length() < 1)
			return "Nothing";
		// 0-product ID
		// 1-product Quantity

		Map<Integer, Integer> mp = proxycatalogue.getProducts(userId);
		List<Product> productsList = new ArrayList<>();
		if(mp.isEmpty())return "Please put the  Products in cart";

		for (Map.Entry<Integer, Integer> entity : mp.entrySet()) {
			productsList.add(orepo.findById(entity.getKey()).get());
			if (entity.getValue() > getQuantityByProductId(entity.getKey()))
				return "Quantity Issue : Seller has only " + getQuantityByProductId(entity.getKey()) + " "
						+ productsList.get(productsList.size() - 1).getProductName();
			TotalPrice += (productsList.get(productsList.size() - 1).getProductPrice()) * entity.getValue();
		}

		int paymentid = proxypayment.makepayment(mailId + ";" + TotalPrice);

		if (paymentid != -1) {
			Runnable myThread = () -> updationAfterOrderSucessfull(productsList, mp,userId);
			Thread run = new Thread(myThread);
			run.start();

			proxynotification.notify(mailId + ";" + "Order Sucessful" + ";" + "payment id =" + paymentid + "\n"
					+ printProducts(productsList, mp) + "\n\t\t\t" + TotalPrice);
			return "Done" + " " + paymentid;
		}

		return "Failed" + " " + paymentid;

	}

	private void updationAfterOrderSucessfull(List<Product> productsList, Map<Integer, Integer> mp,int userId) {

		Runnable myThread = () -> proxycatalogue.deleteUserCatalogue(userId);
		Thread run = new Thread(myThread);
		run.start();

		productsList.forEach(product -> {
			product.setProductAvQuantity(
					orepo.findById(product.getId()).get().getProductAvQuantity() - mp.get(product.getId()));
			updateProduct(product);
		});

	}

	private String printProducts(List<Product> productList, Map<Integer, Integer> mp) {
		String st = "";
		for (Product prod : productList) {
			st += (prod.getProductName() + " " + mp.get(prod.getId()) + " " + prod.getProductPrice() + " = "
					+ (prod.getProductPrice() * mp.get(prod.getId()))) + "\n";
		}
		return st;
	}

	@Override
	public int getQuantityByProductId(int productId) {

		Optional<Product> prod = orepo.findById(productId);
		if (prod.isEmpty())
			return 0;
		return prod.get().getProductPrice();

	}

}
