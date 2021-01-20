package com.alvesjefs.parkweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alvesjefs.parkweb.domain.Category;
import com.alvesjefs.parkweb.domain.dto.CategoryDTO;
import com.alvesjefs.parkweb.repositories.CategoryRepository;
import com.alvesjefs.parkweb.services.exceptions.CannotBeDelete;
import com.alvesjefs.parkweb.services.exceptions.IdNotFoundException;
import com.alvesjefs.parkweb.services.exceptions.NameNotFoundExceptions;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category findById(Long id) {
		Optional<Category> findId = categoryRepository.findById(id);
		return findId.orElseThrow(() -> new IdNotFoundException("Id not found!"));
	}

	public Page<CategoryDTO> findAll(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Category> findPage = categoryRepository.findAll(pageRequest);
		return findPage.map(x -> new CategoryDTO(x));
	}

	public CategoryDTO findName(String name) {
		Category findName = categoryRepository.findByName(name);
		if (findName == null) {
			throw new NameNotFoundExceptions("Name not found!");
		}
		return new CategoryDTO(findName);
	}

	public CategoryDTO insertCategory(CategoryDTO categoryDTO) {
		Category category = new Category(null, categoryDTO.getName());
		category = categoryRepository.save(category);
		return new CategoryDTO(category);
	}

	public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
		Category category = categoryRepository.getOne(id);
		category.setName(categoryDTO.getName());
		category = categoryRepository.save(category);
		return new CategoryDTO(category);
	}

	public void deleteCategory(Long id) {
		try {
			categoryRepository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new IdNotFoundException("Category not found!");
		}
		catch (DataIntegrityViolationException e) {
			throw new CannotBeDelete("IntegrityViolation");
		}
	}
}
