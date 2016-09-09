package br.hibernate.local.config;

import br.hibernate.local.model.Pessoa;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by allan on 09/09/16.
 */
public class ConnectionTest {
    private static Connection connection;
    private static Pessoa pessoa;
    public static void main(String[] args) {
        connection = new Connection();
        StringBuilder query = new StringBuilder("SELECT * FROM InformacoesPessoais");
        try {
            ResultSet resultSet = connection.executarConsulta(query);
            while (resultSet.next()) {
                pessoa = new Pessoa();
                pessoa.setCodidoPessoa(resultSet.getInt("id"));
                pessoa.setNome(resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
