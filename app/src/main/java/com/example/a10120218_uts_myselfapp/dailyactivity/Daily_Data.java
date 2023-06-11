/*
NIM : 10120218
Nama : Faiz Amri Rahman
Kelas : IF-6
Tanggal pengerjaan : 10 Mei 2023
*/
package com.example.a10120218_uts_myselfapp.dailyactivity;

import java.util.ArrayList;

public class Daily_Data {
    private static String[] data_kegiatan = {
            "Bangun Tidur",
            "Solat Subuh",
            "Mandi",
            "Kuliah",
            "Kuliah",
            "Kuliah",
            "Rebahan",
            "Makan Malam",
            "Tidur"
    };

    public static ArrayList<Daily> getListData() {
        ArrayList<Daily> list = new ArrayList<>();
        for (int position = 0; position < data_kegiatan.length; position++) {
            Daily daily = new Daily();
            daily.setKegiatan(data_kegiatan[position]);
            list.add(daily);
        }
        return list;
    }
}
