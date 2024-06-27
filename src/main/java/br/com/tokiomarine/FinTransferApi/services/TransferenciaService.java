package br.com.tokiomarine.FinTransferApi.services;

import br.com.tokiomarine.FinTransferApi.entity.Transferencia;
import br.com.tokiomarine.FinTransferApi.models.request.TransfRequest;
import br.com.tokiomarine.FinTransferApi.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TransferenciaService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public void saveTransferencia(TransfRequest transfRequest){
        try {
            transferenciaRepository.save(builderTransferencia(transfRequest));
        }catch (DataAccessException e){
            e.printStackTrace();
            throw e;
        }
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

    public List<Transferencia> getAllTransferencias() {
        try {
            return transferenciaRepository.findAll();
        }catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Transferencia getTransferenciasById(Long id) {
        try {
            return transferenciaRepository.findById(id).orElse(new Transferencia());
        }catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
