package org.example.newd;

public class PromiseDto {

    private final Integer proposalId;

    private final String lastAcceptedValue;

    private final boolean isSuccess;

    public PromiseDto(Integer proposalId, String lastAcceptedValue, boolean isSuccess) {
        this.proposalId = proposalId;
        this.lastAcceptedValue = lastAcceptedValue;
        this.isSuccess = isSuccess;
    }

    public Integer getProposalId() {
        return proposalId;
    }

    public String getLastAcceptedValue() {
        return lastAcceptedValue;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
