package com.itfactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperatiuniDB {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/itf";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Admin";

    public List<Produs> afiseazaToateProdusele() {

        List<Produs> produseDB = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            //System.out.println("Conectare la DB cu succes!");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM produse");
            while (resultSet.next()) {
                String numeProdus = resultSet.getString("nume_produs");
                double pretProdus = resultSet.getDouble("pret_produs");
                int cantitateProdus = resultSet.getInt("cantitate_produs");
                Produs produs = new Produs(numeProdus, pretProdus, cantitateProdus);
                produseDB.add(produs);
            }


        } catch (SQLException e) {
            System.out.println("Probleme la conectarea cu baza de date");
        }
        return produseDB;
    }

    public void adaugaProduse(Produs produs) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            //System.out.println("Conectare la DB cu succes!");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUSE VALUES(?,?,?)");
            statement.setString(1, produs.getNumeProdus());
            statement.setDouble(2, produs.getPret());
            statement.setInt(3, produs.getCantitate());

            statement.execute();
            System.out.println("DB: Produsul [" + produs.getNumeProdus() + "] cu prețul de [" + produs.getPret() +
                    "lei], în cantitatea de [" + produs.getCantitate() + "] produse a fost adăugat cu success!");

        } catch (SQLException e) {
            System.out.println("Probleme la conectarea cu baza de date pentru adaugarea produsului");
        }
    }

    public void modificaPretul(Produs produs, double pretNou) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            //System.out.println("Conectare la DB cu succes!");

            PreparedStatement statement = connection.prepareStatement("UPDATE PRODUSE SET PRET_PRODUS=? WHERE PRET_PRODUS=?");
            statement.setDouble(1, pretNou);
            statement.setDouble(2, produs.getPret());

            statement.execute();
            System.out.println("DB: Pretul produsului [" + produs.getNumeProdus() + "] a fost actualizat la suma de [" + pretNou + "Lei].");

        } catch (SQLException e) {
            System.out.println("!!! Probleme la conectarea cu baza de date pentru modificarea pretului");
        }
    }

    public void modificaCantitatea(Produs produs, int cantitateNoua) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            //System.out.println("Conectare la DB cu succes!");

            PreparedStatement statement = connection.prepareStatement("UPDATE PRODUSE SET CANTITATE_PRODUS=? WHERE CANTITATE_PRODUS=?");
            statement.setDouble(1, cantitateNoua);
            statement.setDouble(2, produs.getCantitate());

            statement.execute();
            System.out.println("DB: Cantitatea produsului [" + produs.getNumeProdus() + "] a fost modificata cu succes!");
            System.out.println("Cantitatea produsului [" + produs.getNumeProdus() + "] a fost actualizată la [" + cantitateNoua + "] produse.");

        } catch (SQLException e) {
            System.out.println("!!! Probleme la conectarea cu baza de date pentru modificarea cantitatii");
        }
    }

    public void stergeProdus(Produs produs) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            //System.out.println("Conectare la DB cu succes!");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUSE WHERE NUME_PRODUS=?");
            statement.setString(1, produs.getNumeProdus());

            statement.execute();
            System.out.println("DB: Produsul [" + produs.getNumeProdus() + "] a fost sters cu succes!");

        } catch (SQLException e) {
            System.out.println("!!! Probleme la conectarea cu baza de date pentru stergerea produsului");
        }
    }

}
