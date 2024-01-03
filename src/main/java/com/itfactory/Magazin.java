package com.itfactory;

import java.util.List;
import java.util.Scanner;

public class Magazin {
    //Variabile
    public List<Produs> produseM;

    public Magazin(List<Produs> produseDB) {
        this.produseM = produseDB;
    }

    //Afiseaza Produs
    public void afiseazaProduse() {
        System.out.println("1. Se Afisează lista de produse: ");

        if (produseM.isEmpty()) {
            System.out.println("În prezent nu exista produse in magazin!");
            System.out.println(" ");
        } else {
            System.out.println(OperatiuniDB.afiseazaToateProdusele());
            System.out.println(" ");
        }
    }

    //Adauga Produs
    public void adaugaProdus(Scanner scanner) {
        System.out.println("2a. Introduce-ți numele noului produs: ");
        String numeProdus = scanner.nextLine();
        if (verificareProdusExistent(numeProdus.toLowerCase())) {
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
                    pretProdus = Double.parseDouble(scanner.nextLine());
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
                    cantitateProdus = Integer.parseInt(scanner.nextLine());
                    cantitateIncorect = false;
                } catch (NumberFormatException e) {
                    System.out.println("Poți introduce doar cifre!");
                    System.out.println(" ");
                }

            }
            OperatiuniDB.adaugaProduse(new Produs(numeProdus, pretProdus, cantitateProdus));
            Main.Update();
            System.out.println("- Produsul [" + numeProdus + "] cu prețul de " + pretProdus +
                    "lei, în cantitatea de " + cantitateProdus + " produse a fost adăugat cu success!");
        }
    }

    //Sterge Produs
    public void stergeProdus(Scanner scanner) {
        System.out.println("3.Introduce-ți numele produsului pe care doriți sa il ștergeți: ");
        String numeProdus = scanner.nextLine();
        if (verificareProdusExistent(numeProdus.toLowerCase())) {
            for (Produs produs : produseM) {
                if (produs.getNumeProdus().equals(numeProdus)) {
                    OperatiuniDB.stergeProdus(produs);
                }
            }
            Main.Update();
            System.out.println("Produsul " + numeProdus + " a fost șters cu success!");
        } else {
            System.out.println("Produsul nu există in magazin, verificați lista de produse!");
        }
    }

    //Modificare pret produs
    public void modificaPretul(Scanner scanner) {
        System.out.println("4.Introduce-ți numele produsului căruia doriți sa îi modificați prețul: ");
        String numeProdus = scanner.nextLine();
        if (verificareProdusExistent(numeProdus.toLowerCase())) {
            double pretProdus = 0;
            boolean pretIncorect = true;
            while (pretIncorect) {
                try {
                    System.out.println("Scrie-ți noul preț pentru produsul [" + numeProdus + "]: ");
                    pretProdus = Double.parseDouble(scanner.nextLine());
                    pretIncorect = false;
                } catch (NumberFormatException e) {
                    System.out.println("Poți introduce doar cifre!");
                    System.out.println(" ");
                }
            }
            for (Produs produs : produseM) {
                if (produs.getNumeProdus().equals(numeProdus)) {
                    OperatiuniDB.modificaPretul(produs, pretProdus);
                    Main.Update();
                }
            }
            System.out.println("Pretul produsului [" + numeProdus + "] a fost actualizat la suma de " + pretProdus + "Lei.");
            System.out.println(" ");
        } else {
            System.out.println("Produsul nu exista in magazin, verificați lista de produse!");
            System.out.println(" ");
        }
    }

    //Modificare cantitate produs
    public void modificaCantitatea(Scanner scanner) {
        System.out.println("5.Introduce-ți numele produsului căruia doriți sa ii modificați cantitatea: ");
        String numeProdus = scanner.nextLine();
        if (verificareProdusExistent(numeProdus.toLowerCase())) {
            int cantitateProdus = 0;
            boolean cantitateIncorect = true;
            while (cantitateIncorect) {
                try {
                    System.out.println("Scrie-ți noua cantitate pentru produsul [" + numeProdus + "]: ");
                    cantitateProdus = Integer.parseInt(scanner.nextLine());
                    cantitateIncorect = false;
                } catch (NumberFormatException e) {
                    System.out.println("Poți introduce doar cifre!");
                    System.out.println(" ");
                }
            }
            for (Produs produs : produseM) {
                if (produs.getNumeProdus().equals(numeProdus)) {
                    OperatiuniDB.modificaCantitatea(produs, cantitateProdus);
                    Main.Update();
                }
            }
            System.out.println("Cantitatea produsului [" + numeProdus + "] a fost actualizată la " + cantitateProdus + " produse.");
            System.out.println(" ");
        } else {
            System.out.println("Produsul nu exista in magazin, verificați lista de produse!");
            System.out.println(" ");
        }
    }

    //Verifica Produs Existent
    public boolean verificareProdusExistent(String numeProdus) {
        for (Produs produs : produseM) {
            if (produs.getNumeProdus().equals(numeProdus)) return true;
        }
        return false;
    }
}