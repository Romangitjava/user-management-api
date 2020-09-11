package com.example.rolemanagement.entity;

import com.example.rolemanagement.validation.PasswordConstraint;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.UserEntity.class)
    private Long id;

    @NotBlank(message = "Username cannot be empty")
    @JsonView(Views.UserEntity.class)
    private String username;

    @NotBlank(message = "Login cannot be empty")
    @JsonView(Views.UserEntity.class)
    private String login;

    @NotNull(message = "Password cannot be empty")
    @PasswordConstraint
    @JsonView(Views.UserEntity.class)
    private String password;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
