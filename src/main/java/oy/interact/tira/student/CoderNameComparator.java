package oy.interact.tira.student;

import java.util.Comparator;

import oy.interact.tira.model.Coder;

public class CoderNameComparator implements Comparator<Coder> {

    @Override
    public int compare(Coder first, Coder second) {
        //Kutsutaan Coder-luokan getCoderName-metodia ja compareTo-metodia niiden vertailuun.
        return first.getCoderName().compareTo(second.getCoderName());
    }
    
}
