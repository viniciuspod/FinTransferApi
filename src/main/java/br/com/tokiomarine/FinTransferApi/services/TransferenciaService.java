package br.com.tokiomarine.FinTransferApi.services;

import br.com.tokiomarine.FinTransferApi.entity.Transferencia;
import br.com.tokiomarine.FinTransferApi.models.request.TransfRequest;
import br.com.tokiomarine.FinTransferApi.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TransferenciaService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public void saveTransferencia(TransfRequest transfRequest){
        transferenciaRepository.save(builderTransferencia(transfRequest));
    }

    private Transferencia builderTransferencia(TransfRequest transfRequest) {
        LocalDateTime dataAgendamento = LocalDateTime.parse(transfRequest.getDataAgendamento(), formatter);
        return Transferencia.builder()
                .contaOrigem(transfRequest.getContaOrigem())
                .contaDestino(transfRequest.getContaDestino())
                .valor(transfRequest.getValor())
                .dtAgendamento(dataAgendamento)
                .dtTransferencia(LocalDateTime.now())
                .build();
    }
}
