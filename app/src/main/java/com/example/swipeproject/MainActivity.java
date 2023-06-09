package com.example.swipeproject;


import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button;
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    List<PostPojo> postList;
    Adapter adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        button = findViewById(R.id.button);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewxml);
        apiInterface.getposts().enqueue(new Callback<List<PostPojo>>() {
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {

                if (response.body().size() > 0) {
//                    List<PostPojo> postList= response.body();
//                    Adapter adapter=new com.example.swipeproject.Adapter(MainActivity.this, postList);
//
//                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
//                    recyclerView.setLayoutManager(linearLayoutManager);
                    postList = response.body();
                    adapter = new Adapter(MainActivity.this, postList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    Toast.makeText(MainActivity.this, "LIST IS NOT EMPTY", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "LIST IS EMPTY", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent switchActivityIntent = new Intent(MainActivity.this, AddProduct.class);
                startActivity(switchActivityIntent);
            }
        });

        //  listingdata();
    }

    private void filterList(String text) {
        List<PostPojo> filteredList = new ArrayList<>();
        for (PostPojo item : postList) {
            if (item.getProduct_name().toLowerCase().trim().contains(text.toLowerCase().trim())) {
                filteredList.add(item);
            }
        }
        if (filteredList.size() == 0) {
            Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setFilteredList(filteredList);
        }
    }

}