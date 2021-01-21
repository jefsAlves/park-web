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

import com.alvesjefs.parkweb.domain.Clients;
import com.alvesjefs.parkweb.dto.ClientsDTO;
import com.alvesjefs.parkweb.services.ClientsService;

@RestController
@RequestMapping(value = "api/clients")
public class ClientsResource {

	@Autowired
	private ClientsService clientsService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Clients> findById(@PathVariable Long id) {
		Clients findId = clientsService.findById(id);
		return ResponseEntity.ok().body(findId);
	}

	@GetMapping(value = "/searchName")
	public ResponseEntity<ClientsDTO> findByName(@RequestParam String name) {
		ClientsDTO findName = clientsService.findByName(name);
		return ResponseEntity.ok().body(findName);
	}

	@GetMapping(value = "/searchPage")
	public ResponseEntity<Page<ClientsDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		Page<ClientsDTO> findPage = clientsService.findPage(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(findPage);
	}

	@PostMapping(value = "/insertClient")
	public ResponseEntity<ClientsDTO> insertClient(@RequestBody ClientsDTO clientsDTO) {
		ClientsDTO insertClient = clientsService.insertClients(clientsDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(clientsDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(insertClient);
	}

	@PutMapping(value = "/updateIncomeMouth/{id}")
	public ResponseEntity<ClientsDTO> updateClientIncomeMouth(@PathVariable Long id,
			@RequestBody ClientsDTO clientsDTO) {
		ClientsDTO updateClient = clientsService.updateClientIncomeMouth(id, clientsDTO);
		return ResponseEntity.ok().body(updateClient);
	}

	@PutMapping(value = "/updateName/{id}")
	public ResponseEntity<ClientsDTO> updateClientName(@PathVariable Long id, @RequestBody ClientsDTO clientsDTO) {
		ClientsDTO updateClient = clientsService.updateClientName(id, clientsDTO);
		return ResponseEntity.ok().body(updateClient);
	}

	@DeleteMapping(value = "/deleted/{id}")
	public ResponseEntity<ClientsDTO> deleteClient(@PathVariable Long id) {
		clientsService.deleteClients(id);
		return ResponseEntity.noContent().build();
	}
}
