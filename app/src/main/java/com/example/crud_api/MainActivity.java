package com.example.crud_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RepoServiceAPI myApi;
    List<Produit> list = new ArrayList<Produit>();
    ProductAdapter ad;

    Button btnAddProd;
    Button btnGetProduitsList;
    RecyclerView Recycler;
    Produit produit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Appilcation CRUD");

        btnAddProd = (Button) findViewById(R.id.btnAddUser);
        btnGetProduitsList = (Button) findViewById(R.id.btnGetUsersList);
        Recycler = (RecyclerView) findViewById(R.id.RecyclerV);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RepoServiceAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi = retrofit.create(RepoServiceAPI.class);

        btnGetProduitsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProdsList();
            }
        });
        btnAddProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProdActivity.class);
                intent.putExtra("Des", "");
                startActivity(intent);
            }
        });
    }
    public void getProdsList(){
        Call<List<Produit>> call = myApi.Affichage();
        call.enqueue(new Callback<List<Produit>>() {
            @Override
            public void onResponse(Call<List<Produit>> call, Response<List<Produit>> response) {
                if(response.isSuccessful()){
                    list = response.body();

                    ad = new ProductAdapter(MainActivity.this,list);
                    Recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    Recycler.setHasFixedSize(true);
                    Recycler.setAdapter(ad);

                    ad.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Produit>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}