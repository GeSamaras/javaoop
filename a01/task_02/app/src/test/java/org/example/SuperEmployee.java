package org.example;

import java.util.ArrayList;

public class SuperEmployee extends Employee {
    private ArrayList<SuperPower> powers = new ArrayList<>();
        public SuperEmployee(String name, String work, ArrayList<SuperPower> powers) {
            this.name = name;
            this.work = work;
            this.powers = powers;
    }

    public String work() {
        return "";
    }

    public void addPower(SuperPower power) {
        return;
    }

    public String toString() {
        return "";
    }
}
