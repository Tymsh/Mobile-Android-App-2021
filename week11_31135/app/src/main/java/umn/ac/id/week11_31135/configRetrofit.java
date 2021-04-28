package umn.ac.id.week11_31135;

import java.net.URI;

import retrofit2.Retrofit;

public class configRetrofit {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static retrofit retrofit = null;
    public static retrofit getClient(){
        if(retrofit == null){
            URI GsonConverterFactory;
            retrofit = new Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static class Builder {
        public Retrofit.Builder baseUrl(String baseUrl) {
        }
    }
}