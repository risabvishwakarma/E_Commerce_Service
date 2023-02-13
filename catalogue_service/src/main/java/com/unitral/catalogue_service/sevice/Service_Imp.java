package com.unitral.catalogue_service.sevice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.unitral.catalogue_service.dao.Products;
import com.unitral.catalogue_service.repository.CatalogueRepository;
import com.unitral.catalogue_service.repository.ProxyInterface;

@org.springframework.stereotype.Service
public class Service_Imp implements Service {
	boolean b = true;
	final int Max_QAUNTITY = 10;
	@Autowired
	private CatalogueRepository crepo;

	@Autowired
	private ProxyInterface proxyorder;

	@Override
	public List<Products> getProducts() {
		if (b) {
			f();
			b = false;
		}

		return crepo.findAll();
	}

	void f() {

//		crepo.save(new Products("1",452,1));
//		crepo.save(new Products("2",453,9));
//		crepo.save(new Products("3",454,4));
		// crepo.save(new Products("4",R115,5));

	}

	@Override
	public Products addProducts(Products newProduct) {
		if(newProduct.getProductQuantity()<0)return null;
		newProduct.setMapId((""+newProduct.getUserId() + newProduct.getId()).trim());

		if (crepo.existsById(newProduct.getMapId()))
			return updateProducts(newProduct);
		
		newProduct.setProductQuantity(Math.min(proxyorder.getAvialableQuantity(newProduct.getId()),
				Math.min(Max_QAUNTITY, newProduct.getProductQuantity())));
		return crepo.save(newProduct);

	}

	@Override
	public Products updateProducts(Products newProduct) {
		newProduct.setMapId((""+newProduct.getUserId() + newProduct.getId()).trim());
		if(newProduct.getProductQuantity()<=0 && crepo.existsById((""+newProduct.getUserId() + newProduct.getId()).trim())) {
			crepo.deleteById(newProduct.getMapId());return null;}
		
		return crepo.findById(newProduct.getMapId()).map(savedProduct -> {
			savedProduct.setProductQuantity(Math.min(proxyorder.getAvialableQuantity(newProduct.getId()),
					Math.min(Max_QAUNTITY, newProduct.getProductQuantity())));
			return crepo.save(savedProduct);
		}).orElseGet(() -> {
			return addProducts(newProduct);

		});
	}

	@Override
	public void deleteProducts(String id) {

		if (!crepo.existsById(id))
			return;
		crepo.deleteById(id);

	}

	@Override
	public List<Products> getProductsById(String userId) {

		return crepo.findByUserId(userId);
	}

	@Override
	public List<Products> getProductsByUserId(String userId) {

		return crepo.findByUserId(userId);
	}

}
