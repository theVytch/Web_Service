package com.eduejho.web_serviceAPI.config;

import com.eduejho.web_serviceAPI.entities.*;
import com.eduejho.web_serviceAPI.repositories.*;
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
    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    @Autowired
    public TestConfig(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository,
                      CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Estado est1 = new Estado(null, "Parana");
        Estado est2 = new Estado(null, "Sao paulo");
        Estado est3 = new Estado(null, "Rio de Janeiro");

        estadoRepository.saveAll(Arrays.asList(est1,est2,est3));

        Cidade cid1 = new Cidade(null, "Maringa", est1);
        Cidade cid2 = new Cidade(null, "Sarandi", est1);
        Cidade cid3 = new Cidade(null, "Maringa", est1);

        cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));

        Cliente c1 = new Cliente(null, "rodrigo", "rodrigo@gmail.com", "12345678918");
        Cliente c2 = new Cliente(null, "gabriel", "gabriel@gmail.com", "12345789684");
        Cliente c3 = new Cliente(null, "guilherme", "gui@gmail.com", "12378945684");

        clienteRepository.saveAll(Arrays.asList(c1,c2,c3));

        Telefone tel1 = new Telefone(null, c1, "44925581111");
        Telefone tel2 = new Telefone(null, c2, "44969942222");
        Telefone tel3 = new Telefone(null, c3, "44974153333");

        clienteRepository.saveAll(Arrays.asList(c1,c2,c3));

        c1.getTelefones().add(tel1);
        c2.getTelefones().add(tel2);
        c3.getTelefones().add(tel3);

        clienteRepository.saveAll(Arrays.asList(c1,c2,c3));


        Endereco e1 = new Endereco(null, "rua lirios","123", "casa", "monte rey", "12457812", c1, cid1);
        Endereco e2 = new Endereco(null, "rua cravos","132", "casa", "triangulo", "12457835",c2,  cid2);
        Endereco e3 = new Endereco(null, "rua rosas","321", "casa", "quadrado", "12457821",c3, cid1);


        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
    }
}
