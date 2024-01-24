
	package com.nineSoftech.Service;

	

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nineSoftech.Entity.Posts;
import com.nineSoftech.Exception.PostNotFoundException;
import com.nineSoftech.Repository.EventsRepository;
import com.nineSoftech.Repository.PostsRepository;
import com.nineSoftech.Repository.UserRepository;
	

@Service
public class PostsService {


	    @Autowired
	    private PostsRepository postsRepository;
	    
	    @Autowired
	    private UserRepository userRepository;
	    
	    @Autowired
	    private EventsRepository eventsRepository;

	    
	    public List<Posts> getAllPosts() {
	        return postsRepository.findAll();
	    }

	    
	    public Posts getPostById(Long id) {
	        Optional<Posts> optionalPost = postsRepository.findById(id);
	        return optionalPost .orElseThrow(() -> new PostNotFoundException("Post not found with the given ID."));
	    }

	    
	    public Posts createPost(Posts posts) {
	    	
	    	if(posts.getUserId()!=null && posts.getEventId()!=null) {
	    		
	    		if(this.userRepository.findById(posts.getUserId()).isPresent() && this.eventsRepository.findById(posts.getEventId()).isPresent()) {
	    			return postsRepository.save(posts);
	    		}
	    	}
	        return null;
	    }

	    
	    public Posts updatePost(Long id, Posts updatedPost) {
	        Optional<Posts> optionalPost = postsRepository.findById(id);
	        if (optionalPost.isPresent()) {
	            Posts existingPost = optionalPost.get();
	            
	            existingPost.setEventId(updatedPost.getEventId());
	            existingPost.setUserId(updatedPost.getUserId());
	            existingPost.setDescription(updatedPost.getDescription());
	            existingPost.setRating(updatedPost.getRating());
	            return postsRepository.save(existingPost);
	        }
	        return null; 
	    }

	    
	    public void deletePost(Long id) {
	        postsRepository.deleteById(id);
	    }




		public List<Posts> getAllPostsByEventId(Long eventId) {
		
			   return postsRepository.findAllByEventId(eventId);
		}
	}



