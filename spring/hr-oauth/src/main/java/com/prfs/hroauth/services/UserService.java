package com.prfs.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prfs.hroauth.entities.User;
import com.prfs.hroauth.feignclient.UserFeignClient;

@Service
public class UserService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient uFeignClient;

	public User findByEmail(String email) {
		User user = uFeignClient.findByEmail(email).getBody();
		if (user == null) {
			log.error("1 - email not found:" + email);
			throw new IllegalArgumentException("2 - Email not found");
		}
		log.info("Email found" + email);
		return user;
	}
}
