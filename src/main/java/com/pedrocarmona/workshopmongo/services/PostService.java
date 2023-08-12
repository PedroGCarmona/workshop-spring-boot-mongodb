package com.pedrocarmona.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrocarmona.workshopmongo.domain.Post;
import com.pedrocarmona.workshopmongo.repository.PostRepository;
import com.pedrocarmona.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> PostOptional = Optional.ofNullable(repo.findById(id).orElse(null));
		Post Post = null;
		try {
			Post = PostOptional.get();
		} catch (Exception e) {
			throw new ObjectNotFoundException("Object not found");
		}
		return Post;
	}
}
