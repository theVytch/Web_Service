package com.eduejho.web_serviceAPI.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_pagamento_com_boleto")
public class PagamentoComBoleto extends Pagamento{
    private static final long serialVersionUID = 1L;

    private Date datavencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(){}

    public PagamentoComBoleto(Long id, Pedido pedido, Date datavencimento, Date dataPagamento) {
        super(id, pedido);
        this.datavencimento = datavencimento;
        this.dataPagamento = dataPagamento;
    }

//    public PagamentoComBoleto(Long id, Date datavencimento, Date dataPagamento) {
//        super(id);
//        this.datavencimento = datavencimento;
//        this.dataPagamento = dataPagamento;
//    }

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
