package br.com.tokiomarine.FinTransferApi.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "sqteste", sequenceName = "sqteste", initialValue = 1, allocationSize = 1)
public class Transferencia {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqteste")
    private Long id;
    private String contaOrigem;
    private String contaDestino;
    private Double valor;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dtAgendamento;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dtTransferencia;
}
