package com.alvesjefs.parkweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvesjefs.parkweb.domain.Users;
import com.alvesjefs.parkweb.dto.UsersDTO;
import com.alvesjefs.parkweb.repository.UsersRepository;
import com.alvesjefs.parkweb.services.exceptions.EmailNotFoundException;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Transactional(readOnly = true)
	public UsersDTO findByEmail(String email) {
		Users findEmail = usersRepository.findByEmail(email);
		if (findEmail == null) {
			throw new EmailNotFoundException("Email not found!");
		}
		return new UsersDTO(findEmail);
	}
}
