package com.example.trouvaille.ui.favourites;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvaille.Adapter.FavAdapter;
import com.example.trouvaille.Helpers.TrouvailleDB;
import com.example.trouvaille.Models.FavItem;
import com.example.trouvaille.R;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment {
    private RecyclerView recyclerView;
    private TrouvailleDB trouvailleDB;
    private List<FavItem> favItemList = new ArrayList<>();
    private FavAdapter favAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_favourite, container, false);


        trouvailleDB = new TrouvailleDB(getActivity());
        recyclerView = root.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        loadData();

        return root;
    }

    private void loadData() {
        if (favItemList != null) {
            favItemList.clear();
        }
        SQLiteDatabase db = trouvailleDB.getReadableDatabase();
        Cursor cursor = trouvailleDB.select_all_favourite_list();
        try {
            while (cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndex(TrouvailleDB.ITEM_TITLE));
                String id = cursor.getString(cursor.getColumnIndex(TrouvailleDB.KEY_ID));
                int image = Integer.parseInt(cursor.getString(cursor.getColumnIndex(TrouvailleDB.ITEM_IMAGE)));
                String provincedesc = cursor.getString(cursor.getColumnIndex(TrouvailleDB.PROVINCE_DESC));
                String capital = cursor.getString(cursor.getColumnIndex(TrouvailleDB.CAPITAL));
                String other =cursor.getString(cursor.getColumnIndex(TrouvailleDB.OTHER));

                FavItem favItem = new FavItem(title, id, image, provincedesc,capital, other);
                favItemList.add(favItem);
            }
        }finally {
            if (cursor !=null && cursor.isClosed())
                cursor.close();
            db.close();
        }

        favAdapter = new FavAdapter(getActivity(), favItemList);

        recyclerView.setAdapter(favAdapter);
    }
}
