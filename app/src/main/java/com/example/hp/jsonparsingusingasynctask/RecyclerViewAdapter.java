package com.example.hp.jsonparsingusingasynctask;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Contact> list = new ArrayList<>();

    RecyclerViewAdapter(List<Contact> list){
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.item_view,parent,false);
        RecyclerViewHolder holder=new RecyclerViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.Id.setText(list.get(position).getId());
        holder.Name.setText(list.get(position).getName());
        holder.Email.setText(list.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
