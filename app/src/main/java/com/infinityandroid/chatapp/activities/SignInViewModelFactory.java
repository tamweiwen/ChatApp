package com.infinityandroid.chatapp.activities;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SignInViewModelFactory implements ViewModelProvider.Factory {
    String email;

    public SignInViewModelFactory(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        SignInViewModel signInViewModel = new SignInViewModel(email);
        return (T) signInViewModel;
    }
}
