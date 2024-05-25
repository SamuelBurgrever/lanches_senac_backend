package com.ads.cadastroelogin.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads.cadastroelogin.entities.cadastro;
import com.ads.cadastroelogin.repository.cadastroRepository;

@RestController
public class cadastroController {
    
    @Autowired
    cadastroRepository repository;


    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(cadastro cadastro){
        repository.save(cadastro);

        return new ResponseEntity<>("Cadastrado com sucesso", HttpStatus.OK);
        
    }



    @PostMapping("/login")
    public ResponseEntity<String> logar(String cpf, String senha){
        List<cadastro> usuario = new ArrayList<>();
        usuario = repository.findAll();

        for (cadastro item : usuario) {

            if (item.getSenha().equalsIgnoreCase(senha) && item.getCpf().equals(cpf)) {

                return new ResponseEntity<>("Rediracionandom", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Usuario ou senha incorretos", HttpStatus.NOT_FOUND);

    }


}
