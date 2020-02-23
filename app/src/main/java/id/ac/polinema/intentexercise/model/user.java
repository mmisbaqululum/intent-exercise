package id.ac.polinema.intentexercise.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;


public class user implements Parcelable {
    private String fullname;
    private String email;
    private String password;
    private String confirm;
    private String homepage;
    private String about;
    private Bitmap profileImage;

    public user(String fullname, String email, String password, String confirm, String homepage, String about) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.homepage = homepage;
        this.about = about;
    }

    public user(Parcel in) {
        fullname = in.readString();
        email = in.readString();
        password = in.readString();
        confirm = in.readString();
        homepage = in.readString();
        about = in.readString();
    }

    public static final Creator<user> CREATOR = new Creator<user>() {
        @Override
        public user createFromParcel(Parcel in) {
            return new user(in);
        }

        @Override
        public user[] newArray(int size) {
            return new user[size];
        }
    };

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public String getName() {
        return fullname;
    }

    public void setName(String name) {
        this.fullname = name;
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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullname);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(confirm);
        dest.writeString(homepage);
        dest.writeString(about);
    }
}


