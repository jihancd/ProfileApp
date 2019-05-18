package com.oleg.profileapp.repo;

import com.oleg.profileapp.Model.Friend;
import com.oleg.profileapp.Model.Profile;

import java.util.ArrayList;

public class Repository {
     static String[] profileData = new String[]{
            "",
            "10116347",
            "Lukmannudin",
            "IF - 8",
            "Learn From Yesterday, Life for Today, Hope for Tomorrow "
    };

     static String[] contactData = new String[]{
             "",
             "",
             "",
             "08813095231",
             "laodelukmannudinpriatna@gmail.com",
             "lord_lukman19",
             "lukmannudinpriatna",
             "Lukmannudin Priatna"

     };

    public static ArrayList<Profile> getProfileData(){
        Profile p = null;

        ArrayList<Profile> list = new ArrayList<>();

            p = new Profile();
            p.setFoto(profileData[0]);
            p.setNim(profileData[1]);
            p.setNama(profileData[2]);
            p.setKelas(profileData[3]);
            p.setDeskripsi(profileData[4]);
            list.add(p);

            return list;
    }

    public static ArrayList<Friend> getContactData(){
        Friend friend = null;

        ArrayList<Friend> list = new ArrayList<>();

        friend = new Friend();
        friend.setTelepon(contactData[3]);
        friend.setEmail(contactData[4]);
        friend.setTwitter(contactData[5]);
        friend.setInstagram(contactData[6]);
        friend.setFacebook(contactData[7]);
        list.add(friend);

        return list;
    }


}
