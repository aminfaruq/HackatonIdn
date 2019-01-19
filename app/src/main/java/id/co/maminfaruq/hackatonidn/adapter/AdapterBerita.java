package id.co.maminfaruq.hackatonidn.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.co.maminfaruq.hackatonidn.responseapi.ArticlesItem;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.ViewHolder>{
    private Context context;
    private List<ArticlesItem>berita;

    public AdapterBerita(Context context, List<ArticlesItem> berita) {
        this.context = context;
        this.berita = berita;
    }

    @NonNull
    @Override
    public AdapterBerita.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBerita.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
