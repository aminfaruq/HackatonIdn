package id.co.maminfaruq.hackatonidn.activities;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.co.maminfaruq.hackatonidn.R;
import id.co.maminfaruq.hackatonidn.adapter.AdapterBerita;
import id.co.maminfaruq.hackatonidn.network.ApiService;
import id.co.maminfaruq.hackatonidn.network.ConfigRetrofit;
import id.co.maminfaruq.hackatonidn.responseapi.ArticlesItem;
import id.co.maminfaruq.hackatonidn.responseapi.ResponseBerita;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tampilBerita();
    }

    private void tampilBerita() {
        final ProgressDialog dialog = ProgressDialog.show(getContext(), "", "loading. . .");
        ConfigRetrofit config = new ConfigRetrofit();
        ApiService api = config.service;

        api.getAllBerita().enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                Log.i("debug sukses", response.message());

                if (response.isSuccessful()) {
                    dialog.dismiss();

                    String status = response.body().getStatus();

                    if (status.equals(status)) {
                        ResponseBerita dataSemua = response.body();

                        List<ArticlesItem> data_berita = dataSemua.getArticles();

                        AdapterBerita adapterBerita = new AdapterBerita(getContext(),data_berita);

                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(adapterBerita);

                    }


                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBerita> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("debug gagal",t.getMessage());

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
