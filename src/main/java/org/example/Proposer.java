package org.example;

import java.util.List;

public class Proposer {
    protected int lastProposerId;
    protected String proposalValue;
    protected List<Acceptor> acceptors;

    public Proposer(int proposalId, String proposalValue, List<Acceptor> acceptors) {
        this.lastProposerId = proposalId;
        this.proposalValue = proposalValue;
        this.acceptors = acceptors;
    }

    public void propose() {
        if (prepare(lastProposerId)) {
            if (accept()) {
                System.out.println("Proposal " + lastProposerId + " accepted with value '" + proposalValue + "'");
            } else {
                System.out.println("Proposal " + lastProposerId + " failed to receive acceptance.");
            }
        } else {
            System.out.println("Proposal " + lastProposerId + " failed to receive promises.");
            lastProposerId += 2;
        }
    }

    private boolean prepare(int proposalId) {
        return acceptors.stream()
                .filter(acceptor -> acceptor.promise(new Message(proposalId, proposalValue)).isSuccess())
                .count() > acceptors.size() / 2;
    }

    public boolean accept() {
        return acceptors.stream()
                .filter(acceptor -> acceptor.accepted(new Message(lastProposerId, proposalValue)).isSuccess())
                .count() > acceptors.size() / 2;
    }



}

