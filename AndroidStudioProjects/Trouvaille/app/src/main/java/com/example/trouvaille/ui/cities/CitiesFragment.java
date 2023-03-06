package com.example.trouvaille.ui.cities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trouvaille.Adapter.CityAdapter;
import com.example.trouvaille.Models.CityItem;
import com.example.trouvaille.R;

import java.util.ArrayList;

public class CitiesFragment extends Fragment {
    private ArrayList<CityItem> cityItems = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cities, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CityAdapter(cityItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        cityItems.add(new CityItem(R.drawable.borobudur, "Borobudur", "Jawa Tengah", "0",
                "Population - 1.363.290 ", "This 9th century temple is an Indonesia UNESCO Heritage site located in the heart of Java. " +
                "It is one of the largest Buddhist temple in the world, consisting of six square platforms with 2,672 relief panels and 504 Buddha status. Thousands of Buddhists does their pilgrimage here in Borobudur during Waisak day. " +
                "It is also recommended to stay at Manohara Resort * and take the Borobudur sunrise tour exclusively from them.",
                "Yogyakarta+International+Airport/@-7.8981411,110.0574766,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7ae510af9cb49f:0x53f3289baac373ed!8m2!3d-7.8981464!4d110.0596653"));
        cityItems.add(new CityItem(R.drawable.prambanan, "Prambanan", "Jawa Tengah", "1", "Population - 1.363.290 ", "Prambanan, a Hindu temple situated in Yogyakarta, is a well known tourist attraction in Java, Indonesia. " +
                "It is built during the 9th century for Trimurti as an expression that God is the Creator (Brahma), Preserver (Vishnu) and also the Destroyer (Shiva). It is also one of the Indonesia UNESCO World Heritage Site. "+
                "This ancient temple is one of the largest Hindu temple architecture in Southeast Asia.",
                "Yogyakarta+International+Airport/@-7.8981411,110.0574766,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7ae510af9cb49f:0x53f3289baac373ed!8m2!3d-7.8981464!4d110.0596653"));
        cityItems.add(new CityItem(R.drawable.uluwatu, "Uluwatu", "Bali", "2","Population - 4.320.000",
                "This spectacular temple is perched at the edge of a large rugged limestone cliff of 70 meters above the Indian ocean. Imagine a scene from cliffhanger with a temple as the touch of dramatic spelndour. This temple is located in Bukit Peninsula in Bali. " +
                "Its majestic structure is constructed and expanded many times since 11th century. Go to the higher grounds nearby for a breathtaking view of either side and sunsets over Uluwatu temple. ",
                "Ngurah+Rai+International+Airport/@-8.7467172,115.1645447,18z/data=!3m1!4b1!4m5!3m4!1s0x2dd2441650216933:0xdf71da6ddd7bcc1f!8m2!3d-8.7467172!4d115.166787"));
        cityItems.add(new CityItem(R.drawable.bromo, "Bromo","Jawa Timur","3","Population - 39.740.000 ","Mount Bromo, located in East Java, can be touted as the most iconic among the many volcano mountains in Indonesia. " +
                "This is due to it strategically lies in the middle of Tengger caldera, a crater of fine volcanic black sand, while standing foreboding spewing off white sulphurous smoke. " +
                "It is still one of the most active volcanoes in the world and continues to draw many travelers from far and wide to wake up at wee hours to hike and catch the sunrise over the ethereal view of Mount Bromo.",
                "Abdul+Rachman+Saleh+Airport/@-7.9372226,112.7070326,17z/data=!3m1!4b1!4m5!3m4!1s0x2dd6295283d6bc73:0xf027a77c64c3e30!8m2!3d-7.9372226!4d112.7115173"));
        cityItems.add(new CityItem(R.drawable.toba, "Toba","Sumatra Utara","4","Population - 180.694","This largest volcanic lake measuring 1,707 sq ft is called Lake Toba, also known as Danau Toba. It is formed after a gigantic volcanic eruption about 70,000 years ago and is the world’s biggest caldera lake. Lake Toba is rumored to be a product of a massive supervolcanic eruption known as the Toba catastrophe theory which has supposedly killed many of the human population. Besides, there are the Batak people here that are well known for their friendliness.The best rated hotels here are Horas Family Home * and Toba Village Inn *.",
                "Silangit+International+Airport/@2.2624187,98.9878588,17z/data=!3m1!4b1!4m5!3m4!1s0x302e101489f07145:0x4014411bcc553082!8m2!3d2.2624187!4d98.9878588"));
        cityItems.add(new CityItem(R.drawable.komodo, "Komodo","Nusa Tenggara Timur","5","Population - 5.325.566","Found at Komodo National Park in Flores is another UNESCO World Heritage Site in Indonesia. Komodo Dragon may very well be the last of the dragons in the world. Come here and get up close and personal with them though be careful as there are reports of attack though rare. This park is also a refuge for many other wild terrestrial species, with mixture of Asiatic and Australian origins and wide variety of marine life. To get here, fly to Labuan Bajo or take a boat trip from Bali or Lombok to Komodo Island.",
                "Komodo+International+Airport/@-8.488586,119.869922,14z/data=!3m1!4b1!4m5!3m4!1s0x2db465d3a3f0eb39:0xfc58c2a1b386d012!8m2!3d-8.4885864!4d119.8874316"));
        cityItems.add(new CityItem(R.drawable.bukit_lawang, "Bukit Lawang","Sumatra Utara","6","Population - 43.049","Bukit Lawang became a top tourist attraction because of the chance to see the Orang Utan living in the wild in proximity. This Orang Utan sanctuary is also part of the UNESCO World Heritage Site in Indonesia, and literally means “door to the hills”. Travelers will come here to do trekking in hopes to catch sights of the rare Sumatran Orangutans. There is a Orangutan viewing platform where there are twice a day feedings which will almost guarantee a view of them. ",
                "Kualanamu+International+Airport/@3.6312018,98.8575614,14z/data=!3m1!4b1!4m5!3m4!1s0x30314a34dfa5662d:0xc536c90019a09ea6!8m2!3d3.631202!4d98.875071"));
        cityItems.add(new CityItem(R.drawable.raja_ampat, "Raja Ampat","Papua Barat","7","Population - 40.192","Raja Ampat islands is definitely one of the top tourist destination in Indonesia not only for divers but also nature lovers and travelers alike. This diver’s paradise is well known for its riches in marine wildlife, pristine reefs and corals that would wow even the most seasoned diver. It is part of the world’s Coral Triangle which is known for housing more than 3000 species of fish and other extraordinary habitats that breed the biodiversity of its marine life. ",
                "Marinda+Airport/@-0.422202,130.7577324,14z/data=!3m1!4b1!4m5!3m4!1s0x2d5f02e77960e3f7:0xa7eaeab550a25ad5!8m2!3d-0.4222091!4d130.7752846"));
        cityItems.add(new CityItem(R.drawable.toraja, "Toraja","Sulawesi Selatan","8","Population - 280.794","Tana Toraja, or also known as Torajaland, is a highland situated in the southern Sulawesi. A land almost lost in time, it spans with green lush rice terraces, tall limestone and bamboo graves with blue misty mountains as backdrop. The main tourist attraction here is the funeral rites that had been practiced for ages, even after many had adopted Christian beliefs after the Dutch colony. It is said that they are obsess with the idea of death, not in a morbid way but as something really significant to them. ",
                "Toraja+Airport/@-3.1855791,119.8983058,14z/data=!3m1!4b1!4m5!3m4!1s0x2d93f78957b42bc7:0x94145377d62458d0!8m2!3d-3.1855792!4d119.9158154"));
        cityItems.add(new CityItem(R.drawable.baliem, "Baliem","Papua","9","Population - 268.137","Baliem Valley, a remote place that can only be accessed via flying into Jayapura, the nearest town. The tourist attraction here is the chance to discover tribal villages through trekking from one to another. The people of Lani, Dani and Yali tribal land or Asmat lands are living very much like how they have always been. You will find unique cultures (mummy and tradings) and fashion (traditional penis gourd attire). At the same time, you can marvel at the mountain views, rivers, and vast green fields. ",
                "Wamena+Airport/@-4.1001846,138.9339178,14z/data=!3m1!4b1!4m5!3m4!1s0x683e6c85b8e393c3:0x21d1f25e080a9750!8m2!3d-4.1002098!4d138.9514015"));
        cityItems.add(new CityItem(R.drawable.kota_tua,"Kota Tua","Jakarta","10","Population - 10.560.000","Long before Jakarta turned into a modern metropolis with skyscrapers, it was colonized by the Dutch in the 15th century. The Jakarta Old Town or Kota Tua Jakarta bears reminisce of the Dutch era, with its colonial architecture and historical references. The streets of the Old Town boasts of buildings and structures that date back to the colonial times, most of which are converted into museums today.","Soekarno-Hatta+International+Airport/@-6.127119,106.6534595,17z/data=!3m1!4b1!4m5!3m4!1s0x2e6a02695aaccb09:0x61dee98159fa3fe5!8m2!3d-6.127119!4d106.6534595"));
        cityItems.add(new CityItem(R.drawable.rinjani ,"Rinjani","Nusa Tenggara Barat","11","Population - 3.512.689","Another of Indonesia's famed volcanoes, Gunung Rinjani is a top attraction on Lombok. Rinjani itself does not see the eruptions and activity that some of the others have, but its caldera-forming eruption in the late 13th century is believed to have been one of the most powerful in human history. A lake sits in Rinjani's caldera, and within the lake sits Mt. Baru, another active volcano." +
                "In Rinjani National Park, you may spot animals such as the rare black Ebony leaf monkey, long-tailed macaques, the sulfur-crested cockatoo, and other exotic species. Guided treks are available, and you can camp overnight in the park. The park does caution that treks are strenuous, so if you plan to hike the mountain, you should be in good physical health and be prepared with the appropriate equipment","Zainuddin+Abdul+Madjid+Lombok+International+Airport/@-8.7367297,116.2098529,12.42z/data=!4m5!3m4!1s0x2dcdafb526dcbf7d:0xc3c7d00a4024ad3c!8m2!3d-8.761939!4d116.2735566"));
        cityItems.add(new CityItem(R.drawable.tanah_lot ,"Pure Tanah Lot","Bali","12","Population - 4.320.000","This is one of Bali's most popular temples, built on a rock formation in the sea. The original formation began to deteriorate at one point, so a portion of the rock is now artificial. Still, Pura Tanah Lot draws people in droves, particularly in time to catch the sunset." +
                "This temple compound is found on the southern coast of Beraban village, and you can walk out to the temple at low tide. Once the sun goes down, browse the stalls at Tanah Lot market to purchase unique Balinese souvenirs."
                ,"Ngurah+Rai+International+Airport/@-8.7367297,116.2098529,12z/data=!4m5!3m4!1s0x2dd2441650216933:0xdf71da6ddd7bcc1f!8m2!3d-8.7467172!4d115.166787"));
        cityItems.add(new CityItem(R.drawable.bunaken,"Bunaken","Sulawesi Utara","13","Population - 35.000","Located in the Northwest of Sulawesi Island, Bunaken National Park is a UNESCO World Heritage Site and a diverse marine hub that is a habitat for over 390 species of coral, fish and reptiles. Comprising a total area of 75,265 hectares, Bunaken National Park is undoubtedly the best place for marine lovers." +
                "Travellers can visit this enchanting park by Speedboat from Sulawesi. In Bunaken National Marine Park, there are over 20 diving spots. Not many tourists visiting Indonesia know about this hidden gem, but those who know, visit here with a purpose."
                ,"Sam+Ratulangi+International+Airport/@1.5492705,124.5420914,10z/data=!4m9!1m2!2m1!1sairport+near+Bunaken,+North+Sulawesi!3m5!1s0x3287a11a115f8761:0x89e46facc8e4f969!8m2!3d1.5500478!4d124.9254934!15sCiRhaXJwb3J0IG5lYXIgQnVuYWtlbiwgTm9ydGggU3VsYXdlc2laJSIjYWlycG9ydCBuZWFyIGJ1bmFrZW4gbm9ydGggc3VsYXdlc2mSARpjaXZpbGlhbl9wYXNzZW5nZXJfYWlycG9ydJoBJENoZERTVWhOTUc5blMwVkpRMEZuU1VSbk5XTlRkamQzUlJBQg"));
        cityItems.add(new CityItem(R.drawable.flores,"Flores","Nusa Tenggara Timur","14","Population - 2.015.390","Commonly mistaken for the Island in Portugal, Flores in Indonesia is one of the most underrated destinations in the country. Located on the east of Komodo Island, Flores is also home to the exotic Komodo dragon."+
                "The clear waters of Flores are untouched by tourists hence why it’s the ideal place for divers, eco-admirers and those looking for a laid-back getaway. On top of that, if you’re into learning about native prehistoric findings, traditional cultural events and sighting exotic coral reefs, Flores is one of the best places to visit in Indonesia."
                ,"Komodo+International+Airport/@-8.4885864,116.6088943,6z/data=!4m9!1m2!2m1!1sairport+near+Flores,+East+Nusa+Tenggara!3m5!1s0x2db465d3a3f0eb39:0xfc58c2a1b386d012!8m2!3d-8.4885864!4d119.8874316!15sCidhaXJwb3J0IG5lYXIgRmxvcmVzLCBFYXN0IE51c2EgVGVuZ2dhcmFaKCImYWlycG9ydCBuZWFyIGZsb3JlcyBlYXN0IG51c2EgdGVuZ2dhcmGSAQdhaXJwb3J0mgEkQ2hkRFNVaE5NRzluUzBWSlEwRm5TVU5KT1MxdGR6VlJSUkFC"));
        return root;
    }

}
