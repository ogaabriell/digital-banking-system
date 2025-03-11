package com.bank;

import com.bank.service.Banco;
import com.bank.service.Menu;

public class App {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Menu menu = new Menu(banco);
        menu.exibirMenu();
    }
}