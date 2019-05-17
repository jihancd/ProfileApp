package com.oleg.profileapp.repo;

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

    public static ArrayList<Profile> getProfileData(){
        Profile p = null;

        ArrayList<Profile> list = new ArrayList<>();
//        for (int i=0; i<profileData.length;i++){
            p = new Profile();
            p.setFoto(profileData[0]);
            p.setNim(profileData[1]);
            p.setNama(profileData[2]);
            p.setKelas(profileData[3]);
            p.setDeskripsi(profileData[4]);
            list.add(p);
//        }
        return list;
    }
}
