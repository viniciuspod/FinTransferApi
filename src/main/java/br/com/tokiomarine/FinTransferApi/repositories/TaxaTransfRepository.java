package br.com.tokiomarine.FinTransferApi.repositories;

import br.com.tokiomarine.FinTransferApi.entity.TaxaTransf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxaTransfRepository extends JpaRepository<TaxaTransf, Long> {

    @Query(value = "SELECT C.TAXA FROM TAXATRANSF C " +
            " WHERE :qtdDias between C.DIASDE and C.DIASATE", nativeQuery = true)
    Double getTaxa(Integer qtdDias);
}
