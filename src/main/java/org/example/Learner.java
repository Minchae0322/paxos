package org.example;

import java.util.List;

public class Learner {
    private List<Acceptor> acceptors;

    public Learner(List<Acceptor> acceptors) {
        this.acceptors = acceptors;
    }

    public void learn() {
        for (Acceptor acceptor : acceptors) {
            System.out.println(acceptor.getLastAcceptedValue());
        }
    }
}
