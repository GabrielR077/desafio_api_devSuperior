package com.desafioAPI.rdstack.repositories;

import com.desafioAPI.rdstack.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
