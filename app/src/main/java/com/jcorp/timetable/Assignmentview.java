package com.jcorp.timetable;

public class Assignmentview {
    String Assignmentnum, DueDate, SUBJECT;

    public Assignmentview(){

    }

    public String getAssignmentnum() {
        return Assignmentnum;
    }

    public void setAssignmentnum(String assignmentnum) {
        Assignmentnum = assignmentnum;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public String getSUBJECT() {
        return SUBJECT;
    }

    public void setSUBJECT(String SUBJECT) {
        this.SUBJECT = SUBJECT;
    }
}


