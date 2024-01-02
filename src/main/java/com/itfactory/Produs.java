package com.itfactory;

public class Produs {
    private String numeProdus;
    private double pret;
    private int cantitate;

    public Produs(String numeProdus, double pret, int cantitate) {
        this.numeProdus = numeProdus.toLowerCase();
        this.pret = pret;
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "Produs: {" +
                "numeProdus='" + numeProdus + '\'' +
                ", pret=" + pret + "lei" +
                ", cantitate=" + cantitate +
                '}';
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}