package it.distributedsystemsm.model;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
@Stateful
public class Counter implements Serializable {
    private long count;

    @PostConstruct
    public void onCreate() {
        count = 0;
    }
    
    public long increment() {
        count++;
        return count;
    }
}
