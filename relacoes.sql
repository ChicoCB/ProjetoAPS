-- Tabela users
INSERT INTO users (nome, senha, super_user) VALUES
('Francisco', '1234', 1),
('Maria', 'abcdef', 0),
('Pedro', 'qwerty', 0);

-- Tabela produtos
INSERT INTO produtos (nome, preco, quantidade, preco_venda, data_cadastramento, imagem) VALUES
('Produto A', '10.00', '20', '15.00', '2023-01-01', null),
('Produto B', '15.50', '30', '20.00', '2023-01-02', null),
('Produto C', '8.90', '25', '12.00', '2023-01-03', null),
('Produto D', '12.75', '10', '18.00', '2023-01-04', null),
('Produto E', '9.99', '50', '14.00', '2023-01-05', null),
('Produto F', '7.50', '15', '10.00', '2023-01-06', null),
('Produto G', '11.25', '40', '16.00', '2023-01-07', null),
('Produto H', '6.80', '35', '9.00', '2023-01-08', null),
('Produto I', '14.50', '5', '20.00', '2023-01-09', null),
('Produto J', '5.99', '60', '12.00', '2023-01-10', null),
('Produto K', '10.99', '30', '16.00', '2023-01-11', null),
('Produto L', '8.25', '20', '11.00', '2023-01-12', null),
('Produto M', '13.75', '12', '18.00', '2023-01-13', null),
('Produto N', '9.50', '45', '15.00', '2023-01-14', null),
('Produto O', '7.80', '15', '10.00', '2023-01-15', null),
('Produto 16', '10.99', '8', '15.99', '2023-02-01', null),
('Produto 17', '5.99', '12', '9.99', '2023-03-01', null),
('Produto 18', '7.50', '5', '12.99', '2023-04-01', null),
('Produto 19', '3.99', '10', '7.99', '2023-05-01', null),
('Produto 20', '8.99', '3', '14.99', '2023-06-01', null),
('Produto 21', '9.99', '6', '17.99', '2023-07-01', null),
('Produto 22', '6.50', '9', '11.99', '2023-08-01', null),
('Produto 23', '4.99', '4', '8.99', '2023-09-01', null),
('Produto 24', '7.99', '7', '13.99', '2023-10-01', null),
('Produto 25', '5.50', '2', '9.99', '2023-11-01', null);

-- Tabela clientes
INSERT INTO clientes (nome, sobrenome) VALUES
('Ana', 'Silva'),
('Carlos', 'Santos'),
('Fernanda', 'Oliveira'),
('Ricardo', 'Pereira'),
('Juliana', 'Almeida');

-- Tabela enderecos
INSERT INTO enderecos (client_ID, bairro, rua, numero) VALUES
(1, 'Centro', 'Rua A', '123'),
(2, 'Vila Nova', 'Rua B', '456'),
(3, 'Jardim Primavera', 'Rua C', '789'),
(4, 'Bela Vista', 'Rua D', '1011'),
(5, 'Alto da Serra', 'Rua E', '1213');

-- Tabela vendas
INSERT INTO vendas (prod_ID, endereco_ID, quantidade, client_ID, data, status, data_entrega, custo_entrega) VALUES
(1, 1, '2', 1, '2023-01-01', 'Entregue', '2023-01-03', '5.00'),
(2, 2, '1', 2, '2023-01-02', 'Cancelada', null, '0.00'),
(3, 3, '3', 3, '2023-01-03', 'Em processamento', null, '0.00'),
(4, 4, '2', 4, '2023-01-04', 'A caminho', null, '3.50'),
(5, 5, '1', 5, '2023-01-05', 'Em processamento', null, '0.00'),
(6, 1, '4', 1, '2023-02-06', 'Entregue', '2023-02-08', '7.00'),
(7, 2, '1', 2, '2023-02-07', 'Entregue', '2023-02-09', '5.00'),
(8, 3, '2', 3, '2023-02-08', 'Entregue', '2023-02-10', '4.50'),
(9, 4, '3', 4, '2023-02-09', 'Entregue', '2023-02-11', '6.50'),
(10, 5, '2', 5, '2023-02-10', 'A caminho', null, '3.50'),
(11, 1, '1', 1, '2023-03-11', 'Cancelada', null, '0.00'),
(12, 2, '2', 2, '2023-03-12', 'Em processamento', null, '0.00'),
(13, 3, '1', 3, '2023-03-13', 'Entregue', '2023-03-15', '5.00'),
(14, 4, '3', 4, '2023-03-14', 'Em processamento', null, '0.00'),
(15, 5, '2', 5, '2023-03-15', 'Entregue', '2023-03-17', '4.50'),
(16, 1, '1', 1, '2023-04-16', 'Entregue', '2023-04-18', '3.50'),
(17, 2, '2', 2, '2023-04-17', 'A caminho', null, '3.50'),
(18, 3, '3', 3, '2023-04-18', 'Em processamento', null, '0.00'),
(19, 4, '1', 4, '2023-04-19', 'Entregue', '2023-04-21', '5.00'),
(20, 5, '4', 5, '2023-04-20', 'Entregue', '2023-04-22', '7.00'),
(21, 1, '2', 1, '2023-05-21', 'Entregue', '2023-05-23', '4.50'),
(22, 2, '1', 2, '2023-05-22', 'Em processamento', null, '0.00'),
(23, 3, '3', 3, '2023-05-23', 'Entregue', '2023-05-25', '6.00'),
(24, 4, '2', 4, '2023-05-24', 'A caminho', null, '3.50'),
(25, 5, '1', 5, '2023-05-25', 'Em processamento', null, '0.00'),
(21, 1, '2', 1, '2023-06-01', 'Entregue', '2023-06-03', '5.00'),
(22, 2, '1', 2, '2023-06-02', 'Cancelada', null, '0.00'),
(23, 3, '3', 3, '2023-06-03', 'Em processamento', null, '0.00'),
(24, 4, '2', 4, '2023-06-04', 'A caminho', null, '3.50'),
(25, 5, '1', 5, '2023-06-05', 'Em processamento', null, '0.00'),
(11, 1, '1', 1, '2023-09-11', 'Entregue', '2023-09-13', '3.50'),
(12, 2, '2', 2, '2023-09-12', 'A caminho', null, '3.50'),
(13, 3, '3', 3, '2023-09-13', 'Em processamento', null, '0.00'),
(14, 4, '1', 4, '2023-09-14', 'Entregue', '2023-09-16', '5.00'),
(15, 5, '4', 5, '2023-09-15', 'Entregue', '2023-09-17', '7.00'),
(16, 1, '2', 1, '2023-10-16', 'Entregue', '2023-10-18', '3.50'),
(17, 2, '2', 2, '2023-10-17', 'A caminho', null, '3.50'),
(18, 3, '3', 3, '2023-10-18', 'Em processamento', null, '0.00'),
(19, 4, '1', 4, '2023-10-19', 'Entregue', '2023-10-21', '5.00'),
(20, 5, '4', 5, '2023-10-20', 'Entregue', '2023-10-22', '7.00'),
(21, 1, '2', 1, '2023-12-21', 'Entregue', '2023-12-23', '4.50'),
(22, 2, '1', 2, '2023-12-22', 'Em processamento', null, '0.00'),
(23, 3, '3', 3, '2023-12-23', 'Entregue', '2023-12-25', '6.00'),
(24, 4, '2', 4, '2023-12-24', 'A caminho', null, '3.50'),
(25, 5, '1', 5, '2023-12-25', 'Em processamento', null, '0.00');