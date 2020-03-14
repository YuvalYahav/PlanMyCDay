package com.example.planmycday;


    public class User
    {
        private Integer yearOfBirth;
        private Integer yearCD;
        private String gender;

        public User() {

        }
        public User(Integer yearOfBirth, Integer yearCD, String gender) {
            this.yearCD=yearCD;
            this.gender=gender;
            this.yearOfBirth=yearOfBirth;
        }

        public Integer getYearOfBirth() {
            return yearOfBirth;
        }

        public void setYearOfBirth(Integer yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
        }

        public Integer getYearCD() {
            return yearCD;
        }

        public void setYearCD(Integer yearCD) {
            this.yearCD = yearCD;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
