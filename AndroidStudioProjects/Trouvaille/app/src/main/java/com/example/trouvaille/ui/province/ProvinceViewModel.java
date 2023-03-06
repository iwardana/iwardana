package com.example.trouvaille.ui.province;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProvinceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProvinceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is country fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
