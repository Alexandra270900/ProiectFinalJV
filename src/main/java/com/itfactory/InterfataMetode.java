package com.itfactory;

import java.util.Scanner;

public interface InterfataMetode {
    void afiseazaProduse();

    void adaugaProdus(Scanner scanner);

    void modificaPretProdus(Scanner scanner);

    void modificaCantitateProdus(Scanner scanner);

    void stergeProdus(Scanner scanner);

    boolean verificareProdusExistent(String numeProdus);
}
