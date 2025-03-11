package com.bank.service;

import com.bank.model.Conta;
import com.bank.model.Cliente;
import com.bank.model.ContaCorrente;
import com.bank.model.ContaPoupanca;

import java.util.Scanner;

public class Menu {
    private Banco banco;
    private Scanner scanner;

    public Menu(Banco banco) {
        this.banco = banco;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("=== Sistema Bancário ===");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Criar Conta Corrente");
            System.out.println("3. Criar Conta Poupança");
            System.out.println("4. Depositar");
            System.out.println("5. Sacar");
            System.out.println("6. Transferir");
            System.out.println("7. Consultar Saldo");
            System.out.println("8. Extrato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    criarCliente();
                    break;
                case 2:
                    criarContaCorrente();
                    break;
                case 3:
                    criarContaPoupanca();
                    break;
                case 4:
                    depositar();
                    break;
                case 5:
                    sacar();
                    break;
                case 6:
                    transferir();
                    break;
                case 7:
                    consultarSaldo();
                    break;
                case 8:
                    extrato();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void criarCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Contato do Cliente: ");
        String contato = scanner.nextLine();
        banco.adicionarCliente(new Cliente(nome, cpf, contato));
        System.out.println("Cliente criado com sucesso!");
    }

    private void criarContaCorrente() {
        System.out.print("Número da Conta Corrente: ");
        String numero = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();
        System.out.print("Limite de Cheque Especial: ");
        double limite = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Contato do Cliente: ");
        String contato = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf, contato);
        ContaCorrente conta = new ContaCorrente(numero, saldoInicial, limite);
        banco.criarContaCorrente(cliente, conta);
        System.out.println("Conta Corrente criada com sucesso!");
    }

    private void criarContaPoupanca() {
        System.out.print("Número da Conta Poupança: ");
        String numero = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();
        System.out.print("Taxa de Juros: ");
        double taxa = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Contato do Cliente: ");
        String contato = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf, contato);
        ContaPoupanca conta = new ContaPoupanca(numero, saldoInicial, taxa);
        banco.criarContaPoupanca(cliente, conta);
        System.out.println("Conta Poupança criada com sucesso!");
    }

    private void depositar() {
        System.out.print("Número da Conta: ");
        String numero = scanner.nextLine();
        System.out.print("Valor do Depósito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        banco.realizarDeposito(numero, valor);
        System.out.println("Depósito realizado com sucesso!");
    }

    private void sacar() {
        System.out.print("Número da Conta: ");
        String numero = scanner.nextLine();
        System.out.print("Valor do Saque: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        banco.realizarSaque(numero, valor);
        System.out.println("Saque realizado com sucesso!");
    }

    private void transferir() {
        System.out.print("Número da Conta Origem: ");
        String origem = scanner.nextLine();
        System.out.print("Número da Conta Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Valor da Transferência: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer
        banco.realizarTransferencia(origem, destino, valor);
        System.out.println("Transferência realizada com sucesso!");
    }

    private void consultarSaldo() {
        System.out.print("Número da Conta: ");
        String numero = scanner.nextLine();
        Conta conta = banco.obterConta(numero);
        if (conta != null) {
            System.out.println("Saldo atual: " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void extrato() {
        System.out.print("Número da Conta: ");
        String numero = scanner.nextLine();
        banco.exibirExtrato(numero);
    }
}