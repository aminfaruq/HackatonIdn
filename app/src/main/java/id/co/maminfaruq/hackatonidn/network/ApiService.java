package id.co.maminfaruq.hackatonidn.network;

import id.co.maminfaruq.hackatonidn.responseapi.ResponseBerita;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    //TODO 3 merequest data dan mengambil data berita
    @GET("top-headlines?country=id&category=science&apiKey=e379d1d2fefa4a6c8320da3db68ab90b")
    Call<ResponseBerita> getAllBerita();
}
