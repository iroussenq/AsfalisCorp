CREATE TABLE veiculo(
                        id uuid PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        placa VARCHAR(7) UNIQUE,
                        ano INT
);
