package com.ruptam.blog.service;

import com.ruptam.blog.entity.Post;
import com.ruptam.blog.model.BlogResponse;

import java.util.List;
import java.util.Set;

public interface BlogService {
    void postBlog(Post post);

    List<Post> getBlog();

    List<Post> getRecentBlog();

    Set<String> getTags();

    List<Post> findPostByTags(String tagName);

    BlogResponse getBlogContent(String postName);

}
