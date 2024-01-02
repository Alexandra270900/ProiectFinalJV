package com.itfactory;

import java.util.List;

public class Magazin {
    //Variabile
    public List<Produs> produse;

    public Magazin(List<Produs> produse) {
        this.produse = produse;
    }

    //Afiseaza Produs
    public void afiseazaProduse() {
        for (Produs produs : produse) {
            System.out.println(produs);
        }
    }

    //Adauga Produs
    public void adaugaProdus(Produs produs) {
        produse.add(produs);
    }

    //Sterge Produs
    public void stergeProdus(String produsDeSters) {
        produse.removeIf(produs -> produs.getNumeProdus().equals(produsDeSters));
    }

    //Modificare pret produs
    public void modificaPretul(String numeProdus, double pretNou) {
        for (Produs produs : produse) {
            if (produs.getNumeProdus().equals(numeProdus)) {
                produs.setPret(pretNou);
            }
        }
    }

    //Modificare cantitate produs
    public void modificaCantitatea(String numeProdus, int cantitateNoua) {
        for (Produs produs : produse) {
            if (produs.getNumeProdus().equals(numeProdus)) {
                produs.setCantitate(cantitateNoua);
            }
        }
    }

    //Verifica Produs Existent
    public boolean verificareProdusExistent(String numeProdus) {
        for (Produs produs : produse) {
            if (produs.getNumeProdus().equals(numeProdus)) return true;
        }
        return false;
    }
}