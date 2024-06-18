CREATE TABLE tb_coupon(
    id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) PRIMARY KEY,
    code VARCHAR(100) NOT NULL,
    discount INTEGER NOT NULL,
    valid TIMESTAMP NOT NULL,
    tb_event_id BINARY(16),

    FOREIGN KEY (tb_event_id) REFERENCES tb_event (id) ON DELETE CASCADE
);
