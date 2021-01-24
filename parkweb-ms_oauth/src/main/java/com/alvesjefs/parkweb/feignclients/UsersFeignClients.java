package com.alvesjefs.parkweb.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alvesjefs.parkweb.dto.UsersDTO;

@FeignClient(name = "ms-users", path = "api/users")
@Component
public interface UsersFeignClients {

	@GetMapping(value = "/searchEmail")
	ResponseEntity<UsersDTO> findByEmail(@RequestParam String email);
}
