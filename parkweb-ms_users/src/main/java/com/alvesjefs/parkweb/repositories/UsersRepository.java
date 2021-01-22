package com.alvesjefs.parkweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.parkweb.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String name);
}
