package com.pad1.padrumahbelajar.kelas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pad1.padrumahbelajar.R;
import com.pad1.padrumahbelajar.model.KelasData;

import java.util.List;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.ViewHolder> {
    private List<KelasData> kelasData;

    public KelasAdapter(List<KelasData> kelasData) {
        this.kelasData = kelasData;
    }

    @NonNull
    @Override
    public KelasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kelas,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KelasAdapter.ViewHolder holder, int position) {
        holder.namaKelas.setText(kelasData.get(position).getNama_kelas());
        Glide.with(holder.iconMapel.getContext())
                .load("https://image.tmdb.org/t/p/w185"+kelasData.get(position).getIkon())
                .into(holder.iconMapel);



    }

    @Override
    public int getItemCount() {
        return kelasData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaKelas;
        ImageView iconMapel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaKelas = itemView.findViewById(R.id.tvNamaKls);
            iconMapel = itemView.findViewById(R.id.ikon);
        }
    }
}
