package ru.riddle.phVLofSuTe.model;

public class Triple<T1, T2, T3> {

    private final T1 t1;
    private final T2 t2;
    private final T3 t3;

    public Triple(T1 t1, T2 t2, T3 t3){
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public T1 getFirst() {
        return t1;
    }

    public T2 getSecond() {
        return t2;
    }

    public T3 getThird() {
        return t3;
    }
}
