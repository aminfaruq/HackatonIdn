package id.co.maminfaruq.hackatonidn.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static final String API_URL = "https://newsapi.org/v2/";// sesuaikan dengan ip internetnya
    //TODO 1 menseting retrofit
    //setting alamat web service
    //add conventer gson
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //TODO 2 membuat object service api dengan retrovit
    public ApiService service = retrofit.create(ApiService.class);
}
