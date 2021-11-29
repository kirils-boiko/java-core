package com.example.mypackage;

public class Challenge9 {

    public static void main(String[] args) {
        NewTutor newTutor = new NewTutor();
        NewStudent newStudent = new NewStudent(newTutor);
        newTutor.setNewStudent(newStudent);

        Thread newTutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                newTutor.studyTime();
            }
        });

        Thread newStudentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                newStudent.handInAssignment();
            }
        });

        newTutorThread.start();
        newStudentThread.start();
    }
}

class NewTutor {
    private NewStudent newStudent;

    public void setNewStudent(NewStudent newStudent) {
        this.newStudent = newStudent;
    }

    public void studyTime() {

        synchronized (this) {
            System.out.println("NewTutor has arrived");
            try {
                // wait for NewStudent to arrive and hand in assignment
                this.wait();
            } catch (InterruptedException e) {

            }
            synchronized (newStudent) {
                newStudent.startStudy();
                System.out.println("NewTutor is studying with NewStudent");
            }

        }
    }

    public void getProgressReport() {
        // get progress report
        System.out.println("NewTutor gave progress report");
    }
}

class NewStudent {

    private NewTutor newTutor;

    NewStudent(NewTutor newTutor) {
        this.newTutor = newTutor;
    }

    public void startStudy() {
        // study
        System.out.println("NewStudent is studying");
    }

    public void handInAssignment() {
        synchronized (this) {
            System.out.println("NewStudent handed in assignment");
            synchronized (newTutor) {
                newTutor.getProgressReport();
                newTutor.notifyAll();
            }
        }
    }
}

