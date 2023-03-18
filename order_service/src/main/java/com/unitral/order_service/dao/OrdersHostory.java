package com.unitral.order_service.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class OrdersHostory {

    @Id
    int OrderId;
    int paymentId;
    int OrderQuantity;
    int ProductId;
    int orderStatus;
}
