package com.example.trouvaille.ui.province;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvaille.Adapter.ProvinceAdapter;
import com.example.trouvaille.Models.CityItem;
import com.example.trouvaille.Models.ProvinceItem;
import com.example.trouvaille.R;

import java.util.ArrayList;

public class ProvinceFragment extends Fragment {

    private ArrayList<ProvinceItem> provinceItems = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_province, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ProvinceAdapter(provinceItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        provinceItems.add(new ProvinceItem(R.drawable.borobudur, "Borobudur", "0", "0",
                "This 9th century temple is an Indonesia UNESCO Heritage site located in the heart of Java." +
                        "It is one of the largest Buddhist temple in the world, consisting of six square platforms with 2,672 relief panels and 504 Buddha status. Thousands of Buddhists does their pilgrimage here in Borobudur during Waisak day." +
                        "It is also recommended to stay at Manohara Resort * and take the Borobudur sunrise tour exclusively from them.", "Magelang, Jawa Tengah",
                "RP 50.000,-"));
        provinceItems.add(new ProvinceItem(R.drawable.prambanan, "Prambanan", "1", "0", "Prambanan, a Hindu temple situated in Yogyakarta, is a well known tourist attraction in Java, Indonesia." +
                "It is built during the 9th century for Trimurti as an expression that God is the Creator (Brahma), Preserver (Vishnu) and also the Destroyer (Shiva). It is also one of the Indonesia UNESCO World Heritage Site." +
                "This ancient temple is one of the largest Hindu temple architecture in Southeast Asia ", "Sleman, Yogyakarta",
                "RP 48.000,-"));
        provinceItems.add(new ProvinceItem(R.drawable.uluwatu, "Uluwatu", "2", "0","This spectacular temple is perched at the edge of a large rugged limestone cliff of 70 meters above the Indian ocean. Imagine a scene from cliffhanger with a temple as the touch of dramatic spelndour. This temple is located in Bukit Peninsula in Bali. " +
                "Its majestic structure is constructed and expanded many times since 11th century. Go to the higher grounds nearby for a breathtaking view of either side and sunsets over Uluwatu temple.",
                "Badung, Bali","RP 30.000,-"));

        provinceItems.add(new ProvinceItem(R.drawable.bromo, "Bromo","3","0","Mount Bromo, located in East Java, can be touted as the most iconic among the many volcano mountains in Indonesia." +
                "This is due to it strategically lies in the middle of Tengger caldera, a crater of fine volcanic black sand, while standing foreboding spewing off white sulphurous smoke. " +
                "It is still one of the most active volcanoes in the world and continues to draw many travelers from far and wide to wake up at wee hours to hike and catch the sunrise over the ethereal view of Mount Bromo. ","Malang, Jawa Timur",
                "RP 29.000,-"));
        provinceItems.add(new ProvinceItem(R.drawable.toba, "Toba","4","0","This largest volcanic lake measuring 1,707 sq ft is called Lake Toba, also known as Danau Toba. It is formed after a gigantic volcanic eruption about 70,000 years ago and is the world’s biggest caldera lake. Lake Toba is rumored to be a product of a massive supervolcanic eruption known as the Toba catastrophe theory which has supposedly killed many of the human population. Besides, there are the Batak people here that are well known for their friendliness.The best rated hotels here are Horas Family Home * and Toba Village Inn *.","Toba, Sumatera Utara","Free"));
        provinceItems.add(new ProvinceItem(R.drawable.komodo, "Komodo","5","0","Found at Komodo National Park in Flores is another UNESCO World Heritage Site in Indonesia. Komodo Dragon may very well be the last of the dragons in the world. Come here and get up close and personal with them though be careful as there are reports of attack though rare. This park is also a refuge for many other wild terrestrial species, with mixture of Asiatic and Australian origins and wide variety of marine life. To get here, fly to Labuan Bajo or take a boat trip from Bali or Lombok to Komodo Island.","Pulau Komodo, Nusa Tenggara Timur","RP 7.500,-"));
        provinceItems.add(new ProvinceItem(R.drawable.bukit_lawang, "Bukit Lawang","6","0","Bukit Lawang became a top tourist attraction because of the chance to see the Orang Utan living in the wild in proximity. This Orang Utan sanctuary is also part of the UNESCO World Heritage Site in Indonesia, and literally means “door to the hills”. Travelers will come here to do trekking in hopes to catch sights of the rare Sumatran Orangutans. There is a Orangutan viewing platform where there are twice a day feedings which will almost guarantee a view of them. The Best Accommodations in Bukit Lawang“>best accommodations at Bukit Lawang are Hotel Orangutan * and EcoTravel Cottages *.","Toba, Sumatra Utara","RP 5.000,-"));
        provinceItems.add(new ProvinceItem(R.drawable.raja_ampat, "Raja Ampat","7","0","Raja Ampat islands is definitely one of the top tourist destination in Indonesia not only for divers but also nature lovers and travelers alike. This diver’s paradise is well known for its riches in marine wildlife, pristine reefs and corals that would wow even the most seasoned diver. It is part of the world’s Coral Triangle which is known for housing more than 3000 species of fish and other extraordinary habitats that breed the biodiversity of its marine life. Also, Raja Ampat is a remote place left untouched by development and only independent travelers that are nature lovers made their way here.","Raja Ampat, Papua Barat","RP 500.000,-"));
        provinceItems.add(new ProvinceItem(R.drawable.toraja, "Toraja","8","0","Tana Toraja, or also known as Torajaland, is a highland situated in the southern Sulawesi. A land almost lost in time, it spans with green lush rice terraces, tall limestone and bamboo graves with blue misty mountains as backdrop. The main tourist attraction here is the funeral rites that had been practiced for ages, even after many had adopted Christian beliefs after the Dutch colony. It is said that they are obsess with the idea of death, not in a morbid way but as something really significant to them. You may find cave graves, hanging graves, tau tau (life sized wooden effigies), baby tree graves and even mass slaughter of buffaloes, all these bringing you a sense of strangeness yet captivating.","Toraja, Sulawesi Selatan","RP 10.000,-"));
        provinceItems.add(new ProvinceItem(R.drawable.baliem, "Baliem","9","0","Baliem Valley, a remote place that can only be accessed via flying into Jayapura, the nearest town. The tourist attraction here is the chance to discover tribal villages through trekking from one to another. The people of Lani, Dani and Yali tribal land or Asmat lands are living very much like how they have always been. You will find unique cultures (mummy and tradings) and fashion (traditional penis gourd attire). At the same time, you can marvel at the mountain views, rivers, and vast green fields. The traditional grass huts here are also unique while the tribes’ daily activities are fascinating. The Baliem Valley trekking range from half day walks to 30 days expedition deep into the tribal lands.","Jayawijaya, Papua","Free"));
        return root;
    }
}
