package za.ac.nwu.ac.logic.flow.impl;

public class Modulo {
    public Integer doMod(int i, int i1) {
        if (i1 == 0) {
            throw new RuntimeException("Dividing by 0");
        }
        return i % i1;
    }
}
