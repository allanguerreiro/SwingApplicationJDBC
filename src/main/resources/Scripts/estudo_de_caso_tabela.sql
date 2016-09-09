-- 
-- Banco de Dados: `java_embarcado`
-- 
-----------------------------------------------------------
-- HSQL
-- Estrutura da tabela `InformacoesPessoais`
CREATE TABLE InformacoesPessoais(
        id IDENTITY PRIMARY KEY,
        nome VARCHAR(50),
        endereco varchar(50),
  	bairro varchar(32),
  	cidade varchar(32),
        email VARCHAR(50),
        estado varchar(2),
  	sexo varchar(12)
);

-- Estrutura da tabela `Descricao`
CREATE TABLE Descricao(
        id IDENTITY PRIMARY KEY,
        descricao CHARACTER LARGE OBJECT(250)
);

-- Estrutura da tabela `ObjetivoProfissional`
CREATE TABLE ObjetivoProfissional(
        id IDENTITY PRIMARY KEY,
        escolaridade VARCHAR(32),
        areaAtuacao varchar(32),
  			pretensaoSalarial varchar(32),
  			cargoDesejavel varchar(32)
);


-- DERBY

create table InformacoesPessoais(
id SMALLINT not null primary key
GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome VARCHAR(50),
endereco VARCHAR(50),
bairro VARCHAR(32),
cidade VARCHAR(32),
email VARCHAR(50),
estado VARCHAR(2),
sexo VARCHAR(12)
);

create table Descricao(
id SMALLINT not null primary key
GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
descricao LONG VARCHAR
);

create table ObjetivoProfissional(
  id SMALLINT not null primary key
  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  escolaridade VARCHAR(32),
  areaAtuacao VARCHAR(32),
  pretensaoSalarial VARCHAR(32),
  cargoDesejavel VARCHAR(32)
);

CREATE TABLE GRUPOS (
ID_GRUPO SMALLINT NOT NULL
GENERATED ALWAYS AS IDENTITY (START WITH 5, INCREMENT BY 5),
ENDEREÇO VARCHAR(100),
TEL VARCHAR(15)); 

INSERT INTO InformacoesPessoais ( nome, endereco, bairro, cidade, email, estado, sexo  )
VALUES ( 'Allan', 'Rua Olívia de Castro 280B', 'Clélia Bernardes',
	 'Viçosa', 'allanguerreiro@yahoo.com.br', 'MG', 'Masculino');

INSERT INTO Descricao ( descricao )
VALUES ( 'Bacharel em Ciência da Computação BACHARELADO EM CIÊNCIA DA COMPUTAÇÃO, no Centro Universitário do Estado do Pará (CESUPA). Estudante de Mestrado em CIÊNCIA DA COMPUTAÇÃO da Universidade Federal de Viçosa.');

INSERT INTO ObjetivoProfissional ( escolaridade, areaAtuacao, pretensaoSalarial, cargoDesejavel )
VALUES ( 'Superior Completo', 'Ciências Físicas', '5000,00', 'Analista');

-- MySQL
CREATE DATABASE IF NOT EXISTS ScriptBasico CHARACTER SET utf8
COLLATE utf8_general_ci;

CREATE TABLE `InformacoesPessoais` ( 
  `id` smallint(4) NOT NULL auto_increment,
  `nome` varchar(50) collate latin1_general_ci NOT NULL,
  `endereco` varchar(50) collate latin1_general_ci NOT NULL,
  `bairro` varchar(32) collate latin1_general_ci NOT NULL,
  `cidade` varchar(32) collate latin1_general_ci NOT NULL,
  `email` varchar(50) collate latin1_general_ci NOT NULL,
  `estado` varchar(2) collate latin1_general_ci NOT NULL,
  `sexo` varchar(12) collate latin1_general_ci NOT NULL,  
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1;


CREATE TABLE `Descricao` (	
  `id` smallint(4) NOT NULL auto_increment,
  `descricao` text(250) collate latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1;


CREATE TABLE `ObjetivoProfissional` (	
  `id` smallint(4) NOT NULL auto_increment,
  `escolaridade` varchar(32) collate latin1_general_ci NOT NULL,
  `areaAtuacao` varchar(32) collate latin1_general_ci NOT NULL,
  `pretensaoSalarial` varchar(32) collate latin1_general_ci NOT NULL,
  `cargoDesejavel` varchar(32) collate latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1;