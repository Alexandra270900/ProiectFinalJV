package com.itfactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OperatiuniDB operatiuniDB = new OperatiuniDB();

        Update(operatiuniDB);

    }

    public static void Update(OperatiuniDB operatiuniDB) {
        List<Produs> produseDB = operatiuniDB.afiseazaToateProdusele();
        Magazin magazin = new Magazin(produseDB, operatiuniDB);

        MeniuOptiuni.Meniu(magazin);
    }
}