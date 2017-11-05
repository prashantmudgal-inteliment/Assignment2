package com.assignmenttwo.presenter;

import android.content.Context;

import com.assignmenttwo.interfaces.GetResultListener;
import com.assignmenttwo.interfaces.GetSpinnerData;
import com.assignmenttwo.models.ApiResponseModel;
import com.assignmenttwo.retrofitservices.ApiClient;
import com.assignmenttwo.retrofitservices.ApiInterface;
import com.assignmenttwo.utility.RetrofitCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by prashant.mudgal on 11/2/2017.
 */

public class ApiPresenter implements GetResultListener {

    private final Context context;
    private final GetSpinnerData spinnerListener;

    public ApiPresenter(Context context, GetSpinnerData spinnerListener) {
        this.context = context;
        this.spinnerListener = spinnerListener;
    }

    public void callSampleService() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<ApiResponseModel>> call = apiService.getCountriesCall();
        call.enqueue(new RetrofitCallback<List<ApiResponseModel>>(this, context));
    }


    @Override
    public void getResult(Object result) {
        if (result != null && result instanceof Response) {

            Response res = (Response) result;
            List<ApiResponseModel> countries = (List<ApiResponseModel>) res.body();
            spinnerListener.getSpinnerData(countries);
        }
    }
}
