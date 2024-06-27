package br.com.tokiomarine.FinTransferApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contaOrigem;
    private String contaDestino;
    private Double valor;
    private LocalDateTime dtAgendamento;
    private LocalDateTime dtTransferencia;
}
