package com.ruptam.blog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponse {
    private String name;
    private String path;
    private String sha;
    private String size;
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("git_url")
    private String gitUrl;
    @JsonProperty("download_url")
    private String downloadUrl;
    private String type;
    private String content;
    private String encoding;
    @JsonProperty("_links")
    private Link links;
}
