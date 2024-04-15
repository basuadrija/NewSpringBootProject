package com.ruptam.blog.service;

import com.ruptam.blog.entity.Post;
import com.ruptam.blog.model.BlogResponse;
import com.ruptam.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${github.url}")
    private String githubUrl;

    @Value("${github.bearer.token}")
    private String bearerToken;

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void postBlog(Post post) {
        blogRepository.save(post);
    }

    @Override
    public List<Post> getBlog() {
        return blogRepository.findAll();
    }

    @Override
    public List<Post> getRecentBlog() {
        List<Post> recentPosts = blogRepository.findTop4ByOrderByPostDateDesc();
        return recentPosts;
    }

    @Override
    public Set<String> getTags() {
        return blogRepository.findAllTags();
    }

    @Override
    public List<Post> findPostByTags(String tagName) {
        return blogRepository.findByTags(tagName);
    }

    @Override
    public BlogResponse getBlogContent(String postName) {
        String url = githubUrl+postName;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearerToken);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        BlogResponse blogResponse = restTemplate
                .exchange(url, HttpMethod.GET, requestEntity, BlogResponse.class).getBody();
        return blogResponse;
    }


}
