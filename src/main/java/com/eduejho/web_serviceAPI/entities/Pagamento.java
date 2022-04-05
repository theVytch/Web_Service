package com.eduejho.web_serviceAPI.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToMany(mappedBy = "pagamento")
//    private Pedido pedido;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Pagamento(){}

    public Pagamento(Long id, Pedido pedido){
        this.id = id;
        this.pedido = pedido;
    }

//    public Pagamento(Long id){
//        this.id = id;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
