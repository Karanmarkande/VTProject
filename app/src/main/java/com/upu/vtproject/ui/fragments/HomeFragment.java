package com.upu.vtproject.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.upu.vtproject.R;
import com.upu.vtproject.api.ApiClient;
import com.upu.vtproject.api.ApiInterface;
import com.upu.vtproject.api.response.StudentResponse;
import com.upu.vtproject.databinding.FragmentHomeBinding;
import com.upu.vtproject.model.StudentModel;
import com.upu.vtproject.ui.adapter.CourseAdapter;
import com.upu.vtproject.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    FragmentHomeBinding binding;
    List<StudentModel> stringList = new ArrayList<>();
    CourseAdapter courseAdapter;
    String token = "";
    String token1 = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        initiateHome();
        return binding.getRoot();
    }

    private void initiateHome() {
        token=  PreferenceUtils.getString("token", getContext());
        token1 = token.substring(1, token.length() - 1);
        getStudent();
    }

    private void getStudent() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<StudentResponse> call = apiInterface.getStudents("Brearer "+token1);
        call.enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {
                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase("200")) {
                        if (response.body().getCode()==200) {
                            stringList.clear();
                            stringList.addAll(response.body().getResults());

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                            binding.recName.setLayoutManager(linearLayoutManager);
                            courseAdapter = new CourseAdapter(getContext(), stringList);
                            binding.recName.setAdapter(courseAdapter);

                            courseAdapter.notifyDataSetChanged();

                        }else {
                            Toast.makeText(getContext(), "Code Error", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getContext(), "Status Error", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {
                Log.d("responseFail", "onFailure: " + t.toString());

            }
        });
    }
}