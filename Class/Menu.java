package Class;


import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
        // Criar um banco (banco em memória para este exemplo)
        Banco banco = new Banco();

        // Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Menu principal do sistema
        int opcao;
        do {
            System.out.println("\n### Sistema Bancário ###");
            System.out.println("1. Criar conta");
            System.out.println("2. Excluir conta");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Consultar saldo");
            System.out.println("7. Imprimir extrato");
            System.out.println("8. Sair");
            System.out.print("Escolha sua opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarConta(banco, scanner); // Criar conta
                    break;
                case 2:
                    excluirConta(banco, scanner); // Excluir conta
                    break;
                case 3:
                    depositar(banco, scanner); // Depositar
                    break;
                case 4:
                    sacar(banco, scanner); // Sacar
                    break;
                case 5:
                    transferir(banco, scanner); // Transferir
                    break;
                case 6:
                    consultarSaldo(banco, scanner); // Consultar saldo
                    break;
                case 7:
                    imprimirExtrato(banco, scanner); // Imprimir extrato
                    break;
                case 8:
                    System.out.println("Obrigado por usar o Sistema Bancário!");
                    break;
                case 9: // Voltar ao Menu Principal
                    do {
                        System.out.println("\n\n### Sistema Bancário ###");
                        System.out.print("Escolha sua opção: ");
                        opcao = scanner.nextInt();
                    } while (opcao == 9);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 8);

        scanner.close();
    }

    // Método para criar conta
    private static void criarConta(Banco banco, Scanner scanner) {
        System.out.print("Nome do cliente: "); // Pegar nome do cliente
        String nomeCliente = scanner.next();
          
        banco.incluirCliente(nomeCliente); // Incluir cliente no banco
    }

    // Método para excluir conta
    private static void excluirConta(Banco banco, Scanner scanner) {
        System.out.print("Número da conta: "); // Pegar número da conta
        int numeroConta = scanner.nextInt();
        banco.excluirCliente(numeroConta); // Excluir cliente do banco
    }

    // Método para depositar
    private static void depositar(Banco banco, Scanner scanner) {
        System.out.print("Número da conta: "); // Pegar número da conta
        int numeroConta = scanner.nextInt();
        System.out.print("Valor do depósito: R$ "); // Pegar valor do depósito
        double valor = scanner.nextDouble();

        Conta conta = banco.buscarConta(numeroConta); // Buscar conta pelo número
        if (conta != null) {
            conta.depositar(valor); // Depositar valor na conta
            
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
    
 // Método para sacar
    private static void sacar(Banco banco, Scanner scanner) {
        System.out.print("Número da conta: "); // Pegar número da conta
        int numeroConta = scanner.nextInt();
        System.out.print("Valor do saque: R$ "); // Pegar valor do saque
        double valor = scanner.nextDouble();

        Conta conta = banco.buscarConta(numeroConta); // Buscar conta pelo número
        if (conta != null) {
            conta.sacar(valor); // Sacar valor da conta
        } else {
            System.out.println("Conta não encontrada.");
        	}
        }

    // Método para transferir
    private static void transferir(Banco banco, Scanner scanner) {
        System.out.print("Número da conta de origem: "); // Pegar número da conta de origem
        int numeroContaOrigem = scanner.nextInt();
        System.out.print("Número da conta de destino: "); // Pegar número da conta de destino
        int numeroContaDestino = scanner.nextInt();
        System.out.print("Valor da transferência: R$ "); // Pegar valor da transferência
        double valor = scanner.nextDouble();

        Conta contaOrigem = banco.buscarConta(numeroContaOrigem); // Buscar conta de origem
        Conta contaDestino = banco.buscarConta(numeroContaDestino); // Buscar conta de destino

        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor); // Realizar transferência
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
        }
    }

    // Método para Consultar Saldo
    private static void consultarSaldo(Banco banco, Scanner scanner) {
        System.out.print("Número da conta: "); // Pegar número da conta
        int numeroConta = scanner.nextInt();

        Conta conta = banco.buscarConta(numeroConta); // Buscar conta pelo número
        if (conta != null) {
            System.out.println("Saldo da conta " + conta.getNumeroConta() + ": R$" + conta.getSaldo()); // Exibir saldo
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    //Método para Imprimir Extrato
    private static void imprimirExtrato(Banco banco, Scanner scanner) {
        System.out.print("Número da conta: "); // Pegar número da conta
        int numeroConta = scanner.nextInt();

        Conta conta = banco.buscarConta(numeroConta); // Buscar conta pelo número
        if (conta != null) {
            conta.imprimirExtrato(); // Imprimir extrato da conta
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}




