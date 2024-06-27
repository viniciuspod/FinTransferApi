package br.com.tokiomarine.FinTransferApi.repositories;

import br.com.tokiomarine.FinTransferApi.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
