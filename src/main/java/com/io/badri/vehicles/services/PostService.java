package com.io.badri.vehicles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.badri.vehicles.models.Post;
import com.io.badri.vehicles.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	//get all posts
	public List<Post> getPosts() {
		return postRepository.findAll(); 
	}

	//save new post to the database
	public void addPost(Post post) {
		postRepository.save(post);
	}
	
	//get post by id
	public Optional<Post> getPostById(int id) {
     //System.out.println("post from postservice  " + postRepository.findById(id));

		return postRepository.findById(id);
	}

	public void deletePost(int postId) {
	     System.out.println("post from postservice  " + postRepository.findById(postId));

		postRepository.deleteById(postId);
	}
}
