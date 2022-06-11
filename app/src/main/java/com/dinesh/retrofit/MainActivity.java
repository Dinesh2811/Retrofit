package com.dinesh.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "log_test";

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        getModel();
        getModelAsList();

        getModelByPath();
        getModelByPathAsList();

        getModelByQuery();
        getModelByQueryAsList();

        postModel();
    }

    private void postModel() {
        Model model = new Model("1", "dinesh", "dk@gmail.com", "866");
        Call<Model> call = apiInterface.postModel(model);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModelByQueryAsList() {
        Call<List<Model>> call = apiInterface.getModelByQueryAsList("dinesh", "dk@gmail.com", "866");
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModelByQuery() {
        Call<Model> call = apiInterface.getModelByQuery("dinesh", "dk@email.com", "855");
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModelByPathAsList() {
        Call<List<Model>> call = apiInterface.getModelByPathAsList(1);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    private void getModelByPath() {
        Call<Model> call = apiInterface.getModelByPath(1);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.i(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModelAsList() {
        Call<List<Model>> call = apiInterface.getModelAsList();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                Log.i(TAG, "onResponse: " + response.code());
                Log.i(TAG, "onResponse: " + response.body());
                Log.i(TAG, "onResponse: " + response.body().get(1));
                Log.i(TAG, "onResponse: " + response.body().get(1).getName());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void getModel() {
        Call<Model> call = apiInterface.getModel();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.i(TAG, "onResponse: " + response.code());
                Log.i(TAG, "onResponse: " + response.body());
                Log.i(TAG, "onResponse: " + response.body().getName());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
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