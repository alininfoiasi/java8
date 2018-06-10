package main.java.misc.annotation;

import java.lang.annotation.Documented;

// definition of the misc.annotation type
@Documented
public @interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    // Note use of array
    String[] reviewers();
}
