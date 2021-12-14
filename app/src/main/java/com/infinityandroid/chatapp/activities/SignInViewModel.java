package com.infinityandroid.chatapp.activities;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignInViewModel extends ViewModel {

    String email;

    public SignInViewModel(String email) {
        this.email = email;
        lastSignedIn = getLastSignedIn();
        Log.i("SignInViewModel", "SignInViewModel created");
        Log.i("SignInViewModel", lastSignedIn.getValue());
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

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("SignInViewModel", "SignInViewModel destroyed");
        Log.i("SignInViewModel", lastSignedIn.getValue());
    }
}
