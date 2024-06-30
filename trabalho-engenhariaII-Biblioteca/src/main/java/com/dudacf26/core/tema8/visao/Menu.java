package com.dudacf26.core.tema8.visao;

import java.util.List;
import java.util.Scanner;

import com.dudacf26.core.tema8.controller.Biblioteca;
import com.dudacf26.core.tema8.dominio.Livro;

public class Menu {
	private static final Biblioteca biblioteca = Biblioteca.getInstance();
	private final Scanner ler = new Scanner(System.in);

	public void iniciaPrograma() {
        do {
            exibirMenu();
            int opcao = ler.nextInt();
            processarOpcao(opcao);
        } while (true);
	}

	private void exibirMenu() {
		System.out.println("\n\nSeja bem-vindo(a) ao nosso sistema de Empréstimo de livros :D\n");
		System.out.println("Menu:");
		System.out.println("1  - Cadastrar um Livro");
		System.out.println("2  - Listar todos os livros");
		System.out.println("3  - Buscar Livro por autor");
		System.out.println("4  - Buscar Livro por título");
		System.out.println("5  - Excluir um Livro");
		System.out.println("0  - Sair");
		System.out.println("\nDigite a opção de sua preferência:");
	}

	private void processarOpcao(int opcao) {
		switch (opcao) {
			case 1 -> cadastrarLivro();
			case 2 -> listarTodosOsLivros();
			case 3 -> buscarPorNome();
			case 4 -> buscarPorTitulo();
			case 5 -> excluirLivro();
			case 0 -> finalizarPrograma();
			default -> System.out.println("Opção digitada é inválida!\n");
		}
	}

	private void finalizarPrograma() {
		System.out.println("Obrigada por ter usado nosso sistema de Empréstimos de Livros :D!\n");
		System.out.println("Programa finalizado :( \n");
		System.exit(0);
	}

	private void excluirLivro() {
		try {
			System.out.println("Informe o Id do Livro que deseja excluir:\n ");
			int lendoId = ler.nextInt();
			biblioteca.excluirLivro(lendoId);
			System.out.println("Livro com ID " + lendoId + " excluído com sucesso!");
		} catch (Exception erro) {
			System.out.println("Você digitou um Id do livro inválido!");
			tratarErro("excluirLivro");
		}
	}

	private void buscarPorTitulo() {
		try {
			System.out.println("Informe o título do livro que deseja buscar:\n ");
			String lendoTitulo = ler.next();
			biblioteca.buscarLivroTitulo(lendoTitulo);
		} catch (Exception erro) {
			System.out.println("Nenhum Título com esse nome foi encontrado :(");
		}
	}

	private void buscarPorNome() {
		System.out.println("Informe o Autor do Livro:\n");
		String lendoAutor = ler.next();

		List<Livro> livrosEncontrados = biblioteca.buscarLivroPorAutor(lendoAutor);
		if (!livrosEncontrados.isEmpty()) {
			System.out.println("---------Livros do autor: " + lendoAutor + "---------");
			livrosEncontrados.forEach(livro -> System.out.println(livro.getTitulo()));
		} else {
			System.out.println("Nenhum Autor com esse nome foi encontrado :(");
		}
	}

	private void listarTodosOsLivros() {
		System.out.println(biblioteca.listarTodosOsLivros());
	}

	private void cadastrarLivro() {
		try {
			System.out.println("Informe o título do Livro:\n");
			String lendoTitulo = ler.next();

			System.out.println("Informe o autor do Livro:\n");
			String lendoAutor = ler.next();

			biblioteca.adicionarLivro(lendoTitulo, lendoAutor);
			System.out.println("Livro " + lendoTitulo + " foi adicionado com sucesso :)");
		} catch (Exception erro) {
			System.out.println("Você digitou algum campo incorreto ou inválido!");
			tratarErro("cadastrarLivro");
		}
	}

	private void tratarErro(String metodo) {
		System.out.println("\nSe você quiser voltar para o menu anterior digite 1, ou 2 para tentar novamente:");
		int opcao = ler.nextInt();

		switch (opcao) {
			case 1 -> iniciaPrograma();
			case 2 -> {
                if (metodo.equals("excluirLivro")) {
                    excluirLivro();
                } else if (metodo.equals("cadastrarLivro")) {
                    cadastrarLivro();
                }
			}
			default -> System.out.println("Opção digitada é inválida!\n");
		}
	}
}