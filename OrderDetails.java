package com.demo.book.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="orderDetails")
public class OrderDetails {
@Id
@GeneratedValue
private int orderDetailId;
private int quantity;
private double subTotal;
 
@JsonIgnore
 @OneToOne(mappedBy="orderDetails",cascade=CascadeType.ALL)
 BookOrder bookOrder;
 
 @JsonIgnore
	@OneToOne(mappedBy="orderDetails",cascade=CascadeType.ALL)
	Book book;
 
 
 public int getOrderDetailId() {
	return orderDetailId;
}


public void setOrderDetailId(int orderDetailId) {
	this.orderDetailId = orderDetailId;
}


public BookOrder getBookOrder() {
	return bookOrder;
}


public void setBookOrder(BookOrder bookOrder) {
	this.bookOrder = bookOrder;
}


public Book getBook() {
	return book;
}


public void setBook(Book book) {
	this.book = book;
}


public  int getQuantity() {
	return quantity;
}


public double getSubTotal() {
	return subTotal;
}

public void setSubTotal(double subTotal) {
	this.subTotal = subTotal;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


@Override
public String toString() {
	return "OrderDetails [orderDetailId=" + orderDetailId + ", quantity=" + quantity + ", subTotal=" + subTotal
			+ ", bookOrder=" + bookOrder + ", book=" + book + ", getOrderDetailId()=" + getOrderDetailId()
			+ ", getBookOrder()=" + getBookOrder() + ", getBook()=" + getBook() + ", getQuantity()=" + getQuantity()
			+ ", getSubTotal()=" + getSubTotal() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}

}


