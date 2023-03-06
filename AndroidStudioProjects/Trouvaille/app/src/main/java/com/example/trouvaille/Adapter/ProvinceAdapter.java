package com.example.trouvaille.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.trouvaille.ImageNicer;
import com.example.trouvaille.Models.ProvinceItem;
import com.example.trouvaille.R;

import java.util.ArrayList;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder> {

    private ArrayList<ProvinceItem> provinceItems;
    private Context context;
    private TrouvailleDB trouvailleDB;

    public ProvinceAdapter(ArrayList<ProvinceItem> provinceItems, Context context){
        this.provinceItems = provinceItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        trouvailleDB = new TrouvailleDB(context);
        //Create table first
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart",true);
        if(firstStart){
            createTableOnFirstStart();
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ProvinceAdapter.ViewHolder holder, int position) {
        final ProvinceItem provinceItem= provinceItems.get(position);

        readCursorData(provinceItem,holder);
        holder.imageView.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(context.getResources(),provinceItems.get(position).getImageResourse(),300,300));
        holder.titleTextView.setText(provinceItem.getTitle());
        holder.provinceDescTextView.setText(provinceItem.getProvincedesc());
        holder.capitalTextView.setText(provinceItem.getCapital());
        holder.otherTextView.setText(provinceItem.getOther());
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {   //set on click for home countries
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("image",provinceItem.getImageResourse());
                intent.putExtra("titleTextView",provinceItem.getTitle());
                intent.putExtra("provinceDescTextView",provinceItem.getProvincedesc());
                intent.putExtra("capitalTextView",provinceItem.getCapital());
                intent.putExtra("otherTextView",provinceItem.getOther());

                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return provinceItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleTextView;
        TextView provinceDescTextView;
        TextView capitalTextView;
        TextView otherTextView;
        Button favBtn;
        RelativeLayout relative;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView= itemView.findViewById(R.id.titleTextView);
            favBtn = itemView.findViewById(R.id.favBtn);
            provinceDescTextView =itemView.findViewById(R.id.provinceDesctextView);
            capitalTextView = itemView.findViewById(R.id.capitalTextView);
            otherTextView = itemView.findViewById(R.id.otherTextView);
            relative = itemView.findViewById(R.id.relative);

            //add to fav button
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    ProvinceItem provinceItem = provinceItems.get(position);

                    if (provinceItem.getFavStatus().equals("0")) {
                        provinceItem.setFavStatus("1");
                        trouvailleDB.insertIntoTheDatabase(provinceItem.getTitle(), provinceItem.getImageResourse(), provinceItem.getKey_id(), provinceItem.getFavStatus(), provinceItem.getProvincedesc(), provinceItem.getCapital(), provinceItem.getOther());
                        favBtn.setBackgroundResource(R.drawable.ic_favorite_red_24dp);
                    }else{
                        provinceItem.setFavStatus("0");
                        trouvailleDB.remove_fav(provinceItem.getKey_id());
                        favBtn.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);
                    }
                }

            });

        }
    }

    private void createTableOnFirstStart(){
        trouvailleDB.insertEmpty();

        SharedPreferences prefs= context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }
    private void readCursorData(ProvinceItem provinceItem, ViewHolder viewHolder) {
        Cursor cursor = trouvailleDB.read_all_data(provinceItem.getKey_id());
        SQLiteDatabase db = trouvailleDB.getReadableDatabase();
        try{
            while(cursor.moveToNext()){
                String item_fav_status = cursor.getString(cursor.getColumnIndex(TrouvailleDB.FAVORITE_STATUS));
                provinceItem.setFavStatus(item_fav_status);

                //check favourite status
                if (item_fav_status !=null && item_fav_status.equals("1")){
                    viewHolder.favBtn.setBackgroundResource(R.drawable.ic_favorite_red_24dp);

                }else if (item_fav_status !=null && item_fav_status.equals("0")){
                    viewHolder.favBtn.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);
                }
            }
        }finally {
            if (cursor !=null && cursor.isClosed())
                cursor.close();
            db.close();
        }
    }


}
