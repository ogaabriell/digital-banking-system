package com.bank.model;

public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(String numeroConta, double saldoInicial, double taxaJuros) {
        super(numeroConta, saldoInicial);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }
        if (valor > getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        super.sacar(valor);
        registrarTransacao("Saque", valor);
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }
        super.depositar(valor);
        registrarTransacao("Depósito", valor);
    }

    public void aplicarRendimento() {
        double juros = getSaldo() * taxaJuros;
        depositar(juros);
    }

    @Override
    public String toString() {
        return "Conta Poupança{" +
                "Número da Conta='" + getNumeroConta() + '\'' +
                ", Saldo=" + getSaldo() +
                ", Taxa de Juros=" + taxaJuros +
                '}';
    }
}