<h4> Trabalho Engenharia II - Uniritter <h4>

O sistema é sobre uma Biblioteca e foi implementado uma parte do sistema conforme solicitado.
Para gerenciar as dependências utilizei o Gradle.

Classes:

**Gerador de ID:** Uma classe que gera automaticamente ID's para os livros.

**Main:** Responsável pela execução do programa.

**Biblioteca:**

* Instancio o Gerador de ID

* Tenho um método chamado getInstance (Aqui estou implementando o metódo Singleton)

* Tenho os métodos também: Adicionar Livro,Listar todos os Livros,Buscar Livro por Autor,Buscar Livro por ID,Buscar Livro por Titulo, Excluir Livro.

Livro: A classe onde crio o Livro com: id,titulo e autor.

**Menu:** 
* Na hora de Instanciar a Biblioteca no Menu uso o método getInstance(padrão Singleton)

`    private static Biblioteca biblioteca =   Biblioteca.getInstance();
`
* Criação e estruturação do Menu.


**Classes de Testes:**

BibliotecaTest: testa adicionarLivros,Listar todos os livros, buscar por autor, e buscar por ID.