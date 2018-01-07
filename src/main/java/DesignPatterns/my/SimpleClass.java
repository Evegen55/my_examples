package DesignPatterns.my;

/**
 * @author (created on 9/8/2017).
 */
public class SimpleClass implements SimpleInterface {

    @Override
    public String doSmthWith(String param) {
        System.out.println("abc");
        System.out.println(param);
        this.methodMy();
        return null;
    }
}
