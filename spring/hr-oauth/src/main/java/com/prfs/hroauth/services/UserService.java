package com.prfs.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prfs.hroauth.entities.User;
import com.prfs.hroauth.feignclient.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = uFeignClient.findByEmail(username).getBody();
		if (user == null) {
			log.error("1 - email not found:" + username);
			throw new UsernameNotFoundException("2 - Email not found");
		}
		log.info("Email found:" + username);
		return user;
	}
}
