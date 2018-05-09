package Java7.esape;

import java.lang.reflect.Method;

public class Inners {


    public Outer method () {

        class Inner {}

        class Inner1 implements Outer {
            @Override
            public String doSmthg() {
                return null;
            }
        }

        class Inner2 implements Outer {
            @Override
            public String doSmthg() {
                return "doSmthg";
            }

            public String doSmthgInner() {
                return "doSmthgInner";
            }
        }

        Inner inner = new Inner();
        Inner1 inner1 = new Inner1();

        return inner1;
    }

    public static void main(String[] args) {
        Inners inners = new Inners();
        Outer outer = inners.method();
        String s = outer.doSmthg();
        // TODO: 09.05.2018 HOW IT IS POSSIBLE TO INVOKE doSmthgInner() without writing it in an interface??
        Method[] methods = outer.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
        // TODO: 09.05.2018 ANSWER - IT IS IMPOSSIBLE!
        // public java.lang.String Java7.esape.Inners$1Inner1.doSmthg()
        // public final void java.lang.Object.wait() throws java.lang.InterruptedException
        // public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
        // public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
        // public boolean java.lang.Object.equals(java.lang.Object)
        // public java.lang.String java.lang.Object.toString()
        // public native int java.lang.Object.hashCode()
        // public final native java.lang.Class java.lang.Object.getClass()
        // public final native void java.lang.Object.notify()
        // public final native void java.lang.Object.notifyAll()
    }
}
