package com.infinityandroid.chatapp.activities;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.infinityandroid.chatapp.utilities.PreferenceManager;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

import kotlin.jvm.internal.Intrinsics;

public final class SignInViewModelFactory implements ViewModelProvider.Factory {
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
