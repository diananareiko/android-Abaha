package com.example.asus.abaha42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import static com.example.asus.abaha42.R.layout.menu_item;

public class MenuItem extends AppCompatActivity {
String [] menuItemArray = {"Одежда,обувь,фксессуары", "Авто и запчасти", "Спорт,отдых и хобби", "Телефоны и аксессуары", "Электроника",
    "Для дома и дачи", "Бытовая техника", "Работа", "Аренда и недвижимость", "Услуги", "Домашние животные", "Для бизнеса", "Города Беларуси", "Способы оплаты", "Пользовательское соглашение "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_menu_item);
        ListView listView=(ListView)findViewById (R.id.lvmenu);
        ArrayAdapter<String> myadapter= new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, menuItemArray);
        listView.setAdapter (myadapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId ()) {
            case R.id.mymenu:
                Intent intent = new Intent (this, com.example.asus.abaha42.MenuItem.class);
                startActivity (intent);
                break;
            case R.id.newad:
                intent = new Intent (this, NewAd.class);
                startActivity (intent);
                break;
            case R.id.registretion:
                intent = new Intent (this, Registration.class);
                startActivity (intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
