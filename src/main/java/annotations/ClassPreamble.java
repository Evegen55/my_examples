package annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.CONSTRUCTOR)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface ClassPreamble {

    String author();

    int date();

}
