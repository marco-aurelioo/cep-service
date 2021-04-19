# cep-service
Serviço para consultas de CEP

## 1 - Expor um serviço de BUSCA DE CEP

Eu, como usuário, quero informar meu CEP e obter:
 - o nome da minha RUA 
 - BAIRRO 
 - CIDADE
 - ESTADO
   
para preencher meus dados de cadastro de forma automática.

### Os critérios de aceite dessa história são:

- [ ] Dado um CEP válido, deve retornar o endereço correspondente
- [x] Dado um CEP válido, que não exista o endereço, deve substituir um dígito da direita para a esquerda por zero até que o endereço seja localizado (Exemplo: Dado 22333999 tentar com 22333990, 22333900 …)
- [X] Dado um CEP inválido, deve retornar uma mensagem reportando o erro: "CEP inválido"O que se espera para as questões 1  - dicas e direcionamentos:
- [X] Os serviços devem receber e responder JSON;

### Extras:

- [x] Preferencialmente use um versionador e faça commits granulares;
- [ ] Api com autorização;
- [X] boas práticas de design de api;
- [ ] Swagger com a documentação;
- [ ] Tecnologias: Java

### Extras plus plus master (não é mandatório, apenas diferencial se vc tiver tempo e conhecimento):
- [ ] Logs estruturados;
- [ ] Endpoint para saúde da aplicação;
- [ ] Endpoint para métricas da aplicação;
- [ ] Considere a performance do algoritmo e o tempo de resposta da aplicação, sabendo que a API  pode receber flutuações de tráfego agressivas.


