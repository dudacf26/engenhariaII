#### Trabalho Engenharia II - Uniritter

***Eduarda Ferreira***

O sistema é sobre uma Biblioteca e foi implementado uma parte do sistema conforme solicitado. Para gerenciar as dependências utilizei o ***Gradle***.

![Resultado de imagem para gradle](https://taverna.devall.com.br/uploads/default/original/1X/cc3a3d79a4e510252312a0e60ce50de00a3cfe99.png)
***Classes:***

**Gerador de ID:**  Uma classe que gera automaticamente ID's para os livros.

**Main:**  Responsável pela execução do programa.

**Biblioteca:**

-   Instâncio o Gerador de ID
    
-   Tenho um método chamado getInstance (*Aqui estou implementando o Pattern Singleton*)
    
-   Tenho os métodos também: Adicionar Livro,Listar todos os Livros,Buscar Livro por Autor,Buscar Livro por ID,Buscar Livro por Titulo, Excluir Livro.
    

**Livro:** A classe onde crio o Livro com: id,titulo e autor.

**Menu:**

-   Na hora de Instanciar a Biblioteca no Menu uso o método getInstance(padrão Singleton)

`private static Biblioteca biblioteca = Biblioteca.getInstance();`

-   Criação e estruturação do Menu.
-------------------------
**Classes de Testes:**

Utilizei o Framework **JUnit** para elaboração dos testes.

BibliotecaTest: testa adicionarLivros,Listar todos os livros, buscar por autor, e buscar por ID.

![Resultado de imagem para junit](https://store.modelio.org/images/logos/logo_junit.png)
------------------------
**Integração Continua:**
Para fazer a Integração utilizei o **Jenkis**.

![Resultado de imagem para jenkins](https://d1q6f0aelx0por.cloudfront.net/product-logos/f5326186-8ae7-425c-a78d-7192dabf75be-jenkins.png)
