package me.coding.sandbox;

import java.util.List;

public class KafkaUse {
    public static void main(String[] args) {
        Kafka kafka = new Kafka();
        Kafka.Topic topic = kafka.createTopic(3);
        List<Kafka.Consumer> consumers = kafka.createConsumers(topic);
        Kafka.Producer producer = kafka.createProducer(topic);
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    producer.publish(new Kafka.KafkaObject(23435, i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumerThread = new Thread(() -> {
            int size = consumers.size();
            while(true) {
                try {
                    Thread.sleep(1000);
                    for (int j = 0; j < size; j++) {
                        Kafka.Consumer consumer = consumers.get(j);
                        while(!consumer.partions.isEmpty()){
                            Kafka.KafkaObject obj= consumer.consume();
                            System.out.println("Consumer ID :"+j+"Message : "+obj.message+"  ID : "+obj.id);
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
