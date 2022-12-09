package pl.edu.pwr.bsadowski.tools;

import pl.edu.pwr.bsadowski.model.TasteAndImportance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Gladness {

    public static int countSatisfaction(List<TasteAndImportance> lTAI){
        int satisfaction = 0;
        for(TasteAndImportance taiSatis : lTAI){
            satisfaction += (taiSatis.getjValue() *  taiSatis.getImportance());
        }
        return satisfaction;
    }

    public static int countDissatisfaction(List<TasteAndImportance> lTAI){
        Set<Integer> checkIdPersonList = new HashSet<>();
        int dissatisfaction = 0;
        for(TasteAndImportance taiDissatis : lTAI){
            if(taiDissatis.getjValue() < 400 && !checkIdPersonList.contains(taiDissatis.getpId())){
                dissatisfaction += (-(taiDissatis.getjValue())+400);
                checkIdPersonList.add(taiDissatis.getpId());
            }
            else {
                checkIdPersonList.add(taiDissatis.getpId());
            }
        }
        return  dissatisfaction;
    }
}
