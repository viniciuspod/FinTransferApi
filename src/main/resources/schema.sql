CREATE TABLE transferencia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    conta_origem VARCHAR(255) NOT NULL,
    conta_destino VARCHAR(255) NOT NULL,
    valor DOUBLE NOT NULL,
    valor_taxa DOUBLE NOT NULL,
    taxa DOUBLE NOT NULL,
    dt_agendamento DATETIME,
    dt_transferencia DATETIME
);

CREATE SEQUENCE sqteste START WITH 1 INCREMENT BY 1;

CREATE TABLE taxaTransf (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    diasDe Int NOT NULL,
    diasAte Int NOT NULL,
    valor DOUBLE NOT NULL,
    taxa DOUBLE NOT NULL
);