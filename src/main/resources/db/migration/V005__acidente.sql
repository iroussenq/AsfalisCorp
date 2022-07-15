CREATE TABLE acidente(
                       id UUID PRIMARY KEY,
                       condutor_id UUID REFERENCES condutor(id),
                       policial_id UUID REFERENCES policial(id),
                       rodovia_id UUID REFERENCES rodovia(id),
                       veiculo_id UUID REFERENCES veiculo(id),
                       data_do_acidente TIMESTAMP DEFAULT NOW(),
                       relatorio TEXT,
                       casualidades INT
);
