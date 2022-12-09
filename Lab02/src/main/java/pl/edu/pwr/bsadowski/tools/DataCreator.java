package pl.edu.pwr.bsadowski.tools;

import pl.edu.pwr.bsadowski.model.Person;
import pl.edu.pwr.bsadowski.model.Jug;


import java.util.ArrayList;
import java.util.List;


public class DataCreator {

    public static List<Person> createPerson(String personalData){
        List<Person> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> temporaryList;
        DataReader reader = new DataReader();
        temporaryList = reader.readFile(personalData);

        for (ArrayList<Integer> integers : temporaryList) {
            int idP = integers.get(0);
            ArrayList<Integer> preferenceP = new ArrayList<>();
            for (int j = 1; j < integers.size(); j++) {
                preferenceP.add(integers.get(j));
            }

            list.add(new Person(idP, preferenceP));
        }
        return list;
    }

    public static List<Jug> createJug(String jugData){
        List<Jug> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> temporaryList;
        DataReader reader = new DataReader();
        temporaryList = reader.readFile(jugData);

        for (ArrayList<Integer> integers : temporaryList) {
            int idJ = integers.get(0);
            int tasteIdJ = integers.get(1);
            int volumeJ = integers.get(2);

            list.add(new Jug(idJ, tasteIdJ, volumeJ));
        }
        return list;
    }
}
