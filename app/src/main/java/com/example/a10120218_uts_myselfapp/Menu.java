/*
NIM : 10120218
Nama : Faiz Amri Rahman
Kelas : IF-6
Tanggal pengerjaan : 10 Mei 2023
*/
package com.example.a10120218_uts_myselfapp;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.a10120218_uts_myselfapp.dailyactivity.Daily;
import com.example.a10120218_uts_myselfapp.dailyactivity.Daily_Adapter;
import com.example.a10120218_uts_myselfapp.dailyactivity.Daily_Data;
import com.example.a10120218_uts_myselfapp.dailyactivity.Friendlist_Adapter;
import com.example.a10120218_uts_myselfapp.dailyactivity.Friends;
import com.example.a10120218_uts_myselfapp.dailyactivity.Friends_Data;
import com.example.a10120218_uts_myselfapp.gallery.Gallery_Adapter;
import com.example.a10120218_uts_myselfapp.gallery.Gallery_Item;
import com.example.a10120218_uts_myselfapp.music.Music_Adapter;
import com.example.a10120218_uts_myselfapp.music.Music_Data;
import com.example.a10120218_uts_myselfapp.music.Music_Item;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    private RecyclerView rvFrd, rvDa, rvGal, rvMV;
    private ArrayList<Friends> frd = new ArrayList<>();
    private ArrayList<Daily> dai = new ArrayList<>();
    private ArrayList<Music_Item> mv = new ArrayList<>();

    LinearLayout home, dailyactivity, mvplaylist, profile;
    ConstraintLayout gallery;
    MaterialToolbar title;
    VideoView videoView;
    ImageView facebook,instagram,navigation, about;
    Dialog dialoog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        MaterialToolbar toolbar = findViewById(R.id.topappbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        about = findViewById(R.id.about);
        dialoog = new Dialog(this);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.getMenu().getItem(0).setChecked(true);

        home = findViewById(R.id.home_layout);
        dailyactivity = findViewById(R.id.dailyactivity_layout);
        gallery = findViewById(R.id.gallery_layout);
        mvplaylist = findViewById(R.id.mvplaylist_layout);
        profile = findViewById(R.id.profile_layout);
        title = findViewById(R.id.topappbar);

        facebook = findViewById(R.id.fb);
        instagram = findViewById(R.id.ig);
        navigation = findViewById(R.id.maps);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotolink("https://www.facebook.com/profile.php?id=100006938502894");
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotolink("https://www.instagram.com/faizamrirahman/");
            }
        });

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotolink("https://www.google.com/maps/place/Jl.+Asia+Afrika,+Paledang,+Kec.+Lengkong,+Kota+Bandung,+Jawa+Barat+40261/@-6.9223233,107.6113632,17z/data=!3m1!4b1!4m6!3m5!1s0x2e68e62ec8854899:0x74687c6a5eccb2d2!8m2!3d-6.9223233!4d107.6139381!16s%2Fg%2F11cnd955t1?entry=ttu");
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id) {
                    case R.id.nav_home:
                        home.setVisibility(View.VISIBLE);
                        dailyactivity.setVisibility(View.GONE);
                        gallery.setVisibility(View.GONE);
                        mvplaylist.setVisibility(View.GONE);
                        profile.setVisibility(View.GONE);
                        title.setTitle("MySelf Apps");
                        break;

                    case R.id.nav_dailyactivity:
                        home.setVisibility(View.GONE);
                        dailyactivity.setVisibility(View.VISIBLE);
                        gallery.setVisibility(View.GONE);
                        mvplaylist.setVisibility(View.GONE);
                        profile.setVisibility(View.GONE);
                        title.setTitle("Daily Activity");
                        break;

                    case R.id.nav_gallery:
                        home.setVisibility(View.GONE);
                        dailyactivity.setVisibility(View.GONE);
                        gallery.setVisibility(View.VISIBLE);
                        mvplaylist.setVisibility(View.GONE);
                        profile.setVisibility(View.GONE);
                        title.setTitle("Gallery");
                        break;

                    case R.id.nav_mvplaylist:
                        home.setVisibility(View.GONE);
                        dailyactivity.setVisibility(View.GONE);
                        gallery.setVisibility(View.GONE);
                        mvplaylist.setVisibility(View.VISIBLE);
                        profile.setVisibility(View.GONE);
                        title.setTitle("Music and Video Favorite");
                        break;

                    case R.id.nav_profile:
                        home.setVisibility(View.GONE);
                        dailyactivity.setVisibility(View.GONE);
                        gallery.setVisibility(View.GONE);
                        mvplaylist.setVisibility(View.GONE);
                        profile.setVisibility(View.VISIBLE);
                        title.setTitle("Profile");
                        break;

                    default:
                        return true;
                }
                return true;
            }
        });

        rvFrd = findViewById(R.id.rvFrd);
        rvFrd.setHasFixedSize(true);
        frd.addAll(Friends_Data.getListData());
        showFriendList();

        rvDa = findViewById(R.id.rvDa);
        rvDa.setHasFixedSize(true);
        dai.addAll(Daily_Data.getListData());
        showDailyList();

        rvMV = findViewById(R.id.rvMV);
        rvMV.setHasFixedSize(true);
        mv.addAll(Music_Data.getListData());
        showMusicList();

        rvGal = findViewById(R.id.rvGal);
        rvGal.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        //gallery_data_list
        List<Gallery_Item> gallery_items = new ArrayList<>();
        gallery_items.add(new Gallery_Item(R.drawable.foto3));
        gallery_items.add(new Gallery_Item(R.drawable.foto4));
        gallery_items.add(new Gallery_Item(R.drawable.foto5));
        gallery_items.add(new Gallery_Item(R.drawable.foto6));
        gallery_items.add(new Gallery_Item(R.drawable.foto7));
        gallery_items.add(new Gallery_Item(R.drawable.foto8));
        gallery_items.add(new Gallery_Item(R.drawable.foto9));
        gallery_items.add(new Gallery_Item(R.drawable.foto10));
        gallery_items.add(new Gallery_Item(R.drawable.foto11));
        gallery_items.add(new Gallery_Item(R.drawable.foto12));


        rvGal.setAdapter(new Gallery_Adapter(gallery_items));

        videoView = findViewById(R.id.video);
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1));
        videoView.start();
    }

    private void openDialog() {
        dialoog.setContentView(R.layout.dialog);
        dialoog.getWindow();
        dialoog.show();
    }

    private void gotolink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void showFriendList() {
        rvFrd.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        Friendlist_Adapter fladapter = new Friendlist_Adapter(frd);
        rvFrd.setAdapter(fladapter);
    }

    private void showDailyList() {
        rvDa.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Daily_Adapter daiadapter = new Daily_Adapter(dai);
        rvDa.setAdapter(daiadapter);
    }

    private void showMusicList() {
        rvMV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Music_Adapter mvadapter = new Music_Adapter(mv);
        rvMV.setAdapter(mvadapter);
    }

}