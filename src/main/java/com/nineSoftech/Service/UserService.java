package com.nineSoftech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nineSoftech.Entity.User;
import com.nineSoftech.Exception.DeleteApiException;
import com.nineSoftech.Exception.PostNotFoundException;
import com.nineSoftech.Repository.ManagementRepository;
import com.nineSoftech.Repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private  ManagementRepository managementRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElseThrow(() -> new PostNotFoundException("user not found with the given ID."));
	}

	public User createUser(User user) {
		if(user.getManagementId()!=null) {
			if(this.managementRepository.findById(user.getManagementId()).isPresent()) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				return userRepository.save(user);	
			}
		}
	return null;
	}

	public User updateUser(Long id, User updatedUser) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			existingUser.setFirstName(updatedUser.getFirstName());
			existingUser.setLastName(updatedUser.getLastName());
			return userRepository.save(existingUser);
		}
		return null; 
	}

	public void deleteUser(Long id) {
		
		try {
			Optional<User>optional = userRepository.findById(id);
			if(optional.isPresent()) {
				userRepository.deleteById(id);	
			}else {
				throw new PostNotFoundException("user not found with the given ID");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new DeleteApiException("Deleting failed");
		}
		
	}
}
