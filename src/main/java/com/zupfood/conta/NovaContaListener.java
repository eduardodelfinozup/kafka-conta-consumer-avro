package com.zupfood.conta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NovaContaListener {

    Logger logger = LoggerFactory.getLogger(NovaContaListener.class);

    @Autowired
    OfertaService ofertaService;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.nova-conta}")
    public void recebe(NovaContaEvent event) {

        logger.info("Evento NOVA_CONTA consumido com sucesso {} ", event.toString());
        logger.info("Id: {} ", event.getId());

        BigDecimal saldo = (BigDecimal) event.getSaldo();

        ofertaService.incluirNovaOferta(event.getAgencia(), event.getNumero(), saldo);

        logger.info("Evento Nova Conta lido com sucesso: {}", event.toString());
    }

}
