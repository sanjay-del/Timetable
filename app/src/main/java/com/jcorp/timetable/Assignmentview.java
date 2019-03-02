package com.jcorp.timetable;

public class Assignmentview {
   private String assignmentnum, subject, duedate;

    public Assignmentview() {
    }

    public Assignmentview(String assignmentnum, String subject, String duedate) {
        this.assignmentnum = assignmentnum;
        this.subject = subject;
        this.duedate = duedate;
    }

    public String getAssignmentnum() {
        return assignmentnum;
    }

    public void setAssignmentnum(String assignmentnum) {
        this.assignmentnum = assignmentnum;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
}


