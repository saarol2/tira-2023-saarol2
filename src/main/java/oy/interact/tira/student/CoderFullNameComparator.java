package oy.interact.tira.student;

import java.util.Comparator;

import oy.interact.tira.model.Coder;

public class CoderFullNameComparator implements Comparator<Coder> {

    @Override
    public int compare(Coder first, Coder second) {
        //Kutsutaan Coder-luokan getFullName-metodia ja compareTo-metodia niiden vertailuun.
        return first.getFullName().compareTo(second.getFullName());
    }
    
}
