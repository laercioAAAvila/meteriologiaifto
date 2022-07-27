<h1 align="center"> Sistema Meteriologico desenvolvido para GuaraBots - IFTO Campus Dianópolis  </h1>



Necessario ter banco de dados MySQL 
precisar criar o banco de dados com nome meteriologiaifto

Adicionar informação da estação via json na rota: localhost:8080/api/estacao

Os dados são:
nome
descricao
posicao_mapa

Adicionar dados da estação via json na rota: localhost:8080/api/estacao/dados
Os dados são:
id_estacao
temperatura
umidade_ar
velocidade_vento
direcao_vento
precipitacao_chuva
radiacao_solar
private String data;



Vizualizar dados no navegador no endereço localhost:8080
