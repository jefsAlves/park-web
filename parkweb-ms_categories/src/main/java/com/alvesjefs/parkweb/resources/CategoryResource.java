package com.alvesjefs.parkweb.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alvesjefs.parkweb.domain.Category;
import com.alvesjefs.parkweb.domain.dto.CategoryDTO;
import com.alvesjefs.parkweb.services.CategoryService;

@RestController
@RequestMapping(value = "api/categories")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category findId = categoryService.findById(id);
		return ResponseEntity.ok().body(findId);
	}

	@GetMapping(value = "/searchPage")
	public ResponseEntity<Page<CategoryDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		Page<CategoryDTO> findPage = categoryService.findAll(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(findPage);
	}

	@GetMapping(value = "/searchName")
	public ResponseEntity<CategoryDTO> findByName(@RequestParam String name) {
		CategoryDTO findName = categoryService.findName(name);
		return ResponseEntity.ok().body(findName);
	}

	@PostMapping
	public ResponseEntity<CategoryDTO> insertCategory(@RequestBody CategoryDTO categoryDTO) {
		CategoryDTO insertCategory = categoryService.insertCategory(categoryDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoryDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(insertCategory);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
		CategoryDTO updateCategory = categoryService.updateCategory(id, categoryDTO);
		return ResponseEntity.ok().body(updateCategory);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}
