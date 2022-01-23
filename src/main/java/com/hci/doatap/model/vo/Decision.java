package com.hci.doatap.model.vo;

public class Decision {
    private String decision;
    private String message;


    public Decision() {
    }

    public Decision(String decision, String message) {
        this.decision = decision;
        this.message = message;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
