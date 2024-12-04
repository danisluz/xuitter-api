package br.com.xuitter.xuitter_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
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
    @Column(columnDefinition = "enum('ORIGINAL', 'REXUIT', 'QUOTE')")
    private XuitType type;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User author;

    @JoinColumn(name = "original_xuit_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Xuit originalXuit;

    @NotNull
    private LocalDateTime createdAt;

    @Deprecated
    protected Xuit(){}


    //Getters
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

    public Optional<Xuit> getOriginalXuit() {
        return Optional.ofNullable(originalXuit);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
