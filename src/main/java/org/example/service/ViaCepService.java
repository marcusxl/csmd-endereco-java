package org.example.service;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.example.models.Endereco;

import java.io.IOException;
import java.net.http.HttpClient;
/*Classe que faz o contato com a API*/
public class ViaCepService {

    /*Metodo que faz a busca pelo CEP e retorna um Objeto Endereco*/
    public  Endereco getEndereco(String cep) throws IOException {

        Endereco endereco = null; //Objeto endereco

        //Aqui estamos entradndo em contato com a api atraves do metodo GET

        HttpGet reques = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");

        //Bloco de codigo que transforma O Json em um Objeto

        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
            CloseableHttpResponse response = httpClient.execute(reques)) {

            HttpEntity entity = response.getEntity();

            if(entity != null){
                String result = EntityUtils.toString(entity); // passando a resposta para "result"

                Gson gson = new Gson();

                endereco = gson.fromJson(result, Endereco.class); //Transformando em um Objeto
            }
        }

        return  endereco;//Retornando o Objeto

    }
}
