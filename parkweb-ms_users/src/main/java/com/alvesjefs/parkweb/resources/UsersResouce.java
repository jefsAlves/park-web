package com.alvesjefs.parkweb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.parkweb.dto.UsersDTO;
import com.alvesjefs.parkweb.services.UsersService;

@RestController
@RequestMapping(value = "api/users")
public class UsersResouce {

	@Autowired
	private UsersService usersService;

	@GetMapping(value = "/searchEmail")
	public ResponseEntity<UsersDTO> findByEmail(@RequestParam String email) {
		UsersDTO findEmail = usersService.findByEmail(email);
		return ResponseEntity.ok().body(findEmail);
	}
}
