package com.alvesjefs.parkweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alvesjefs.parkweb.domain.Users;
import com.alvesjefs.parkweb.dto.UsersDTO;
import com.alvesjefs.parkweb.feignclients.UsersFeignClients;
import com.alvesjefs.parkweb.services.exceptions.EmailNotFoundException;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	private UsersFeignClients usersFeignClients;

	public UsersDTO findByEmail(String email) {
		UsersDTO findEmail = usersFeignClients.findByEmail(email).getBody();
		if (findEmail == null) {
			throw new EmailNotFoundException("Email not found!");
		}
		return findEmail;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersDTO findEmail = usersFeignClients.findByEmail(username).getBody();
		if (findEmail == null) {
			throw new UsernameNotFoundException("Email not found!");
		}
		return new Users(findEmail);
	}

}
