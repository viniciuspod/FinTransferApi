package br.com.tokiomarine.FinTransferApi.services;

import br.com.tokiomarine.FinTransferApi.entity.Transferencia;
import br.com.tokiomarine.FinTransferApi.models.request.TransfRequest;
import br.com.tokiomarine.FinTransferApi.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public void saveTransferencia(TransfRequest transfRequest){
        transferenciaRepository.save(builderTransferencia(transfRequest));
    }

    private Transferencia builderTransferencia(TransfRequest transfRequest) {
        return Transferencia.builder()
                .build();
    }
}
