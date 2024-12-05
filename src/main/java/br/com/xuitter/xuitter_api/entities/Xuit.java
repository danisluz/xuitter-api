package br.com.xuitter.xuitter_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "xuit")
public class Xuit {

    public enum XuitType {
        ORIGINAL, REXUIT, QUOTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 42)
    private String content;

    @Enumerated(EnumType.STRING)
    @NotNull
    private XuitType type;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_xuit_id")
    private Xuit originalXuit;

    @NotNull
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

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