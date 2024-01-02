package com.itfactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Produs> produse = new ArrayList<>();
        Magazin magazin = new Magazin(produse);
        Produs tricou = new Produs("Tricou", 35.0, 15);
        Produs hanorac = new Produs("Hanorac", 70.0, 10);

        magazin.adaugaProdus(tricou);
        magazin.adaugaProdus(hanorac);


        while (true) {

            System.out.println("Introduceți tasta corespunzătoare opțiunii dorite: ");
            System.out.println("1. Afișează lista de produse. ");
            System.out.println("2. Adaugă un produs nou. ");
            System.out.println("3. Șterge un produs existent. ");
            System.out.println("4. Modifică prețul unui produs existent. ");
            System.out.println("5. Modifică cantitatea unui produs existent. ");
            System.out.println("6. Ieșire din meniu. ");
            System.out.println(" ");

            Scanner inputUtilizator = new Scanner(System.in);
            int optiune = Integer.parseInt(inputUtilizator.nextLine());

            System.out.println(" ");
            switch (optiune) {
                case 1: {
                    System.out.println("1. Se Afisează lista de produse: ");

                    if (magazin.produse.isEmpty()) {
                        System.out.println("În prezent nu exista produse in magazin!");
                        System.out.println(" ");
                    } else {
                        magazin.afiseazaProduse();
                        System.out.println(" ");
                    }
                    break;

                }

                case 2: {
                    System.out.println("2a. Introduce-ți numele noului produs: ");
                    String numeProdus = inputUtilizator.nextLine();
                    if (magazin.verificareProdusExistent(numeProdus.toLowerCase())) {
                        System.out.println(" ");
                        System.out.println("Produsul există deja in magazin!");
                        System.out.println(" ");
                    } else {
                        double pretProdus = 0;
                        int cantitateProdus = 0;
                        boolean pretIncorect = true;
                        while (pretIncorect) {
                            try {
                                System.out.println("2b.Introduce-ți prețul noului produs: ");
                                pretProdus = Double.parseDouble(inputUtilizator.nextLine());
                                pretIncorect = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Poți introduce doar cifre!");
                                System.out.println(" ");
                            }
                        }
                        boolean cantitateIncorect = true;
                        while (cantitateIncorect) {
                            try {
                                System.out.println("2c.Introduce-ți cantitatea noului produs: ");
                                cantitateProdus = Integer.parseInt(inputUtilizator.nextLine());
                                cantitateIncorect = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Poți introduce doar cifre!");
                                System.out.println(" ");
                            }

                        }
                        magazin.adaugaProdus(new Produs(numeProdus, pretProdus, cantitateProdus));
                        System.out.println("- Produsul [" + numeProdus + "] cu prețul de " + pretProdus +
                                "lei, în cantitatea de " + cantitateProdus + " produse a fost adăugat cu success!");
                    }
                }
                break;


                case 3: {
                    System.out.println("3.Introduce-ți numele produsului pe care doriți sa il ștergeți: ");
                    String numeProdus = inputUtilizator.nextLine();
                    if (magazin.verificareProdusExistent(numeProdus.toLowerCase())) {
                        magazin.stergeProdus(numeProdus);
                        System.out.println("Produsul " + numeProdus + " a fost șters cu success!");
                    } else {
                        System.out.println("Produsul nu există in magazin, verificați lista de produse!");
                    }
                    break;
                }

                case 4: {
                    System.out.println("4.Introduce-ți numele produsului căruia doriți sa îi modificați prețul: ");
                    String numeProdus = inputUtilizator.nextLine();
                    if (magazin.verificareProdusExistent(numeProdus.toLowerCase())) {
                        double pretProdus = 0;
                        boolean pretIncorect = true;
                        while (pretIncorect) {
                            try {
                                System.out.println("Scrie-ți noul preț pentru produsul [" + numeProdus + "]: ");
                                pretProdus = Double.parseDouble(inputUtilizator.nextLine());
                                pretIncorect = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Poți introduce doar cifre!");
                                System.out.println(" ");
                            }
                        }
                        magazin.modificaPretul(numeProdus, pretProdus);
                        System.out.println("Pretul produsului [" + numeProdus + "] a fost actualizat la suma de " + pretProdus + "Lei.");
                        System.out.println(" ");
                    } else {
                        System.out.println("Produsul nu exista in magazin, verificați lista de produse!");
                        System.out.println(" ");
                    }
                    break;
                }

                case 5: {
                    System.out.println("5.Introduce-ți numele produsului căruia doriți sa ii modificați cantitatea: ");
                    String numeProdus = inputUtilizator.nextLine();
                    if (magazin.verificareProdusExistent(numeProdus.toLowerCase())) {
                        int cantitateProdus = 0;
                        boolean cantitateIncorect = true;
                        while (cantitateIncorect) {
                            try {
                                System.out.println("Scrie-ți noua cantitate pentru produsul [" + numeProdus + "]: ");
                                cantitateProdus = Integer.parseInt(inputUtilizator.nextLine());
                                cantitateIncorect = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Poți introduce doar cifre!");
                                System.out.println(" ");
                            }
                        }
                        magazin.modificaCantitatea(numeProdus, cantitateProdus);
                        System.out.println("Cantitatea produsului [" + numeProdus + "] a fost actualizată la " + cantitateProdus + " produse.");
                        System.out.println(" ");
                    } else {
                        System.out.println("Produsul nu exista in magazin, verificați lista de produse!");
                        System.out.println(" ");
                    }
                    break;
                }

                case 6:
                    System.exit(0);
            }
        }
    }
}