package com.retrofit.java;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.retrofit.java.model.Bean;
import com.retrofit.java.model.BeanList;
import com.retrofit.java.network.ApiJavaService;
import com.retrofit.java.network.RetrofitJavaBuilder;
import com.retrofit.kotlin.KotlinFragment;
import com.retrofit.sample.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.retrofit.Constants.API_KEY;
import static com.retrofit.Constants.API_VERSION;
import static com.retrofit.Constants.DAY;
import static com.retrofit.Constants.MONTH;

public class JavaFragment extends Fragment {

    private static final String TAG = "JavaFragment";

    private ApiJavaService apiService;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = new RetrofitJavaBuilder(requireActivity()).getRetrofit();
        apiService = retrofit.create(ApiJavaService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.btn_send_get_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // HTTP GET
                Call<BeanList> call = apiService.getRequestData(API_KEY, API_VERSION, MONTH, DAY);
                responseHandler(call);
            }
        });


        view.findViewById(R.id.btn_send_post_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // HTTP POST
                Call<BeanList> call = apiService.postRequestData(API_KEY, API_VERSION, MONTH, DAY);
                responseHandler(call);
            }
        });


        view.findViewById(R.id.btn_to_kotlin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                KotlinFragment fragment = new KotlinFragment(); // create second fragment instance

                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.rl_fragment_container, fragment)
                        .addToBackStack(fragment.getClass().getName()) // add back stack
                        .commit();
            }
        });
    }

    private void responseHandler(Call<BeanList> call) {

        call.enqueue(new Callback<BeanList>() {
            @Override
            public void onResponse(@NonNull Call<BeanList> call, @NonNull Response<BeanList> response) {

                assert response.body() != null;
                ArrayList<Bean> beanList = response.body().getBeanList();

                for (Bean bean : beanList) {
                    Log.wtf(TAG, "bean item:" + bean);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BeanList> call, @NonNull Throwable t) {
                Toast.makeText(requireActivity(), "net request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}