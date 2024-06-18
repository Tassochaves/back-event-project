CREATE TABLE tb_address(
    id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) PRIMARY KEY,
    city VARCHAR(100) NOT NULL,
    uf VARCHAR(100) NOT NULL,
    tb_event_id BINARY(16),

    FOREIGN KEY (tb_event_id) REFERENCES tb_event (id) ON DELETE CASCADE
);
