package org.example.newd;

public class AcceptRequest {
    private Integer acceptId;
    private String acceptValue;

    public AcceptRequest(Integer acceptId, String acceptValue) {
        this.acceptId = acceptId;
        this.acceptValue = acceptValue;
    }

    public Integer getAcceptId() {
        return acceptId;
    }

    public String getAcceptValue() {
        return acceptValue;
    }
}
