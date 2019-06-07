#!/bin/bash

# Comandos para a instalação e configuração Avro Schema Registre no Ubuntu 18.04:

# Nota:
# 1 - Este script deve ser executado no host que irá hospedar o Avro Schema Registry
# 2 - Você deve editar o arquivo de definição de serviço "avro_schema" antes de executar este script mudando os caminhos de arquivo.

# Fazer o download do confluent-5.2.1 no site: https://www.confluent.io/download/

# Descompactar o arquivo: 
tar -xvf /home/node4/Downloads/confluent-5.2.1-2.12.tar.gz -C /home/node4/cluster/ && rm /home/node4/Downloads/confluent-5.2.1-2.12.tar.gz


# Substituindo as configurações padrão do avro Schema: /home/node4/cluster/conf_kafka_cluster/avro_schema_registry/schema-registry.properties
nano /home/node4/cluster/confluent-5.2.1/etc/schema-registry/schema-registry.properties 

# Instalando o Avro Schema Registry como serviço.
sudo cp /home/node4/cluster/conf_kafka_cluster/avro_schema_registry/avro_schema /etc/init.d/
sudo chmod +x /etc/init.d/avro_schema
sudo chown root:root /etc/init.d/avro_schema

# Ignorando avisos de segurança.
sudo update-rc.d avro_schema defaults

# Reiniciando/Iniciando o Zookeeper
sudo service avro_schema stop

# Verifica se está parado retornando vazio.
nc -vz localhost 8081

sudo service avro_schema start

# Dorme por 30 segundos para aguardar o server subir.
#sleep 30 && \

# verifica se está rodando retornando um "imok"
nc -vz localhost 8081
echo "ruok" | nc localhost 8081 ; echo


