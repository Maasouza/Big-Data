##Big Data  

BigData UFRJ 2016/1  

Requisitos do sistema para a disciplina de Big Data.  

Título: Mundo - Análise de dados meteorológicos.  

Disciplina: EEL890 – Big Data.  

UFRJ – DEL - Departamento de Engenharia Eletrônica e de Computação.  

Professor: Alexandre de Assis Bento Lima.  

####Alunos: Aramys Matos, Celso Tinoco, Leonardo Souza, Lucas Gomes, Luciana Cruz, Marcos Aurélio, Vinicius Alves.  

--
##Introdução
Este é o projeto de um web service cujo objetivo é permitir a comparação e análise de mudanças climáticas no mundo com o passar dos anos, levando em consideração dados coletados desde 1763. Os dados utilizados foram obtidos no site do NOAA (National Oceanic and Atmospheric Administration, órgão do Departamento de Comércio norte-americano).
Os dados serão processados em um cluster na nuvem, rodando Spark, sendo capaz de servir um arquivo JSON contendo as informações requisitadas. A interface para acessar o cluster será disponibilizada em uma página HTML. O usuário poderá fazer uma requisição de dados, configurando filtros de região geográfica e espaço de tempo. O browser, por sua vez, processará os resultados obtidos, enviados pelo servidor em um arquivo JSON, a fim de gerar gráficos ou outras visualizações a serem selecionadas pelo usuário.

##Os Dados
Os dados que serão utilizados foram obtidos através do servidor ftp da NOAA e podem ser obtidos através da URL(1). Estão divididos de acordo com o dia em que foram coletados e abrangem medições datando desde 1783 a 2016. Os primeiros anos do dataset contém apenas dados de estações meteorológicas de alguns lugares dos Estados Unidos. Nos anos subsequentes, foram incluídas, gradativamente, estações de outras partes do mundo, como Oceania, Europa e Ásia.
Os dados mais relevantes contidos no data set são o ID da estação meteorológica, através do qual podemos descobrir sua localização geográfica, a data da medição, no formado aaaammdd (ano - 4 caracteres, mês - 2 caracteres e dia - 2 caracteres) e os valores das flags TMAX e TMIN, indicando as temperaturas máxima e mínima no dia da medição. Estas flags não estão preenchidas em todos os dias, o que demandará tratamento de campos de valor nulo.
Arquivos auxiliares como o README (que fala sobre a organização dos arquivos) e que contém a localização de cada estação incluída nos dados e detalhes adicionais sobre o significado de cada um dos campos contidos no data set podem ser encontrados na URL(2)

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
