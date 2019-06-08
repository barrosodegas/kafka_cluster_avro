# Cluster Kafka Avro
Projeto Kafka com um cluster contendo três hosts kafka-2.2 e um host Avro Schema Registry.

## Objetivo deste projeto
Demonstrar como preparar um cluster Kafka com as configurações básicas para produção e consumo de dados em formato Avro Schema.

## Para quem este projeto é indicado?
Este projeto foi criado tendo em mente que os desenvolvedores estão familiarizados com algum SO Linux, saibam configurará-lo em rede e, que ao menos tenham noções básicas sobre sistemas de messageria(Conceitos de tópicos e filas), Apache Avro Schemas, Java-7 e/ou Java-8.

## Sou iniciante. O posso que fazer?
Para os que estão começando agora, deixarei abaixo **SUGESTÕES** de estudos que devem ser realizados antes de iniciar este projeto para que possam ter uma boa base e não ficarem bloqueados caso algum imprevisto aconteça durante o processo.

### Literaturas
1. [Comece por: "Java-8"](https://howtodoinjava.com/java8/)
2. [Depois leia: "Kafka: The Definitive Guide", disponibizado neste link](https://www.confluent.io/resources/?_ga=2.5496883.1489748109.1559990952-721488887.1559164543)
3. ["Making Sense of Stream Processing"](https://www.confluent.io/resources/?_ga=2.5496883.1489748109.1559990952-721488887.1559164543)
4. [Aprenda sobre o orquestrador/coordenador de aplicações distribuídas, Zookeeper](https://www.amazon.com/ZooKeeper-Distributed-Coordination-Flavio-Junqueira-ebook/dp/B00GRCODKS)

### Cursos
1. [Comece por: "Learn Apache Kafka for Beginners".](https://www.udemy.com/course/apache-kafka/)
2. [Para extrair e sincronizar dados em sistemas externos: "Kafka Connect"](https://www.udemy.com/kafka-connect/)
2. [Kafka Streams for Data Processing](https://www.udemy.com/kafka-streams/)
3. [Confluent Avro Schema Registry](https://www.udemy.com/confluent-schema-registry/)
4. [Kafka Cluster Setup and Administration](https://www.udemy.com/kafka-cluster-setup/)
5. [Kafka Monitoring and Operations](https://www.udemy.com/kafka-monitoring-and-operations/)
6. [Kafka Ksql](https://www.udemy.com/kafka-ksql/)
7. [Kafka Security](https://www.udemy.com/apache-kafka-security/)

## O que você irá encontrar neste repositório:
1. Os scripts de instalação e preparação de cada host do cluster Apache kafka.
2. Os scripts de banco de dados das aplicações Spring Boot criadas para interagir com o cluster.
3. O projeto Spring Boot Web "kafka-avro-client-retail-sales" que produz dados para os tópicos no cluster.
4. Três projetos Spring Boot Web Rest que consomem os dados dos tópicos no cluster.

## Ferramentas e SO utilizados neste exemplo
1. SO: Ubuntu-18.04 Desktop LTS
2. Software de criação de máquinas virtuais
3. Rede: net-tools
4. Downloads: curl
5. Java: openjdk-8-jdk
6. Kafka: Apache kafka_2.12-2.2.0
7. Avro Schema Registry: confluent-5.2.1-2.12
8. BD Postgresql-10

## Preparando cada host do cluster para receber o Kafka
### Nota: Cada arquivo de setup listado abaixo deve ser executado em todos os hosts antes de passar para o próximo setup-x.sh
1. Criar quatro hosts Linux com uma rede em modo bridge para que possam de comunicar
2. Executar os comandos do arquivo: "scripts/install_cluster/conf_kafka_cluster/setup/setup-1.sh" para instalar e baixar os arquivos necessários. **Apenas nos hosts que forem hospedar um kafka server!**
3. Executar os comandos do arquivo: "scripts/install_cluster/conf_kafka_cluster/setup/setup-2.sh" para instalar e configurar o orquestrador Zookeeper. **Apenas nos hosts que forem hospedar um kafka server!**
4. Executar os comandos do arquivo: "scripts/install_cluster/conf_kafka_cluster/setup/setup-3.sh" para instalar e configurar o kafka. **Apenas nos hosts que forem hospedar um kafka server!**
5. Executar os comandos do arquivo: "scripts/install_cluster/conf_kafka_cluster/setup/setup-4.sh" para instalar e configurar o Avro Schema Regisrtry. **Apenas nos hosts que forem hospedar o Avro Schema Registry!**
6. Executar os comandos do arquivo: "scripts/install_cluster/conf_kafka_cluster/zookeeper/topics.sh para criar os tópicos utilizados neste exemplo. **Basta rodar em um dos hosts kafka que todos os demais hosts terão acesso a estes tópicos!**

## Como interagir com o cluster utilizando os clientes Java
1. Após instalar o banco de dados, editar o arquivo: "recources/application.properties" dos projetos: "kafka-avro-client-retail-sales, kafka-avro-client-rs-invoice-consumer, kafka-avro-client-rs-order-consumer e kafka-avro-client-rs-payment-consumer" adicionando suas configurações de acesso ao banco
2. Criar o banco de dados: "retail_sales_order"
3. Compilar o projeto: "kafka-avro-client-rs-commons" com o comando: "mvn clean package install -U -T 2"
4. Compilar os demais projetos java com o comando: "mvn clean package -U"
5. Com o cluster ativo e todos os hosts já configurados, executar o arquivo ".jar" de cada projeto em um prompt de comando separado a partir de um host/Notebooke/PC que tenha acesso ao cluster
6. Acessar o projeto WEB através da URL: "http:localhost:9000", se estiver rodando em ambiente local!
7. Os consumidores não tem interface WEB. Então, basta acompanhar os logs no prompt
8. O consumidor "Order" roda na porta: "10000", o consumidor: "Payment" roda na porta: "11000" e o consumidor "Invoice" roda na porta: "12000"

## O que é este sistema cliente?
É um sistema que faz cadastro de pedidos, produz e consome dados em formato Avro em seus respectivos tópicos cobrindo os processos de solicitação de compra, pagamento e faturamento.
**Estes projetos não estão completos. Foram criados apenas para fins de testes de fluxo em Java**

## Como é o fluxo?
1. Ao adicionar um pedido, este é enviado para o tópico de pedidos
2. O consumidor de pedidos irá pegar o pedido no tópico e persistir esses dados na base permitindo que o usuário possa fazer as devidas avaliações e aprovar essa solicitação de compra
3. Uma vez que o pedido seja aprovado para pagamento, os dados do pagamento são enviados para o tópico de pagamentos
4. O consumidor de pagamentos irá persistir esses dados na base permitindo que o usuário possa avaliar e aprovar o pagamento
5. Uma vez aprovado o pagamento, os dados são enviados para o tópico de faturamentos e um consumidor irá persistir os dados para que o usuário possa avaliar e aprovar o faturamento
6. Uma vez aprovado o faturamento, este é enviado para o tópico de separação de estoque para que o pedido possa ser destinado ao cliente.


## Qual o propósito desses projetos java?
A idéia aqui foi simular um sistema hipotético de vendas no varejo. Como o intuito é apenas demonstar como produzir e consumir dados em formato Avro. **O sistema não está completo e tem alguns dados mocados.**
Mas, o que eu quero com isto é demonstar o poder que temos em mãos utilizando essa poderosa ferramenta de messageria e stream de dados.
Neste caso específico, se bem planejado e aplicado em um cenário real, os dados coletados deste sistema ou do conjunto de sistemas que atendem a empresa, poderiam ser processados em tempo real e 
serem inseridos um data warehouse que poderia gerar relatórios que podem ajudar a diretoria da empresa a decidir que produtos vender ou comprar em determinadas épocas do ano e/ou em cada região do país.
**E isso é só uma das formas de se tirar proveito desta plataforma!**

# **Em breve postarei vídeos sobre como preparar o cluster e executar os códigos deste projeto!**

# Sobre o Autor
Estou a sete anos na área e sempre em busca de uma integração melhor e mais robusta!
[André Barroso](http://www.linkedin.com/pub/andré-barroso/33/708/a87)