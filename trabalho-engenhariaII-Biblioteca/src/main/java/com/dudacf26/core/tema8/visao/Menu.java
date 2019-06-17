package com.dudacf26.core.tema8.visao;

import java.util.List;
import java.util.Scanner;

import com.dudacf26.core.tema8.controller.Biblioteca;
import com.dudacf26.core.tema8.dominio.Livro;

public class Menu {
	private static Biblioteca biblioteca =  Biblioteca.getInstance();
	private Scanner ler = new Scanner(System.in);
	  
	 
	public void iniciaPrograma() {
		while (true) {
			System.out.println("\n \nSeja bem vindo(a) ao nosso sistema de Empréstimo de livros :D \n");

			System.out.println("Menu:\n" +
					"1  - Cadastrar um Livro\n" +
					"2  - Listar todos os livros\n" +
					"3  - Buscar Livro por autor\n" +
					"4  - Buscar Livro por titulo\n" +
					"5  - Excluir um Livro\n" +
					"0  - Sair");

			System.out.println("\nDigite a opção de sua preferência:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				cadastrarLivro();
				break;
			case 2:
				listarTodosOsLivros();
				break;
			case 3:
				buscarPorNome();
				break;
			case 4:
				buscarPorTitulo();
				break;
			case 5:
				excluirLivro();
				break;
			case 0:
				System.out.println("Obrigada por ter usado nosso sistema de Empréstimos de Livros :D !\n ");
				System.out.println("Programa finalizado :( \n ");
				System.exit(0);
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}
	}

	private void excluirLivro() {
		int lendoId = 0;
		try {
			System.out.println("Informe o Id do Livro que deseja excluir:\n ");
			Scanner idRecebido = new Scanner(System.in);
			lendoId = idRecebido.nextInt();
		} catch (Exception erro) {

			System.out.println("Você digitou um Id do livro inválido" + "!");
			System.out.println(
					"\nSe você quiser voltar para o menu anterior digite 1 , ou 2 para tentar devolver novamente:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				iniciaPrograma();
				break;
			case 2:
				excluirLivro();
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}
		biblioteca.excluirLivro(lendoId);
		System.out.println("Livro com ID" + lendoId + "excluido com sucesso!");

	}

	private void buscarPorTitulo() {
		String lendoTitulo = "";
		int lendoId = 0;
		try {
			System.out.println("Informe o titulo do livro que deseja alugar:\n ");
			Scanner tituloRecebido = new Scanner(System.in);
			lendoTitulo = tituloRecebido.nextLine();

		} catch (Exception erro) {
			System.out.println("Nenhum Título com esse nome foi encontrado :(");
		}

		biblioteca.buscarLivroTitulo(lendoTitulo);

	}

	private void buscarPorNome() {
		System.out.println("Informe o Autor do Livro:\n");
		Scanner autorRecebido = new Scanner(System.in);
		String lendoAutor = autorRecebido.nextLine();

		List<Livro> livrosEncontrados = biblioteca.buscarLivroPorAutor(lendoAutor);
		if (livrosEncontrados.size() != 0) {
			System.out.println("---------Livros do autor:" + lendoAutor + "---------");
			for (int i = 0; i < livrosEncontrados.size(); i++) {
				System.out.println(lendoAutor + livrosEncontrados.get(i).getTitulo());
			}
		} else {
			System.out.println("Nenhum Autor com esse nome foi encontrado :(");
		}
	}

	private void listarTodosOsLivros() {
		System.out.println(biblioteca.listarTodosOsLivros());
	}

	private void cadastrarLivro() {
		String lendoTitulo = "";
		String lendoAutor = "";
		try {
			System.out.println("Informe o título do Livro:\n");
			Scanner tituloRecebido = new Scanner(System.in);
			lendoTitulo = tituloRecebido.nextLine();

			System.out.println("Informe o autor do Livro:\n");
			Scanner autorRecebido = new Scanner(System.in);
			lendoAutor = autorRecebido.nextLine();
		} catch (Exception erro) {

			System.out.println("Você digitou algum campo abaixo incorreto ou inválido: \n" + "- Titulo do Livro\n"
					+ "- Autor do Livro\n" + "!");
			System.out.println(
					"\nSe você quiser voltar para o menu anterior digite 1 , ou 2 para tentar cadastrar novamente:");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				iniciaPrograma();
				break;
			case 2:
				cadastrarLivro();
				break;
			default:
				System.out.println("Opção digitada é inválida!\n ");
			}
		}
		System.out.println("Livro " + lendoTitulo + " foi adicionado com sucesso :)");

		biblioteca.adicionarLivro(lendoTitulo, lendoAutor);

	}

}
