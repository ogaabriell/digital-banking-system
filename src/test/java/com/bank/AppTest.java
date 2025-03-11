package com.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.bank.model.Cliente;
import com.bank.model.ContaCorrente;
import com.bank.model.ContaPoupanca;
import com.bank.service.Banco;

public class AppTest {
    private Banco banco;
    private Cliente cliente;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    @BeforeEach
    public void setUp() {
        banco = new Banco();
        cliente = new Cliente("João Silva", "123.456.789-00", "joao@example.com");
        contaCorrente = new ContaCorrente("001", 1000.0, 500.0);
        contaPoupanca = new ContaPoupanca("002", 2000.0, 0.05);
        
        banco.adicionarCliente(cliente);
        banco.criarContaCorrente(cliente, contaCorrente);
        banco.criarContaPoupanca(cliente, contaPoupanca);
    }

    @Test
    public void testDepositoContaCorrente() {
        contaCorrente.depositar(500.0);
        assertEquals(1500.0, contaCorrente.getSaldo(), 0.001);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testSaqueContaCorrente() {
        contaCorrente.sacar(300.0);
        assertEquals(700.0, contaCorrente.getSaldo());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testTransferenciaContaCorrenteParaPoupanca() {
        contaCorrente.transferir(contaPoupanca, 200.0);
        assertEquals(800.0, contaCorrente.getSaldo());
        assertEquals(2200.0, contaPoupanca.getSaldo());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testRendimentoContaPoupanca() {
        contaPoupanca.aplicarRendimento();
        assertEquals(2100.0, contaPoupanca.getSaldo());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testSaqueContaPoupanca() {
        contaPoupanca.sacar(500.0);
        assertEquals(1500.0, contaPoupanca.getSaldo());
    }

    @Test
    public void testSaldoInsuficiente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contaCorrente.sacar(2000.0);
        });
        assertEquals("Saldo insuficiente para saque.", exception.getMessage());
    }
}