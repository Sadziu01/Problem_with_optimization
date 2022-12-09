package pl.edu.pwr.bsadowski.tools;

import pl.edu.pwr.bsadowski.model.Person;
import pl.edu.pwr.bsadowski.model.PersonDrinkTable;
import pl.edu.pwr.bsadowski.model.TasteAndImportance;

import java.util.ArrayList;
import java.util.List;

public class PersonDrinkTableCreator {

    public static List<PersonDrinkTable> createFinalList(List<Person> lPerson, List<TasteAndImportance> lTAI){
        List<PersonDrinkTable> printTable = new ArrayList<>();
        for (Person person : lPerson) {
            for (TasteAndImportance tasteAndImportance : lTAI) {
                if (person.getId() == tasteAndImportance.getpId()) {
                    List<Integer> finalList = new ArrayList<>();
                    finalList.add(tasteAndImportance.getTaste());
                    finalList.add(tasteAndImportance.getjValue());
                    printTable.add(new PersonDrinkTable(person.getId(), finalList));
                }
            }
        }
        return printTable;
    }
}
