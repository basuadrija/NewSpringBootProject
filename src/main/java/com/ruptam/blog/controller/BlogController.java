package com.ruptam.blog.controller;

import com.ruptam.blog.entity.Post;
import com.ruptam.blog.model.BlogResponse;
import com.ruptam.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping(value = "/blog")
    public ResponseEntity<?> savePost(@RequestBody Post post) {
        blogService.postBlog(post);
        return new ResponseEntity<>("Saved successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getBlog() {
        List<Post> posts = blogService.getBlog();
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

    @GetMapping(value = "/tags")
    public ResponseEntity<?> getAllTags() {
        Set<String> tags = blogService.getTags();
        return new ResponseEntity<Set<String>>(tags, HttpStatus.OK);
    }

    @GetMapping(value = "/recent")
    public ResponseEntity<?> getRecentPosts() {
        List<Post> recentPosts = blogService.getRecentBlog();
        return new ResponseEntity<List<Post>>(recentPosts, HttpStatus.OK);
    }

    @GetMapping(value = "/post")
    public ResponseEntity<?> getPostByTags(@RequestParam("tagName") String tagName) {
        List<Post> postByTags = blogService.findPostByTags(tagName);
        return new ResponseEntity<List<Post>>(postByTags, HttpStatus.OK);
    }

    @GetMapping(value = "/content")
    public ResponseEntity<?> getBlogContent(@RequestParam("postName") String postName) {
        BlogResponse blogResponse = blogService.getBlogContent(postName);
        return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.OK);
    }
}
