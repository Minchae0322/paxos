package org.example;

import java.rmi.RemoteException;

public interface PaxosNode {
    Message promise(Message message) throws RemoteException;
    Message accepted(Message message) throws RemoteException;

}
