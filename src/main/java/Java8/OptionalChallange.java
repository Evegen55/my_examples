package Java8;

import java.util.Optional;

/**
 * @author (created on 11/8/2017).
 */
public class OptionalChallange {

    public static void main(String[] args) throws Throwable {
        String finalOpt = "";
        Optional<String> opt = null;
        try {
            opt = Optional.of(null);
        } catch (RuntimeException e) {
            System.out.println(opt.orElseThrow(() -> new Throwable(e)));
        } catch (Throwable error) {
            finalOpt = opt.orElse("lol");
        }
        System.out.println(finalOpt);
    }
}
