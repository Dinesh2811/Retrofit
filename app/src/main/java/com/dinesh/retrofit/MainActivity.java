package com.dinesh.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "log_test";

    ApiInterface apiInterface;

    public static List<ApiModel> body;
    static List<ApiModelProductsId> apiModelProductsIdList ;
    static List<String> img ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

//        getModel();
        getModelAsList();
//
//        getModelByPath();
//        getModelByPathAsList();
//
//        getModelByQuery();
//        getModelByQueryAsList();
//
        postModel();

    }

    private void postModel() {
        ApiModel apiModel = new ApiModel(apiModelProductsIdList,"title","des",
                41,5.5d,5.1d,4,
                "jh","jm","jm",img);
//        ApiModel apiModel = new ApiModel("1", "dinesh", "dk@gmail.com", "866");
        Call<ApiModel> call = apiInterface.postModel(apiModel);
        call.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                Log.e(TAG, "onResponse:post " + response.code());
                Log.e(TAG, "onResponse:post " + response.isSuccessful());
                Log.e(TAG, "onResponse:post " + response.toString());
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModelByQueryAsList() {
        Call<List<ApiModel>> call = apiInterface.getModelByQueryAsList("dinesh", "dk@gmail.com", "866");
        call.enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModelByQuery() {
        Call<ApiModel> call = apiInterface.getModelByQuery("dinesh", "dk@email.com", "855");
        call.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModelByPathAsList() {
        Call<List<ApiModel>> call = apiInterface.getModelByPathAsList(1);
        call.enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    private void getModelByPath() {
        Call<ApiModel> call = apiInterface.getModelByPath(1);
        call.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModelAsList() {
        Call<List<ApiModel>> call = apiInterface.getModelAsList();
        call.enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                Log.i(TAG, "onResponse: " + response.code());
                Log.i(TAG, "onResponse: " + response.body());
                body = response.body();
            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModel() {
        Call<ApiModel> call = apiInterface.getModel();
        call.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                Log.i(TAG, "onResponse: " + response.code());
                Log.i(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}


//
////    Retrofit
//    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//
////    Gson
//            implementation 'com.squareup.retrofit2:converter-gson:2.9.0'    //Gson Converter
//            implementation 'com.google.code.gson:gson:2.9.0'    //Used to convert Java Object into JSON representation
//
////    HTTP
//            implementation 'com.squareup.okhttp3:okhttp:5.0.0-alpha.8'
//            implementation 'com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.8'