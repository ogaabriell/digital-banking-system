package com.bank.service;

import com.bank.model.Cliente;
import com.bank.model.Conta;
import com.bank.model.ContaCorrente;
import com.bank.model.ContaPoupanca;
import com.bank.model.Transacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
    private List<Cliente> clientes;
    private Map<String, Conta> contas;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new HashMap<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void criarContaCorrente(Cliente cliente, ContaCorrente conta) {
        contas.put(conta.getNumeroConta(), conta);
        adicionarCliente(cliente);
    }

    public void criarContaPoupanca(Cliente cliente, ContaPoupanca conta) {
        contas.put(conta.getNumeroConta(), conta);
        adicionarCliente(cliente);
    }

    public Conta obterConta(String numeroConta) {
        return contas.get(numeroConta);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public void realizarDeposito(String numeroConta, double valor) {
        Conta conta = obterConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        }
    }

    public void realizarSaque(String numeroConta, double valor) {
        Conta conta = obterConta(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        }
    }

    public void realizarTransferencia(String numeroContaOrigem, String numeroContaDestino, double valor) {
        Conta contaOrigem = obterConta(numeroContaOrigem);
        Conta contaDestino = obterConta(numeroContaDestino);
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
        }
    }

    public void exibirExtrato(String numeroConta) {
        Conta conta = obterConta(numeroConta);
        if (conta != null) {
            for (Transacao transacao : conta.getExtrato()) {
                System.out.println(transacao);
            }
        }
    }
}