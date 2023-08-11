package com.estudo.lojalivros.repository;

import com.estudo.lojalivros.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

    AutorEntity findByNome(String nomeAutor);
}
