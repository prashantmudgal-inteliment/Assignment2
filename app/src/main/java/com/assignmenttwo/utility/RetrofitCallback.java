package com.assignmenttwo.utility;

import android.content.Context;
import android.widget.Toast;

import com.assignmenttwo.interfaces.GetResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by prashant.mudgal on 11/2/2017.
 */

public class RetrofitCallback<T> implements Callback<T> {


    private final GetResultListener listener;
    private Context context;

    public RetrofitCallback(GetResultListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        this.listener.getResult(response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable e) {
        Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
