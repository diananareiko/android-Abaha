package com.example.asus.abaha42;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {
    private static final String URL_DATA = "https://abaha.by/test-0.json";
    public static final String EXTRA_URL = "imageURL";
    public static final String EXTRA_TITLE = "head";
    public static final String EXTRA_PRICE = "price";
    public static final String EXTRA_DESC = "description";
    public static final String EXTRA_DATE = "date";
    public static final String EXTRA_TOWN = "town";
    private static final String TAG = "MainActivity";
    private ViewPager mViewPager;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
FloatingActionButton floatingActionButton;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        floatingActionButton=(FloatingActionButton) findViewById (R.id.floatingBtn);
        floatingActionButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (MainActivity.this,NewAd.class);
                startActivity (intent);
            }
        });
        recyclerView = (RecyclerView) findViewById (R.id.recyclerView);
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));
        listItems = new ArrayList<> ();
        loadRecyclerViewData ();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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


    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog (this);
        progressDialog.setMessage ("Data loading...");
        progressDialog.show ();
        StringRequest stringRequest = new StringRequest (Request.Method.GET, URL_DATA, new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss ();
                try {
                    JSONArray array = new JSONArray (response);
                    for (int i = 0; i < array.length (); i++) {
                        JSONObject o = array.getJSONObject (i);
                        ListItem item = new ListItem (
                                o.getString ("image_path_md"),
                                o.getString ("title"),
                                o.getString ("price_cent_str"),
                                o.getString ("category"),
                                o.getString ("time_publish_str"),
                                o.getString ("city")
                        );
                        listItems.add (item);
                    }
                    MyAdapter adapter;
                    adapter = new MyAdapter (listItems, MainActivity.this);
                    recyclerView.setAdapter (adapter);
                    adapter.setOnItemClickListener (MainActivity.this);

                } catch (JSONException e) {
                    e.printStackTrace ();
                }
            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss ();
                Toast.makeText (getApplicationContext (), error.getMessage (), Toast.LENGTH_LONG).show ();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue (this);
        requestQueue.add (stringRequest);

    }


    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent (this, DetailActivity.class);
        ListItem clickedItem = listItems.get (position);
        detailIntent.putExtra (EXTRA_URL, clickedItem.getImageUrl ());
        detailIntent.putExtra (EXTRA_TITLE, clickedItem.getHead ());
        detailIntent.putExtra (EXTRA_PRICE, clickedItem.getPrice ());
        detailIntent.putExtra (EXTRA_DESC, clickedItem.getDesc ());
        detailIntent.putExtra (EXTRA_DATE, clickedItem.getDate ());
        detailIntent.putExtra (EXTRA_TOWN, clickedItem.getTown ());
        startActivity (detailIntent);
    }


}
