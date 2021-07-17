/*package com.aquicksoft.dto;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MessagingConfig3 {
	@Value("${QC_NEW_IMAGE_FOUND}")
	String QC_NEW_IMAGE_FOUND;

	@Bean
	Queue queue() {
		return new Queue(QC_NEW_IMAGE_FOUND);
	}

	@Bean
	Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
*/