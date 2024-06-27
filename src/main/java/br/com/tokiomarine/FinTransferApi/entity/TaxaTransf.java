package br.com.tokiomarine.FinTransferApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxaTransf {

    @Id
    private Long id;

    private Integer diasDe;

    private Integer diasAte;

    private Double valor;

    private Double taxa;

}
