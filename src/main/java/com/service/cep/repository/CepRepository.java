package com.service.cep.repository;

import com.service.cep.entity.CepEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CepRepository extends JpaRepository<CepEntity,Long> {

    Optional<CepEntity> findByCep(String cep) ;

}
