package com.io.badri.vehicles.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.io.badri.vehicles.models.Country;
import com.io.badri.vehicles.models.Post;
import com.io.badri.vehicles.services.CountryService;
import com.io.badri.vehicles.services.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private CountryService countryService;

	@GetMapping("/posts")
	public String getPosts(Model model) {
		List<Post> postList = postService.getPosts();

		model.addAttribute("posts", postList);
		return "Post";
	}

	@GetMapping("/posts/showFormForAdd")
	public String showFormForAdd(Model model) {

		List<Country> countryList = countryService.getCountries();

		model.addAttribute("countries", countryList);

		Post post = new Post();
		model.addAttribute("post", post);

		return "forms/PostForm";
	}

	@PostMapping("/posts/addNew")
	// post is in th:object =
	public String addPost(@ModelAttribute("post") Post post, Model model) {
		postService.addPost(post);
		// redirect to the list and prevent duplicate submission.
		return "redirect:/posts";
	}

	@GetMapping("/posts/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("postId") int postId, Model model) {
		// get the post for that post id
		// System.out.println("update" + postId);
		Optional<Post> post = postService.getPostById(postId);

		// set post as model to pre-populate the form
		model.addAttribute("post", post);

		// has to populate country select drop down.
		model.addAttribute("countries", countryService.getCountries());

		// send to form
		return "forms/PostForm";
	}

	@GetMapping("/posts/deletePost")
	public String deletePost(@RequestParam("postId") int postId, Model model) {
		System.out.println("delete" + postId);
		Optional<Post> post = postService.getPostById(postId);

		if (post != null) {
			postService.deletePost(postId);
		}
		return "redirect:/posts";
	}
}
