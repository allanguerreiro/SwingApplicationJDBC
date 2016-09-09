package br.hibernate.local.config;


import javax.swing.*;
import java.sql.*;

public class Connection {

    JOptionPane optionPane = new NarrowOptionPane();
    private String urlODBC; // Recebe string de conexão com o banco
    private java.sql.Connection con;     // Recebe string que conecta com o banco
    private Statement stmt;    // Recebe string que permitirá a execução SQL
    private ResultSet res;      // Recebe um conjunto de resultado da tabela

    public Connection() {
        // Armazena a string de conexão
        urlODBC = "jdbc:mysql://localhost:3306/estudodecaso";
    }

    public void conectarBD() {
        try {
            // Carrega Driver Conexão
            Class.forName("com.mysql.jdbc.Driver");
            // Estabelece Conexão
            con = DriverManager.getConnection(urlODBC, "root", "");
            // Cria a conexão com o banco
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Driver JDBC-ODBC não encontrado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Problemas na conexão com a fonte de dados");
        }
    }

    public void desconectar() {
        boolean result = true;
        try {
            con.close();
            stmt.close();
        } catch (SQLException Fechar) {
            result = false;
            mensagem("Erro na conexao com a fonte de dados" + Fechar.getMessage() + "\n");
        }
    }

    public ResultSet executeSQL(StringBuilder query) {
        try {
            this.conectarBD();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            res = stmt.executeQuery(query.toString());

        } catch (SQLException sqlex) {

            sqlex.getMessage();
        }
        return res;
    }

    public void executarUpdate(StringBuilder query) {
        try {
            this.conectarBD();
            PreparedStatement preparedStatement = con.prepareStatement(query.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlex) {
            sqlex.getMessage();
        }
    }

    public ResultSet executarConsulta(StringBuilder query) {
        try {
            this.conectarBD();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            res = stmt.executeQuery(query.toString());

        } catch (SQLException sqlex) {
            mensagem(sqlex.getMessage());
        }

        return res;
    }

    public void mensagem(String mensagem) {
        optionPane.setMessage(mensagem);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Mensagem do Sistema");
        dialog.setVisible(true);
    }
}

class NarrowOptionPane extends JOptionPane {

    NarrowOptionPane() {}

    public int getMaxCharactersPerLineCount() {
        return 100;
    }
}