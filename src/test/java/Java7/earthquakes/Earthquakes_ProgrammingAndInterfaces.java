/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java7.earthquakes;


import Java7.earthquakes.algorithms_and_tasks.ClosestQuakes;
import Java7.earthquakes.algorithms_and_tasks.LargestQuakes;
import Java7.earthquakes.algorithms_and_tasks.QuakeSortInPlace;
import Java7.earthquakes.apps.EarthQuakeClient2;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Johnn
 */
public class Earthquakes_ProgrammingAndInterfaces {


    @Test
    @Ignore //until file data\nov20quakedatasmall.atom
    public void test2() {
        ClosestQuakes c = new ClosestQuakes();
        c.findClosestQuakes();
    }

    @Test
    public void test3() {
        LargestQuakes l = new LargestQuakes();
        l.findLargestQuakes();
    }

    @Test
    @Ignore //until file data\nov20quakedatasmall.atom
    public void test4() {
        LargestQuakes l = new LargestQuakes();
        l.findListOfLargestQuakes();
    }

    @Test
    @Ignore //until file data\nov20quakedatasmall.atom
    public void test5(){
        EarthQuakeClient2 s = new EarthQuakeClient2();
        //s.createCSV();
        //s.bigQuakes();
        //s.closeToMe();
        //s.quakesOfDepth();
        //s.quakesWithFilter();
        //s.testMatchAllFilter();
        s.testMatchAllFilter2();
    }

    @Test
    public void testWeek2() {
        QuakeSortInPlace qsip = new QuakeSortInPlace();
        qsip.testSort();
    }
}
