package com.prfs.microservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prfs.microservices.entities.Worker;
import com.prfs.microservices.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources { // API basica para rodar na web

	@Autowired
	private WorkerRepository wRepository;

	// Encapsula uma resposta http
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> wList = wRepository.findAll();
		return ResponseEntity.ok(wList);
	}

	@GetMapping(value = "/{id}")		 // Para reconhecer o id na requisição
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker oWorker = wRepository.findById(id).get(); // findByID retorna um Optional
		return ResponseEntity.ok(oWorker);
	}
}
