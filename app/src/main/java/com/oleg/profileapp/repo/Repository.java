package com.oleg.profileapp.repo;

import com.oleg.profileapp.model.Friend;
import com.oleg.profileapp.model.Profile;

import java.util.ArrayList;

// Tanggal Pengerjaan : 19 Mei 2019
// NIM : 10116347
// Nama : Lukmannudin
// Kelas :IF - 8

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

    static String[][] friendsData = new String[][]{
            {
                    "10116340",
                    "Ibrahimovic Azkaban",
                    "IF - 12",
                    "08911231232",
                    "ibraazkaban@gmail.com",
                    "ibrazzz",
                    "ibrazinov",
                    "Ibrahim Azka"
            },
            {
                    "10116329",
                    "Zaenal Arif",
                    "IF - 7",
                    "0812334234",
                    "zaenalarif@gmail.com",
                    "zaenalarifff",
                    "babangzaenal",
                    "Zae Arif"
            },
            {
                    "10116210",
                    "Maman Abdruhaman",
                    "IF - 1",
                    "08231242342",
                    "maman@gmail.com",
                    "mamankoman",
                    "mamamamaman",
                    "Maman Kuu"
            }
    };

    public static ArrayList<Profile> getProfileData() {
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

    public static ArrayList<Friend> getContactData() {
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

    public static ArrayList<Friend> getFriendsData(){
        Friend friend = null;

        ArrayList<Friend> list = new ArrayList<>();
        for (int i = 0; i < friendsData.length;i++){
            friend = new Friend();
            friend.setNim(friendsData[i][0]);
            friend.setNama(friendsData[i][1]);
            friend.setKelas(friendsData[i][2]);
            friend.setTelepon(friendsData[i][3]);
            friend.setEmail(friendsData[i][4]);
            friend.setTwitter(friendsData[i][5]);
            friend.setInstagram(friendsData[i][6]);
            friend.setFacebook(friendsData[i][7]);
            list.add(friend);
        }
        return list;
    }


}
