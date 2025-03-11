# Sistema Bancário Digital

## Visão Geral
O Sistema Bancário Digital é uma aplicação baseada em Java que simula um ambiente bancário, permitindo que os usuários gerenciem suas contas, realizem transações e visualizem suas atividades financeiras. O sistema suporta dois tipos de contas: Conta Corrente e Conta Poupança, cada uma com suas próprias características únicas.

## Funcionalidades
- **Tipos de Conta**:
    - **Conta Corrente**: Permite depósitos, saques, transferências e inclui um limite de cheque especial.
    - **Conta Poupança**: Permite depósitos, saques, transferências e acumula juros mensais.

- **Funcionalidades**:
    - Depositar fundos nas contas.
    - Sacar fundos respeitando o saldo da conta e os limites.
    - Transferir fundos entre contas dentro do mesmo banco.
    - Verificar o saldo atual da conta.
    - Visualizar o histórico de transações (extrato).

## Primeiros Passos

### Pré-requisitos
- Java Development Kit (JDK) 11 ou superior
- Apache Maven

### Instalação
1. Clone o repositório:
    ```
    git clone https://github.com/seunomeusuario/digital-banking-system.git
    ```
2. Navegue até o diretório do projeto:
    ```
    cd digital-banking-system
    ```
3. Construa o projeto usando o Maven:
    ```
    mvn clean install
    ```

### Executando a Aplicação
Para executar a aplicação, execute o seguinte comando:
```
mvn exec:java -Dexec.mainClass="com.bank.App"
```

## Uso
Uma vez que a aplicação esteja em execução, você será apresentado a um menu interativo. Siga as instruções para realizar várias operações bancárias, como criar contas, fazer depósitos, saques e transferências.

## Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para enviar um pull request ou abrir uma issue para quaisquer sugestões ou melhorias.

## Licença
Este projeto é licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.
