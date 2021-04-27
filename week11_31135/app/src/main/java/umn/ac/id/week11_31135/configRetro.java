package umn.ac.id.week11_31135;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class configRetro {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static retrofit retrofit = null;
    public static retrofit getClient(){
        if(retrofit == null){
            retrofit = new retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}