package com.rifat_hossain.myportfolio.Team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rifat_hossain.myportfolio.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Team_adapter extends RecyclerView.Adapter<Team_adapter.MyViewHolder> {
    List<Integer> profile;
    List<String> name;
    List<String> des;
    Context context;

    public Team_adapter(List<Integer> profile, List<String> name, List<String> des, Context context) {
        this.profile = profile;
        this.name = name;
        this.des = des;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.team_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.circleImageView.setImageResource(profile.get(position));
        holder.name.setText(name.get(position));
        holder.des.setText(des.get(position));

    }

    @Override
    public int getItemCount() {
        return profile.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView name,des;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView=itemView.findViewById(R.id.team_image);
            name=itemView.findViewById(R.id.member_name);
            des=itemView.findViewById(R.id.member_des);



        }
    }
}
