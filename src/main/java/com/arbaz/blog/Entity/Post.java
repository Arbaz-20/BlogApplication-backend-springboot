package com.arbaz.blog.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Post")
public class Post {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content",length = 1000)
    private String content;

    @Column(name = "ImageName")
    private String imageName;

    @Column(name = "Date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private Category category;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();

}
