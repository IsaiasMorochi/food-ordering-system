
## Crear las carpeta volumes
docker-compose
    - volumes
        - kafka
            - broker-1
            - broker-2
            - broker-3
        - zookeeper
            - data
            - transactions

## 1. Start zookeeper
```docker-compose -f common.yml -f zookeeper.yml up```

### HealthCheck
```echo ruok | nc localhost 2181```

## 2. Start Kafka with docker-compose
```docker-compose -f common.yml -f kafka_cluster.yml up```

## 3. Start Kafka with docker-compose
```docker-compose -f common.yml -f init_kafka.yml up```

## Add Cluster Zookeeper
localhost:9000

cluster name: food-ordering-system-cluster
cluster Zookeeper Hosts: zookeeper:2181


## Iniciar contenedores
docker-compose -f common.yml -f zookeeper.yml up
docker-compose -f common.yml -f kafka_cluster.yml up

## verificar request 
kafkacat -C -b localhost:19092 -t payment-request

