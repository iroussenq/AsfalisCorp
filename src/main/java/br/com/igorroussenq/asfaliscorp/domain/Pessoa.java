package br.com.igorroussenq.asfaliscorp.domain;

import br.com.igorroussenq.asfaliscorp.helper.StringUtils;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
public abstract class Pessoa {

    private UUID id;
    private String nome;
    String cpf;
    private LocalDate dataDeNascimento;

    protected Pessoa(final String nome,final String cpf,final LocalDate dataDeNascimento){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = StringUtils.extractNumbers(cpf);
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        if (this.cpf.length() == 11) {
            return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return cpf;
    }

    protected Pessoa editar(final String nome,final String cpf, final LocalDate dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    protected int mod11(final List<Integer> digitos, final int... multiplicadores) {
        final var i = new AtomicInteger(0);
        final var resto = digitos.stream()
                .reduce(0, (p, e) -> p + e * multiplicadores[i.getAndIncrement()]) % 11;
        return resto > 9 ? 0 : resto;
    }

    public boolean getDocumentoValido() {
        final List<Integer> digitos = StringUtils.extractNumbersToList(this.cpf);
        if (digitos.size() == 11 && digitos.stream().distinct().count() > 1) {
            return geraCpf(digitos.subList(0, 9)).equals(this.cpf);
        }
        return false;
    }

    private String geraCpf(final List<Integer> digitos) {
        digitos.add(mod11(digitos, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        digitos.add(mod11(digitos, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        return StringUtils.listToString(digitos);
    }

    public Long getIdade() {
        return Objects.nonNull(dataDeNascimento) ? ChronoUnit.YEARS.between(dataDeNascimento, LocalDate.now()) : 0L;
    }

    public UUID getId() {
        return id;
    }
}
