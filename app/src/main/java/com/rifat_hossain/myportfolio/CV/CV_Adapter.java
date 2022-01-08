package com.rifat_hossain.myportfolio.CV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rifat_hossain.myportfolio.R;

import java.util.List;

public class CV_Adapter extends RecyclerView.Adapter<CV_Adapter.viewHolder> {
    List<String> date;
    List<String> description;
    Context context;

    public CV_Adapter(List<String> date, List<String> description, Context context) {
        this.date = date;
        this.description = description;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.menu_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.date.setText(date.get(position));
        holder.des.setText(description.get(position));
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView date,des;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date_title);
            des=itemView.findViewById(R.id.description_experience);

        }
    }
}
