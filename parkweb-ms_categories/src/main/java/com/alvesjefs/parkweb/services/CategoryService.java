package com.alvesjefs.parkweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alvesjefs.parkweb.domain.Category;
import com.alvesjefs.parkweb.domain.dto.CategoryDTO;
import com.alvesjefs.parkweb.repositories.CategoryRepository;
import com.alvesjefs.parkweb.services.exceptions.IdNotFoundException;

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
		return new CategoryDTO(findName);
	}
}
