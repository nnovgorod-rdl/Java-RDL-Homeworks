package io.humb1t;

public class Human {
    int age;
    Gender gender;

    public Human(int age, Gender gender) {
        if (age < 0) {
            throw new NotCorrectAgeException("Incorrect age entered");
        } else {
            this.age = age;
        }

        this.gender = gender;
    }
}

enum Gender {MALE, FEMALE}