package Reflection;

import java.lang.reflect.Field;

public class BadThings {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = "ABC";
        String s1 = "abc";
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());

        Field hashField = s.getClass().getDeclaredField("hash");
        System.out.println(hashField);

        hashField.setAccessible(true);
        hashField.set(s, s1.hashCode());
        System.out.println(s.hashCode());
        System.out.println(s.equals(s1));

        System.out.println(s + "\t" + s1);
        Field valueField = s.getClass().getDeclaredField("value");
        System.out.println(valueField);
        valueField.setAccessible(true);
        valueField.set(s, s1.toCharArray());
        System.out.println(s.equals(s1));
        System.out.println(s + "\t" + s1);
    }
}
