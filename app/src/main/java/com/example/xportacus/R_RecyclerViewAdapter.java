package com.example.xportacus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class R_RecyclerViewAdapter extends RecyclerView.Adapter<R_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<RutinasModel> rutinasModels;

    public R_RecyclerViewAdapter(Context context, ArrayList<RutinasModel> rutinasModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.rutinasModels = rutinasModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public R_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new R_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull R_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.rTitulo.setText(rutinasModels.get(position).getTitulos_de_video());
        holder.rDescripcion.setText(rutinasModels.get(position).getDescrip_rutinas());
        holder.imageView.setImageResource(rutinasModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return rutinasModels.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView rTitulo, rDescripcion;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            rTitulo = itemView.findViewById(R.id.txtTitulo);
            rDescripcion = itemView.findViewById(R.id.txtDescripcion);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
