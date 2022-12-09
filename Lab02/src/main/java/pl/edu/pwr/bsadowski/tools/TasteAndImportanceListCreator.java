package pl.edu.pwr.bsadowski.tools;

import pl.edu.pwr.bsadowski.model.Person;
import pl.edu.pwr.bsadowski.model.TasteAndImportance;

import java.util.ArrayList;
import java.util.List;

public class TasteAndImportanceListCreator {
    public static List<TasteAndImportance> createTasteAndImportanceList(List<Person> list){
        List<TasteAndImportance> listTAI = new ArrayList<>();
            for (Person person : list) {
               for (int j = 0; j < person.getPreference().size(); j++) {
                   int taste = person.getPreference().get(j);
                   int importance = (person.getPreference().size() + 1 - (j + 1));
                   int pId = person.getId();

                  listTAI.add(new TasteAndImportance(taste, importance, pId ,0, 0));
            }
        }
            return listTAI;
    }

}
