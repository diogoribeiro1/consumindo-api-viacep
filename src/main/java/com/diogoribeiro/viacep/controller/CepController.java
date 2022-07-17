package com.diogoribeiro.viacep.controller;

import com.diogoribeiro.viacep.Exceptions.ResourceNotFoundException;
import com.diogoribeiro.viacep.models.CepModel;
import com.diogoribeiro.viacep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CepController  {

    @Autowired
    CepService cepService;

    @GetMapping("/vicep/{cep}")
    public ResponseEntity<CepModel> getCep (@PathVariable(value = "cep") String cep){
        CepModel cepModel = cepService.buscarCep(cep);
        if (cepModel == null)
            throw new ResourceNotFoundException("CEP não econtrado!");
        return new ResponseEntity<>(cepModel, HttpStatus.OK);
    }
}
