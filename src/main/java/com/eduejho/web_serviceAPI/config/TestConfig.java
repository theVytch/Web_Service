package com.eduejho.web_serviceAPI.config;

import com.eduejho.web_serviceAPI.entities.*;
import com.eduejho.web_serviceAPI.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public TestConfig(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository, PedidoRepository pedidoRepository, ItemPedidoRepository itemPedidoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente(null, "rodrigo", "rodrigo@gmail.com", "12345678918");
        Cliente c2 = new Cliente(null, "gabriel", "gabriel@gmail.com", "12345789684");
        Cliente c3 = new Cliente(null, "guilherme", "gui@gmail.com", "12378945684");

        Endereco e1 = new Endereco(null, "rua lirios","123", "casa", "monte rey", "12457812", c1);
        Endereco e2 = new Endereco(null, "rua cravos","132", "casa", "triangulo", "12457835",c2);
        Endereco e3 = new Endereco(null, "rua rosas","321", "casa", "quadrado", "12457821",c3);

        Categoria cat1 = new Categoria(null, "Limpeza");
        Categoria cat2 = new Categoria(null, "Bebida");

        Produto prod1 = new Produto(null, "Detergente", 5.50);
        Produto prod2 = new Produto(null, "Coca-cola", 9.00);
        Produto prod3 = new Produto(null, "Cerveja Heineken 330ml", 6.35);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

        prod1.getCategorias().add(cat2);
        prod2.getCategorias().add(cat1);
        prod3.getCategorias().add(cat2);

        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

        clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

        Pedido ped1 = new Pedido(null, new Date(), c1);
        Pedido ped2 = new Pedido(null, new Date(), c2);
        Pedido ped3 = new Pedido(null, new Date(), c1);
        Pedido ped4 = new Pedido(null, new Date(), c1);

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4));

        ItemPedido item1 = new ItemPedido(ped1, prod1, 2);
        ItemPedido item2 = new ItemPedido(ped1, prod2, 1);
        ItemPedido item3 = new ItemPedido(ped2, prod3, 6);

        itemPedidoRepository.saveAll(Arrays.asList(item1, item2, item3));
    }
}
