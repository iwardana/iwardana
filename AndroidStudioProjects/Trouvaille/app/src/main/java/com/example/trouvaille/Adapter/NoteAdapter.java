package com.example.trouvaille.Adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvaille.Models.Note;
import com.example.trouvaille.NoteDetail;
import com.example.trouvaille.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Note> notes;

    public NoteAdapter(Context context, List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = inflater.inflate(R.layout.custom_note_list_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder viewHolder, int i){
        String title    = notes.get(i).getTitle();
        String  date     = notes.get(i).getDate();
        String  time     = notes.get(i).getTime();
        long    id       = notes.get(i).getId();
        Log.d("date on ", "Date on: "+date);

        viewHolder.nTitle.setText(title);
        viewHolder.nDate.setText(date);
        viewHolder.nTime.setText(time);
        viewHolder.nID.setText(String.valueOf(notes.get(i).getId()));
    }

    @Override
    public int getItemCount(){
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nTitle,nDate,nTime,nID;

        public ViewHolder(@NonNull final View itemView){
            super(itemView);
            nTitle  = itemView.findViewById(R.id.nTitle);
            nDate   = itemView.findViewById(R.id.nDate);
            nTime   = itemView.findViewById(R.id.nTime);
            nID     = itemView.findViewById(R.id.listId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v){
                    Intent i = new Intent(v.getContext(), NoteDetail.class);
                    i.putExtra("ID", notes.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(i);
                }
            });
        }
    }

}
