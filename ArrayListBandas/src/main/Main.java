package main;

import java.util.Scanner;

/**
 *
 * @author rickt
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static BandsList myFavoriteBands = new BandsList();

    public static void main(String[] args) {
        int choice;
        boolean quit = false;
        printInstructions();

        while (!quit) {
            System.out.print("\nEntre com sua escolha: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;

                case 1:
                    printBands();
                    break;

                case 2:
                    addBand();
                    break;

                case 3:
                    updateBand();
                    break;

                case 4:
                    removeBand();
                    break;

                case 5:
                    searchBand();
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
        System.out.println("\nPressione:"
                + "\n\t0 -> para imprimir instruções"
                + "\n\t1 -> para imprimir bandas na lista"
                + "\n\t2 -> para adicionar bandas na lista"
                + "\n\t3 -> para atualizar bandas na lista"
                + "\n\t4 -> para remover bandas na lista"
                + "\n\t5 -> para procurar por bandas na lista"
                + "\n\t6 -> para sair da aplicação");
    }

    private static void printBands() {
        boolean isListNotEmpty = myFavoriteBands.printBandList();
        if (!isListNotEmpty) {
            System.out.println("Lista está vazia");
        }
    }

    private static void addBand() {
        System.out.print("Insira nome de uma banda: ");
        String band = scanner.nextLine();
        boolean isBandAdded = myFavoriteBands.addBand(band);
        if (!isBandAdded) {
            System.out.println("Erro ao adicionar: nome da banda já está na"
                    + " lista");
        } else {
            System.out.println("Banda adicionada com sucesso");
        }
    }

    private static void updateBand() {
        System.out.print("Insira nome da banda que deseja modificar/"
                + "atualizar: ");
        String oldBand = scanner.nextLine();
        boolean isBandOnList = myFavoriteBands.isOnList(oldBand);
        if (!isBandOnList) {
            System.out.println("Erro ao atualizar: banda não está na lista");
            return;
        }
        System.out.print("Atualize a banda com um nome novo: ");
        String newBand = scanner.nextLine();
        boolean isBandUpdated = myFavoriteBands.updateBand(oldBand, newBand);
        if (!isBandUpdated) {
            System.out.println("Erro ao atualizar: nome novo já está na lista");
        } else {
            System.out.println("Banda atualizada com sucesso");
        }
    }

    private static void removeBand() {
        System.out.print("Insira nome da banda que deseja remover da lista: ");
        String e = scanner.nextLine();
        boolean isBandRemoved = myFavoriteBands.removeBand(e);
        if (!isBandRemoved) {
            System.out.println("Erro ao remover banda da lista: banda não "
                    + "existe");
        } else {
            System.out.println("Banda removida da lista com sucesso");
        }
    }

    private static void searchBand() {
        System.out.println("Insira nome da banda que deseja procurar: ");
        String band = scanner.nextLine();
        if (myFavoriteBands.isOnList(band)) {
            System.out.println(band + " está na lista");
        } else {
            System.out.println(band + " não está na lista");
        }
    }

}
