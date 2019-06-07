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
