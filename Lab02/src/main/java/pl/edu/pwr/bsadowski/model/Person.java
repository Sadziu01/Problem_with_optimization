package pl.edu.pwr.bsadowski.model;

import java.util.List;

public class Person {
    private final int id;

    private final List<Integer> preference;

    public int getId(){
        return id;
    }

    public List<Integer> getPreference() {
        return preference;
    }

    public Person(int id, List<Integer> preference) {
        this.id = id;
        this.preference = preference;
    }

    public int getListSize(){
        return preference.size();
    }

}
