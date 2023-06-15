package com.example.openBook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.openBook.repository.LivroRepository;

import jakarta.validation.Valid;

import com.example.openBook.model.Livro;

@RestController
@RequestMapping("/Livro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public ResponseEntity<List<Livro>> getAll() {
		return ResponseEntity.ok(livroRepository.findAll());
	}

	@GetMapping("//nome{nome}")
	public ResponseEntity<List<Livro>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(livroRepository.findAllByNomeContainingIgnoreCase(titulo));
	}

	@PostMapping("/cadastrar") // adicionar livro ao banco
	public ResponseEntity<Livro> addBanco(@Valid @RequestBody Livro livro) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(livroRepository.save(livro));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);

		if (livro.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		livroRepository.deleteById(id);
	}

}
