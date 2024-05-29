package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaxosTest {
    private List<Acceptor> acceptors;

    @BeforeEach
    void setup() {
        acceptors = Arrays.asList(new Acceptor(), new Acceptor(), new Acceptor());
    }

    @Test
    void testMultipleProposersSameProposal() {
        Proposer proposer1 = new Proposer(1, "ValueA", acceptors);
        Proposer proposer2 = new Proposer(1, "ValueA", acceptors);
        Proposer proposer3 = new Proposer(1, "ValueA", acceptors);

        proposer1.propose();
        proposer2.propose();
        proposer3.propose();

        for (Acceptor acceptor : acceptors) {
            assertEquals("Proposal 1 with value 'ValueA' was accepted.", acceptor.getLastAcceptedValue());
        }

        Learner learner = new Learner(acceptors);
        learner.learn();
    }

    @Test
    void testMultipleProposersDifferentProposals() {
        Proposer proposer1 = new Proposer(1, "ValueA", acceptors);
        Proposer proposer2 = new Proposer(2, "ValueB", acceptors);
        Proposer proposer3 = new Proposer(3, "ValueC", acceptors);

        proposer1.propose();
        proposer2.propose();
        proposer3.propose();


        int latestAcceptedId = 3;  // Since proposer3 has the highest ID, its value should be accepted
        for (Acceptor acceptor : acceptors) {
            Message accepted = acceptor.accepted(new Message(latestAcceptedId, "ValueC"));
            assertNotNull(accepted);
            assertEquals(3, accepted.proposalId);
            assertEquals("ValueC", accepted.value);
        }


        Learner learner = new Learner(acceptors);
        learner.learn();
    }
}

