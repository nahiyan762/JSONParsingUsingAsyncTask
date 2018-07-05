package com.example.hp.jsonparsingusingasynctask;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView Id,Name,Email;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        Id = itemView.findViewById(R.id.id);
        Name = itemView.findViewById(R.id.name);
        Email = itemView.findViewById(R.id.email);
    }
}
