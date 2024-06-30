# 🏫 Trabalho Engenharia II - Uniritter

## Autor

**Eduarda Ferreira**

## Descrição

O sistema é sobre uma Biblioteca sendo implementada uma parte do sistema conforme solicitado. Para gerenciar as dependências, utilizei o **Gradle**.

## 📚 Classes

### 🆔 Gerador de ID
Uma classe que gera automaticamente IDs para os livros.

### 🚀 Main
Responsável pela execução do programa.

### 📖 Biblioteca

- Instancia o Gerador de ID.
- Possui um método chamado `getInstance` (*implementação do Pattern Singleton*).
- Métodos disponíveis:
    - `adicionarLivro`
    - `listarTodosOsLivros`
    - `buscarLivroPorAutor`
    - `buscarLivroPorID`
    - `buscarLivroPorTitulo`
    - `excluirLivro`

### 📘 Livro
Classe onde são criados os livros com os atributos: `id`, `titulo` e `autor`.

### 📋 Menu

- Ao instanciar a Biblioteca no Menu, utiliza o método `getInstance` (padrão Singleton):
  
~~~java
  private static Biblioteca biblioteca = Biblioteca.getInstance();
~~~

- Criação e estruturação do Menu.

## 📋 Menu

Ao iniciar o programa, o seguinte menu será exibido:


Seja bem-vindo(a) ao nosso sistema de Empréstimo de livros :D

Menu:
* 1  - Cadastrar um Livro
* 2  - Listar todos os livros
* 3  - Buscar Livro por autor
* 4  - Buscar Livro por título
* 5  - Excluir um Livro
* 0  - Sair

Digite a opção de sua preferência:


## 🧪 Classes de Testes

Utilizei o Framework **JUnit** para elaboração dos testes.

### 📚 BibliotecaTest
Testa os métodos:
- `adicionarLivro`
- `listarTodosOsLivros`
- `buscarLivroPorAutor`
- `buscarLivroPorID`

## 🔄 Integração Contínua

Para fazer a integração contínua, utilizei o **Jenkins**.

