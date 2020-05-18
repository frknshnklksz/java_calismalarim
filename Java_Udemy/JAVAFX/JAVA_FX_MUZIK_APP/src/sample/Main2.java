package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        //List<Object, Integer> kelimeler = new ArrayList<>();
        Map<Object, Object> biseyler = new HashMap<>();

        biseyler.put("Isim", "Furkan");
        biseyler.put(4,3.487);
        biseyler.put(7,"Sahin");
        biseyler.put(false,4.78);
        biseyler.put(Math.PI,"PI sayısı");
        biseyler.put(true,4.25);

        for (Map.Entry<Object, Object> entry:
             biseyler.entrySet()) {
            System.out.println("KEY : " + entry.getKey() + " VALUE : " + entry.getValue());
        }

        //ArrayList<String> arrayList = new ArrayList<>();
        Map<ArrayList<String>, String> biseyler2 = new HashMap<>();

        biseyler2.put(biseyler2.keySet().add("Furkan"), 4)

    }
}
