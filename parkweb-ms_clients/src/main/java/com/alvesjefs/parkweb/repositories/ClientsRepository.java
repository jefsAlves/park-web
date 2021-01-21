package com.alvesjefs.parkweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.parkweb.domain.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

	Clients findByName(String name);
}
