package org.example.newd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Proposer {

    private Integer lastProposeId = -1;
    private String proposerValue = "";

    private Learner learner;

    List<Acceptor> acceptors = new ArrayList<>();
    public void propose() {
        List<PromiseDto> promiseDtoList = acceptors.stream()
                .map(acceptor -> acceptor.promise(++lastProposeId))
                .filter(PromiseDto::isSuccess)
                .collect(Collectors.toList());

        if (promiseDtoList.size() > acceptors.size() / 2) {
            accept(lastProposeId);
            return;
        }
        promiseDtoList.forEach(
                promiseDto -> lastProposeId = Math.max(lastProposeId, promiseDto.getProposalId()) + 1
        );
    }

    public void accept(Integer proposeId) {
        List<Integer> response = acceptors.stream()
                .map(acceptor -> acceptor.accepted(new AcceptRequest(proposeId, proposerValue)))
                .collect(Collectors.toList());

        long accepted = response.stream()
                .filter(integer -> integer == proposeId)
                .count();

        if (accepted > acceptors.size() / 2) {
            learner.learn(proposerValue);
            return;
        }

    }

}
