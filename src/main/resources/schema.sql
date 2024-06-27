CREATE TABLE transferencia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    conta_origem VARCHAR(255) NOT NULL,
    conta_destino VARCHAR(255) NOT NULL,
    valor DOUBLE NOT NULL,
    dt_agendamento DATETIME,
    dt_transferencia DATETIME
);

CREATE SEQUENCE sqteste START WITH 1 INCREMENT BY 1;