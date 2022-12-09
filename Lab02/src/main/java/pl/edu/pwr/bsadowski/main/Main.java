/**
 * @author Bartosz Sadowski
 *
 * Aplikacja została napisana w InteliJ (JDK 11)
 * Archiwizacja z rozserzeniem .jar została wygenerowana przy użyciu Gradle
 * Do uruchomienia aplikacji używać polecenia: java -jar Lab02_pop.jar
 */
package pl.edu.pwr.bsadowski.main;

import pl.edu.pwr.bsadowski.model.Jug;
import pl.edu.pwr.bsadowski.model.Person;
import pl.edu.pwr.bsadowski.model.PersonDrinkTable;
import pl.edu.pwr.bsadowski.model.TasteAndImportance;
import pl.edu.pwr.bsadowski.tools.*;

import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args){
        String jugData = "jugData.txt";
        String personalData = "personalData.txt";
        List<Person> lPerson =  DataCreator.createPerson(personalData);
        List<Jug> lJug = DataCreator.createJug(jugData);


        lPerson.sort(Comparator.comparing(Person::getListSize).reversed());
        lJug.sort(Comparator.comparing(Jug::getTasteId).thenComparing(Jug::getVolume, Comparator.reverseOrder()));

        List<TasteAndImportance> lTAI = TasteAndImportanceListCreator.createTasteAndImportanceList(lPerson);

        lTAI.sort(Comparator.comparing(TasteAndImportance::getImportance).reversed());

        Pouring.minimalizeDissatisfaction(lTAI, lJug);

        Pouring.fillOther(lTAI, lJug);

        Pouring.optimalizeSatisfaction(lTAI);

        Pouring.forEveryone(lTAI);

        List<PersonDrinkTable> printTable = PersonDrinkTableCreator.createFinalList(lPerson, lTAI);

        printTable.sort(Comparator.comparing(PersonDrinkTable::getIdPerson));

        System.out.println(printTable);

        System.out.println(Gladness.countSatisfaction(lTAI));
        System.out.println(Gladness.countDissatisfaction(lTAI));
    }
}
