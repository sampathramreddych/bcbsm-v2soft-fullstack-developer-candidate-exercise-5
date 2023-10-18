package com.bcbsm.mail.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bcbsm.mail.repository.UserRepository;

@Service
public class BcbsUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BcbsUserDetails user = userRepository.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found" + username);
		}
		return user;
	}

}
