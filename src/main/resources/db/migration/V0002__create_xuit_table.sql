CREATE TABLE xuit (
                      id                 BIGINT          NOT NULL AUTO_INCREMENT,
                      content            VARCHAR(42)     NOT NULL,
                      create_at          DATETIME        NOT NULL,
                      type               ENUM('ORIGINAL', 'REXUIT', 'QUOTE') NOT NULL,
                      autor_id           BIGINT          NOT NULL,
                      original_xuit_id   BIGINT,
                      PRIMARY KEY (id),
                      CONSTRAINT fk_xuit_user FOREIGN KEY (autor_id) REFERENCES user (id),
                      CONSTRAINT fk_original_xuit FOREIGN KEY (original_xuit_id) REFERENCES xuit (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;