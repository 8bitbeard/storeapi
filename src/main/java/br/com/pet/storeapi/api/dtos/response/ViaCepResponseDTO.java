package br.com.pet.storeapi.api.dtos.response;

import lombok.Data;

@Data
public class ViaCepResponseDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private Boolean erro;

}
