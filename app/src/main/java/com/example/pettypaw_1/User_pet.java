package com.example.pettypaw_1;

// 강아지 정보를 담기 위한 User_pet 클래스
public class User_pet {
    public String Pet_Name;
    public String Pet_age;
    public String Pet_gender;
    public String Color;


    public User_pet() {

    }

    public User_pet(String PetName, String PetAge, String PetGender, String Color) {
        this.Pet_Name = PetName;
        this.Pet_age = PetAge;
        this.Pet_gender = PetGender;
        this.Color = Color;
    }
}
