package com.ads.cadastroelogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads.cadastroelogin.entities.cadastro;

@Repository
public interface cadastroRepository extends JpaRepository <cadastro, Integer> {
    
}
