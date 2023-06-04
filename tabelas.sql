DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS vendas;
DROP TABLE IF EXISTS produtos;
DROP TABLE IF EXISTS enderecos;
DROP TABLE IF EXISTS clientes;

create table users (
	user_ID varchar(8),
	nome varchar(30),
    senha varchar(30),
    super_user bool,
	primary key (user_ID)
);

create table produtos (
	prod_ID varchar(8),
    nome varchar(40),
    preco varchar(20),
	quantidade varchar(10),
    imagem MEDIUMBLOB,
    primary key (prod_ID)
);

create table clientes (
	client_ID varchar(8),
    nome varchar(30),
    sobrenome varchar(30),
    primary key (client_ID)
);

create table enderecos (
	endereco_ID varchar(20),
	client_ID varchar(8),
	bairro varchar(20),
    rua varchar(40),
    numero varchar(8),
    primary key (endereco_ID),
    foreign key (client_ID) references clientes(client_ID)
);

create table vendas (
	venda_ID varchar(8),
    prod_ID varchar(8),
	quantidade varchar(10),
    client_ID varchar(8),
    data DATE,
    status varchar(20),
    data_entrega DATE null,
    primary key(venda_ID),
    foreign key (prod_ID) references produtos(prod_ID),
    foreign key (client_ID) references clientes(client_ID)
);