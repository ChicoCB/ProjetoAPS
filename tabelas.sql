DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS vendas;
DROP TABLE IF EXISTS produtos;
DROP TABLE IF EXISTS enderecos;
DROP TABLE IF EXISTS clientes;

create table users (
	user_ID int auto_increment,
	nome varchar(30),
    senha varchar(30),
    super_user bool,
	primary key (user_ID)
);

create table produtos (
	prod_ID int auto_increment,
    nome varchar(40),
    preco varchar(20),
	quantidade varchar(10),
    imagem MEDIUMBLOB default null,
    primary key (prod_ID)
);

create table clientes (
	client_ID int auto_increment,
    nome varchar(30),
    sobrenome varchar(30),
    primary key (client_ID)
);

create table enderecos (
	endereco_ID int auto_increment,
	client_ID int,
	bairro varchar(20),
    rua varchar(40),
    numero varchar(8),
    primary key (endereco_ID),
    foreign key (client_ID) references clientes(client_ID)
);

CREATE TABLE vendas (
    venda_ID INT AUTO_INCREMENT,
    prod_ID INT,
    endereco_ID INT,
    quantidade VARCHAR(10),
    client_ID INT,
    data DATE,
    status VARCHAR(20),
    data_entrega DATE NULL,
    PRIMARY KEY (venda_ID),
    FOREIGN KEY (prod_ID)
        REFERENCES produtos (prod_ID),
    FOREIGN KEY (client_ID)
        REFERENCES clientes (client_ID),
    FOREIGN KEY (endereco_ID)
        REFERENCES enderecos (endereco_ID)
);