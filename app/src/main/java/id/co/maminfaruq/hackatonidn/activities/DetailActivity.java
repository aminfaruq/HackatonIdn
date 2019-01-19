package id.co.maminfaruq.hackatonidn.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.maminfaruq.hackatonidn.R;
import id.co.maminfaruq.hackatonidn.model.BeritaModel;

public class DetailActivity extends AppCompatActivity {


    public static final String EXTRA_OBJ = "EXTRA_OBJ";
    @BindView(R.id.ivGambarBerita)
    ImageView ivGambarBerita;
    @BindView(R.id.tvTglTerbit)
    TextView tvTglTerbit;
    @BindView(R.id.tvPenulis)
    TextView tvPenulis;
    @BindView(R.id.wvContentBerita)
    TextView wvContentBerita;
    @BindView(R.id.tvBacaSelengkapnya)
    TextView tvBacaSelengkapnya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BeritaModel beritaModel = getIntent().getParcelableExtra(EXTRA_OBJ);

        String judul = beritaModel.getTitle();
        String penulis = beritaModel.getAuthor();
        String tglTerbit = beritaModel.getPublishedAt();
        String content = beritaModel.getContent();
        String foto = beritaModel.getUrlToImage();

        if (getActionBar() != null){
            Objects.requireNonNull(getSupportActionBar()).setTitle(judul);
        }

        tvPenulis.setText(penulis);
        tvTglTerbit.setText(tglTerbit);
        wvContentBerita.setText(content);

        Glide.with(this).load(foto).into(ivGambarBerita);
    }

    @OnClick(R.id.tvBacaSelengkapnya)
    public void onViewClicked() {
        BeritaModel beritaModel = new BeritaModel();
        String url = beritaModel.getUrl();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }
}
