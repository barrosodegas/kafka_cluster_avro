# Cluster Kafka Avro
Projeto Kafka com um cluster contendo três hosts kafka-2.2 e um host Avro Schema Registry.

## Objetivo deste projeto
Demonstar como preparar um cluster Kafka para produção e consumo de dados em formato Avro Schemas.

## O que você irá encontrar neste repositório
1. Os scripts de instalação e preparação de cada host do cluster Apache kafka.
2. Os scripts de banco de dados das aplicações Spring Boot criadas para interagir com o cluster.
3. O projeto Spring Boot Web "kafka-avro-client-retail-sales" que produz dados para os tópicos no cluster.
4. Três projetos Spring Boot Web Rest que consomem os dados dos tópicos no cluster.

## Ferramentas e SO utilizados neste exemplo
1. SO: Ubuntu-18.04 Desktop LTS
2. Rede: net-tools
3. Downloads: curl
4. Java: openjdk-8-jdk
5. Kafka: Apache kafka_2.12-2.2.0
6. Avro Schema Registry: confluent-5.2.1-2.12
7. BD Postgresql-10

## Preparando cada host do cluster para receber o Kafka
### Nota: Cada arquivo de setup listado abaixo deve ser executado em todos os hosts antes de passar para o próximo setup-x.sh
1. Criar três hosts Linux com a rede em mode bridge para que possam de comunicar
2. Executar os comandos listados no arquivo: "scripts/install_cluster/conf_kafka_cluster/setup/setup-1.sh" para instalar e baixar os arquivos necessários
3. Executar os comandos listados no arquivo: "scripts/install_cluster/conf_kafka_cluster/setup/setup-2.sh" para instalar e configurar o orquestrador kookeeper
4. Executar os comandos listados no arquivo: "scripts/install_cluster/conf_kafka_cluster/setup/setup-3.sh" para isntalar e configurar o kafka
5. Executar os comandos listados no arquivo: "scripts/install_cluster/conf_kafka_cluster/setup/setup-4.sh" para instalar e configurar o Avro Schema Regisrtry
6. Executar os comandos listados no arquivo: "scripts/install_cluster/conf_kafka_cluster/zookeeper/topics.sh para criar os tópicos utilizados neste exemplo.

## Como interagir com o cluster utilizando os clientes Java
1. Após instalar o banco de dados, editar o arquivo: "recources/application.properties" dos projetos: "kafka-avro-client-retail-sales, kafka-avro-client-rs-invoice-consumer, kafka-avro-client-rs-order-consumer e kafka-avro-client-rs-payment-consumer" adicionando suas configurações de acesso ao banco
2. Compilar o projeto: "kafka-avro-client-rs-commons" com o comando: "mvn clean package install"
3. Compilar os demais projetos java com o comando: "mvn clean package"
4. Com o cluster ativo e todos os hosts já configurados, executar o arquivo ".jar" de cada projeto em um prompt de comando separado
5. Acessar o projeto WEB através da URL: "http:localhost:9000", se estiver rodando localmente!
6. Os consumer não tem interface WEB. Então, basta acompanhar os logs na console
7. O consumer "Order" roda na porta: "10000". O consumer: "Payment" rodar na porta: "11000". O consumer "Invoice" roda na porta: "12000"

## O que é este sistema cliente?
É um sistema de faz cadastro de pedidos, produz e consume dados dos topicos cobrindo os processos de solicitação de compra, pagamento e faturamento.

## Qual o intuito disso?
A idéia aqui foi simular um sistema ipotético de vendas no varejo. Como o intuito é o de demonstar como produzir e consumir dados. O sistema não está completo e tem alguns dados mocados.
Mas, o que eu quero é demonstar aqui o poder que temos em mãos utilizando essa poderosa ferramenta de messageria e stream de dados.
Neste caso em específico, se bem planejado e aplicado em um cenário real, os dados coletados dos sistemas em um casos real poderiam ser processados em tempo real para 
alimentar algum data warehouse e que poderia ajudar a diretoria da empresa a decidir que produtos vender em determinadas épocas do ano e em cada região do país.
E isso é só uma das formas de se tirar proveito desta plataforma!
