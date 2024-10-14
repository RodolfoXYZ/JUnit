package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    @Test
    void criarLivroComDadosValidos() {
        Livro livro = new Livro("O Senhor dos Anéis: Volume Único", "J.R.R. Tolkien");
        assertEquals("O Senhor dos Anéis: Volume Único", livro.getTitulo(), "Título incorreto.");
        assertEquals("J.R.R. Tolkien", livro.getAutor(), "Autor incorreto.");
    }

    @Test
    void emprestarLivroDisponivel() {
        Livro livro = new Livro("O Senhor dos Anéis: Volume Único", "J.R.R. Tolkien");
        livro.emprestar();
        assertTrue(livro.isEmprestado(), "Livro deveria estar emprestado.");
    }

    @Test
    void naoEmprestarLivroJaEmprestado() {
        Livro livro = new Livro("O Senhor dos Anéis: Volume Único", "J.R.R. Tolkien");
        livro.emprestar();
        
        Exception exception = assertThrows(IllegalStateException.class, livro::emprestar);
        assertEquals("Livro já está emprestado", exception.getMessage());
    }

    @Test
    void devolverLivroEmprestado() {
        Livro livro = new Livro("O Senhor dos Anéis: Volume Único", "J.R.R. Tolkien");
        livro.emprestar();
        livro.devolver();
        assertFalse(livro.isEmprestado(), "Livro deveria estar disponível.");
    }

    @Test
    void naoDevolverLivroNaoEmprestado() {
        Livro livro = new Livro("O Senhor dos Anéis: Volume Único", "J.R.R. Tolkien");

        Exception exception = assertThrows(IllegalStateException.class, livro::devolver);
        assertEquals("Livro não está emprestado", exception.getMessage());
    }
}
