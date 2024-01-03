package com.itfactory;

import java.util.Scanner;

public class MeniuOptiuni {

    public static void Meniu(Magazin magazin) {


        while (true) {

            System.out.println("Meniu: ");
            System.out.println("1. Afișează lista de produse. ");
            System.out.println("2. Adaugă un produs nou. ");
            System.out.println("3. Șterge un produs existent. ");
            System.out.println("4. Modifică prețul unui produs existent. ");
            System.out.println("5. Modifică cantitatea unui produs existent. ");
            System.out.println("6. Ieșire din meniu. ");
            System.out.println(" ");

            Scanner inputUtilizator = new Scanner(System.in);

            int optiune = 0;
            boolean OptiuneIncorecta = true;
            while (OptiuneIncorecta) {
                try {
                    System.out.println("Introduceți tasta corespunzătoare opțiunii dorite: ");
                    optiune = Integer.parseInt(inputUtilizator.nextLine());
                    OptiuneIncorecta = false;
                } catch (NumberFormatException e) {
                    System.out.println("Poți introduce doar cifre!");
                    System.out.println(" ");
                }
            }


            System.out.println(" ");
            switch (optiune) {
                case 1: {
                    magazin.afiseazaProduse();
                }
                break;

                case 2: {
                    magazin.adaugaProdus(inputUtilizator);
                }
                break;

                case 3: {
                    magazin.stergeProdus(inputUtilizator);
                }
                break;

                case 4: {
                    magazin.modificaPretul(inputUtilizator);
                }
                break;

                case 5: {
                    magazin.modificaCantitatea(inputUtilizator);
                }
                break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
