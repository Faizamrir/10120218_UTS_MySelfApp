/*
NIM : 10120218
Nama : Faiz Amri Rahman
Kelas : IF-6
Tanggal pengerjaan : 10 Mei 2023
*/
package com.example.a10120218_uts_myselfapp.dailyactivity;

import com.example.a10120218_uts_myselfapp.R;

import java.util.ArrayList;

public class Friends_Data {
    private static String[] data_nama = {
            "Tri",
            "Abyan",
            "Adit",
            "Fahmi",
            "Faris"
    };

    private static String[] data_username = {
            "",
            "",
            "",
            "",
            ""
    };

    private static int[] data_img = {
            R.drawable.tri,
            R.drawable.abyan,
            R.drawable.adit,
            R.drawable.fahmi,
            R.drawable.faris
    };

    public static ArrayList<Friends> getListData() {
        ArrayList<Friends> list = new ArrayList<>();
        for (int position = 0; position<data_nama.length; position++) {
            Friends friends = new Friends();
            friends.setNama(data_nama[position]);
            friends.setUsername(data_username[position]);
            friends.setFoto(data_img[position]);
            list.add(friends);
        }
        return list;
    }
}
