package task1.annotation;

import java.lang.annotation.Repeatable;

@interface ThisCodeSmellsAuthor {
    ThisCodeSmells[] value();
}

@Repeatable(ThisCodeSmellsAuthor.class)
public @interface ThisCodeSmells {
    String author() default "Ivan Kalinin";
}
