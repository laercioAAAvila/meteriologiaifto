<h1 align="center"> Sistema Meteriologico desenvolvido para GuaraBots - IFTO Campus Dianópolis  </h1>



Necessario ter banco de dados MySQL 
precisar criar o banco de dados com nome meteriologiaifto

Adicionar informação da estação via json na rota: localhost:8080/api/estacao<br/>

Os dados são:<br/>
nome<br/>
descricao<br/>
posicao_mapa<br/>

Adicionar dados da estação via json na rota: localhost:8080/api/estacao/dados<br/>
Os dados são:<br/>
id_estacao<br/>
temperatura<br/>
umidade_ar<br/>
velocidade_vento<br/>
direcao_vento<br/>
precipitacao_chuva<br/>
radiacao_solar<br/>
private String data;<br/>



Vizualizar dados no navegador no endereço localhost:8080
