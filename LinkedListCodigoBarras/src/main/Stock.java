// Um objeto do tipo estoque é constituído do nome do objeto que é do tipo
// String e um código de barras do tipo String

package main;

/**
 *
 * @author rickt
 */
public class Stock {

    private String object, barcode;

    public Stock(String object, String barcode) {
        this.object = object;
        this.barcode = barcode;
    }

    public String getObject() {
        return object;
    }

    public String getBarcode() {
        return barcode;
    }

    public static Stock createStock(String object, String barcode) {
        return new Stock(object, barcode);
    }
}
