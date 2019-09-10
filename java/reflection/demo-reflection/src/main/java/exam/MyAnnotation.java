package exam;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface MyAnnotation {
    String name() default "jun";

    int number() default 100;
}
