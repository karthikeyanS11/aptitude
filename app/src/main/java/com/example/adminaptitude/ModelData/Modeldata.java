package com.example.adminaptitude.ModelData;

public class Modeldata {
    String name;
    String userid;
    String mobile;
    String email;
    String password;
    String dob;

    public Modeldata() {

    }

    public Modeldata(String name, String userid, String mobile, String email, String password, String dob) {
        this.name = name;
        this.userid = userid;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public static class Report {

        String category, sub_category;
    }

    public static class ModelQuestion {
        String questions;
        String optionA;
        String optionB;
        String optionC;
        String optionD;
        String correctans;

        public ModelQuestion(String questions, String optionA, String optionB, String optionC, String optionD, String correctans) {
            this.questions = questions;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.correctans = correctans;
        }

        public String getQuestions() {
            return questions;
        }

        public void setQuestions(String questions) {
            this.questions = questions;
        }

        public String getOptionA() {
            return optionA;
        }

        public void setOptionA(String optionA) {
            this.optionA = optionA;
        }

        public String getOptionB() {
            return optionB;
        }

        public void setOptionB(String optionB) {
            this.optionB = optionB;
        }

        public String getOptionC() {
            return optionC;
        }

        public void setOptionC(String optionC) {
            this.optionC = optionC;
        }

        public String getOptionD() {
            return optionD;
        }

        public void setOptionD(String optionD) {
            this.optionD = optionD;
        }

        public String getCorrectans() {
            return correctans;
        }

        public void setCorrectans(String correctans) {
            this.correctans = correctans;
        }
    }
}


