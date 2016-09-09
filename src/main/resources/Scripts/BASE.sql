INSERT INTO InformacoesPessoais ( nome, endereco, bairro, cidade, email, estado, sexo  )
VALUES ( 'Allan Guerreiro Carneiro', 'Rua Olívia de Castro 280B', 'Clélia Bernardes',
	 'Viçosa', 'allanguerreiro@yahoo.com.br', 'MG', 'Masculino')

INSERT INTO Descricao ( descricao )
VALUES ( 'Bacharel em Ciência da Computação BACHARELADO EM CIÊNCIA DA COMPUTAÇÃO, no Centro Universitário do Estado do Pará (CESUPA). Estudante de Mestrado em CIÊNCIA DA COMPUTAÇÃO da Universidade Federal de Viçosa.')

INSERT INTO ObjetivoProfissional ( escolaridade, areaAtuacao, pretensaoSalarial, cargoDesejavel )
VALUES ( 'Superior Completo', 'Ciências Físicas', '5000,00', 'Analista')

SELECT * FROM InformacoesPessoais

SELECT * FROM Descricao

SELECT * FROM ObjetivoProfissional

SELECT * FROM InformacoesPessoais WHERE nome LIKE '%Nina Beagle%'

SELECT i.nome, i.endereco, i.bairro, i.cidade, i.email, i.estado, i.sexo, 
d.descricao, 
o.escolaridade, o.areaatuacao, o.pretensaosalarial, o.cargodesejavel
FROM informacoespessoais i, descricao d, objetivoprofissional o
WHERE i.codinfpessoais = d.coddescricao AND i.codinfpessoais = o.codobjprofissional

SELECT Distinct i.nome, i.endereco, i.bairro, i.cidade, i.email, i.estado, i.sexo, 
d.descricao, 
o.escolaridade, o.areaatuacao, o.pretensaosalarial, o.cargodesejavel
FROM InformacoesPessoais i, Descricao d, ObjetivoProfissional o
WHERE i.nome = 'Nina Beagle'

SELECT * FROM InformacoesPessoais AS tbl1, Descricao AS tbl2, ObjetivoProfissional AS tbl3 WHERE tbl1.nome like "%Nina Beagle%"


UPDATE InformacoesPessoais SET cidade='Valadares'
WHERE nome = 'NIna'

DELETE FROM InformacoesPessoais where codinfpessoais = 7

DELETE FROM Descricao where codDescricao = 7

DELETE FROM ObjetivoProfissional where codObjProfissional = 7

UPDATE InformacoesPessoais set nome='João da Silva',cidade='São Paulo' where codInfPessoais=1

UPDATE InformacoesPessoais SET NOME = 'Nina', ENDERECO = 'Rua', BAIRRO = 'Novo', 
CIDADE = 'Valadares Nova', EMAIL= 'nina@gmail.com.br', ESTADO = 'AM', SEXO = 'Feminino' WHERE NOME = 'Nina'

UPDATE Descricao SET DESCRICAO = 'Testando Alteração.' WHERE descricao = 'Testando'

UPDATE ObjetivoProfissional SET ESCOLARIDADE = 'Fundamental', AREAATUACAO = 'Agrárias', 
PRETENSAOSALARIAL = '750,00', CARGODESEJAVEL = 'Assistente' WHERE ESCOLARIDADE = 'Fundamental'

SELECT *
FROM (InformacoesPessoais AS tbl1 INNER JOIN Descricao AS tbl2
ON tbl1.codinfpessoais = tbl2.coddescricao AND tbl1.nome = 'Allan') INNER JOIN ObjetivoProfissional AS tbl3
ON tbl2.coddescricao = tbl3.codobjprofissional

SELECT codDescricao 
FROM descricao 
WHERE descricao = 'Testando'

UPDATE Descricao SET DESCRICAO = 'Testando'WHERE DESCRICAO = Testando

DELETE FROM (InformacoesPessoais AS tbl1 INNER JOIN Descricao AS tbl2
ON tbl1.codinfpessoais = tbl2.coddescricao AND tbl1.nome = 'Allan') INNER JOIN ObjetivoProfissional AS tbl3
ON tbl2.coddescricao = tbl3.codobjprofissional

DELETE InformacoesPessoais AS tbl1, Descricao AS tbl2, ObjetivoProfissional AS tbl3 FROM tbCliente INNER JOIN tbPedidos ON 
tbCliente.SubCodCliente=tbPedidos.SubCodCliente Where tbCliente.CodCliente=xxx;

DELETE tbl1, tbl2, tbl3
     FROM InformacoesPessoais AS tbl1 INNER JOIN Descricao AS tbl2 ON tbl1.codinfpessoais = tbl2.coddescricao
	AND tbl1.nome = 'Nina Beagle' INNER JOIN ObjetivoProfissional AS tbl3 ON tbl2.coddescricao = tbl3.codobjprofissional

     WHERE AuthorLastName='Tom';


UPDATE InformacoesPessoais SET codInformacoesPessoais = 0 WHERE 

