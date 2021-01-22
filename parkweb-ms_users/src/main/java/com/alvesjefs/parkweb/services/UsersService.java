package com.alvesjefs.parkweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvesjefs.parkweb.domain.Users;
import com.alvesjefs.parkweb.repositories.UsersRepository;
import com.alvesjefs.parkweb.services.exceptions.EmailNotFoundException;
import com.alvesjefs.parkweb.services.exceptions.IdNotFoundException;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Transactional(readOnly = true)
	public Users findById(Long id) {
		Optional<Users> findId = usersRepository.findById(id);
		return findId.orElseThrow(() -> new IdNotFoundException("Id not found!"));
	}

	@Transactional(readOnly = true)
	public Users findByEmail(String email) {
		Users findEmail = usersRepository.findByEmail(email);
		if (findEmail == null) {
			throw new EmailNotFoundException("Email not found!");
		}
		return findEmail;
	}
}
