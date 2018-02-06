package com.example.asus.abaha42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

public class Entry extends AppCompatActivity {
TextView registretion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_entry);
        registretion=(TextView)findViewById (R.id.registretionBnt);
        registretion.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent (Entry.this,Registration.class);
                startActivity (intent);
            }
        });
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
        return super.onOptionsItemSelected (item);
    }
}
