create table cliente (

IDCliente int(11) AUTO_INCREMENT PRIMARY KEY,
nomeCliente	varchar(255) not null,			
CPF	varchar(11) not null,
enderecoCliente	varchar(255) not null,
telefoneCliente	bigint(20) not null

);

select *from cliente;

create table animal (

IDAnimal int(11) AUTO_INCREMENT PRIMARY KEY,
nome varchar(255),	
especie varchar(255),
raca varchar(255),
idade int(11),
historicoMedico varchar(255),
Tutor varchar(255)

);

select *from animal;

create table servicos (
IDServico INT AUTO_INCREMENT PRIMARY KEY,
nomeServico VARCHAR(255) NOT NULL,
precoServico float,
dataServico varchar(255)
);

select *from servicos;