package com.itfactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Update();

    }

    public static void Update() {
        List<Produs> produseDB = OperatiuniDB.afiseazaToateProdusele();
        Magazin magazin = new Magazin(produseDB);

        MeniuOptiuni.Meniu(magazin);
    }
}