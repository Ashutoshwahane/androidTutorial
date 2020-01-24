package com.example.recycleviewtodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/* adapter take the data from model class add to the layout*/


/* we extended the recycleView adapter for custom features */
public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {


    private ArrayList<modelClass> modelClassList = new ArrayList<>();
    private Context context;

    public Adapter(Context context, ArrayList<modelClass> modelClassList) {
        this.modelClassList = modelClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*to find  item layout and to create item layouts */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        /* get all name from model class*/
        String name = modelClassList.get(position).getName();
        String description = modelClassList.get(position).getDescription();
        holder.setData(name, description);

    }

    @Override
    public int getItemCount() {
        /* create no of item layout  as list size*/
        return modelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private TextView textView_name;
        private TextView textView_desciption;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            textView_name = itemView.findViewById(R.id.name);
            textView_desciption = itemView.findViewById(R.id.description);
        }

        private void setData(String name, String description){

            textView_name.setText(name);
            textView_desciption.setText(description);

        }
    }


}
