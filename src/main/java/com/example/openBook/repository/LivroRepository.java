package com.example.openBook.repository;

import java.util.List;

import com.example.openBook.model.Livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
