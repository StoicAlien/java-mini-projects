// Referência:
// Stock = Estoque

package main;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rickt
 */
public class Barcode {

    private List<Stock> myStock;

    public Barcode() {
        this.myStock = new LinkedList<Stock>();
    }

//    Procura um código de barras por um objeto do tipo estoque
//    e retorna a posição do código de barras na lista
    private int findBarcode(Stock stock) {
        return this.myStock.indexOf(stock);
    }

//    Procura um código de barras pela String
//    e retorna a posição do código de barras na lista
    private int findBarcode(String paramStock) {
        for (int i = 0; i < myStock.size(); i++) {
            Stock stock = this.myStock.get(i);
            if (stock.getBarcode().equals(paramStock)) {
                return i;
            }
        }

        return -1;
    }

//    Adiciona um novo código de barras com um objeto do tipo estoque
    public boolean addNewBarcode(Stock stock) {
        if (findBarcode(stock.getBarcode()) >= 0) {
            return false;
        }

        myStock.add(stock);
        return true;
    }

//    Atualiza um código de barras
    public boolean updateBarcode(Stock oldStock, Stock newStock) {
        int position = findBarcode(oldStock);
        if (position < 0) {
            return false;
        } else if (findBarcode(newStock) != -1) {
            return false;
        }

        this.myStock.set(position, newStock);
        return true;
    }

//    Remove um código de barras da lista
    public boolean removeBarcode(Stock stock) {
        int position = findBarcode(stock);
        if (position < 0) {
            return false;
        }

        this.myStock.remove(stock);
        return true;
    }

//    Pesquisa um código de barras por um objeto do tipo estoque
//    e retorna o código de barras em forma de String
    public String queryBarcode(Stock stock) {
        int position = findBarcode(stock);
        if (position < 0) {
            return null;
        }

        return stock.getBarcode();
    }

//    Pesquisa um código de barras por uma String
//    e retorna um objeto do tipo estoque
    public Stock queryBarcode(String stock) {
        int position = findBarcode(stock);
        if (position < 0) {
            return null;
        }

        return this.myStock.get(position);
    }

//    Imprime todos os códigos de barras na lista e seus respectivos objetos
    public void printBarcode() {
        System.out.println("Barcode and Objects List:");
        for (int i = 0; i < this.myStock.size(); i++) {
            System.out.println("\nBarcode -> " + this.myStock.get(i).getBarcode()
                    + "; Object -> " + this.myStock.get(i).getObject());
        }
    }

}
