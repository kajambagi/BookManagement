package com.demo.book.service;

import java.util.List;

import com.demo.book.entity.OrderDetails;

import com.demo.book.exception.OrderDetailsNotFoundException;

public interface IOrderDetailsService {

	List<OrderDetails> getAllOrderDetails();
	
	OrderDetails getOrderDetailsByOrderDetailId(int OrderDetailId) throws OrderDetailsNotFoundException;

	OrderDetails addOrderDetails(OrderDetails orderDetails);
	
	OrderDetails updateOrderDetails(int orderId,OrderDetails orderDetails );


		OrderDetails deleteOrderDetailsByOrderDetailId(int orderDetailId);
		
}
