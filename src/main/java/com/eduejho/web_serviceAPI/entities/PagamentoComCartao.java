package com.eduejho.web_serviceAPI.entities;

import javax.persistence.*;

@Entity
@Table(name="tb_pagamento_com_cartao")
public class PagamentoComCartao extends Pagamento{
    private static final long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao(){}

    public PagamentoComCartao(Long id, Pedido pedido, Integer numeroDeParcelas) {
        super(id, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

//    public PagamentoComCartao(Long id, Integer numeroDeParcelas) {
//        super(id);
//        this.numeroDeParcelas = numeroDeParcelas;
//    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
