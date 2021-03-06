package com.ejemplo.app.koltinyjavaplatzi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import java.util.List;

public class AdapterListado extends RecyclerView.Adapter <AdapterListado.ViewHolder>{

    //El constructor para pasar la información al Adaptador
    private List<PojoBasico> list;

    public AdapterListado(List<PojoBasico> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PojoBasico data = list.get(position);
        holder.txtTitle.setText(data.getTitulo());
        holder.txtDesc.setText(data.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle, txtDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtViewTitle);
            txtDesc = itemView.findViewById(R.id.txtViewDesc);
        }
    }
}
