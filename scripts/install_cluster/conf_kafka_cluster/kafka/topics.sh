#!bin/bash

# Tópico Orders
./cluster/kafka/bin/kafka-topics.sh  --zookeeper zookeeper1:2181,zookeeper2:2181,zookeeper3:2181/kafka --create --topic rs-order --replication-factor 3 --partitions 3

#  Tópico Payments
./cluster/kafka/bin/kafka-topics.sh  --zookeeper zookeeper1:2181,zookeeper2:2181,zookeeper3:2181/kafka --create --topic rs-payment --replication-factor 3 --partitions 3

# Tópico Invoices
./cluster/kafka/bin/kafka-topics.sh  --zookeeper zookeeper1:2181,zookeeper2:2181,zookeeper3:2181/kafka --create --topic rs-invoice --replication-factor 3 --partitions 3

# Tópico Stock Separations
./cluster/kafka/bin/kafka-topics.sh  --zookeeper zookeeper1:2181,zookeeper2:2181,zookeeper3:2181/kafka --create --topic rs-stock-separation --replication-factor 3 --partitions 3

# Tópico Delivery
./cluster/kafka/bin/kafka-topics.sh  --zookeeper zookeeper1:2181,zookeeper2:2181,zookeeper3:2181/kafka --create --topic rs-released-for-delivery --replication-factor 3 --partitions 3

# Tópico Delivery COnfirmation
./cluster/kafka/bin/kafka-topics.sh  --zookeeper zookeeper1:2181,zookeeper2:2181,zookeeper3:2181/kafka --create --topic rs-delivery-confirmation --replication-factor 3 --partitions 3

# Listar tópicos
./cluster/kafka/bin/kafka-topics.sh  --zookeeper zookeeper1:2181,zookeeper2:2181,zookeeper3:2181/kafka --list


# Teste de resiliência

# Gerando 10KB de dados aleatórios para o teste
base64 /dev/urandom | head -c 10000 | egrep -ao "\w" | tr -d '\n' > file10KB.txt

# Criando o tópico de teste
./cluster/kafka/bin/kafka-topics.sh  --zookeeper zookeeper1:2181,zookeeper2:2181,zookeeper3:2181/kafka --create --topic tp-test --replication-factor 2 --partitions 2

# Produzindo dados em lote com dados de performance
./cluster/kafka/bin/kafka-producer-perf-test.sh --topic tp-test --num-records 10000 --throughput 10 --payload-file file10KB.txt --producer-props acks=1 bootstrap.servers=kafka1:9092,kafka2:9092,kafka3:9092 --payload-delimiter A

# Consumindo as mensagens em cada host do cluster
./cluster/kafka/bin/kafka-console-consumer.sh --bootstrap-server kafka1:9092,kafka2:9092,kafka3:9092 --topic tp-test
