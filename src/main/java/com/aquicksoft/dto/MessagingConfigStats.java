package com.aquicksoft.dto;
/*
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfigStats {
	@Value("${QC_Stats}")
	String QC_Stats;

	@Bean
	Queue queueStats() {
		return new Queue(QC_Stats);
	}

	@Bean
	Jackson2JsonMessageConverter producerJackson2MessageConverterStats() {
		return new Jackson2JsonMessageConverter();
	}
}
*/


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfigStats {

	public static final String QUEUE = "QC_Stats";
	public static final String EXCHANGE = "QC_Stats_exchange";
	public static final String ROUTING_KEY = "QC_Stats_routingKey";

	@Bean
	public Queue queueStats() {
		return new Queue(QUEUE);
	}

	@Bean
	public TopicExchange exchangeStats() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Binding bindingStats(Queue queue2, TopicExchange exchange2) {
		return BindingBuilder.bind(queue2).to(exchange2).with(ROUTING_KEY);
	}

	@Bean
	public MessageConverter converterStats() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate templateStats(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converterStats());
		return rabbitTemplate;
	}
}

