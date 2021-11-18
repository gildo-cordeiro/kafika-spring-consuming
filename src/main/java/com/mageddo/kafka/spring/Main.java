package com.mageddo.kafka.spring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@EnableKafka
@SpringBootApplication
public class Main {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final long EVERY_FIVE_SECONDS = 5 *100;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Scheduled(fixedDelay = EVERY_FIVE_SECONDS)
    void createFruits(){
        this.kafkaTemplate.send("fruit", new Fruit().setNome("Orange").toString());
        logger.info("post-fruit-to-kafkar");
    }
}
