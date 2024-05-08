package org.example.db;

import org.example.models.Endereco;
import org.example.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDao {

    Connection connection;

    public EnderecoDao(){
        this.connection = ConnectionFactory.getConnection();
    }

    public void save(Endereco endereco){
        String query = "INSERT INTO endereco (ed_cep, ed_logradouro, ed_bairro, ed_localidade, ed_uf, ed_ddd) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, endereco.getCep());
            stm.setString(2, endereco.getLogradouro());
            stm.setString(3,endereco.getBairro());
            stm.setString(4, endereco.getLocalidade());
            stm.setString(5, endereco.getUf());
            stm.setInt(6, Integer.valueOf(endereco.getDdd()));

            stm.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
