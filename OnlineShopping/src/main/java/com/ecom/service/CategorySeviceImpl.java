package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ecom.beans.Category;
import com.ecom.repository.CategoryRepository;

@Service
public class CategorySeviceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		
		return this.categoryRepository.findAll();
	}

	@Override
	public boolean deleteCategory(int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		if(!ObjectUtils.isEmpty(category)) {
			categoryRepository.delete(category);
			return true;
			
		}
		return false;
	}

	@Override
	public Category getyCategoryById(int id) {
		Category category = this.categoryRepository.findById(id).orElse(null);
		return category;
	}

	@Override
	public boolean existCategory(String name) {
		boolean existByName1 = this.categoryRepository.existsByName(name);
		return existByName1;
	}

	@Override
	public List<Category> getAllActiveCategory() {
		List<Category> categories = categoryRepository.findByIsActiveTrue();
		return categories;
		
	}

}
