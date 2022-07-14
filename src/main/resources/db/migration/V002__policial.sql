CREATE TABLE policial(
                             id uuid PRIMARY KEY,
                             nome VARCHAR(255) NOT NULL,
                             data_de_nascimento DATE,
                             cpf VARCHAR(14) UNIQUE,
                             patente VARCHAR(30)
);