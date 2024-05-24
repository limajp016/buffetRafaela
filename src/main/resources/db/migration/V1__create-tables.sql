CREATE TABLE item (
    item_id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    valor_unitario DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (item_id)
);
