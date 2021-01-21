package com.alvesjefs.parkweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvesjefs.parkweb.domain.Clients;
import com.alvesjefs.parkweb.domain.Products;
import com.alvesjefs.parkweb.dto.ClientsDTO;
import com.alvesjefs.parkweb.dto.ProductsDTO;
import com.alvesjefs.parkweb.repositories.ClientsRepository;
import com.alvesjefs.parkweb.repositories.ProductsRepository;
import com.alvesjefs.parkweb.services.exceptions.IdNotFoundException;
import com.alvesjefs.parkweb.services.exceptions.NameNotFoundExceptions;

@Service
public class ClientsService {

	@Autowired
	private ClientsRepository clientsRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Transactional(readOnly = true)
	public Clients findById(Long id) {
		Optional<Clients> findId = clientsRepository.findById(id);
		return findId.orElseThrow(() -> new IdNotFoundException("Id not found!"));
	}

	@Transactional(readOnly = true)
	public ClientsDTO findByName(String name) {
		Clients findName = clientsRepository.findByName(name);
		if (findName == null) {
			throw new NameNotFoundExceptions("Name not found!");
		}
		return new ClientsDTO(findName);
	}

	@Transactional(readOnly = true)
	public Page<ClientsDTO> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Clients> findPage = clientsRepository.findAll(pageRequest);
		return findPage.map(x -> new ClientsDTO(x));
	}

	@Transactional
	public ClientsDTO insertClients(ClientsDTO clientsDTO) {
		Clients clients = new Clients(null, clientsDTO.getName(), clientsDTO.getCpf(), clientsDTO.getIncomeMouth(),
				clientsDTO.getBirthDate(), clientsDTO.getChildren());
		for (ProductsDTO prod : clientsDTO.getProducts()) {
			Products products = productsRepository.getOne(prod.getId());
			clients.getProducts().add(products);
		}

		clients = clientsRepository.save(clients);
		return new ClientsDTO(clients);
	}

	@Transactional
	public ClientsDTO updateClientIncomeMouth(Long id, ClientsDTO clientsDTO) {
		Clients client = clientsRepository.getOne(id);
		client.setIncomeMouth(clientsDTO.getIncomeMouth());
		client = clientsRepository.save(client);
		return new ClientsDTO(client);
	}

	@Transactional
	public ClientsDTO updateClientName(Long id, ClientsDTO clientsDTO) {
		Clients client = clientsRepository.getOne(id);
		client.setName(clientsDTO.getName());
		client = clientsRepository.save(client);
		return new ClientsDTO(client);
	}

	public void deleteClients(Long id) {
		try {
			clientsRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new IdNotFoundException("Id not found!");
		}
	}

}
