package com.estudo.lojalivros.repository;

import com.estudo.lojalivros.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

    AutorEntity findByCodigo(Long codigo);

    AutorEntity findByNome(String nomeAutor);

    boolean existsByCodigo(Long codigoAutor);

    boolean existsByNome(String nomeAutor);

    void deleteByCodigo(Long codigoAutor);
}
