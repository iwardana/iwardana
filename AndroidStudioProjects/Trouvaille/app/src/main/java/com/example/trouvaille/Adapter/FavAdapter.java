package com.example.trouvaille.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvaille.Details;
import com.example.trouvaille.Helpers.TrouvailleDB;
import com.example.trouvaille.Models.FavItem;
import com.example.trouvaille.R;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    // List to store all the  details
    private Context context;
    private List<FavItem> favItemList;
    private TrouvailleDB trouvailleDB;

    // Counstructor
    public FavAdapter(Context context, List<FavItem> favItemList) {
        this.context = context;
        this.favItemList = favItemList;
    }


    // This method creates views for the RecyclerView by inflating the layout
    // Into the viewHolders which helps to display the items in the
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout view you have created for the list rows here
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item, parent, false);
        trouvailleDB = new TrouvailleDB(context);
        return new ViewHolder(view);
    }




    // This method is called when binding the data to the views being created in RecyclerView
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.favTextView.setText(favItemList.get(position).getItem_title());   // Set the data to the views here
        holder.favImageView.setImageResource(favItemList.get(position).getItem_image());
        holder.favProvinceDescView.setText(favItemList.get(position).getProvince_desc());
        holder.favcapitalTextView.setText(favItemList.get(position).getCapital());
        holder.favotherTextView.setText(favItemList.get(position).getOther());

        //set on click in favourite countries
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("image",favItemList.get(position).getItem_image());
                intent.putExtra("titleTextView",favItemList.get(position).getItem_title());
                intent.putExtra("provinceDescTextView",favItemList.get(position).getProvince_desc());
                intent.putExtra("capitalTextView",favItemList.get(position).getCapital());
                intent.putExtra("otherTextView",favItemList.get(position).getOther());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return favItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView favTextView;
        Button favBtn;
        ImageView favImageView;
        TextView favProvinceDescView;
        TextView favcapitalTextView;
        TextView favotherTextView;
        RelativeLayout relative;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favTextView = itemView.findViewById(R.id.favTextView);
            favBtn = itemView.findViewById(R.id.favBtn);
            favImageView = itemView.findViewById(R.id.favImageView);
            favProvinceDescView =itemView.findViewById(R.id.favprovinceDesctextView);
            favcapitalTextView = itemView.findViewById(R.id.favcapitalTextView);
            favotherTextView = itemView.findViewById(R.id.favotherTextView);
            relative = itemView.findViewById(R.id.relative);   //relative layout


            //after click remove from favorite
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final FavItem favItem = favItemList.get(position);
                    trouvailleDB.remove_fav(favItem.getKey_id());
                    removeItem(position);
                }

                //methanta
            });
        }
    }
    private void removeItem(int position) {
        favItemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,favItemList.size());
    }
}
