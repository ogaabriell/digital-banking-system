package com.bank.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta {
    private String numeroConta;
    private double saldo;
    private List<Transacao> extrato;

    public Conta(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.extrato = new ArrayList<>();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }
        saldo += valor;
        registrarTransacao("Depósito", valor);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        registrarTransacao("Saque", valor);
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de transferência deve ser positivo.");
        }
        sacar(valor);
        contaDestino.depositar(valor);
        registrarTransacao("Transferência", valor);
    }

    public List<Transacao> getExtrato() {
        return extrato;
    }

    protected void registrarTransacao(String tipo, double valor) {
        Transacao transacao = new Transacao(tipo, valor, new Date());
        extrato.add(transacao);
    }
}

