# spring-kafka-java-source-code
End-to-End kafka course

## Start Kafka

Run:

```bash
docker compose -f docker-compose-core.yml up -d
```

---

## Stop Kafka

```bash
docker compose -f docker-compose-core.yml down
```
1. Consume from topic specific partition
```bash
kafka-console-consumer --bootstrap-server localhost:9092 --topic t-multi-partitions --from-beginning --partition 0
```
2. Alter topic add partition
```bash
kafka-topics --bootstrap-server localhost:9092 --alter --topic t-multi-partitions --partitions 4
```
3. Describe partition
```bash
kafka-topics --bootstrap-server localhost:9092 --describe --topic t-multi-partitions
```
4. Create topic
```bash
kafka-topics --bootstrap-server localhost:9092 --create --topic t-multi-partitions --partitions 4 --replication-factor 1

```
---
