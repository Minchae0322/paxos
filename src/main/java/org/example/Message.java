package org.example;

public class Message {
    protected final int proposalId;

    protected final String value;
    protected boolean isSuccess;

    public Message(int proposalId, String value) {
        this.proposalId = proposalId;
        this.value = value;
    }

    public Message(int proposalId, String value, boolean isSuccess) {
        this.proposalId = proposalId;
        this.value = value;
        this.isSuccess = isSuccess;
    }

    public int getProposalId() {
        return proposalId;
    }

    public String getValue() {
        return value;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
