package Java7.ADT;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

/**
 * @author Evgenii_Lartcev (created on 10/10/2016).
 */
public class CheckParenthesis {

    /**
     * @param input - input string that has to be checked for pairing parenthesis
     * @return true or false
     */
    public static boolean check(final String input) {
        final Logger logger = LogManager.getLogger(CheckParenthesis.class.getName());

        LinkedList<Character> list = new LinkedList<>(); //this stack may be with infinity size
        for (char c : input.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    list.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!list.isEmpty()) {
                        char c_out = list.pop();
                        if ((c == '}' && c_out != '{') ||
                                ((c == ']' && c_out != '[')) ||
                                ((c == ')' && c_out != '(')
                                )) {
                            logger.error("Error, the parenthesis '" + c + "' with no pair");
                            return false;
                        }
                    } else {
                        break;
                    }
                default:
                    break;

            }
        }
        if (!list.isEmpty()) {
            logger.error("the stack is not empty");
            return false;
        }

        return true;
    }
}
