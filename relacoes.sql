-- Inserção de registros na tabela users
INSERT INTO users (user_ID, nome, senha, super_user)
VALUES ('user1', 'Francisco', '1234', false),
       ('user2', 'Maria Santos', 'senha456', true),
       ('user3', 'Pedro Souza', 'senha789', false);

-- Inserção de registros na tabela produtos
INSERT INTO produtos (prod_ID, nome, preco, quantidade, imagem)
VALUES ('1', 'Camiseta', '29.99', '50', null),
       ('2', 'Calça Jeans', '79.99', '30', null),
       ('3', 'Tênis', '99.99', '20', null),
       ('4', 'Moletom', '49.99', '40', null),
       ('5', 'Boné', '19.99', '100', null),
       ('6', 'Bolsa', '39.99', '10', null),
       ('7', 'Óculos de Sol', '59.99', '15', null),
       ('8', 'Relógio', '89.99', '5', null),
       ('9', 'Chapéu', '24.99', '30', null),
       ('10', 'Cinto', '14.99', '50', null);

-- Inserção de registros na tabela clientes
INSERT INTO clientes (client_ID, nome, sobrenome)
VALUES ('client1', 'Ana', 'Silva'),
       ('client2', 'Carlos', 'Santos'),
       ('client3', 'Mariana', 'Almeida');

-- Inserção de registros na tabela clientes
INSERT INTO clientes (client_ID, nome, sobrenome)
VALUES ('client4', 'Rafael', 'Silva'),
       ('client5', 'Patricia', 'Santos'),
       ('client6', 'Lucas', 'Ferreira');

-- Inserção de registros na tabela enderecos
INSERT INTO enderecos (endereco_ID, client_ID, bairro, rua, numero)
VALUES ('endereco1', 'client1', 'Centro', 'Rua Principal', '123'),
       ('endereco2', 'client2', 'Bairro Novo', 'Avenida das Flores', '456'),
       ('endereco3', 'client3', 'Vila Feliz', 'Rua das Palmeiras', '789');

-- Inserção de registros na tabela enderecos
INSERT INTO enderecos (endereco_ID, client_ID, bairro, rua, numero)
VALUES ('endereco4', 'client4', 'Centro', 'Rua das Flores', '10'),
       ('endereco5', 'client5', 'Bairro Novo', 'Rua das Palmeiras', '20'),
       ('endereco6', 'client6', 'Vila Feliz', 'Avenida Principal', '30');

-- Inserção de registros na tabela vendas
INSERT INTO vendas (venda_ID, prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega)
VALUES ('venda1', '1','endereco3', '2', 'client1', '2023-06-01', 'Em andamento', null),
       ('venda2', '3','endereco2', '1', 'client2', '2023-06-02', 'Concluído', '2023-06-03'),
       ('venda3', '5','endereco3', '3', 'client1', '2023-06-03', 'Em andamento', null),
       ('venda4', '2','endereco4', '2', 'client3', '2023-06-04', 'Em andamento', null),
       ('venda5', '7','endereco6', '1', 'client2', '2023-06-05', 'Em andamento', null);

-- Inserção de registros na tabela users
INSERT INTO users (user_ID, nome, senha, super_user)
VALUES ('user4', 'Carlos Oliveira', 'senha987', false),
       ('user5', 'Ana Paula', 'senha654', false),
       ('user6', 'Fernanda Pereira', 'senha321', true);

-- Inserção de registros na tabela vendas
INSERT INTO vendas (venda_ID, prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega)
VALUES ('venda6', '1','endereco1', '3', 'client4', '2023-06-06', 'Em andamento', null),
       ('venda7', '3','endereco2', '2', 'client5', '2023-06-07', 'Em andamento', null),
       ('venda8', '5','endereco1', '1', 'client6', '2023-06-08', 'Em andamento', null),
       ('venda9', '2','endereco4', '4', 'client4', '2023-06-09', 'Em andamento', null),
       ('venda10', '7','endereco3', '3', 'client5', '2023-06-10', 'Em andamento', null);
