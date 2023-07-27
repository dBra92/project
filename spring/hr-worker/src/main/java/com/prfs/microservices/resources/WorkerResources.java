package com.prfs.microservices.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);

	@Autowired
	private WorkerRepository wRepository;

	@Autowired
	private Environment env;

	// Encapsula uma resposta http
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> wList = wRepository.findAll();
		return ResponseEntity.ok(wList);
	}

	@GetMapping(value = "/{id}") // Para reconhecer o id na requisição
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		// N º da porta que irá rodar
		logger.info("PORT = " + env.getProperty("local.server.port"));

		Worker oWorker = wRepository.findById(id).get(); // findByID retorna um Optional
		return ResponseEntity.ok(oWorker);
	}
}
