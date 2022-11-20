package main;

import java.util.Scanner;

/**
 *
 * @author rickt
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Barcode myBarcodes = new Barcode();

    public static void main(String[] args) {

        int choice;
        boolean quit = false;
        printInstructions();

        while (!quit) {
            System.out.println("\nEntre com sua escolha: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;

                case 1:
                    printBarcodeList();
                    break;

                case 2:
                    addBarcode();
                    break;

                case 3:
                    updateBarcode();
                    break;

                case 4:
                    removeBarcode();
                    break;

                case 5:
                    queryBarcode();
                    break;

                case 6:
                    quit = true;
                    break;
                    
                default:
                    System.out.println("Entrada inválida");
            }

        }
        
        scanner.close();
    }

    private static void printInstructions() {
        startProcess();
        System.out.println("\nPressione"
                + "\n\t0 -> para imprimir instruções"
                + "\n\t1 -> para imprimir lista de código de barras e objetos"
                + "\n\t2 -> para adicionar um código de barras e objeto"
                + "\n\t3 -> para modificar um código de barras e objeto"
                + "\n\t4 -> para remover um código de barras"
                + "\n\t5 -> para procurar por um código de barras"
                + "\n\t6 -> para sair da aplicação");
        endProcess();
    }

    private static void printBarcodeList() {
        startProcess();
        myBarcodes.printBarcode();
        endProcess();
    }

    private static void addBarcode() {
        startProcess();
        System.out.print("Insira um novo código de barras: ");
        String barcode = scanner.nextLine();
        System.out.print("Insira um objeto para o estoque: ");
        String object = scanner.nextLine();

        Stock stock = Stock.createStock(object, barcode);

        if (myBarcodes.addNewBarcode(stock)) {
            System.out.println("Código de barras adicionado com sucesso");
        } else {
            System.out.println("Erro ao adicionar o código de barras: "
                    + "código já existe na lista");
        }
        
        endProcess();
    }

    private static void updateBarcode() {
        startProcess();
        System.out.print("Insira um código de barras já existente: ");
        String barcode = scanner.nextLine();
        Stock existingStock = myBarcodes.queryBarcode(barcode);

        if (existingStock == null) {
            errorFindingBarcode();
            return;
        }

        System.out.print("Insira um novo código de barras: ");
        String newBarcode = scanner.nextLine();
        if (myBarcodes.queryBarcode(newBarcode) != null) {
            System.out.println("Erro ao atualizar: novo código de barras já"
                    + " existe");
            return;
        }
        System.out.print("Insira um novo objeto para o estoque: ");
        String newObject = scanner.nextLine();
        Stock newStock = Stock.createStock(newObject, newBarcode);        

        if (myBarcodes.updateBarcode(existingStock, newStock)) {
            System.out.println("Código de barras atualizado com sucesso");
        }
        
        endProcess();
    }

    private static void removeBarcode() {
        startProcess();
        System.out.print("Insira um código de barras que deseja remover: ");
        String barcode = scanner.nextLine();
        Stock stock = myBarcodes.queryBarcode(barcode);
        
        if (stock == null) {
            errorFindingBarcode();
            return;
        }

        if (myBarcodes.removeBarcode(stock)) {
            System.out.println("Código de barras removido com sucesso");
        } else {
            System.out.println("Erro ao remover código de barras");
        }
        
        endProcess();
    }

    private static void queryBarcode() {
        startProcess();
        System.out.print("Insira o código de barras que está procurando: ");
        String barcode = scanner.nextLine();
        Stock stock = myBarcodes.queryBarcode(barcode);

        if (stock == null) {
            errorFindingBarcode();
            return;
        }
        
        System.out.println("Código de barras encontrado com sucesso");
        endProcess();
    }
    
    private static void errorFindingBarcode() {
        System.out.println("Erro ao encontrar código de barras: não existe");
        endProcess();
    }
    
    private static void startProcess() {
        System.out.println("*********************************************************");
    }
    
    private static void endProcess() {
        System.out.println("*********************************************************");
    }

}
