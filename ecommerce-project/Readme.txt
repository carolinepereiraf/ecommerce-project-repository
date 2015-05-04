************************ README - Detalhes do Projeto *******************************************************************

** Web Services **
Os web services se encontram no pacote "br.com.ecommerce.resources".
Utilizei o Tomcat v8.0 para rodar o projeto. Basta inicializar o Tomcat (ou qualquer outro servidor),
e acessar as sequintes URLs:
localhost:8080/ecommerce-project/people
localhost:8080/ecommerce-project/products

Como utilizo Windows, usei a ferramenta "Poster" do navegador Firefox para fazer os testes de POST, GET, etc.  

** Banco de Dados: Neo4J version 2.1.8 **
Para funcionar, deve-se atualizar o atributo
<neo4j:config storeDirectory="C:\Users\Caroline\Documents\Neo4j2" [...]
dos arquivos "person.xml" e "product.xml", com a localiza��o do BD na m�quina que rodar� o programa.

** Persist�ncia **
Utilizo aqui o "Spring Data Neo4J" (http://projects.spring.io/spring-data-neo4j/)
Este framework permite visualizar os n�s em POJOs, o que torna o desenvolvimento mais intuitivo e 
facilita as opera��es no BD. 

** Logs **
Os logs s�o gerados usando Log4J.
A classe "Log4JInitServlet" inicializa o log com propriedades definidas no arquivo "log4j.properties". 
Deve aparecer um aviso no console ao iniciar.
Os logs s�o exibidos no console durante a execu��o.


** Projeto no GitHub **
O projeto atual se encontra no meu reposit�rio do GitHub:
https://github.com/carolinepereiraf/ecommerce-project-repository

Antes de incluir o BD Neo4J, programei os web services para inser��o em mapas est�ticos, apenas para teste.
Caso haja interesse, o projeto se encontra em:
https://github.com/carolinepereiraf/ecommerce-repository

*************************************************************************************************************************