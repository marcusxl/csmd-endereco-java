package org.example;

import org.example.db.EnderecoDao;
import org.example.models.Endereco;
import org.example.service.ViaCepService;

import javax.xml.stream.events.EndDocument;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {

        ViaCepService viaCep = new ViaCepService();

        try {

            EnderecoDao endDao = new EnderecoDao();
            Endereco endereco = viaCep.getEndereco("74474416");

            endDao.save(endereco);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
