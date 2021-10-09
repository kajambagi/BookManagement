package com.demo.book.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book.entity.OrderDetails;
import com.demo.book.exception.OrderDetailsNotFoundException;
import com.demo.book.service.IOrderDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderDetailsController {
	@Autowired
	IOrderDetailsService orderDetailsService;
	
	// get all orderDetails
	@GetMapping("/orderdetails")
	ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
		return new ResponseEntity<>(orderDetailsService.getAllOrderDetails(), HttpStatus.OK); // 200 Ok
	}

	// Get orderDetails by orderDetailsId - GET
	@GetMapping("/orderdetails/orderDetailId/{orderDetailId}")
	ResponseEntity<OrderDetails>getOrderDetailsByOrderDetailId(@PathVariable("orderDetailId") int orderDetailId)
			throws OrderDetailsNotFoundException {
		OrderDetails od = orderDetailsService.getOrderDetailsByOrderDetailId(orderDetailId);
		return new ResponseEntity<>(od, HttpStatus.OK); // 200 Ok

	}

	// Add new orderDetails - POST
	@PostMapping("/orderdetails")
	ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {
		OrderDetails od = orderDetailsService.addOrderDetails(orderDetails);
		return new ResponseEntity<>(od, HttpStatus.CREATED); // 201 created
	}

	// Delete orderDetails by quantity - DELETE
	@DeleteMapping("/orderdetails/{orderDetailId}")
	ResponseEntity<OrderDetails> deleteOrderDetailsByOrderDetailId(@PathVariable("orderDetailId") int orderDetailId) {
		OrderDetails od = orderDetailsService.deleteOrderDetailsByOrderDetailId(orderDetailId);
		return new ResponseEntity<>(od, HttpStatus.OK);
	}

	// Delete orderDetails by name
	@DeleteMapping("/orderdetails/delete/{orderDetailId}")
	ResponseEntity<Void> deleteOrderDetails(@PathVariable("orderDetailId") int orderDetailId) throws OrderDetailsNotFoundException {
		OrderDetails od=orderDetailsService.getOrderDetailsByOrderDetailId((orderDetailId));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Update orderDetails - PUT
	@PutMapping("/orderdetails")
	ResponseEntity<OrderDetails> updateOrderDetails(
			@RequestBody OrderDetails orderDetails) {
		OrderDetails od = orderDetailsService.addOrderDetails(orderDetails);
		return new ResponseEntity<>(od, HttpStatus.OK);
	}

	// update  orderDetails - PATCH
	@PatchMapping("/orderdetails/{orderDetailId}")
	ResponseEntity<OrderDetails> updateOrderDetailsOrderDetailId(@PathVariable("orderDetailId") int orderDetailId,
			@RequestBody OrderDetails orderDetails) {
		OrderDetails od = orderDetailsService.updateOrderDetails(orderDetailId, orderDetails);
		return new ResponseEntity<>(od, HttpStatus.OK);
	}

}
