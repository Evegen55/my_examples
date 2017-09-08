package DesignPatterns.my;

/**
 * @author (created on 9/8/2017).
 */
interface SimpleInterface {

    default void methodMy() {
       this.doSmthWith("with my string");
    };

    String doSmthWith(final String param);
}
