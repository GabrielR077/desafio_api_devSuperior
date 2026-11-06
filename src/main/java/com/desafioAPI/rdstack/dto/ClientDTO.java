package com.desafioAPI.rdstack.dto;

import com.desafioAPI.rdstack.entities.Client;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ClientDTO {

    private Integer id;

    @Size(min = 3,max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Size(min = 1,max = 11, message = "CPF precisa conter 11 caracteres")
    @NotBlank(message = "Campo requerido")
    private String cpf;

    @NotNull(message = "Campo requerido")
    @Past(message = "Data de nascimento deve ser anterior à data atual")
    private LocalDate bithDate;

    @Positive(message = "A renda precisa ser positiva")
    @NotNull(message = "Campo requerido")
    private Double income;

    @Positive(message = "O número de filhos precisa ser positivo")
    @NotNull(message = "Campo requerido")
    private Integer children;

    public ClientDTO(){

    }

    public ClientDTO(Integer id, String name, String cpf, LocalDate bithDate, Double income, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.bithDate = bithDate;
        this.income = income;
        this.children = children;
    }

    public ClientDTO(Client client){
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        bithDate = client.getBirthDate();
        income = client.getIncome();
        children = client.getChildren();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBithDate() {
        return bithDate;
    }

    public Double getIncome() {
        return income;
    }

    public Integer getChildren() {
        return children;
    }
}
