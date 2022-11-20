package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo Rabelo
 */
public class Celular {
    
    private final String meuNumero;
    private final List<Contato> meusContatos;

    public Celular(String meuNumero) {
        this.meuNumero = meuNumero;
        this.meusContatos = new ArrayList<>();
    }
    
    //Retorna a posição do contato no vetor ou -1 caso contato não exista
    private int encontrarContato(Contato contato) {
        return meusContatos.indexOf(contato);
    }
    
    //Este método está sobrecarregando o método acima, encontrarContatos()
    private int encontrarContato(String nomeContato) {
        for (Contato contato : this.meusContatos) {
            if (contato.getNome().equals(nomeContato)) {
                return meusContatos.indexOf(contato);
            }
        }
        
        return -1;
    }
    
    public boolean addNovoContato(Contato contato) {
        if (encontrarContato(contato.getNome()) >= 0) {
            System.out.println("Contato " + contato.getNome() + " já existe");
            return false;
        }
        
        meusContatos.add(contato);
        System.out.println("Contato " + contato.getNome() + " adicionado com sucesso");
        return true;
    }
    
    public boolean atualizarContato(Contato antigoContato, Contato novoContato) {
        int posicaoEncontrada = encontrarContato(antigoContato);
        if (posicaoEncontrada < 0) {
            System.out.println(antigoContato.getNome() + " não foi encontrado");
            return false;
        } else if (encontrarContato(novoContato.getNome()) != -1) {
            System.out.println("Contato " + novoContato.getNome() + "já existe");
        }
        
        meusContatos.set(posicaoEncontrada, novoContato);
        System.out.println(antigoContato.getNome() + " foi substituído por " + novoContato.getNome());
        return true;
    }
    
    public boolean removerContato(Contato contato) {
        int posicaoEncontrada = encontrarContato(contato);
        if (posicaoEncontrada < 0) {
            System.out.println(contato.getNome() + " não foi encontrado");
            return false;
        }
        
        meusContatos.remove(posicaoEncontrada);
        System.out.println(contato.getNome() + " foi removido");
        return true;
    }
    
    public String pesquisarContato(Contato contato) {
        if (encontrarContato(contato) < 0) {
            return null;
        }
        
        return contato.getNome();
    }
    
    public Contato pesquisarContato(String nome) {
        int posicao = encontrarContato(nome);
        if (posicao < 0) {
            return null;
        }
        
        return meusContatos.get(posicao);
    }
    
    public void imprimirContatos() {
        System.out.println("Lista de Contatos");
        for (int i = 0; i < meusContatos.size(); i++) { //depois tentar for each
            System.out.println((i + 1) + ". " +
                    meusContatos.get(i).getNome() + " | " + 
                    meusContatos.get(i).getNumeroCelular());
        }
    }
        
}
