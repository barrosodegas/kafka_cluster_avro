#!/bin/bash

# Comandos para a instalação e configuração Zookeeper com kafka_2.12-2.2.0 no Ubuntu 18.04:

# Nota: OS comandos deste script deves ser executados em cada um dos hosts(Kafka) participantes do seu cluster.

# Atualiza e instala os softwares necessários para rodar o Kafka e o Zookeeper e para testar a comunicação IP entre os hosts.
sudo apt-get update && sudo apt-get install -y net-tools curl openjdk-8-jdk

# Baixando o Kafka com o zookeeper.
curl http://mirror.nbtelecom.com.br/apache/kafka/2.2.0/kafka_2.12-2.2.0.tgz --output /home/node1/Downloads/kafka_2.12-2.2.0.tgz

# Descompactando o Kafka com o zookeeper e excluindo o arquivo compactado.
tar -xvf /home/node1/Downloads/kafka_2.12-2.2.0.tgz -C /home/node1/cluster/ && rm /home/node1/Downloads/kafka_2.12-2.2.0.tgz

# Renomeia a pasta do kafka.
mv /home/node1/cluster/kafka_2.12-2.2.0 /home/node1/cluster/kafka
