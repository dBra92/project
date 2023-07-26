package com.prfs.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prfs.microservices.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{ // Acesso ao banco de dados

}
