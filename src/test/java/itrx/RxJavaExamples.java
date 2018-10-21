package itrx;

import io.reactivex.Flowable;
import org.junit.Test;

public class RxJavaExamples {

    @Test
    public void test() {
        Flowable.just("Hello world")
                .subscribe(System.out::println);
    }
}
