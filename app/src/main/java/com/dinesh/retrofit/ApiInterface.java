package com.dinesh.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
//    https://jsonplaceholder.typicode.com/posts/1

    //    https://jsonplaceholder.typicode.com/posts
    String url = "posts";

    @GET(url)
    Call<Model> getModel();

    @GET("posts")
    Call<List<Model>> getModelAsList();


    //    https://jsonplaceholder.typicode.com/posts/1
    @GET("posts/{id}")
    Call<Model> getModelByPath(@Path("id") int id);

    @GET("posts/{id}")
    Call<List<Model>> getModelByPathAsList(@Path("id") int id);


    //    https://jsonplaceholder.typicode.com/comments?name=dinesh&email=dk@gmail.com&mobile=866
    @GET("posts")
    Call<Model> getModelByQuery(
            @Query("name") String name,
            @Query("email") String email,
            @Query("mobile") String mobile
    );

    @GET("posts")
    Call<List<Model>> getModelByQueryAsList(
            @Query("name") String name,
            @Query("email") String email,
            @Query("mobile") String mobile
    );


    @POST("posts")
    Call<Model> postModel(@Body Model todo);
}
