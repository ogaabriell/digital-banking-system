package com.bank.model;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, double saldoInicial, double limiteChequeEspecial) {
        super(numeroConta, saldoInicial);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }
        if (getSaldo() + limiteChequeEspecial < valor) {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
        setSaldo(getSaldo() - valor);
        registrarTransacao("Saque", valor);
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de transferência deve ser positivo.");
        }
        if (getSaldo() + limiteChequeEspecial < valor) {
            throw new IllegalArgumentException("Saldo insuficiente para transferência.");
        }
        setSaldo(getSaldo() - valor);
        contaDestino.depositar(valor);
        registrarTransacao("Transferência", valor);
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
}