package id.co.maminfaruq.hackatonidn.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.maminfaruq.hackatonidn.R;
import id.co.maminfaruq.hackatonidn.activities.DetailActivity;
import id.co.maminfaruq.hackatonidn.model.BeritaModel;
import id.co.maminfaruq.hackatonidn.responseapi.ArticlesItem;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.ViewHolder> {


    private Context context;
    private List<ArticlesItem> berita;

    public AdapterBerita(Context context, List<ArticlesItem> berita) {
        this.context = context;
        this.berita = berita;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.berita_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        viewHolder.txtJudulBerita.setText(berita.get(i).getTitle());
        viewHolder.txtPenulis.setText(berita.get(i).getAuthor());
        viewHolder.txtTglTerbit.setText(berita.get(i).getPublishedAt());
        Glide.with(context).load(berita.get(i).getUrlToImage()).into(viewHolder.imgBerita);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeritaModel beritaModel = new BeritaModel();

                beritaModel.setTitle(berita.get(i).getTitle());
                beritaModel.setAuthor(berita.get(i).getAuthor());
                beritaModel.setContent(berita.get(i).getContent());
                beritaModel.setPublishedAt(berita.get(i).getPublishedAt());
                beritaModel.setUrl(berita.get(i).getUrl());

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity. EXTRA_OBJ, beritaModel);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return berita.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgBerita)
        ImageView imgBerita;
        @BindView(R.id.txtJudulBerita)
        TextView txtJudulBerita;
        @BindView(R.id.txtPenulis)
        TextView txtPenulis;
        @BindView(R.id.txtTglTerbit)
        TextView txtTglTerbit;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
