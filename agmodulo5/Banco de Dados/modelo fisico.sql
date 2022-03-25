CREATE DATABASE agencia;
USE agencia;

CREATE TABLE Clientes 
( 
 nome VARCHAR(50) NOT NULL,  
 telefone CHAR(15),   
 id_cliente INT PRIMARY KEY AUTO_INCREMENT,   
 email VARCHAR(50) NOT NULL,    
 id_promocoes INT 
); 

CREATE TABLE Destinos 
( 
 id_destino INT PRIMARY KEY AUTO_INCREMENT, 
 cidade VARCHAR(50),  
 estado VARCHAR(50),  
 id_promocoes INT  
); 

CREATE TABLE Promocoes 
( 
 id_promocoes INT PRIMARY KEY AUTO_INCREMENT,    
 preco CHAR(20),  
 data_ida VARCHAR(50),  
 id_cliente INT,  
 id_destino INT  
); 

ALTER TABLE Clientes ADD FOREIGN KEY(id_promocoes) REFERENCES Promocoes (id_promocoes);
ALTER TABLE Destinos ADD FOREIGN KEY(id_promocoes) REFERENCES Promocoes (id_promocoes);
ALTER TABLE Promocoes ADD FOREIGN KEY(id_cliente) REFERENCES Clientes (id_cliente);
ALTER TABLE Promocoes ADD FOREIGN KEY(id_destino) REFERENCES Destinos (id_destino);
