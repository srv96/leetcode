package me.coding.sandbox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Kafka {
    static class KafkaObject {
        int message;

        public KafkaObject(int message, int id) {
            this.message = message;
            this.id = id;
        }

        int id;
    }

    class Topic {
        public List<Queue<KafkaObject>> topic;

        public Topic(int partition) {
            topic = new ArrayList<>();
            for (int i = 0; i < partition; i++) {
                topic.add(new LinkedList<>());
            }
        }

        public void store(KafkaObject kafkaObject) {
            int messageId = kafkaObject.id;
            int hash = messageId % topic.size();
            topic.get(hash).add(kafkaObject);
        }
    }

    class ConsumerGroup {
        List<Consumer> consumer;

        public ConsumerGroup(Topic topic) {
            consumer = new ArrayList<>();
            int nPartions = topic.topic.size();
            for (int i = 0; i < nPartions; i++) {
                consumer.add(new Consumer(topic.topic.get(i)));
            }
        }
    }

    class Consumer {
        Queue<KafkaObject> partions;

        public Consumer(Queue<KafkaObject> partions) {
            this.partions = partions;
        }

        public KafkaObject consume() {
            if (!partions.isEmpty()) return partions.poll();
            else {
                return null;
            }
        }
    }

    class Producer {
        Topic topic;

        public Producer(Topic topic) {
            this.topic = topic;
        }

        public void publish(KafkaObject kafkaObject) {
            this.topic.store(kafkaObject);
        }
    }

    int fromOffset;
    int untilOffset;
    Topic topic;

    public Topic createTopic(int partition) {
        this.topic = new Topic(partition);
        return this.topic;
    }

    public List<Consumer> createConsumers(Topic topic) {
        List<Consumer> consumers = new ArrayList<>();
        int size = topic.topic.size();
        for (int i = 0; i < size; i++) {
            consumers.add(new Consumer(topic.topic.get(i)));
        }
        return consumers;
    }

    public Producer createProducer(Topic topic) {
        Producer producer = new Producer(topic);
        return producer;
    }
}
