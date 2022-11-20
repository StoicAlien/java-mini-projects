package main;

/**
 *
 * @author rickt
 * Feito em Novembro de 2020
 * Aluno: Ricardo de Souza Rabelo Filho
 Projeto: Frequência Cardíaca Alvo
 Descrição: Segundo a American Heart Association (AHA), a fórmula para calcular a frequência cardíaca
 máxima por minuto é 220 menos a idade em anos. Sua frequência cardíaca alvo é um intervalo entre 50-85% da sua frequência cardíaca
 máxima.
 Objetivo: Definir o ritmo cardíaco ideal para determinado ser humano para execução de seus exercícios físicos.
 Fonte: www.americanheart.org/presenter.jhtml?identifier=4736 e https://veja.abriyouom.br/saude/qual-e-a-frequencia-cardiaca-ideal-durante-o-exercicio/
 */
import java.util.Random;

public class FrequenciaCardiacaAlvoCalculo extends javax.swing.JFrame {
    private String nome;
    private int idade;
    private int frequenciaCardiacaMax;
    private double frequenciaAlvoMin;
    private double frequenciaAlvoMax;
    private int simulador;
    private String status;

    public String getStatus() {
        if(simulador<frequenciaAlvoMax & simulador>frequenciaAlvoMin){
            status="Seu ritmo cardíaco está estável! Continue assim.";
        }if(simulador<frequenciaAlvoMin){
            status="Perigo! Você deve acelerar seu ritmo cardíaco.";
        }if(simulador>frequenciaAlvoMax){
            status="Perigo! Você deve diminuir seu ritmo cardíaco.";
        }
        
        return status;
    }
    
    public int getSimulador() {
        Random aleatorio = new Random();
        simulador= aleatorio.nextInt((frequenciaCardiacaMax-0)+1)+0; // Para gerar números entre um intervalo especificado, devemos utilizar a seguinte fórmula: aleatorio.nextInt((max - min) + 1) + min; onde max é o valor máximo do intervalo e min é o valor inicial do intervalo.
        return simulador;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getFrequenciaCardiacaMax() {
        this.frequenciaCardiacaMax=220-this.idade;
        return frequenciaCardiacaMax;
    }

    public void setFrequenciaCardiacaMax(int frequenciaCardiacaMax) {
        this.frequenciaCardiacaMax = frequenciaCardiacaMax;        
    }

    public double getFrequenciaAlvoMin() {
        this.frequenciaAlvoMin= frequenciaCardiacaMax*0.5;
        return frequenciaAlvoMin;
    }

    public void setFrequenciaAlvoMin(double frequenciaAlvoMin) {
        this.frequenciaAlvoMin = frequenciaAlvoMin;        
    }

    public double getFrequenciaAlvoMax() {
        this.frequenciaAlvoMax= frequenciaCardiacaMax*0.85;
        return frequenciaAlvoMax;
    }

    public void setFrequenciaAlvoMax(double frequenciaAlvoMax) {
        this.frequenciaAlvoMax = frequenciaAlvoMax;        
    }
    
}
