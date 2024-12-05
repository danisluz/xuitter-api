package br.com.xuitter.xuitter_api.dtos;

import br.com.xuitter.xuitter_api.entities.Xuit;

public class XuitResponse {

    private final Long id;
    private final String content;
    private final String type;
    private final String authorUsername;

    public XuitResponse(Xuit xuit) {
        this.id = xuit.getId();
        this.content = xuit.getContent();
        this.type = xuit.getType().name();
        this.authorUsername = xuit.getAuthor().getUsername();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }
}