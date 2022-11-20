package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rickt
 */
public class BandsList {

    private List<String> myFavoriteBands;

    public BandsList() {
        this.myFavoriteBands = new ArrayList<String>();
    }

//    Adiciona uma banda na Lista
    public boolean addBand(String band) {
        int bandPosition = findBand(band);
        if (bandPosition < 0) {
            return false;
        }
        myFavoriteBands.add(band);
        return true;
    }

//    Retorna a posição de uma banda na lista
    private int findBand(String band) {
        return myFavoriteBands.indexOf(band);
    }

//    Atualiza o nome de uma banda pelo antigo nome
    public boolean updateBand(String oldBand, String newBand) {
        int bandPosition = findBand(oldBand);
        if (bandPosition < 0) {
            return false;
        } else if (findBand(newBand) >= 0) {
            return false;
        }
        updateBand(bandPosition, newBand);
        return true;
    }

//    Atualiza o nome de uma banda pela posição
    private void updateBand(int bandPosition, String newBand) {
        myFavoriteBands.set(bandPosition, newBand);
    }

//    Remove uma banda da lista pelo nome
    public boolean removeBand(String band) {
        int bandPosition = findBand(band);
        if (bandPosition >= 0) {
            removeBand(bandPosition);
            return true;
        }
        return false;
    }

//    Remove uma banda da lista pela posição
    private void removeBand(int position) {
        myFavoriteBands.remove(position);
    }

//    Verifica se o nome de uma banda está na lista
    public boolean isOnList(String band) {
        int position = findBand(band);
        return position >= 0;
    }

//    Imprime todas as bandas da lista
    public boolean printBandList() {
        if (myFavoriteBands.isEmpty()) {
            return false;
        }
        System.out.println(myFavoriteBands.size() + " bandas na lista:");

        for (int i = 0; i < myFavoriteBands.size(); i++) {
            System.out.println((i + 1) + "." + myFavoriteBands.get(i));
        }
        return true;
    }

}
