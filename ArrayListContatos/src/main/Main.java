/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Ricardo Rabelo
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Celular celular = new Celular("71 9999-6666");

    public static void main(String[] args) {
        boolean quit = false;

        iniciarCelular();
        imprimirAcoes();

        while (!quit) {
            System.out.println("\nEntre com uma ação: (6 ações disponíveis)");
            int acao = scanner.nextInt();
            scanner.nextLine(); //handle the nextInt

            switch (acao) {
                case 0:
                    System.out.println("\nDesligando...");
                    quit = true;
                    break;

                case 1:
                    celular.imprimirContatos();
                    break;

                case 2:
                    addNovoContato();
                    break;

                case 3:
                    atualizarContato();
                    break;

                case 4:
                    removerContato();
                    break;

                case 5:
                    pesquisarContato();
                    break;

                case 6:
                    imprimirAcoes();
                    break;

                default:
                    System.out.println("\nEntrada Inválida");
            }
        }
    }

    private static void addNovoContato() {
        System.out.println("Insira nome do novo contato: ");
        String nome = scanner.nextLine();
        System.out.println("Insira o número do celular: ");
        String numeroCelular = scanner.nextLine();

        Contato novoContato = Contato.criarContato(nome, numeroCelular);
        if (celular.addNovoContato(novoContato)) {
            System.out.println("Novo contato adicionado: nome = " + nome + ", número = " + numeroCelular);
        } else {
            System.out.println("Erro ao adicionar. " + nome + " já está nos contatos");
        }
    }

    private static void atualizarContato() {
        System.out.println("Insira nome do contato que deseja atualizar: ");
        String nome = scanner.nextLine();

        Contato contatoExistente = celular.pesquisarContato(nome);
        if (contatoExistente == null) {
            System.out.println("Contato não encontrado");
            return;
        }

        System.out.println("Insira nome do novo contato: ");
        String novoNome = scanner.nextLine();
        System.out.println("Insira número do novo contato: ");
        String novoNumero = scanner.nextLine();

        Contato novoContato = Contato.criarContato(novoNome, novoNumero);
        if (celular.atualizarContato(contatoExistente, novoContato)) {
            System.out.println("Contato atualizado com sucesso");
        } else {
            System.out.println("Erro ao atualizar contato");
        }
    }

    private static void removerContato() {
        System.out.println("Insira nome do contato que deseja remover: ");
        String nome = scanner.nextLine();

        Contato contatoExistente = celular.pesquisarContato(nome);
        if (contatoExistente == null) {
            System.out.println("Contato não encontrado");
            return;
        }

        if (celular.removerContato(contatoExistente)) {
            System.out.println("Contato removido com sucesso");
        } else {
            System.out.println("Erro ao remover contato");
        }

    }

    private static void pesquisarContato() {
        System.out.println("Insira nome do contato que deseja pesquisar: ");
        String nome = scanner.nextLine();
        Contato contatoExistente = celular.pesquisarContato(nome);
        
        if (contatoExistente == null) {
            System.out.println("Contato não encontrado");
            return;
        }
        
        System.out.println("Nome: " + contatoExistente.getNome() + " | " + "Número: " + contatoExistente.getNumeroCelular());
    }
    
    private static void iniciarCelular() {
        System.out.println("Iniciando celular...");
    }
    
    private static void imprimirAcoes() {
        System.out.println("\nAções disponíveis:\nEntre com");
        System.out.println("0 - para desligar\n"
                + "1 - para imprimir contatos\n"
                + "2 - para adicionar um novo contato\n"
                + "3 - para atualizar um contato existente\n"
                + "4 - para remover um contato existente\n"
                + "5 - pesquisar se um contato existe\n"
                + "6 - imprimir lista de ações disponíveis");
        System.out.println("Escolha sua ação: ");
    }
    
}
