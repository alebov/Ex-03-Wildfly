package it.distributedsystemsm.model;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@SessionScoped
@Stateful
public class Calculator implements Serializable {

    private long value;

    @PostConstruct
    public void onCreate() {
        System.out.println("\n\nCalculator created\n\n");
        value = 0;
    }

    public long sum(long other) {
        this.value += other;
        return value;
    }

    public long subtract(long other) {
        this.value -= other;
        return value;
    }

    public long multiply(long other) {
        this.value *= other;
        return value;
    }

    public long divide(long other) {
        this.value /= other;
        return value;
    }

    public long getValue() {
        return value;
    }


}