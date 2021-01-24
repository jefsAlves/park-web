package com.alvesjefs.parkweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.parkweb.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);
}
