package com.pedrocarmona.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrocarmona.workshopmongo.domain.User;
import com.pedrocarmona.workshopmongo.dto.UserDTO;
import com.pedrocarmona.workshopmongo.repository.UserRepository;
import com.pedrocarmona.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> userOptional = Optional.ofNullable(repo.findById(id).orElse(null));
		User user = null;
		try {
			user = userOptional.get();
		} catch (Exception e) {
			throw new ObjectNotFoundException("Object not found");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
