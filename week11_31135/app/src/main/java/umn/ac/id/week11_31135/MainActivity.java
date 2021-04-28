package umn.ac.id.week11_31135;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telecom.Call;
import android.widget.Toast;

import java.util.ArrayList;
import javax.security.auth.callback.Callback;



public class MainActivity extends AppCompatActivity {

    RecyclerView rvPostList;
    postAdapter adapter;

    ArrayList<retrofitModel> posts;

    netInterface netInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPostList = findViewById(R.id.rvPostList);
        rvPostList.setLayoutManager(new LinearLayoutManager(this));

        netInterface = configRetrofit.getClient().create(netInterface.class);

        Call<ArrayList<retrofitModel>> postModelCall = netInterface.getPosts();

        postModelCall.enqueue(new Callback<ArrayList<retrofitModel>>(){
            @Override
            public <response> void onResponse(Call<ArrayList<retrofitModel>> call, response<ArrayList<retrofitModel>> response){
                posts = response.body();

                adapter = new postAdapter(posts);
                rvPostList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<retrofitModel>> call, Throwable t){
                Toast.makeText(MainActivity.this, "Internet not available", Toast.LENGTH_LONG).show();
            }
        });
    }
}