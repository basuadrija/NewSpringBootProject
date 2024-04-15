package com.ruptam.blog.repository;

import java.util.List;

public interface PartialPost {
    Integer getId();
    String getHeading();

    String getSubHeading();

    String getPostDate();

    List<String> getTags();
}
