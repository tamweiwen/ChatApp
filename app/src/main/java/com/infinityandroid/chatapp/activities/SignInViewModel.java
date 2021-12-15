package com.infinityandroid.chatapp.activities;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignInViewModel extends ViewModel {

    String email;

    public SignInViewModel(String email) {
        this.email = email;
        lastSignedIn = getLastSignedIn();
    }

    private MutableLiveData<String> _lastSignedIn;
    public LiveData<String> lastSignedIn;


    public MutableLiveData<String> getLastSignedIn() {
        if (_lastSignedIn == null) {
            _lastSignedIn = new MutableLiveData<>();
            setLastSignedIn();
        }
        return _lastSignedIn;
    }

    public void setLastSignedIn(){
        _lastSignedIn.setValue(email);
    }

}
