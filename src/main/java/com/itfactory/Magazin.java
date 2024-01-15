package com.itfactory;

import java.util.List;
import java.util.Scanner;

public class Magazin implements InterfataMetode {
    //Variabile
    public List<Produs> produseM;
    public OperatiuniDB operatiuniDB;

    public Magazin(List<Produs> produseDB, OperatiuniDB operatiuniDB) {
        this.operatiuniDB = operatiuniDB;
        this.produseM = produseDB;
    }

    //Afiseaza Produs
    @Override
    public void afiseazaProduse() {
        System.out.println("Se Afisează lista de produse: ");

        if (produseM.isEmpty()) {
            System.out.println("În prezent nu exista produse in magazin!");
            System.out.println(" ");
        } else {
            System.out.println(operatiuniDB.afiseazaToateProdusele());
            System.out.println(" ");
        }
    }

    //Adauga Produs
    @Override
    public void adaugaProdus(Scanner scanner) {
        System.out.print("Introduceți numele noului produs: ");
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
                    System.out.print("Introduceți prețul noului produs: ");
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
                    System.out.print("Introduceți cantitatea noului produs: ");
                    cantitateProdus = Integer.parseInt(scanner.nextLine());
                    cantitateIncorect = false;
                } catch (NumberFormatException e) {
                    System.out.println("Poți introduce doar cifre!");
                    System.out.println(" ");
                }

            }
            operatiuniDB.adaugaProduse(new Produs(numeProdus, pretProdus, cantitateProdus));
            Main.Update(operatiuniDB);
        }
    }

    //Sterge Produs
    @Override
    public void stergeProdus(Scanner scanner) {
        System.out.print("Introduceți numele produsului pe care doriți sa il ștergeți: ");
        String numeProdus = scanner.nextLine();
        if (verificareProdusExistent(numeProdus.toLowerCase())) {
            for (Produs produs : produseM) {
                if (produs.getNumeProdus().equals(numeProdus)) {
                    operatiuniDB.stergeProdus(produs);
                }
            }
            Main.Update(operatiuniDB);
        } else {
            System.out.println("Produsul nu există in magazin, verificați lista de produse!");
        }
    }

    //Modificare pret produs
    @Override
    public void modificaPretProdus(Scanner scanner) {
        System.out.print("Introduceți numele produsului căruia doriți sa îi modificați prețul: ");
        String numeProdus = scanner.nextLine();
        if (verificareProdusExistent(numeProdus.toLowerCase())) {
            double pretProdus = 0;
            boolean pretIncorect = true;
            while (pretIncorect) {
                try {
                    System.out.print("Scrieți noul preț pentru produsul [" + numeProdus + "]: ");
                    pretProdus = Double.parseDouble(scanner.nextLine());
                    pretIncorect = false;
                } catch (NumberFormatException e) {
                    System.out.println("Poți introduce doar cifre!");
                    System.out.println(" ");
                }
            }
            for (Produs produs : produseM) {
                if (produs.getNumeProdus().equals(numeProdus)) {
                    operatiuniDB.modificaPretul(produs, pretProdus);
                    System.out.println(" ");
                    Main.Update(operatiuniDB);
                }
            }
        } else {
            System.out.println("Produsul nu exista in magazin, verificați lista de produse!");
            System.out.println(" ");
        }
    }

    //Modificare cantitate produs
    @Override
    public void modificaCantitateProdus(Scanner scanner) {
        System.out.print("Introduceți numele produsului căruia doriți sa ii modificați cantitatea: ");
        String numeProdus = scanner.nextLine();
        if (verificareProdusExistent(numeProdus.toLowerCase())) {
            int cantitateProdus = 0;
            boolean cantitateIncorect = true;
            while (cantitateIncorect) {
                try {
                    System.out.print("Scrieți noua cantitate pentru produsul [" + numeProdus + "]: ");
                    cantitateProdus = Integer.parseInt(scanner.nextLine());
                    cantitateIncorect = false;
                } catch (NumberFormatException e) {
                    System.out.println("Poți introduce doar cifre!");
                    System.out.println(" ");
                }
            }
            for (Produs produs : produseM) {
                if (produs.getNumeProdus().equals(numeProdus)) {
                    operatiuniDB.modificaCantitatea(produs, cantitateProdus);
                    System.out.println(" ");
                    Main.Update(operatiuniDB);
                }
            }
        } else {
            System.out.println("Produsul nu exista in magazin, verificați lista de produse!");
            System.out.println(" ");
        }
    }

    //Verifica Produs Existent
    @Override
    public boolean verificareProdusExistent(String numeProdus) {
        for (Produs produs : produseM) {
            if (produs.getNumeProdus().equals(numeProdus)) return true;
        }
        return false;
    }
}