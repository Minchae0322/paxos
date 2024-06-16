package org.example.newd;

public class Acceptor {

    private Integer lastProposerId = -1;
    private String lastAcceptedValue = "NIL";

    public PromiseDto promise(Integer proposerId) {
        if (proposerId > lastProposerId) {
            lastProposerId = proposerId;
            return new PromiseDto(lastProposerId, lastAcceptedValue, true);
        }
        return new PromiseDto(lastProposerId, "", false);
    }

    public Integer accepted(AcceptRequest acceptRequest) {
        if (acceptRequest.getAcceptId() >= lastProposerId) {
            lastProposerId = acceptRequest.getAcceptId();
            lastAcceptedValue = acceptRequest.getAcceptValue();
            return lastProposerId;
        }
        return lastProposerId;
    }
}
