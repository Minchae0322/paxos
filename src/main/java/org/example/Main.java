package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Acceptor> acceptors = Arrays.asList(new Acceptor(), new Acceptor(), new Acceptor());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter proposal ID and value:");
        int proposalId = scanner.nextInt();
        String proposalValue = scanner.next();

        Proposer proposer = new Proposer(proposalId, proposalValue, acceptors);
        proposer.propose();

        Learner learner = new Learner(acceptors);
        learner.learn();

        scanner.close();
    }
}