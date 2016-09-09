/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.hibernate.local.controller;

import br.hibernate.local.config.Connection;
import br.hibernate.local.model.Curriculo;
import br.hibernate.local.model.Descricao;
import br.hibernate.local.model.ObjetivoProfissional;
import br.hibernate.local.model.Pessoa;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author allan.carneiro
 */
public class CurriculoController {
    // Conexão com a classe responsável pelo banco de dados    
    Connection conx = new Connection();

    // Modelos
    Pessoa pessoa = new Pessoa();

    public void inserirPessoa(Pessoa pessoa) {
        try {

            StringBuilder queryPessoa = new StringBuilder();

            queryPessoa.append("INSERT INTO PESSOA(NOME, ENDERECO,");
            queryPessoa.append(" BAIRRO, CIDADE, EMAIL, UF, SEXO)");
            queryPessoa.append(" VALUES(");
            queryPessoa.append("'").append(pessoa.getNome()).append("'").append(",");
            queryPessoa.append("'").append(pessoa.getEndereco()).append("'").append(",");
            queryPessoa.append("'").append(pessoa.getBairro()).append("'").append(",");
            queryPessoa.append("'").append(pessoa.getCidade()).append("'").append(",");
            queryPessoa.append("'").append(pessoa.getEmail()).append("'").append(",");
            queryPessoa.append("'").append(pessoa.getEstado()).append("'").append(",");
            queryPessoa.append("'").append(pessoa.getSexo()).append("'").append(")");

            conx.executeSQL(queryPessoa);
            conx.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas no cadastro" + e.getMessage());
        }
    }

    public void inserirDescricao(Descricao descricao) {
        try {

            StringBuilder queryDescricao = new StringBuilder();

            queryDescricao.append("INSERT INTO DESCRICAO(CODIGOPESSOA, DESCRICAO)");
            queryDescricao.append(" VALUES(");
            queryDescricao.append(descricao.getCodigoPessoa()).append(",");
            queryDescricao.append("'").append(descricao.getDescricao()).append("')");

            conx.executeSQL(queryDescricao);
            conx.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas no cadastro" + e.getMessage());
        }
    }


    public void inserirObjProfissional(ObjetivoProfissional objetivoProfissional) {
        try {

            StringBuilder queryObjetivoProfissional = new StringBuilder();

            queryObjetivoProfissional.append("INSERT INTO OBJETIVO_PROFISSIONAL(");
            queryObjetivoProfissional.append(" CODIGOPESSOA, ESCOLARIDADE, AREAATUACAO,");
            queryObjetivoProfissional.append(" PRETENSAOSALARIAL, CARGODESEJAVEL)");
            queryObjetivoProfissional.append("VALUES(");
            queryObjetivoProfissional.append(objetivoProfissional.getCodigoPessoa()).append(",");
            queryObjetivoProfissional.append("'").append(objetivoProfissional.getEscolaridade()).append("'").append(",");
            queryObjetivoProfissional.append("'").append(objetivoProfissional.getAreaAtuacao()).append("'").append(",");
            queryObjetivoProfissional.append("'").append(objetivoProfissional.getPretensaoSalarial()).append("'").append(",");
            queryObjetivoProfissional.append("'").append(objetivoProfissional.getCargoDesejavel()).append("'").append(")");

            conx.executeSQL(queryObjetivoProfissional);
            conx.desconectar();

            JOptionPane.showMessageDialog(null,
                    "Gravação realizada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas no cadastro" + e.getMessage());
        }
    }


    public Integer pesquisarCodigoPessoa(String nome) {

        Integer codigoPessoa = null;
        ResultSet resultSet;

        try {

            StringBuilder query = new StringBuilder();
            query.append("SELECT CODIGOPESSOA FROM PESSOA");
            query.append(" WHERE NOME = ").append("'").append(nome).append("'");

            resultSet = conx.executarConsulta(query);
            boolean EOF = !(resultSet.next());

            if (EOF) {
                String msg = "O Nome " + pessoa.getNome() + " não existe!";
            } else {
                int numCols = resultSet.getMetaData().getColumnCount();
                while (!EOF) { // Execute enquanto não for fim
                    pessoa.setCodidoPessoa(resultSet.getInt("codigoPessoa"));
                    codigoPessoa = pessoa.getCodigoPessoa();
                    EOF = !(resultSet.next());
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Problemas na conexão com a fonte de dados");
        } finally {
            conx.desconectar();
        }
        return codigoPessoa;
    }


    public Curriculo pesquisarCurriculoPorNome(String nome) {

        ResultSet resultSet;
        Curriculo curriculo = null;

        try {

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM PESSOA AS P");
            query.append(" INNER JOIN DESCRICAO AS D ON D.CODIGOPESSOA = P.CODIGOPESSOA");
            query.append(" INNER JOIN OBJETIVO_PROFISSIONAL AS OP ON OP.CODIGOPESSOA = P.CODIGOPESSOA");
            query.append(" WHERE P.NOME = '").append(nome).append("'");

            resultSet = conx.executeSQL(query);
            boolean EOF = !(resultSet.next());
            if (EOF) {
                String msg = "O Nome " + nome + " não existe no banco de dados!";
                JOptionPane.showMessageDialog(null, msg);
            } else {
                int numCols = resultSet.getMetaData().getColumnCount();
                while (!EOF) { // Execute enquanto não for fim

                    curriculo = new Curriculo();
                    curriculo.setCodigoPessoa(resultSet.getInt("codigoPessoa"));
                    curriculo.setNome(resultSet.getString("nome"));
                    curriculo.setEndereco(resultSet.getString("endereco"));
                    curriculo.setBairro(resultSet.getString("bairro"));
                    curriculo.setCidade(resultSet.getString("cidade"));
                    curriculo.setEmail(resultSet.getString("email"));
                    curriculo.setEstado(resultSet.getString("uf"));
                    curriculo.setSexo(resultSet.getString("sexo"));
                    curriculo.setCodidoDescricao(resultSet.getInt("codigoDescricao"));
                    curriculo.setDescricao(resultSet.getString("descricao"));
                    curriculo.setCodObjProfissional(resultSet.getInt("codigoObjProfissional"));
                    curriculo.setEscolaridade(resultSet.getString("escolaridade"));
                    curriculo.setAreaAtuacao(resultSet.getString("areaAtuacao"));
                    curriculo.setPretensaoSalarial(resultSet.getString("pretensaoSalarial"));
                    curriculo.setCargoDesejavel(resultSet.getString("cargoDesejavel"));
                    EOF = !(resultSet.next());
                }
                JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Problemas na conexão com a fonte de dados");
        } finally {
            conx.desconectar();
        }

        return curriculo;
    }


    public void alterarCurriculo(Curriculo curriculo, Integer codigoPessoa) {
        try {
            StringBuilder sql1 = new StringBuilder();
            sql1.append("UPDATE PESSOA");
            sql1.append(" SET NOME = '").append(curriculo.getNome()).append("',");
            sql1.append(" ENDERECO = '").append(curriculo.getEndereco()).append("',");
            sql1.append(" BAIRRO = '").append(curriculo.getBairro()).append("',");
            sql1.append(" CIDADE = '").append(curriculo.getCidade()).append("',");
            sql1.append(" EMAIL = '").append(curriculo.getEmail()).append("',");
            sql1.append(" UF = '").append(curriculo.getEstado()).append("',");
            sql1.append(" SEXO = '").append(curriculo.getSexo()).append("'");
            sql1.append(" WHERE CODIGOPESSOA = '").append(codigoPessoa).append("'");

            StringBuilder sql2 = new StringBuilder();
            sql2.append("UPDATE DESCRICAO");
            sql2.append(" SET DESCRICAO = '").append(curriculo.getDescricao()).append("'");
            sql2.append(" WHERE CODIGOPESSOA = '").append(codigoPessoa).append("'");

            StringBuilder sql3 = new StringBuilder();
            sql3.append("UPDATE OBJETIVO_PROFISSIONAL");
            sql3.append(" SET ESCOLARIDADE = '").append(curriculo.getEscolaridade()).append("',");
            sql3.append(" AREAATUACAO = '").append(curriculo.getAreaAtuacao()).append("',");
            sql3.append(" PRETENSAOSALARIAL = '").append(curriculo.getPretensaoSalarial()).append("',");
            sql3.append(" CARGODESEJAVEL = '").append(curriculo.getCargoDesejavel()).append("'");
            sql3.append(" WHERE CODIGOPESSOA = '").append(codigoPessoa).append("'");

            conx.executarUpdate(sql1);
            conx.executarUpdate(sql2);
            conx.executarUpdate(sql3);

            JOptionPane.showMessageDialog(null,
                    "Alteração realizada com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Problemas na conexão com a fonte de dados");
        } finally {
            conx.desconectar();
        }
    }

    public void excluiDados(Integer codigoPessoa) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM PESSOA");
            query.append(" WHERE CODIGOPESSOA = ").append(codigoPessoa);
            conx.executarUpdate(query);
            JOptionPane.showMessageDialog(null,
                    "Exclusão realizada com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Problemas na conexão com a fonte de dados");
        } finally {
            conx.desconectar();
        }
    }
}
