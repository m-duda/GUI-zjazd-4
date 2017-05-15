package zad3;

import java.util.ArrayList;

public class Towar {
    private int id;
    private double weight;
    volatile private Towar towarTmp;
    boolean ready = false;

    synchronized  Towar  get() {
        while (ready == false) {
            try {
                wait();
            } catch (InterruptedException exc) {
            }
        }
        ready = false;
        notify();
        return towarTmp;
    }

    synchronized void put(Towar t) {
        while (ready == true) {
            try {
                wait();
            } catch(InterruptedException exc) {}
        }
        towarTmp = t;
        ready = true;
        notify();
    }

    public double getWeight() {
        return weight;
    }

    public Towar(int id, double weight) {
        this.id = id;
        this.weight = weight;
    }

}
