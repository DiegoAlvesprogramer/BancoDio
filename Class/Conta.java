package Class;

import java.util.ArrayList;
import java.util.List;

import Class.Transacao.TipoTransacao;

public class Conta {

    // Atributos
    private int numeroConta;
    private String nomeCliente;
    private double saldo;
    private List<Transacao> extrato;

    // Construtor
    public Conta(int numeroConta, String nomeCliente) {
        this.numeroConta = numeroConta;
        this.nomeCliente = nomeCliente;
        this.saldo = 0;
        this.extrato = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "Número da Conta: " + numeroConta + "\n" +
               "Nome do Cliente: " + nomeCliente + "\n" +
               "Saldo: R$" + String.format("%.2f", saldo);
    }
    
    // Métodos
   
    public void depositar(double valor) {
        if (valor > 0) { //@param valor Valor a ser depositado (deve ser positivo).
            this.saldo += valor;
            this.extrato.add(new Transacao(TipoTransacao.DEPOSITO, valor)); // Deposita o valor especificado na conta.
            System.out.println("Depósito realizado com sucesso!\n"
            		+ "Seu Saldo atual é de: R$" + this.saldo);
        } else {
            throw new IllegalArgumentException("Erro: Valor do depósito deve ser positivo.");
            //@throws IllegalArgumentException Se o valor for negativo.
        }
    }

    
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) { //@param valor Valor a ser sacado (deve ser positivo e menor ou igual ao saldo).
            this.saldo -= valor;
            this.extrato.add(new Transacao(TipoTransacao.SAQUE, valor));
            System.out.println("Saque realizado com sucesso!"
            		+ "\nSeu Saldo atual é de: R$" + this.saldo);
        } else {
            throw new IllegalArgumentException("Erro: Valor do saque deve ser positivo e menor ou igual ao saldo.");
        //@throws IllegalArgumentException Se o valor for negativo ou maior que o saldo.
        }
    }

    public void transferir(Conta destino, double valor) {// @param destino Conta para a qual o valor será transferido.
        if (valor > 0 && valor <= this.saldo && destino != null) { //@param valor Valor a ser transferido (deve ser positivo e menor ou igual ao saldo).
            this.saldo -= valor;
            destino.saldo += valor;

            this.extrato.add(new Transacao(TipoTransacao.TRANSFERENCIA, valor, destino.getNumeroConta()));
            destino.extrato.add(new Transacao(TipoTransacao.RECEBIMENTO_TRANSFERENCIA, valor, this.getNumeroConta()));

            System.out.println("Transferência realizada com sucesso! R$" + valor + " transferidos para a conta " + 
            destino.getNumeroConta() + "." + "\nSeu Saldo atual é de: R$" + this.saldo);
        } else {
            throw new IllegalArgumentException("Erro: Valor da transferência deve ser positivo e menor ou igual ao saldo.");
        //@throws IllegalArgumentException Se o valor for negativo, maior que o saldo ou a conta destino for null.
        }
    }

    /**
     * Retorna o valor do saldo da conta.
     *
     * @return Saldo atual da conta.
     */
    public double consultarSaldo() {
        return this.saldo;
    }

    /**
     * Imprime o extrato da conta, exibindo cada transação na lista `extrato`.
     */
    public void imprimirExtrato() {
        System.out.println("Extrato da Conta: " + this.numeroConta);
        for (Transacao transacao : this.extrato) {
            System.out.println(transacao);
        }
    }
    
    // Getters and setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transacao> getExtrato() {
        return extrato;
    }
}
