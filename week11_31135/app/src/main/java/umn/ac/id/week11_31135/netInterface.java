package umn.ac.id.week11_31135;

import android.telecom.Call;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface netInterface {

    @GET("posts")
    Call<ArrayList<retrofitModel>> getPosts();
}
