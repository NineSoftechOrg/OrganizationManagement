package com.nineSoftech.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nineSoftech.Entity.Posts;



@Repository
public interface PostsRepository extends JpaRepository<com.nineSoftech.Entity.Posts, Long> {

	List<Posts> findAllByEventId(Long eventId);

}
