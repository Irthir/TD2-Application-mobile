package com.example.navigation3_requiem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Gacha extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation();
            }
        });

        //LA RECEPTION DE NAVIGATION !!!
        final String EXTRA_GACHA="gacha";
        Intent monIntent = getIntent();
        String strGacha = monIntent.getStringExtra(EXTRA_GACHA);

        //On récupère notre layout contenu
        LinearLayout content_gacha = findViewById(R.id.contentgacha);
        //On instancie et on utilise l'inflater
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout=null;
        String videoPath="";
        switch (strGacha)
        {
            case "Genshin" :
                layout = inflater.inflate(R.layout.fragment_genshin,null);
                content_gacha.removeAllViews();
                content_gacha.addView(layout);

                videoPath = "android.resource://"+getPackageName() + "/"+R.raw.genshin;
                break;
            case "FGO" :
                layout = inflater.inflate(R.layout.fragment_fgo,null);
                content_gacha.removeAllViews();
                content_gacha.addView(layout);

                videoPath = "android.resource://"+getPackageName() + "/"+R.raw.fgo;
                break;
            case "GuraBuru" :
                layout = inflater.inflate(R.layout.fragment_guraburu,null);
                content_gacha.removeAllViews();
                content_gacha.addView(layout);

                videoPath = "android.resource://"+getPackageName() + "/"+R.raw.guraburu;
                break;
            case "RSL" :
                layout = inflater.inflate(R.layout.fragment_rsl,null);
                content_gacha.removeAllViews();
                content_gacha.addView(layout);

                videoPath = "android.resource://"+getPackageName() + "/"+R.raw.nordvpn;
                break;
            case "KanColle" :
                layout = inflater.inflate(R.layout.fragment_kancolle,null);
                content_gacha.removeAllViews();
                content_gacha.addView(layout);

                videoPath = "android.resource://"+getPackageName() + "/"+R.raw.kancolle;
                break;
            case "AzuruReinu" :
                layout = inflater.inflate(R.layout.fragment_azurureinu,null);
                content_gacha.removeAllViews();
                content_gacha.addView(layout);

                videoPath = "android.resource://"+getPackageName() + "/"+R.raw.azurureinu;
                break;
            default:
                break;
        }

        if (videoPath!="")
        {
            Log.d("debug","Chargement de la video");
            Log.d("chemin",videoPath);
            Log.d("id video",Integer.toString(R.raw.genshin));

            VideoView video = (VideoView)findViewById(R.id.videoView);
            Uri uri = Uri.parse(videoPath);
            video.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            video.setMediaController(mediaController);
            mediaController.setAnchorView(video);
        }

    }

    public void Navigation()
    {
        //Préparation de la navigation.
        Intent monIntent = new Intent(Gacha.this,MainActivity.class);

        //Navigation
        startActivity(monIntent);
    }
}