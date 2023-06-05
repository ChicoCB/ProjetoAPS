-- Inserting data into users table
INSERT INTO users (nome, senha, super_user) VALUES
    ('Francisco', '1234', 1),
    ('Jane Smith', 'pass456', 0),
    ('Mark Johnson', 'test789', 0);

-- Inserting data into produtos table
INSERT INTO produtos (nome, preco, quantidade, imagem) VALUES
    ('Product A', '10.99', '100', NULL),
    ('Product B', '15.99', '50', NULL),
    ('Product C', '5.99', '200', NULL);

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

-- Inserting data into vendas table
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega) VALUES
    (1, 1, '5', 1, '2023-06-01', 'Em processamento', NULL),
    (2, 2, '2', 2, '2023-06-02', 'Entregue', '2023-06-05'),
    (3, 2, '10', 3, '2023-06-03', 'A caminho', NULL);
    
-- Inserts for produtos table
INSERT INTO produtos (nome, preco, quantidade, imagem) VALUES
    ('Product D', '8.99', '75', NULL),
    ('Product E', '12.99', '30', NULL),
    ('Product F', '6.99', '150', NULL),
    ('Product G', '9.99', '90', NULL);

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

-- Inserts for vendas table
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega) VALUES
    (4, 3, '3', 5, '2023-06-04', 'Em processamento', NULL),
    (1, 2, '8', 6, '2023-06-05', 'Entregue', '2023-06-07'),
    (2, 4, '5', 7, '2023-06-06', 'A caminho', NULL),
    (3, 1, '12', 8, '2023-06-07', 'Em processamento', NULL);
    
    -- Inserts for produtos table
INSERT INTO produtos (nome, preco, quantidade, imagem) VALUES
    ('Product H', '7.99', '80', NULL),
    ('Product I', '11.99', '20', NULL),
    ('Product J', '4.99', '250', NULL);


-- Inserts for enderecos table
INSERT INTO enderecos (client_ID, bairro, rua, numero) VALUES
    (8, 'City Center', 'Oak Avenue', '456'),
    (9, 'Downtown', 'Elm Street', '789'),
    (10, 'Suburb', 'Cedar Road', '123');

-- Inserts for vendas table
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega) VALUES
    (5, 4, '6', 9, '2023-06-08', 'Entregue', '2023-06-10'),
    (6, 2, '3', 10, '2023-06-09', 'A caminho', NULL),
    (7, 3, '15', 8, '2023-06-10', 'Em processamento', NULL);


