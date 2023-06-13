-- Inserting data into users table
INSERT INTO users (nome, senha, super_user) VALUES
    ('Francisco', '1234', 1),
    ('Jane Smith', 'pass456', 0),
    ('Mark Johnson', 'test789', 0);

-- Inserting data into clientes table
INSERT INTO clientes (nome, sobrenome) VALUES
    ('Alice', 'Brown'),
    ('Bob', 'Smith'),
    ('Charlie', 'Johnson');

-- Inserting data into enderecos table
INSERT INTO enderecos (client_ID, bairro, rua, numero) VALUES
    (1, 'Downtown', 'Main Street', '123'),
    (2, 'Suburb', 'Park Avenue', '456'),
    (3, 'City Center', 'Broadway', '789');
    

-- Inserts for clientes table
INSERT INTO clientes (nome, sobrenome) VALUES
    ('Eve', 'Johnson'),
    ('Frank', 'Brown'),
    ('Grace', 'Smith'),
    ('Henry', 'Taylor');
    
-- Inserts for clientes table
INSERT INTO clientes (nome, sobrenome) VALUES
    ('Ivy', 'Anderson'),
    ('Jack', 'Wilson'),
    ('Kate', 'Miller');

-- Inserts for enderecos table
INSERT INTO enderecos (client_ID, bairro, rua, numero) VALUES
    (4, 'Suburb', 'Oak Street', '789'),
    (5, 'City Center', 'Maple Avenue', '123'),
    (6, 'Downtown', 'Elm Road', '456'),
    (7, 'Suburb', 'Cedar Lane', '321');


    
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Camiseta', '29.99', '50', '39.99', '2023-05-01', NULL);
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Calça jeans', '79.99', '30', '99.99', '2023-05-02', NULL);
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Tênis esportivo', '99.99', '20', '129.99', '2023-05-03', NULL);
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Boné', '19.99', '100', '24.99', '2023-05-04', NULL);
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Vestido', '49.99', '40', '59.99', '2023-05-05', NULL);
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Bolsa', '39.99', '25', '49.99', '2023-06-05', NULL);
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Óculos de sol', '29.99', '35', '39.99', '2023-05-07', NULL);
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Cinto', '14.99', '80', '19.99', '2023-05-08', NULL);
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Chapéu', '24.99', '60', '29.99', '2023-06-09', NULL);
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES ('Camisa social', '59.99', '15', '79.99', '2023-06-10', NULL);


-- Inserts for enderecos table
INSERT INTO enderecos (client_ID, bairro, rua, numero) VALUES
    (8, 'City Center', 'Oak Avenue', '456'),
    (9, 'Downtown', 'Elm Street', '789'),
    (10, 'Suburb', 'Cedar Road', '123');


INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (1, 1, '2', 1, '2023-05-01', 'Concluída', '2023-06-05', '5.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (2, 2, '1', 2, '2023-05-02', 'Concluída', '2023-06-06', '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (3, 3, '3', 3, '2023-05-03', 'Pendente', NULL, '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (4, 4, '2', 1, '2023-05-04', 'Pendente', NULL, '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (5, 5, '1', 1, '2023-06-05', 'Concluída', '2023-06-07', '3.50');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (6, 6, '2', 1, '2023-06-06', 'Concluída', '2023-06-08', '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (7, 7, '1', 1, '2023-06-07', 'Pendente', NULL, '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (8, 8, '3', 2, '2023-06-08', 'Concluída', '2023-06-10', '7.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (9, 9, '2', 2, '2023-06-09', 'Pendente', NULL, '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (10, 10, '1', 2, '2023-06-10', 'Concluída', '2023-06-12', '4.50');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (1, 2, '20', 2, '2023-06-11', 'Pendente', NULL, '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (2, 3, '10', 2, '2023-06-12', 'Concluída', '2023-06-14', '3.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (3, 3, '30', 3, '2023-06-13', 'Pendente', NULL, '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (4, 4, '20', 3, '2023-06-14', 'Concluída', '2023-06-16', '6.50');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (5, 5, '10', 3, '2023-06-15', 'Concluída', '2023-06-17', '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (6, 6, '20', 3, '2023-06-16', 'Pendente', NULL, '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (7, 7, '10', 1, '2023-06-17', 'Concluída', '2023-06-19', '3.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (8, 8, '30', 1, '2023-06-18', 'Pendente', NULL, '0.00');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (9, 9, '20', 1, '2023-06-19', 'Concluída', '2023-06-21', '5.50');
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES (10, 10, '10', 2, '2023-06-20', 'Concluída', '2023-06-22', '0.00');
