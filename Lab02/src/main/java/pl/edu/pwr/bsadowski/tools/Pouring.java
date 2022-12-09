package pl.edu.pwr.bsadowski.tools;

import pl.edu.pwr.bsadowski.model.Jug;
import pl.edu.pwr.bsadowski.model.TasteAndImportance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pouring {

    public static Jug newJug(List<Jug> lJug, int tasteId) {
        int max = 0;
        Jug newJug = null;
        for (Jug jug : lJug) {
            if (jug.getTasteId() == tasteId) {
                if (jug.getVolume() > max) {
                    newJug = jug;
                    max = newJug.getVolume();
                }
            }
        }
        return newJug;
    }

    public static void minimalizeDissatisfaction(List<TasteAndImportance> lTAI, List<Jug> lJug){
        Set<Integer> checkIdPersonList = new HashSet<>();
        for (TasteAndImportance tasteAndImportance : lTAI) {
            Jug newJug = newJug(lJug, tasteAndImportance.getTaste());
            for (Jug jug : lJug) {
                if(jug.equals(newJug) && !checkIdPersonList.contains(tasteAndImportance.getpId())) {
                    int maxScale = 400;
                    if (tasteAndImportance.getTaste() == jug.getTasteId()) {
                        if (jug.getVolume() > maxScale && tasteAndImportance.getjValue() < maxScale) {
                            tasteAndImportance.setjValue(tasteAndImportance.getjValue() + maxScale);
                            jug.setVolume(jug.getVolume() - maxScale);
                            tasteAndImportance.setIdJug(jug.getId());
                            checkIdPersonList.add(tasteAndImportance.getpId());
                        } else if (jug.getVolume() < maxScale && jug.getVolume() > 0) {
                            for (int l = 400; l >= 0; l--) {
                                maxScale--;
                                if (jug.getVolume() > maxScale - 1 && tasteAndImportance.getjValue() < maxScale) {
                                    tasteAndImportance.setjValue(tasteAndImportance.getjValue() + maxScale);
                                    jug.setVolume(jug.getVolume() - maxScale);
                                    tasteAndImportance.setIdJug(jug.getId());
                                    checkIdPersonList.add(tasteAndImportance.getpId());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void fillOther(List<TasteAndImportance> lTAI, List<Jug> lJug){
        for (Jug jug : lJug) {
            if (jug.getVolume() > 0) {
                for (TasteAndImportance tasteAndImportance : lTAI) {
                    if (tasteAndImportance.getTaste() == jug.getTasteId() && tasteAndImportance.getIdJug() == jug.getId()) {
                        int tempValue = jug.getVolume();
                        tasteAndImportance.setjValue(tasteAndImportance.getjValue() + jug.getVolume());
                        jug.setVolume(jug.getVolume() - tempValue);
                    }
                }
            }
        }
    }

    public static void optimalizeSatisfaction(List<TasteAndImportance> lTAI){
        for(int i = 0; i < lTAI.size(); i++){
            for (int j = 1; j < lTAI.size(); j++){
                if(lTAI.get(j-1).getjValue() < lTAI.get(j).getjValue() && lTAI.get(j-1).getTaste() == lTAI.get(j).getTaste()){
                    int buforV = lTAI.get(j-1).getjValue();
                    int buforId = lTAI.get(j-1).getIdJug();

                    lTAI.get(j-1).setjValue(lTAI.get(j).getjValue());
                    lTAI.get(j-1).setIdJug(lTAI.get(j).getIdJug());

                    lTAI.get(j).setjValue(buforV);
                    lTAI.get(j).setIdJug(buforId);
                }
            }
        }
    }

    public  static void forEveryone(List<TasteAndImportance> lTAI){
        Set<Integer> checkPersonVolume = new HashSet<>();
        for (TasteAndImportance tasteAndImportance : lTAI) {
            if (tasteAndImportance.getjValue() > 0) {
                checkPersonVolume.add(tasteAndImportance.getpId());
            }
        }
        for(int j = 0; j < lTAI.size(); j++){
            if(!checkPersonVolume.contains(lTAI.get(j).getpId())){
                int min = Integer.MIN_VALUE;
                TasteAndImportance newTAI = null;
                for (TasteAndImportance tasteAndImportance : lTAI) {
                    if (tasteAndImportance.getTaste() == lTAI.get(j).getTaste()) {
                        if (tasteAndImportance.getjValue() < min && tasteAndImportance.getjValue() > 1) {
                            newTAI = tasteAndImportance;
                            min = tasteAndImportance.getjValue();
                        }
                    }
                }
                lTAI.get(j).setjValue(1);
                lTAI.get(j).setIdJug(newTAI.getIdJug());
                checkPersonVolume.add(lTAI.get(j).getpId());

                for (TasteAndImportance tasteAndImportance : lTAI) {
                    if (tasteAndImportance.equals(newTAI)) {
                        tasteAndImportance.setjValue(tasteAndImportance.getjValue() - 1);
                    }
                }

            }
        }
    }

}
