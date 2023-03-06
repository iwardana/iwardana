package com.example.trouvaille.Models;

public class FavItem {


        private String item_title;
        private String key_id;
        private int item_image;
        private String province_desc;
        private String capital;
        private String other;


        public FavItem(){
        }

        public FavItem(String item_title, String key_id, int item_image, String province_desc,  String capital, String other) {
            this.item_title = item_title;
            this.key_id = key_id;
            this.item_image = item_image;
            this.province_desc=province_desc;
            this.capital= capital;
            this.other=other;
        }

        public String getItem_title() {
            return item_title;
        }

        public void setItem_title(String item_title) {
            this.item_title = item_title;
        }

        public String getKey_id() {
            return key_id;
        }

        public void setKey_id(String key_id) {
            this.key_id = key_id;
        }

        public int getItem_image() {
            return item_image;
        }

        public void setItem_image(int item_image) {
            this.item_image = item_image;
        }

        public String getProvince_desc() {
            return province_desc;
        }

        public void setProvince_desc(String province_desc) {
            this.province_desc = province_desc;
        }


        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }
    }


