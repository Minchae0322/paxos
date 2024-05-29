package org.example;

public class Acceptor implements PaxosNode {
    private int lastPromisedId = -1;
    private int lastAcceptedId = -1;
    private String lastAcceptedValue = "NONE";

    @Override
    public synchronized Message promise(Message message) {
        if (message.proposalId > lastPromisedId) {
            lastPromisedId = message.proposalId;

            System.out.println("lastId : " + lastPromisedId + ", lastValue : " + lastAcceptedValue);

            return new Message(lastPromisedId, lastAcceptedValue, true);
        }
        return new Message(lastPromisedId, lastAcceptedValue, false);
    }

    @Override
    public synchronized Message accepted(Message message) {
        if (message.proposalId >= lastPromisedId) {
            lastAcceptedId = message.proposalId;
            lastAcceptedValue = message.value;
            return new Message(lastAcceptedId, lastAcceptedValue, true);
        }
        return new Message(lastAcceptedId, lastAcceptedValue, false);
    }


    public synchronized String getLastAcceptedValue() {
        if (lastAcceptedId != -1) {
            return "Proposal " + lastAcceptedId + " with value '" + lastAcceptedValue + "' was accepted.";
        }
        return "No proposal accepted.";
    }
}

