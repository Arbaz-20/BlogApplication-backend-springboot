package com.arbaz.blog.Entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int userId;

    @Column(name = "Name",length = 100)
    private String  name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "About")
    private String about;

    @Column(name = "Role")
    private String userRole;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Post> post = new ArrayList<>();

}
