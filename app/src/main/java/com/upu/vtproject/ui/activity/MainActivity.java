package com.upu.vtproject.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.upu.vtproject.R;
import com.upu.vtproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    public static NavController bottomNavController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initiateHome();
    }

    private void initiateHome() {
        bottomNavController = Navigation.findNavController(MainActivity.this, R.id.navFragment);
        NavigationUI.setupWithNavController(binding.bottomNav, bottomNavController);

//        binding.bottomNav.getMenu().findItem(R.id.nav_home).setOnMenuItemClickListener(menuItem -> {
//            if (bottomNavController.getCurrentDestination().getId() != R.id.nav_home) {
//                navigateToFragment(R.id.nav_home);
//        }
//            return false;
//        });

    }

//    public void navigateToFragment(int id) {
//        bottomNavController.navigate(id);
//    }



}