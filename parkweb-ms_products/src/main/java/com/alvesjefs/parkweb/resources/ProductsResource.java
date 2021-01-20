package com.alvesjefs.parkweb.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alvesjefs.parkweb.domain.Products;
import com.alvesjefs.parkweb.dto.ProductsDTO;
import com.alvesjefs.parkweb.services.ProductsService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductsResource {

	@Autowired
	private ProductsService productsService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Products> findById(@PathVariable Long id) {
		Products findId = productsService.findById(id);
		return ResponseEntity.ok().body(findId);
	}

	@GetMapping(value = "/searchPage")
	public ResponseEntity<Page<ProductsDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		Page<ProductsDTO> findPage = productsService.findPage(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(findPage);
	}

	@PostMapping(value = "/insertProduct")
	public ResponseEntity<ProductsDTO> insertProduct(@RequestBody ProductsDTO productsDTO) {
		ProductsDTO insertProduct = productsService.insertProduct(productsDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productsDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(insertProduct);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ProductsDTO> updateProduct(@PathVariable Long id, @RequestBody ProductsDTO productsDTO) {
		ProductsDTO updateProduct = productsService.updateProducts(id, productsDTO);
		return ResponseEntity.ok().body(updateProduct);
	}

	@DeleteMapping(value = "/deleted/{id}")
	public ResponseEntity<ProductsDTO> deleteProduct(@PathVariable Long id) {
		productsService.deleteProducts(id);
		return ResponseEntity.noContent().build();
	}

}
