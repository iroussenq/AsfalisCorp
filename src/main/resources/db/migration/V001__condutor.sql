CREATE TABLE condutor(
                        id uuid PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        data_de_nascimento DATE,
                        cpf VARCHAR(14) UNIQUE,
                        status_condutor VARCHAR(30)
);