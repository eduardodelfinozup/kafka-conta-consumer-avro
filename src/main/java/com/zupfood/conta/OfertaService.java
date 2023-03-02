package com.zupfood.conta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OfertaService {
    Logger logger = LoggerFactory.getLogger(OfertaService.class);

    private static final BigDecimal VALOR_CREDITO = new BigDecimal(1000);
    private static final BigDecimal VALOR_CARTAO = new BigDecimal(500);
    public static final int TRUE = 1;

    @Autowired
    private OfertaRepository ofertaRepository;

    public void incluirNovaOferta(int agencia, long numero, BigDecimal saldo){
        logger.info("Preparando para salvar a oferta recebida pelo consumidor (Saldo da oferta): {}", saldo);
        Oferta oferta = null;

        if(saldo.compareTo(VALOR_CREDITO) == TRUE){
            oferta = new Oferta(Tipo.EMPRESTIMO.name(), agencia, numero, saldo);
        }else if(saldo.compareTo(VALOR_CARTAO) == TRUE){
            oferta = new Oferta(Tipo.CARTAO.name(), agencia, numero, saldo);
        }

        if(oferta != null ){
            ofertaRepository.save(oferta);
        }
        logger.info("Oferta salva com sucesso!!!");
    }
}