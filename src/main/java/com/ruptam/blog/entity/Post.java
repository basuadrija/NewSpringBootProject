package com.ruptam.blog.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog_tbl")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String heading;

    private Date postDate;

    private String subHeading;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @ElementCollection
    private List<String> tags;

    public Post(int id, String heading, String subHeading, List<String> tags) {
        this.id=id;
        this.heading = heading;
        this.subHeading = subHeading;
        this.tags = tags;
    }

}
