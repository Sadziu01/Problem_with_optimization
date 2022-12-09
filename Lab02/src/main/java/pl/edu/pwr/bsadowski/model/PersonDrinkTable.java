package pl.edu.pwr.bsadowski.model;

import java.util.List;

public class PersonDrinkTable {
    private final int idPerson;
    private final List<Integer> drink;

    public int getIdPerson() {
        return idPerson;
    }

    public PersonDrinkTable(int idPerson, List<Integer> drink) {
        this.idPerson = idPerson;
        this.drink = drink;
    }

    @Override
    public String toString() {
        return " " + idPerson +
                "; " + drink +
                '\n';
    }
}
