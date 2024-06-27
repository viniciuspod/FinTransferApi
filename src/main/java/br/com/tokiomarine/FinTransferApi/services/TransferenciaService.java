package br.com.tokiomarine.FinTransferApi.services;

import br.com.tokiomarine.FinTransferApi.entity.Transferencia;
import br.com.tokiomarine.FinTransferApi.models.request.TransfRequest;
import br.com.tokiomarine.FinTransferApi.repositories.TaxaTransfRepository;
import br.com.tokiomarine.FinTransferApi.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferenciaService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private TaxaTransfRepository taxaTransfRepository;

    public void saveTransferencia(TransfRequest transfRequest){
        try {
            Transferencia transferencia = builderTransferencia(transfRequest);
            transferenciaRepository.save(transferencia);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private Transferencia builderTransferencia(TransfRequest transfRequest) {
        LocalDateTime dataAgendamento = LocalDateTime.parse(transfRequest.getDataAgendamento(), formatter);
        Double vTaxa = getTaxa(dataAgendamento);
        Double vValorTaxa = getValorTaxa(vTaxa,transfRequest.getValor());
        return Transferencia.builder()
                .contaOrigem(transfRequest.getContaOrigem())
                .contaDestino(transfRequest.getContaDestino())
                .taxa(vTaxa)
                .valorTaxa(vValorTaxa)
                .valor(transfRequest.getValor() + vValorTaxa)
                .dtAgendamento(dataAgendamento)
                .dtTransferencia(LocalDateTime.now())
                .build();
    }

    private Double getValorTaxa(Double taxa, Double valor){
        if(taxa == 0.025){
            return 3.0;
        }else if(taxa == 0.0){
            return 12.0;
        }else{
            return valor * taxa;
        }
    }

    private Double getTaxa(LocalDateTime dataTransferencia) {
        long diasEntre = ChronoUnit.DAYS.between(LocalDateTime.now(), dataTransferencia);
        return taxaTransfRepository.getTaxa((int) diasEntre);
    }

    public List<Transferencia> getAllTransferencias() {
        try {
            return transferenciaRepository.findAll();
        }catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public Transferencia getTransferenciasById(Long id) {
        try {
            return transferenciaRepository.findById(id).orElse(new Transferencia());
        }catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
