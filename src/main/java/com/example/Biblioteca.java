package com.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> consultarLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (!livro.isEmprestado()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    public Livro emprestarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && !livro.isEmprestado()) {
                livro.emprestar();
                return livro;
            }
        }
        throw new IllegalStateException("Livro não disponível ou já emprestado");
    }

    public void devolverLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && livro.isEmprestado()) {
                livro.devolver();
                return;
            }
        }
        throw new IllegalStateException("Livro não está emprestado ou não existe");
    }
}
