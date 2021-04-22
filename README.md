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

- [x] Dado um CEP válido, deve retornar o endereço correspondente
- [x] Dado um CEP válido, que não exista o endereço, deve substituir um dígito da direita para a esquerda por zero até que o endereço seja localizado (Exemplo: Dado 22333999 tentar com 22333990, 22333900 …)
- [X] Dado um CEP inválido, deve retornar uma mensagem reportando o erro: "CEP inválido"O que se espera para as questões 1  - dicas e direcionamentos:
- [X] Os serviços devem receber e responder JSON;

### Extras:

- [x] Preferencialmente use um versionador e faça commits granulares;
- [x] Api com autorização;
- [X] boas práticas de design de api;
- [X] Swagger com a documentação;
- [x] Tecnologias: Java

### Extras plus plus master (não é mandatório, apenas diferencial se vc tiver tempo e conhecimento):
- [ ] Logs estruturados;
- [X] Endpoint para saúde da aplicação;
- [x] Endpoint para métricas da aplicação;
- [ ] Considere a performance do algoritmo e o tempo de resposta da aplicação, sabendo que a API  pode receber flutuações de tráfego agressivas.




### url documentação (Swagger2):

http://localhost:8080/swagger-ui/

### Serviço de Autoriação:

Autenticação JWT

Geração usuario:

```
localhost:8080/user/create-account
```

Login:

```
localhost:8080/login
```

POSTMan file:

```
${projectdir}/postman-client/cep-magalu-exemplo.postman_collection.json
```


Exemplo java:



### run prometheus 

Windows, arquivo de configuração em ${project}/prometheus-cfg/prometheus.yml

```
docker service create --replicas 1 --name my-prometheus --mount type=bind,source=${projectdir}/prometheus-cfg/prometheus.yml,destination=/opt/bitnami/prometheus/conf/prometheus.yml --publish published=9090,target=9090,protocol=tcp bitnami/prometheus
```