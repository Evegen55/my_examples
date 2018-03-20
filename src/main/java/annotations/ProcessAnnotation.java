package annotations;

import java.lang.reflect.Constructor;

public class ProcessAnnotation {

    /**
     *
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        final Class cl = Class.forName("annotations.AnnotatedClass");

        final Constructor[] constructors = cl.getConstructors();
        for (final Constructor c : constructors) {
            if (c.isAnnotationPresent(ClassPreamble.class)) {
                System.out.println("Annotation for next constructor: " + c);
            } else {
                System.err.println("There is no annotations for for next constructor: " + c);
            }
        }
    }

}
