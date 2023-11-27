package io.github.matperetti.eventschedulerapi.messaging;

import io.github.matperetti.eventschedulerapi.rest.dto.InvitationDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InvitationProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String invitationExchange;
    private final String invitationRoutingKey;

    public InvitationProducer(RabbitTemplate rabbitTemplate,
                              @Value("${rabbitmq.exchanges.invitation}") String invitationExchange,
                              @Value("${rabbitmq.routingkeys.invitation}") String invitationRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.invitationExchange = invitationExchange;
        this.invitationRoutingKey = invitationRoutingKey;
    }

    public void sendInvitation(InvitationDTO invitationDTO) {
        rabbitTemplate.convertAndSend(invitationExchange, invitationRoutingKey, invitationDTO);
    }
}
