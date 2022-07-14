CREATE TABLE policial(
                             id uuid PRIMARY KEY,
                             nome VARCHAR(255) NOT NULL,
                             dataDeNascimento DATE,
                             cpf VARCHAR(11) UNIQUE,
                             patente VARCHAR(30)
);