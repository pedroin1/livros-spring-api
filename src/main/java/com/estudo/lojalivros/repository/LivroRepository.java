package com.estudo.lojalivros.repository;

import com.estudo.lojalivros.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    LivroEntity findByNome(String nomeLivro);

    boolean existsByNome(String nomeLivro);
}
