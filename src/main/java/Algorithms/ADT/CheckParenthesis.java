/*
 * Copyright (C) 2016 Lartsev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Algorithms.ADT;

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
        for (final char c : input.toCharArray()) {
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
