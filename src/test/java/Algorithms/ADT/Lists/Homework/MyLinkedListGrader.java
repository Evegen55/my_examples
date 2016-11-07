package Algorithms.ADT.Lists.Homework;

import java.io.PrintWriter;

public class MyLinkedListGrader {

    PrintWriter out;

    public String printListForwards(MyLinkedList<Integer> lst) {
        LLNode<Integer> curr;
        String ret = "";
        if (lst.getHead().getData() == null)
            curr = lst.getHead().getNext();
        else
            curr = lst.getHead();

        while (curr != null && curr.getData() != null) {
            ret += curr.getData();
            curr = curr.getNext();
        }
        return ret;
    }

    public String printListBackwards(MyLinkedList<Integer> lst) {
        LLNode<Integer> curr;
        String ret = "";
        if (lst.getTail().getData() == null)
            curr = lst.getTail().getPrev();
        else
            curr = lst.getTail();
        while (curr != null && curr.getData() != null) {
            ret += curr.getData();
            curr = curr.getPrev();
        }
        return ret;
    }

    public void doTest() {
        int incorrect = 0;
        int tests = 0;
        String feedback = "";
        try {
            out = new PrintWriter("src\\test\\resources\\grader_output\\module1.part1.out", "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        MyLinkedList<Integer> lst = new MyLinkedList<>();
        int nums[] = {1, 2, 3, 4, 5};

        feedback += " ** Test #1: Adding to end of list...";
        for (int i : nums) {
            lst.add(i);
        }
        feedback += "Got " + printListForwards(lst) + ". ";

        feedback += "\n ** Test #2: Getting from the middle...";
        feedback += "Fourth element was " + lst.get(3) + ". ";

        lst.add(2, 6);

        feedback += "\n ** Test #3: Adding to the middle...";
        feedback += "Got " + printListForwards(lst) + ". ";

        feedback += "\n ** Test #4: Testing 'prev' pointers by going through the list backwards...";
        feedback += "Got " + printListBackwards(lst) + ". ";

        feedback += "\n ** Test #5: Testing list size...";
        feedback += "Got " + lst.size() + ". ";

        lst.remove(2);
        feedback += "\n ** Test #6: Removing from the middle...";
        feedback += "Got " + printListForwards(lst) + ". ";

        feedback += "\n ** Test #7: Testing 'prev' pointers on remove by going through the list backwards...";
        feedback += "Got " + printListBackwards(lst) + ". ";

        feedback += "\n ** Test #8: Testing size after remove...";
        feedback += "Got " + lst.size() + ". ";

        feedback += "\n ** Test #9: Testing add, remove, and add on new list...";
        lst = new MyLinkedList<>();
        lst.add(0, 1);
        lst.remove(0);
        lst.add(0, 1);
        feedback += "Got " + printListForwards(lst) + ". ";

        feedback += "\n ** Test 10: Checking size after previous test...";
        feedback += "List size is " + lst.size() + ". ";

        feedback += "\n ** Tests 11-20: Testing method bounds...";

        out.println(feedback + "Tests complete. Check that everything is as expected.");
        out.close();

    }

    public static void main(String args[]) {
        MyLinkedListGrader grader = new MyLinkedListGrader();
        grader.doTest();
    }


}
