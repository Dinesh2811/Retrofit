package com.dinesh.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
//    http://10.0.2.2/products
    String url = "products";

    @GET(url)
    Call<ApiModel> getModel();

    @GET("products")
    Call<List<ApiModel>> getModelAsList();


    //    https://jsonplaceholder.typicode.com/posts/1
    @GET("posts/{id}")
    Call<ApiModel> getModelByPath(@Path("id") int id);

    @GET("posts/{id}")
    Call<List<ApiModel>> getModelByPathAsList(@Path("id") int id);


    //    https://jsonplaceholder.typicode.com/comments?name=dinesh&email=dk@gmail.com&mobile=866
    @GET("posts")
    Call<ApiModel> getModelByQuery(
            @Query("name") String name,
            @Query("email") String email,
            @Query("mobile") String mobile
    );

    @GET("posts")
    Call<List<ApiModel>> getModelByQueryAsList(
            @Query("name") String name,
            @Query("email") String email,
            @Query("mobile") String mobile
    );


    @POST("products")
    Call<ApiModel> postModel(@Body ApiModel todo);
}
