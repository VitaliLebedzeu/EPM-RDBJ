package annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(ThisCodeSmells.List.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ThisCodeSmells {
    String reviewer() default "Ivan Kalinin";

    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        ThisCodeSmells[] value();
    }
}
