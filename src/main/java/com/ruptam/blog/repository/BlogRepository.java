package com.ruptam.blog.repository;

import com.ruptam.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BlogRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT DISTINCT tag FROM Post p, IN(p.tags) tag")
    Set<String> findAllTags();

    List<Post> findTop4ByOrderByPostDateDesc();

    List<Post> findByTags(String tagName);
}
