
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

## Start Kafka
```docker-compose -f common.yml -f zookeeper.yml up```

## HealthCheck
```echo ruok | nc localhost 2181```

## Start Kafka with docker-compose
```docker-compose -f common.yml -f kafka_cluster.yml up```

```docker-compose -f common.yml -f init_kafka.yml up```

## Add Cluster Zookeeper
localhost:9000

cluster name: food-ordering-system-cluster
cluster Zookeeper Hosts: zookeeper:2181