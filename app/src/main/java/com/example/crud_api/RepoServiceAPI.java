package com.example.crud_api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RepoServiceAPI {
    String BASE_URL = "http://10.25.1.100:8686/";

    @GET("produits/listes/")
    Call<List<Produit>> Affichage();

    @GET("produits/listes/{id}")
    Call<Produit> GetOne(@Path("id") int id);

    @POST("produits/listes/")
    Call<Produit> addProd(@Body Produit p);
    @DELETE("produits/listes/{id}")
    Call<Produit> deleteProd(@Path("id") int id);
    @PUT("produits/listes/{id}")
    Call<Produit> updateProd(@Path("id") int id, @Body Produit p);

}
