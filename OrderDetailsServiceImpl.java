package com.demo.book.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.book.dao.IOrderDetailsDao;
import com.demo.book.entity.Book;
import com.demo.book.entity.OrderDetails;
import com.demo.book.exception.OrderDetailsFoundException;
import com.demo.book.exception.OrderDetailsNotFoundException;


@Service
public  class OrderDetailsServiceImpl implements IOrderDetailsService {
	@Autowired
	IOrderDetailsDao orderDetailsDao;
	private int orderDetailId;

	@Override
	public List<OrderDetails> getAllOrderDetails() {
		return orderDetailsDao.findAll();	
		}

	public Object getOrderDetailsByQuantity(int orderDetailId) throws OrderDetailsNotFoundException {
		Optional<Object> od = Optional.of(orderDetailsDao.findById(orderDetailId));
		if(!od.isPresent()) {
			throw new OrderDetailsNotFoundException("OrderDetails not found with given orderDetailId "+orderDetailId);
		}
		return od.get();
	}

	@Override
	public OrderDetails addOrderDetails(OrderDetails orderDetails) {
		return orderDetailsDao.save(orderDetails);
	}

	@Override
	public OrderDetails deleteOrderDetailsByOrderDetailId(int orderDetailId) {
		OrderDetails od = orderDetailsDao.findById(orderDetailId).get();
		orderDetailsDao.deleteById(orderDetailId);
		return od;
	}

	@Override
	public OrderDetails updateOrderDetails(int orderDetailId, OrderDetails orderDetails) {
		OrderDetails od = orderDetailsDao.findById(orderDetailId).get();
		od.setQuantity(orderDetails.getQuantity());
		return orderDetailsDao.save(od);
	}

	@Override
	public OrderDetails getOrderDetailsByOrderDetailId(int OrderDetailId) throws OrderDetailsNotFoundException {
		return null;
	}


}
	
