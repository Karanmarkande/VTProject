package com.upu.vtproject.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.upu.vtproject.R;
import com.upu.vtproject.api.ApiClient;
import com.upu.vtproject.api.ApiInterface;
import com.upu.vtproject.api.response.LoginResponse;
import com.upu.vtproject.api.response.StudentResponse;
import com.upu.vtproject.databinding.ActivityLoginBinding;
import com.upu.vtproject.ui.adapter.CourseAdapter;
import com.upu.vtproject.utils.PreferenceUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAPI();
            }

            private void loginAPI() {
                String userName = binding.etUserName.getText().toString();
                String pass = binding.etpass.getText().toString();

                Map<String, Object> loginData = new HashMap<>();
                loginData.put("username", userName);
                loginData.put("password", pass);

                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<LoginResponse> call = apiInterface.login(loginData);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        try {
                            if (String.valueOf(response.code()).equalsIgnoreCase("200")) {
                                if (response.body().getCode()==200) {

                                    PreferenceUtils.setString("token", "" + response.body().getResults(), LoginActivity.this);
                                    PreferenceUtils.setString("is_loged_in", "LogedIn" , LoginActivity.this);
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Code Error", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(LoginActivity.this, "Status Error", Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.d("responseFail", "onFailure: " + t.toString());
                        Toast.makeText(LoginActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                    }
                });
            }

        });

    }
}