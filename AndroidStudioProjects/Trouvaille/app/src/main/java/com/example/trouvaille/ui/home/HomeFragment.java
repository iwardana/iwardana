package com.example.trouvaille.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.trouvaille.R;
import com.example.trouvaille.ui.cities.CitiesFragment;
import com.example.trouvaille.ui.favourites.FavouriteFragment;
import com.example.trouvaille.ui.province.ProvinceFragment;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
public class HomeFragment extends Fragment {

    Button b1;
    Button b2;
    Button b3;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        b1 = v.findViewById(R.id.button2);
        b2 = v.findViewById(R.id.button3);
        b3 = v.findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment, new ProvinceFragment());
                fr.commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment,new FavouriteFragment());
                fr.commit();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment,new CitiesFragment());
                fr.commit();



            }
        });

        return v;
    }

}
