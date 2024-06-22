package Class; // Nome do pacote

import java.time.LocalDateTime; // Importação da classe LocalDateTime

public class Transacao { // Declaração da classe Transacao

    // Atributos da transacao
    private TipoTransacao tipo; // Tipo da transacao (DEPOSITO, SAQUE, TRANSFERENCIA, RECEBIMENTO_TRANSFERENCIA)
    private double valor; // Valor da transacao
    private LocalDateTime dataHora; // Data e hora da transacao
    private Integer numeroContaDestino; // Numero da conta de destino (apenas para transferencias)

    // Enum para os tipos de transacao
    public enum TipoTransacao {
        DEPOSITO, SAQUE, TRANSFERENCIA, RECEBIMENTO_TRANSFERENCIA
    }

    // Construtores da classe Transacao
    public Transacao(TipoTransacao tipo, double valor) { // Construtor para deposito e saque
        this.tipo = tipo; // Define o tipo da transacao
        this.valor = valor; // Define o valor da transacao
        this.dataHora = LocalDateTime.now(); // Registra a data e hora da transacao no momento da criacao
    }

    public Transacao(TipoTransacao tipo, double valor, int numeroContaDestino) { // Construtor para transferencia
        this.tipo = tipo; // Define o tipo da transacao
        this.valor = valor; // Define o valor da transacao
        this.dataHora = LocalDateTime.now(); // Registra a data e hora da transacao no momento da criacao
        this.numeroContaDestino = numeroContaDestino; // Define o numero da conta de destino
    }

    // Getters para os atributos da transacao
    public TipoTransacao getTipo() { // Retorna o tipo da transacao
        return tipo;
    }

    public double getValor() { // Retorna o valor da transacao
        return valor;
    }

    public LocalDateTime getDataHora() { // Retorna a data e hora da transacao
        return dataHora;
    }

    public Integer getnumeroContaDestino() { // Retorna o numero da conta de destino (apenas para transferencias)
        return numeroContaDestino;
    }

    // Setters para os atributos da transacao
    public void setTipo(TipoTransacao tipo) { // Define o tipo da transacao
        this.tipo = tipo;
    }

    public void setValor(double valor) { // Define o valor da transacao
        this.valor = valor;
    }

    public void setNumeroContaDestino(Integer numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }

    // toString para formatar a impressão da transação
    @Override
    public String toString() {
        return "[Tipo: " + tipo + "\nValor: R$" + valor + "\nData/Hora: " + dataHora + (numeroContaDestino != null ? "\nConta Destino: " + numeroContaDestino : "") + "]";
    }
}
