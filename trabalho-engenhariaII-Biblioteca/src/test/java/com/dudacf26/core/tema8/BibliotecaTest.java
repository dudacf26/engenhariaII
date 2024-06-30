package com.dudacf26.core.tema8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.Optional;


import com.dudacf26.core.tema8.controller.Biblioteca;
import com.dudacf26.core.tema8.dominio.Livro;
import org.junit.Test;

public class BibliotecaTest {
    @Test
    public void testaAdicionarLivros() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("Duda", "Deus");
        List<Livro> livros = biblioteca.listarTodosOsLivros();
        assertFalse(livros.isEmpty());
    }

    @Test
    public void testaSeListaTodos() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("Duda", "Deus");
        biblioteca.adicionarLivro("Duda1", "Deus");
        biblioteca.adicionarLivro("Duda2", "Deus");
        biblioteca.adicionarLivro("Duda3", "Deus");
        assertEquals(4, biblioteca.listarTodosOsLivros().size());
    }

    @Test
    public void testaBuscaPorAutor() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("Testando2", "TesteAutor");
        assertEquals(1, biblioteca.buscarLivroPorAutor("TesteAutor").size());
    }

    @Test
    public void testaBuscaPorID() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("Testando2", "TesteAutor");
        biblioteca.adicionarLivro("Testando4", "TesteAutor");
        Optional<Livro> livro = biblioteca.buscarLivroPorId(1);
        assertEquals(1, livro.get().getId());
    }

    @Test
    public void testaBuscaPorTitulo() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("Testando2", "TesteAutor");
        biblioteca.adicionarLivro("Testando4", "TesteAutor3");
        List<Livro> livro = biblioteca.buscarLivroTitulo("Testando2");
        assertEquals("Testando2", livro.get(0).getTitulo());
    }
}
