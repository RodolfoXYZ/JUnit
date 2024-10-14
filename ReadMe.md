[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/_5K7Agse)
# Projeto: Testes de Caixa Preta e Caixa Branca - Sistema de Biblioteca

## Objetivo

Este projeto tem como objetivo realizar testes de **caixa preta** e **caixa branca** para duas classes Java: **`Livro`** e **`Biblioteca`**. Os alunos devem desenvolver testes que verifiquem tanto o comportamento externo do sistema quanto a cobertura de todos os caminhos lógicos e fluxos internos do código.

## Descrição das Classes

### 1. `Livro.java`
A classe `Livro` representa um livro com os seguintes atributos:
- **Título**: O título do livro.
- **Autor**: O nome do autor.
- **Emprestado**: Estado do livro, indicando se ele está emprestado ou não.

#### Métodos:
- `emprestar()`: Empresta o livro (muda o estado de `emprestado` para `true`).
- `devolver()`: Devolve o livro (muda o estado de `emprestado` para `false`).
- Construtor: Inicializa um livro com título e autor.

### 2. `Biblioteca.java`
A classe `Biblioteca` gerencia uma coleção de livros.

#### Métodos:
- `adicionarLivro(Livro livro)`: Adiciona um novo livro à coleção da biblioteca.
- `consultarLivrosDisponiveis()`: Retorna uma lista de livros disponíveis (não emprestados).
- `emprestarLivro(String titulo)`: Empresta o livro com o título fornecido, alterando seu estado para emprestado.
- `devolverLivro(String titulo)`: Devolve o livro com o título fornecido.

## Tarefas

### Parte 1: Teste de Caixa Preta

O teste de **caixa preta** verifica o comportamento do sistema sem considerar a implementação interna. Teste o sistema com entradas válidas e inválidas, verificando se ele se comporta como esperado.

#### Testes Recomendados:

1. **Classe `Livro`**:
   - Verificar se o estado do livro muda corretamente ao chamar os métodos `emprestar()` e `devolver()`.
   - Verificar se exceções são lançadas quando:
     - Um livro já emprestado é emprestado novamente.
     - Um livro não emprestado é devolvido.

2. **Classe `Biblioteca`**:
   - Verificar se o método `adicionarLivro()` adiciona livros corretamente.
   - Testar se `consultarLivrosDisponiveis()` retorna apenas os livros não emprestados.

### Parte 2: Teste de Caixa Branca

O teste de **caixa branca** analisa a implementação interna do código, garantindo que todos os caminhos lógicos e ramificações sejam testados.

### Passo Inicial

#### Testes Recomendados:

1. **Classe `Livro`**:
   - Verificar os diferentes caminhos nos métodos `emprestar()` e `devolver()`.
   - Garantir que todas as exceções e condições sejam testadas.

2. **Classe `Biblioteca`**:
   - Verificar se o método `emprestarLivro()` cobre:
     - Livro disponível para empréstimo.
     - Livro não encontrado.
     - Livro já emprestado.
   - Testar o método `devolverLivro()` para diferentes cenários:
     - Livro emprestado sendo devolvido.
     - Livro inexistente.
     - Livro não emprestado sendo devolvido.

3. **Cobertura de Código**:
   - Utilize o **JaCoCo** para gerar relatórios de cobertura de código e garantir que todas as linhas e ramificações do código estão cobertas pelos testes.

## Ferramentas Necessárias

- **JUnit**: Para criar e executar os testes unitários.
- **JaCoCo**: Para gerar relatórios de cobertura de código e analisar os testes de caixa branca.

## Requisitos de Entrega

1. **Código dos testes**: Submeter os testes unitários completos para as classes `Livro` e `Biblioteca`.
2. **Relatório de cobertura de código**: Gerar e entregar o relatório de cobertura usando **JaCoCo**. Tire prints da evolução da cobertura de código a medida que for desenvolvendo os testes. 
3. **Análise crítica**: Incluir um breve pdf explicando o que foi coberto nos testes de caixa preta e caixa branca, destacando as exceções e caminhos lógicos cobertos e o se deve ser feita alguma modificação, no código original, pela equipe de desenvolvimento. 

---

## Tutorial: Como Gerar o Relatório do JaCoCo via Terminal

O **JaCoCo** é uma ferramenta de cobertura de código para projetos Java. Abaixo, estão os passos para gerar o relatório de cobertura de código usando **Maven** e **JaCoCo** via terminal.

### Passos para gerar o relatório:

### 1. Adicionar o plugin JaCoCo ao `pom.xml`

Se caso o projeto não tenha (Já está adicionado), adicione o seguinte bloco no arquivo `pom.xml` para configurar o JaCoCo:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
            <version>0.8.7</version>
            <executions>
                <execution>
                    <goals>
                        <goal>prepare-agent</goal>
                    </goals>
                </execution>
                <execution>
                    <id>report</id>
                    <phase>test</phase>
                    <goals>
                        <goal>report</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

### 2. Executar os testes com Maven

Abra o terminal no diretório raiz do projeto e execute o seguinte comando para rodar os testes:

```
mvn clean test
```

### 3. Gerar o relatório de cobertura

Após a execução dos testes, execute o seguinte comando para gerar o relatório de cobertura:

```
mvn jacoco:report
```
