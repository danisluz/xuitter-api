package br.com.xuitter.xuitter_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Xuit {

    public enum XuitType {
        ORIGINAL, REXUIT, QUOTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 42)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private XuitType type;

    @ManyToOne
    @JoinColumn(name = "original_xuit_id")
    private Xuit originalXuit;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @NotNull
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @Deprecated
    protected Xuit() {}

    public Xuit(String content, XuitType type, User author) {
        this.content = content;
        this.type = type;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public XuitType getType() {
        return type;
    }

    public User getAuthor() {
        return author;
    }

    public Xuit getOriginalXuit() {
        return originalXuit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}