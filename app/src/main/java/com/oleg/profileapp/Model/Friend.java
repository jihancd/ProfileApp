package com.oleg.profileapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Friend implements Parcelable {
    String nim, nama, kelas, telepon, email, twitter, instagram, facebook;

    public Friend(String nim, String nama, String kelas, String telepon, String email, String twitter, String instagram, String facebook) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.telepon = telepon;
        this.email = email;
        this.twitter = twitter;
        this.instagram = instagram;
        this.facebook = facebook;
    }

    public Friend() {
    }

    protected Friend(Parcel in) {
        nim = in.readString();
        nama = in.readString();
        kelas = in.readString();
        telepon = in.readString();
        email = in.readString();
        twitter = in.readString();
        instagram = in.readString();
        facebook = in.readString();
    }

    public static final Creator<Friend> CREATOR = new Creator<Friend>() {
        @Override
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        @Override
        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nim);
        dest.writeString(nama);
        dest.writeString(kelas);
        dest.writeString(telepon);
        dest.writeString(email);
        dest.writeString(twitter);
        dest.writeString(instagram);
        dest.writeString(facebook);
    }
}
