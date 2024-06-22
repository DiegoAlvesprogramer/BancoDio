package Class;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    // Atributo
    private List<Conta> contas;
    

    // Construtor
    public Banco() {
        this.contas = new ArrayList<>();
    }

    // Métodos
    public void incluirCliente(String nomeCliente) {
        int novoNumeroConta = gerarNumeroConta(); // Implementar método para gerar número único
        Conta novaConta = new Conta(novoNumeroConta, nomeCliente);
        this.contas.add(novaConta);
        double saldoInicial = 0; // Valor inicial do saldo pode ser ajustado
        
        System.out.println("Conta criada com sucesso! Número da conta: " + novoNumeroConta + " Seu saldo é de: " + saldoInicial);
    }

    public void excluirCliente(int numeroConta) {
        Conta contaParaExcluir = buscarConta(numeroConta);
        if (contaParaExcluir != null) {
            this.contas.remove(contaParaExcluir);
            System.out.println("Conta excluída com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta conta : this.contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
    
    	private static int contadorConta = 1000;

    	private int gerarNumeroConta() {
    	    return contadorConta++;
    }
}
