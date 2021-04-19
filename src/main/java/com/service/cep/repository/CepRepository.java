package com.service.cep.repository;

import com.service.cep.entity.CepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CepRepository extends JpaRepository<CepEntity,Long> {

    Optional<CepEntity> findByCep(String cep) ;

}
