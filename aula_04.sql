
CREATE DATABASE cadastro
DEFAULT CHARACTER SET utf8mb4        -- Constraints (parâmetros/regras), define a configuração dos caracteres
DEFAULT COLLATE utf8mb4_general_ci;  -- Collations

use cadastro;  -- Seleciona o BD a ser usado

CREATE TABLE pessoas (
	id int NOT NULL AUTO_INCREMENT,  -- Vai incrementar em +1 o id de cada pessoa 
	nome varchar(30) NOT NULL,       -- NOT NULL obriga que o campo não pode ser nulo (vazio)
    nascimento date,
    sexo enum('M', 'F'),  -- Coleção enum onde só é permitido valores que estão especificados dentro dos parenteses
    peso decimal(5, 2),   -- 5 casas permitidas no número onde 2 casa (a precisão do número) são após a vírgula (ex: 103,89)
	altura decimal(3, 2),
	nacionalidade varchar(20) DEFAULT 'Brasil',  -- Constraint: se ninguém digitar nada, por padrão será 'Brasil'
    PRIMARY KEY (id)  -- Definindo o id como chave primária
) DEFAULT CHARSET = utf8mb4;  -- Define o conjunto de caracteres padrão que serão suportados
