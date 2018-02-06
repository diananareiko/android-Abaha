package com.example.asus.abaha42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import static com.example.asus.abaha42.MainActivity.EXTRA_DATE;
import static com.example.asus.abaha42.MainActivity.EXTRA_DESC;
import static com.example.asus.abaha42.MainActivity.EXTRA_PRICE;
import static com.example.asus.abaha42.MainActivity.EXTRA_TITLE;
import static com.example.asus.abaha42.MainActivity.EXTRA_TOWN;
import static com.example.asus.abaha42.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {
    public ImageView imageView;
    public TextView textViewHeadDet;
    public TextView textViewDescDet;
    public TextView textViewPriceDet;
    public TextView textViewDateDet;
    public TextView textViewTownDet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent ();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String title =intent.getStringExtra(EXTRA_TITLE);
        String desc = intent.getStringExtra(EXTRA_DESC);
        String price =intent.getStringExtra(EXTRA_PRICE);
        String date = intent.getStringExtra(EXTRA_DATE);
        String town = intent.getStringExtra(EXTRA_TOWN);
        imageView = (ImageView) findViewById(R.id.imageDetail);
        textViewHeadDet = (TextView) findViewById(R.id.textViewHeadDet);
        textViewDescDet = (TextView) findViewById(R.id.textViewDescDet);
        textViewPriceDet = (TextView) findViewById(R.id.textViewPriceDet);
        textViewDateDet = (TextView) findViewById(R.id.textViewDateDet);
        textViewTownDet = (TextView) findViewById(R.id.textViewTownDet);
        Picasso.with(this).load(imageUrl).into(imageView);
        textViewHeadDet.setText(title);
        textViewDescDet.setText(desc);
        textViewPriceDet.setText(price);
        textViewPriceDet.setText(date);
        textViewTownDet.setText(town);
    }
}
