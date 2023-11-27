package io.github.matperetti.eventschedulerapi.messaging;

import io.github.matperetti.eventschedulerapi.rest.dto.InvitationDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class InvitationConsumer {

    @RabbitListener(queues = "${rabbitmq.queues.invitation}")
    public void receiveInvitation(InvitationDTO invitationDTO) {
        System.out.println("Received invitation for user: " + invitationDTO.getUserId());
    }

}
