/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Ricardo Rabelo
 */
public class Contato {
    
    private final String nome, numeroCelular;

    public Contato(String nome, String numeroCelular) {
        this.nome = nome;
        this.numeroCelular = numeroCelular;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }
    
    public static Contato criarContato(String nome, String numeroCelular) {
        return new Contato(nome, numeroCelular);
    }
    
}
