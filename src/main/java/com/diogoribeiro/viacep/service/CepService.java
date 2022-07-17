package com.diogoribeiro.viacep.service;

import com.diogoribeiro.viacep.Exceptions.ResourceNotFoundException;
import com.diogoribeiro.viacep.models.CepModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    public CepModel buscarCep(String cep){

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        CepModel cepModel = restTemplate.getForObject("https://viacep.com.br/ws/"+cep+"/json/", CepModel.class);

        return cepModel;
    }
}
