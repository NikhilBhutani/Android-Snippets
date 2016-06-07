package github.nikhilbhutani.usingretrofit2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Bhutani on 6/7/2016.
 */
public class People {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("height")
    @Expose
    private String height;

    @SerializedName("mass")
    @Expose
    private String mass;

    @SerializedName("hair_color")
    @Expose
    private String hairColor;

    @SerializedName("skin_color")
    @Expose
    private String skinColor;

    @SerializedName("eye_color")
    @Expose
    private String eyeColor;

    @SerializedName("birth_year")
    @Expose
    private String birthYear;

    @SerializedName("gender")
    @Expose
    private String gender;

    public People(String birthYear, String eyeColor, String gender, String hairColor, String height,
                  String mass, String name, String skinColor, String url) {
        this.birthYear = birthYear;
        this.eyeColor = eyeColor;
        this.gender = gender;
        this.hairColor = hairColor;
        this.height = height;
        this.mass = mass;
        this.name = name;
        this.skinColor = skinColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
