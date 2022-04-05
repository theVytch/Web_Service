package com.eduejho.web_serviceAPI.config;

import com.eduejho.web_serviceAPI.entities.*;
import com.eduejho.web_serviceAPI.repositories.*;
import com.eduejho.web_serviceAPI.entities.Categoria;
import com.eduejho.web_serviceAPI.entities.Cliente;
import com.eduejho.web_serviceAPI.entities.Endereco;
import com.eduejho.web_serviceAPI.entities.Produto;
import com.eduejho.web_serviceAPI.repositories.CategoriaRepository;
import com.eduejho.web_serviceAPI.repositories.ClienteRepository;
import com.eduejho.web_serviceAPI.repositories.EnderecoRepository;
import com.eduejho.web_serviceAPI.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PagamentoRepository<PagamentoComBoleto> pagamentoComBoletoRepository;
    private final PagamentoRepository<PagamentoComCartao> pagamentoComCartaoRepository;


    @Autowired
    public TestConfig(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository,
                      CidadeRepository cidadeRepository, EstadoRepository estadoRepository,
                      CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository,
                      PedidoRepository pedidoRepository, ItemPedidoRepository itemPedidoRepository,
                      PagamentoRepository<PagamentoComBoleto> pagamentoComBoletoRepository,
                      PagamentoRepository<PagamentoComCartao> pagamentoComCartaoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
        this.pagamentoComBoletoRepository = pagamentoComBoletoRepository;
        this.pagamentoComCartaoRepository = pagamentoComCartaoRepository;
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

        c1.getTelefones().add(tel1);
        c2.getTelefones().add(tel2);
        c3.getTelefones().add(tel3);

        clienteRepository.saveAll(Arrays.asList(c1,c2,c3));


        Endereco e1 = new Endereco(null, "rua lirios","123", "casa", "monte rey", "12457812", c1, cid1);
        Endereco e2 = new Endereco(null, "rua cravos","132", "casa", "triangulo", "12457835",c2,  cid2);
        Endereco e3 = new Endereco(null, "rua rosas","321", "casa", "quadrado", "12457821",c3, cid1);

        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));


        Pedido ped1 = new Pedido(null, new Date(), c1, e1);
        Pedido ped2 = new Pedido(null, new Date(), c2, e1);
        Pedido ped3 = new Pedido(null, new Date(), c1, e2);
        Pedido ped4 = new Pedido(null, new Date(), c1, e3);

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4));

        PagamentoComCartao pag1 = new PagamentoComCartao( null,ped4,2);
        PagamentoComBoleto pag2 = new PagamentoComBoleto( null, ped2, new Date(), new Date());

        pagamentoComCartaoRepository.save(pag1);
        pagamentoComBoletoRepository.save(pag2);

        ItemPedido item1 = new ItemPedido(ped1, prod1, 2);
        ItemPedido item2 = new ItemPedido(ped1, prod2, 1);
        ItemPedido item3 = new ItemPedido(ped2, prod3, 6);

        itemPedidoRepository.saveAll(Arrays.asList(item1, item2, item3));

    }
}
