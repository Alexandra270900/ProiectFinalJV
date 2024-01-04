import com.itfactory.OperatiuniDB;
import com.itfactory.Produs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OperatiuniDBTest {
    OperatiuniDB operatiuniDB = new OperatiuniDB();
    Produs produs = new Produs("hanorac", 70, 5);
    Produs produs1 = new Produs("geaca", 80, 10);

    @Before
    public void init() {
        System.out.println("===Before===");
        System.out.println(" ");
        if (operatiuniDB.afiseazaToateProdusele().isEmpty()) {
            System.out.println("DB WAS CLEAR!");
            operatiuniDB.adaugaProduse(produs);
        } else {
            operatiuniDB.afiseazaToateProdusele().clear();
            System.out.println("DB CLEARED!");
            operatiuniDB.adaugaProduse(produs);
        }
        System.out.println(" ");
    }

    @Test
    public void adaugaProdus_Pozitiv() {
        System.out.println("===Test1===");
        System.out.println(" ");
        operatiuniDB.adaugaProduse(produs1);
        assertEquals(2, operatiuniDB.afiseazaToateProdusele().size());
        System.out.println(" ");
    }

    @Test
    public void adaugaProdus_Negativ() {
        System.out.println("===Test2===");
        System.out.println(" ");
        operatiuniDB.adaugaProduse(produs1);
        assertNotEquals(1, operatiuniDB.afiseazaToateProdusele().size());
        System.out.println(" ");

    }

    @Test
    public void modificaPretProdus_Pozitiv() {
        System.out.println("===Test3===");
        System.out.println(" ");
        operatiuniDB.modificaPretul(produs, 15);
        assertEquals(15, operatiuniDB.afiseazaToateProdusele().getFirst().getPret(), 0);
        System.out.println(" ");
    }

    @Test
    public void modificaPretProdus_Negativ() {
        System.out.println("===Test4===");
        System.out.println(" ");
        operatiuniDB.modificaPretul(produs, 15);
        assertNotEquals(70, operatiuniDB.afiseazaToateProdusele().getFirst().getPret(), 0);
        System.out.println(" ");
    }

    @Test
    public void modificaCantitateProdus_Pozitiv() {
        System.out.println("===Test5===");
        System.out.println(" ");
        operatiuniDB.modificaCantitatea(produs, 7);
        assertEquals(7, operatiuniDB.afiseazaToateProdusele().getFirst().getCantitate());
        System.out.println(" ");
    }

    @Test
    public void modificaCantitateProdus_Negativ() {
        System.out.println("===Test6===");
        System.out.println(" ");
        operatiuniDB.modificaCantitatea(produs, 7);
        assertNotEquals(10, operatiuniDB.afiseazaToateProdusele().getFirst().getCantitate());
        System.out.println(" ");
    }

    @Test
    public void stergeProdus_Pozitiv() {
        System.out.println("===Test7===");
        System.out.println(" ");
        operatiuniDB.stergeProdus(produs);
        assertEquals(0, operatiuniDB.afiseazaToateProdusele().size());
        System.out.println(" ");
    }

    @Test
    public void stergeProdus_Negativ() {
        System.out.println("===Test8===");
        System.out.println(" ");
        operatiuniDB.stergeProdus(produs);
        assertNotEquals(1, operatiuniDB.afiseazaToateProdusele().size());
        System.out.println(" ");
    }

    @After
    public void cleanup() {
        System.out.println("===After===");
        System.out.println(" ");
        if (!operatiuniDB.afiseazaToateProdusele().isEmpty()) {
            operatiuniDB.stergeProdus(produs);
            operatiuniDB.stergeProdus(produs1);
        }
    }
}
