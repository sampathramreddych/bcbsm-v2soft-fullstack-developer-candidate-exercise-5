package com.bcbsm.mail.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bcbsm.mail.model.UserModel;
import com.bcbsm.mail.repository.UserRepository;
import com.bcbsm.mail.security.BcbsUserDetails;
import com.bcbsm.mail.security.UserRole;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * This loads the user from repository.
	 */
	@Override
	public UserModel getUser(String name) {
		BcbsUserDetails objBcbsUserDetails = userRepository.findUserByUsername(name);

		if (objBcbsUserDetails != null) {
			return new UserModel(objBcbsUserDetails.getUsername(), objBcbsUserDetails.getUserFirstName(),
					objBcbsUserDetails.getUserLastName(),
					objBcbsUserDetails.getUserRoles().stream().map(role -> role.name()).collect(Collectors.toSet()));
		} else {
			return null;
		}
	}

	/**
	 * This creates the new user in the repository.
	 */
	@Override
	public String addUser(UserModel user) {

		Set<UserRole> userRoles = new HashSet<>();

		for (String role : user.getRoles()) {
			if (role.equals(UserRole.ROLE_ADMIN.name())) {
				userRoles.add(UserRole.ROLE_ADMIN);
			} else {
				userRoles.add(UserRole.ROLE_USER);
			}
		}

		BcbsUserDetails newUser = new BcbsUserDetails(user.getUsername(),
				passwordEncoder.encode(user.getPassword()),
				userRoles,
				user.getFirstName(), user.getLastName());
		userRepository.save(newUser);

		return user.getUsername();
	}

}
