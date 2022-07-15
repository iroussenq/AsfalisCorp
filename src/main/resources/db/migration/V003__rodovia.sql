CREATE TABLE rodovia(
    id uuid PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cep VARCHAR(9) UNIQUE,
    mortes INT DEFAULT 0
);

ALTER TABLE rodovia
    ADD column mortes_totais INT default 0;

CREATE OR REPLACE FUNCTION soma_total_mortes_rodovia() RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        UPDATE rodovia SET mortes_totais = COALESCE(mortes_totais, 0) + NEW.mortes
        WHERE id = NEW.id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Informa a soma de mortes da rodovia
CREATE TRIGGER soma_total_mortes_rodovias_tg AFTER INSERT
    ON rodovia for each row
EXECUTE PROCEDURE soma_total_mortes_rodovia();