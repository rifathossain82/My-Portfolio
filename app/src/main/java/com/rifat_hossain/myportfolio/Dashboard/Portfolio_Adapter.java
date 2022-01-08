package com.rifat_hossain.myportfolio.Dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.rifat_hossain.myportfolio.R;

import org.w3c.dom.Text;

import java.util.List;

public class Portfolio_Adapter extends RecyclerView.Adapter<Portfolio_Adapter.MyViewHolder>{
    Context context;
    List<Integer> app_image;
    private Call_back call_back;
    public Portfolio_Adapter(Context context, List<Integer> app_image,Call_back call_back1) {
        this.context = context;
        this.app_image = app_image;
        this.call_back=call_back1;
    }

    @NonNull
    @Override
    public Portfolio_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_portfolio,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Portfolio_Adapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(app_image.get(position));
    }

    @Override
    public int getItemCount() {
        return app_image.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.app_image);

            cardView=itemView.findViewById(R.id.cardView_id);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    call_back.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
