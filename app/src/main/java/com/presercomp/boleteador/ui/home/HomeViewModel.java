package com.presercomp.boleteador.ui.home;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.presercomp.boleteador.R;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void numberPress(View view){
        Toast.makeText(null, "Hola", Toast.LENGTH_SHORT).show();
    }
}