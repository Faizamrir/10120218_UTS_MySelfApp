/*
NIM : 10120218
Nama : Faiz Amri Rahman
Kelas : IF-6
Tanggal pengerjaan : 10 Mei 2023
*/
package com.example.a10120218_uts_myselfapp.music;

import java.util.ArrayList;

public class Music_Data {
    private static String[] data_musik = {
            "Mad World - Hardwell",
            "Pompeii - Bastille",
            "Viva la vida - Coldplay",
            "Feels Good - Illenium",
            "Safe And Sound - Capital Cities",
            "Payphone - Maroon 5"
    };

    public static ArrayList<Music_Item> getListData() {
        ArrayList<Music_Item> list = new ArrayList<>();
        for (int position = 0; position <data_musik.length; position++) {
            Music_Item mi = new Music_Item();
            mi.setMusicList(data_musik[position]);
            list.add(mi);
        }
        return list;
    }
}
