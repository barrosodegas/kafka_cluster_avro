#!/bin/bash

# Comandos para a instalação e configuração kafka_2.12-2.2.0 no Ubuntu 18.04:

# Nota:
# 1 - Este script deve ser executado em cada um dos hosts participantes do seu cluster.
# 2 - Você deve editar o arquivo server.propeties do exemplo mudando o ID "broker.id=Id numérico único" e o listener (advertised.listeners) em cada cluster.
# 3 - Você deve editar o arquivo de definição de serviço "kafka" antes de executar este script mudando os caminhos de arquivo.

# Adciona configuração de limite de arquivos - permite abrir 100.000 arquivos.
sudo nano /etc/security/limits.conf
# Adicionar esse valor: * hard nofile 100000 * soft nofile 100000

# Cria um diretório de dados para o Kafka
sudo mkdir -p /data/kafka
sudo chown -R node1:node1 /data/kafka

# Substituindo as configurações padrão do Kafka: /home/node1/cluster/conf_kafka_cluster/kafka/server.properties
nano /home/node1/cluster/kafka/config/server.properties 

# Instalando o Kafka como serviço.
sudo cp /home/node1/cluster/conf_kafka_cluster/kafka/kafka /etc/init.d/
sudo chmod +x /etc/init.d/kafka
sudo chown root:root /etc/init.d/kafka

# Ignorando avisos de segurança.
sudo update-rc.d kafka defaults

# Reiniciando/Iniciando o Zookeeper
sudo service kafka stop

# Verifica se está parado retornando vazio.
nc -vz localhost 9092

sudo service kafka start

# Dorme por 30 segundos para aguardar o server subir.
#sleep 30 && \

# verifica se está rodando retornando um "imok"
nc -vz localhost 9092
echo "ruok" | nc localhost 9092 ; echo

#
# É importante fazer o reboot do host após concluir a execução desse script!!!
#

sudo service zookeeper stop

sudo service kafka stop

sudo reboot

