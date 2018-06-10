package main.java.misc.annotation;

import java.util.concurrent.ForkJoinPool;

// usage of the misc.annotation type
@ClassPreamble (
        author = "John Doe",
        date = "3/17/2002",
        currentRevision = 6,
        lastModified = "4/12/2004",
        lastModifiedBy = "Jane Doe",
        // note array notation
        reviewers = {"Alice", "Bob", "Cindy"}
)
public class AnnotationUsage {

    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());
    }
}
