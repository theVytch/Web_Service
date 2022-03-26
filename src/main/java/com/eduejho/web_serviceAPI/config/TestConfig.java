package com.eduejho.web_serviceAPI.config;

import com.eduejho.web_serviceAPI.entities.Cliente;
import com.eduejho.web_serviceAPI.entities.Endereco;
import com.eduejho.web_serviceAPI.repositories.ClienteRepository;
import com.eduejho.web_serviceAPI.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public TestConfig(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente(null, "rodrigo", "rodrigo@gmail.com", "12345678918");
        Cliente c2 = new Cliente(null, "gabriel", "gabriel@gmail.com", "12345789684");
        Cliente c3 = new Cliente(null, "guilherme", "gui@gmail.com", "12378945684");

        Endereco e1 = new Endereco(null, "rua lirios","123", "casa", "monte rey", "12457812", c1);
        Endereco e2 = new Endereco(null, "rua cravos","132", "casa", "triangulo", "12457835",c2);
        Endereco e3 = new Endereco(null, "rua rosas","321", "casa", "quadrado", "12457821",c3);

        clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

    }
}
