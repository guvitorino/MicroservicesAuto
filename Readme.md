# Microserviços
Este projeto está divido em 5 microserviços, sendo eles:

- MS-Gateway
- MS-EurekaServer
- MS-Boleto
- MS-Automoveis
- MS-Auth

#### Endpoints

#### ```/login``` : Rota para realizar a autenticação na aplicação 

Ex.: ```curl -i -H "Content-Type: application/json" -X POST -d '{"username":"vitto","password":"300995V1tT0"}' http://localhost:8080/login```

Deve retornar:
```
HTTP/1.1 200 
Date: Thu, 01 Oct 2020 16:42:06 GMT
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXR0byIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MDE1NzA1MjYsImV4cCI6MTYwMTY1NjkyNn0.qY4ObpSwQsIYT7Ok6WCRZRVv5HyjbWps9mMOHbowPRc
Keep-Alive: timeout=60
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Transfer-Encoding: chunked
```

E ser utilizado o token retornado:
```Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXR0byIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MDE1NzA1MjYsImV4cCI6MTYwMTY1NjkyNn0.qY4ObpSwQsIYT7Ok6WCRZRVv5HyjbWps9mMOHbowPRc```



#### `/cadastroAutomoveis`: Rota para inserir um veículo

Ex.:  
```
curl --location --request POST 'localhost:8080/cadastroAutomoveis' \
 --header 'Authorization: Bearer Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXR0byIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MDE1MDg1MTQsImV4cCI6MTYwMTU5NDkxNH0.Z-ImgNdfcDzx1r4U6z886_03zj8zzQHaZLfqmLDCoso' \
 --header 'Content-Type: application/json' \
 --data-raw '{
     "marca": "Fiat",
     "modelo": "Uno",
     "valor": 4000
 }'
```

Irá retornar, os dados do veículo cadastrado:
```
    {
        "id":2,
        "marca":"Fiat",
        "modelo":"Uno",
        "valor":4000.0,
        "dataDeCadastro":"2020-10-01T16:47:59.364+00:00"
    }
```

#### `/automoveis` - Rota para listar os veículos cadastrados

Ex.: ```
curl --location --request GET 'localhost:8080/automoveis' \
--header 'Authorization: Bearer Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXR0byIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MDE1NzA1MjYsImV4cCI6MTYwMTY1NjkyNn0.qY4ObpSwQsIYT7Ok6WCRZRVv5HyjbWps9mMOHbowPRc'```

Que irá retornar:

```
[
    {
        "id": 1,
        "marca": "Fiat",
        "modelo": "Uno",
        "valor": 4000.0,
        "dataDeCadastro": "2020-10-01T16:47:44.563+00:00"
    },
    {
        "id": 2,
        "marca": "Fiat",
        "modelo": "Uno",
        "valor": 4000.0,
        "dataDeCadastro": "2020-10-01T16:47:59.364+00:00"
    }
]
```

#### `/boleto` - Rota para realizar o cadastro de boleto
Ex.: ``` 
curl --location --request POST 'localhost:8080/boleto' \
--header 'Authorization: Bearer Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2aXR0byIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MDE1NzA1MjYsImV4cCI6MTYwMTY1NjkyNn0.qY4ObpSwQsIYT7Ok6WCRZRVv5HyjbWps9mMOHbowPRc' \
--header 'Content-Type: application/json' \
--data-raw '{
    "marca": "Fiat",
    "modelo": "uno",
    "valor": 4000
}'```

Irá retorna os dados do boleto cadastrado:
```
{
    "codigo": 2,
    "valor": 4000.0,
    "vencimento": "2020-10-04T16:56:52.479+00:00"
}
```


### O que foi utilizado

- [Zuul](https://github.com/Netflix/zuul) - Para a criação do Api Gateway

- [Eureka](https://github.com/Netflix/eureka) - Como server discovery

- [H2](https://www.h2database.com/html/main.html) - Banco de dados

- [Lombok](https://projectlombok.org/) - Gerador de Getter e Setter

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework 

#### Executando Local

**Este projeto foi desenvolvido utilizando o JDK 11**

1. Instalar as dependências utilizando o comando `mvn dependency:resolve` em cada microserviço.
2. Entrar no diretório de cada microserviço e executar `mvn clean spring-boot:run` **Lembrando que o `MS-EurekaServer`** deve ser executado primeiro, e após ele inicializar os demais.