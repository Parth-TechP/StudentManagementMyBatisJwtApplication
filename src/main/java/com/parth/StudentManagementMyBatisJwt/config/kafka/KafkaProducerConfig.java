package com.parth.StudentManagementMyBatisJwt.config.kafka;

import com.parth.StudentManagementMyBatisJwt.dto.kafka.AcknowledgmentDTO;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
  @Bean
  public NewTopic createStudentAckTopic(){
    return TopicBuilder.name("student-ack-topic")
      .partitions(3)
      .replicas(1)
      .build();
  }

  @Bean
  public Map<String, Object> producerConfig(){
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
    return props;
  }

  @Bean
  public ProducerFactory<String, AcknowledgmentDTO> producerFactory(){
    return new DefaultKafkaProducerFactory<>(producerConfig());
  }

  @Bean
  public KafkaTemplate<String, AcknowledgmentDTO> kafkaTemplate(){
    return new KafkaTemplate<>(producerFactory());
  }
}
