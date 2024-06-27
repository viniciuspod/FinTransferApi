-- Inserir dados na tabela transferencia
INSERT INTO transferencia (id,conta_origem, conta_destino, valor, dt_agendamento, dt_transferencia)
VALUES (NEXTVAL('sqteste'),'123456-7', '987654-3', 1000.00, '2024-06-28 10:00:00', '2024-06-28 10:30:00');

INSERT INTO transferencia (id,conta_origem, conta_destino, valor, dt_agendamento, dt_transferencia)
VALUES (NEXTVAL('sqteste'),'987654-3', '123456-7', 500.00, '2024-06-28 11:00:00', '2024-06-28 11:30:00');

INSERT INTO transferencia (id,conta_origem, conta_destino, valor, dt_agendamento, dt_transferencia)
VALUES (NEXTVAL('sqteste'),'111111-1', '222222-2', 750.00, '2024-06-28 12:00:00', '2024-06-28 12:30:00');

INSERT INTO transferencia (id,conta_origem, conta_destino, valor, dt_agendamento, dt_transferencia)
VALUES (NEXTVAL('sqteste'),'333333-3', '444444-4', 2000.00, '2024-06-28 13:00:00', '2024-06-28 13:30:00');

INSERT INTO transferencia (id,conta_origem, conta_destino, valor, dt_agendamento, dt_transferencia)
VALUES (NEXTVAL('sqteste'),'555555-5', '666666-6', 1500.00, '2024-06-28 14:00:00', '2024-06-28 14:30:00');
