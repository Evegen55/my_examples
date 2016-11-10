package Algorithms;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Evgenii_Lartcev (created on 11/10/2016).
 */
public class FinalParamethersInMethod {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Abc");
        arrayList.add("Cbc");
        arrayList.add("Dbc");
        arrayList.add("Bbc");

        changeMeNow(arrayList);

        System.out.println(arrayList);
    }

    private static void changeMeNow(final ArrayList<String> arrayList) {
        //arrayList = new ArrayList<>();
        Collections.sort(arrayList);
    }
}
