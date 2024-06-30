package com.dudacf26.core.tema8.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.dudacf26.core.tema8.GeradorDeId;
import com.dudacf26.core.tema8.dominio.Livro;

public class Biblioteca {
	private final List<Livro> gerenciaDelivros;
	private GeradorDeId geradorId;
	private static Biblioteca instance;

	private void inicializaGerador() {
		int idInicial = 0;
		if (!gerenciaDelivros.isEmpty()) {
			idInicial = gerenciaDelivros.get(gerenciaDelivros.size() - 1).getId();
		}
		geradorId = new GeradorDeId(idInicial);
	}

	public static synchronized Biblioteca getInstance(){
		if(instance == null){
			instance = new Biblioteca();
		}
		return instance;
	}

	public Biblioteca() {
		this.gerenciaDelivros = new ArrayList<>();
	}

	public void adicionarLivro(String titulo, String autor) { inicializaGerador();
		int id = geradorId.gerarId();
		Livro livro = new Livro(id, titulo, autor);
		gerenciaDelivros.add(livro);
	}

	public List<Livro> listarTodosOsLivros() {
		return gerenciaDelivros;
	}

	public List<Livro> buscarLivroPorAutor(String nome) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro l : gerenciaDelivros) {
            if (l.getAutor()
                 .toLowerCase()
                 .contains(nome.toLowerCase())) {
                livrosEncontrados.add(l);
            }
        }
        return livrosEncontrados;
	}

	public Optional<Livro> buscarLivroPorId(int id) {
		Optional<Livro> livroOptional = Optional.empty();
		for (Livro livro : gerenciaDelivros) {
			if (livro.getId() == id) {
				livroOptional = Optional.of(livro);
			}
		}
		return livroOptional;
	}

	public List<Livro> buscarLivroTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro l : gerenciaDelivros) {
            if (l.getTitulo()
                 .toLowerCase()
                 .contains(titulo.toLowerCase())) {
                livrosEncontrados.add(l);
            }
        }
        return livrosEncontrados;
	}

	public void excluirLivro(int id) {
		for (Livro livro : gerenciaDelivros) {
			if (livro.getId() == id) {
				gerenciaDelivros.remove(livro);
				return;
			}
		}
	}
}
