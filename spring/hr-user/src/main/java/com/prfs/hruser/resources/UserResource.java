package com.prfs.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prfs.hruser.entities.User;
import com.prfs.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserRepository uRepository;

	@Autowired
	private Environment env;

	@GetMapping(value = "/{id}") // Para reconhecer o id na requisição
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User oWorker = uRepository.findById(id).get(); // findByID retorna um Optional
		return ResponseEntity.ok(oWorker);
	}
	

	@GetMapping(value = "/search") 
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User user = uRepository.findByEmail(email);
		return ResponseEntity.ok(user);
	}
}
