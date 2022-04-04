package com.eduejho.web_serviceAPI.entities;

import javax.persistence.*;

@Entity
@Table(name="tb_pagamento_com_cartao")
public class PagamentoComCartao extends Pagamento{

    private Integer numeroDeParcelas;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public PagamentoComCartao(Integer numeroDeParcelas, Pedido pedido) {
        super();
        this.numeroDeParcelas = numeroDeParcelas;
        this.pedido = pedido;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
