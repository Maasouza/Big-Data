//Acessando arquivos de outro blob conteiner = <main container> storagegrupocluster = < account > 2015.csv = <path>
val myrdd = sc.textFile("wasb://conteiner@storagegrupocluster.blob.core.windows.net/2015.csv");
