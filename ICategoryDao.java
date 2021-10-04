package com.demo.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.book.entity.Category;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {

	void deleteByCategoryName(String categoryName);

}	

