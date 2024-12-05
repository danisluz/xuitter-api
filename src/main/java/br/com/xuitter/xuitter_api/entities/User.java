package br.com.xuitter.xuitter_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "\\w+")
    @NotBlank
    @Size(max = 10)
    private String username;

    @NotNull
    private LocalDateTime createAt;

    @Deprecated
    protected User() {}

    public User(String username) {
        this.username = username;
        this.createAt = LocalDateTime.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getCreatedAt() {
        return createAt;
    }
}