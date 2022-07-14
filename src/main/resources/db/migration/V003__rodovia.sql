CREATE TABLE rodovia(
    id uuid PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cep VARCHAR(9) UNIQUE,
    mortes INT
);