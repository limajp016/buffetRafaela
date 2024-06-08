CREATE TABLE item (
    item_id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    valor_unitario DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (item_id)
);

CREATE TABLE aluguel (
    aluguel_id INT NOT NULL AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    endereco_id INT NOT NULL,
    tema_id INT NOT NULL,
    item_id INT NOT NULL,
    dt_hr_inicio TIMESTAMP NOT NULL,
    dt_hr_fim TIMESTAMP NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    desconto DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (aluguel_id),
    FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id),
    FOREIGN KEY (endereco_id) REFERENCES endereco(endereco_id),
    FOREIGN KEY (tema_id) REFERENCES tema(tema_id),
    FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE cliente (
    cliente_id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf CHAR(11) NOT NULL,
    telefone CHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cliente_antigo BOOLEAN NOT NULL,
    PRIMARY KEY (cliente_id)
);

CREATE TABLE endereco (
    endereco_id INT NOT NULL AUTO_INCREMENT,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(50),
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado CHAR(2) NOT NULL,
    cep CHAR(7) NOT NULL
    PRIMARY KEY (endereco_id)
);

CREATE TABLE tema (
    tema_id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (tema_id)
);