##Big Data  

BigData UFRJ 2016/1  

Requisitos do sistema para a disciplina de Big Data.  

Título: Mundo - Análise de dados meteorológicos.  

Disciplina: EEL890 – Big Data.  

UFRJ – DEL - Departamento de Engenharia Eletrônica e de Computação.  

Professor: Alexandre de Assis Bento Lima.  

Alunos: Aramys Matos, Celso Tinoco, Leonardo Souza, Lucas Gomes, Luciana Cruz, Marcos Aurélio, Vinicius Alves.  
--
##Introdução
Este projeto é um webservice que tem o objetivo de comparar  mudanças climáticas no mundo com o passar dos anos, levando em consideração dados coletados desde 1763. 
O browser fará a leitura de um arquivo do tipo CSV(Comma Separated Values) com dados de temperatura em diversos lugares, anos, meses e cria um gráfico comparativo.

##Casos de Uso

###Módulo Cloud (web services):
Armazenar os dados fornecidos pelo módulo sistema.
Enviar os dados requisitados para o modulo web.
###Módulo Web:
Apresenta gráficos baseados nas pesquisas realizadas pelos usuários.
###Módulos do sistema:
Processa requisições dadas pelos usuários.

###Tecnologias
Programação Scala, Spark, HTML, JavaScript
