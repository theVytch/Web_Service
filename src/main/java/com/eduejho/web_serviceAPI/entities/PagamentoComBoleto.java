package com.eduejho.web_serviceAPI.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_pagamento_com_boleto")
public class PagamentoComBoleto extends Pagamento{

    private Date datavencimento;
    private Date dataPagamento;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public PagamentoComBoleto(Date datavencimento, Date dataPagamento, Pedido pedido) {
        super();
        this.datavencimento = datavencimento;
        this.dataPagamento = dataPagamento;
        this.pedido = pedido;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
