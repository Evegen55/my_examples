package Reflection;

import java.lang.reflect.Field;

public class BadThings {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = "ABC";
        System.out.println(s.hashCode());

        Field hashField = s.getClass().getDeclaredField("hash");
        hashField.setAccessible(true);
        System.out.println(hashField);

        hashField.set(s, 123456);

        System.out.println(s.hashCode());
    }
}
