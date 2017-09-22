/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java7.earthquakes.filters;

import Java7.earthquakes.model.QuakeEntry;

/**
 * @author Lartsev
 */
public class PhraseFilter implements Filter {

    private String where;
    private String what;

    /**
     * @param loc
     * @param phrase
     */
    public PhraseFilter(String loc, String phrase) {
        where = loc;
        what = phrase;
    }

    /**
     * @param quakeEntry
     * @return
     */
    @Override
    public boolean satisfies(final QuakeEntry quakeEntry) {
        if (where.equals("end") && quakeEntry.getInfo().endsWith(what)) {
            return true;
        } else if (where.equals("start") && quakeEntry.getInfo().startsWith(what)) {
            return true;
        } else return where.equals("any") && quakeEntry.getInfo().contains(what);
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return "PhraseFilter";
    }

}
