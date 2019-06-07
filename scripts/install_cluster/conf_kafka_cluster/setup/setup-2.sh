#!/bin/bash

# Comandos para a instalação e configuração Zookeeper com kafka_2.12-2.2.0 no Ubuntu 18.04:

# Nota:
# 1 - Este script deve ser executado em cada um dos hosts(Kafka) participantes do seu cluster.
# 2 - Você deve subistituir o ID do zookeeper e os caminhos de diretório em cada host.
# 3 - Você deve editar o arquivo de definição de serviço "zookeeper" antes de executar este script mudando os caminhos de arquivo.

# Desabilita RAM Swap
sudo sysctl vm.swappiness=1

# Colocar na configuração para pegar no boot do SO: vm.swappiness=1
sudo nano /etc/sysctl.conf

# Cria um diretório de dados para o Zookeeper
sudo mkdir -p /data/zookeeper
sudo chown -R node1:node1 /data/

# Declara um ID para o Zookeeper. Cada host Zookeeper de ter um ID numérico único!
sudo echo "1" > /data/zookeeper/myid

# Adiciona os IPs e alias de cada host que irá participar do cluster - Substituir pelos IPs dos hosts do seu cluster.
# No nosso exemplo (Cluster com 3 hosts) cada host irá receber os IPs e alias (zookeeper e kafka) de cada host participante.
sudo nano /etc/hosts 
xxx.xxx.xxx.xxx	kafka1
xxx.xxx.xxx.xxx	zookeeper1
xxx.xxx.xxx.xxx	kafka2
xxx.xxx.xxx.xxx	zookeeper2
xxx.xxx.xxx.xxx	kafka3
xxx.xxx.xxx.xxx	zookeeper3
xxx.xxx.xxx.xxx	avroschema

# Substituindo as configurações padrão do Zookeeper por  /home/node1/cluster/conf_kafka_cluster/zookeeper/zookeeper.properties.
nano /home/node1/cluster/kafka/config/zookeeper.properties

# Instalando o Zookeeper como serviço.
sudo cp /home/node1/cluster/conf_kafka_cluster/zookeeper/zookeeper /etc/init.d/
sudo chmod +x /etc/init.d/zookeeper
sudo chown root:root /etc/init.d/zookeeper

# Ignorando avisos de segurança.
sudo update-rc.d zookeeper defaults

# Reiniciando/Iniciando o Zookeeper
sudo service zookeeper stop

# Verifica se está parado retornando vazio.
nc -vz localhost 2181

sudo service zookeeper start

# Dorme por 15 segundos para aguardar o server subir.
#sleep 15

# verifica se está rodando retornando um "imok"
nc -vz localhost 2181
echo "ruok" | nc localhost 2181 ; echo

