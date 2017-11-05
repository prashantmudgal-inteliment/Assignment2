package com.assignmenttwo.retrofitservices;


import com.assignmenttwo.models.ApiResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by prashant.mudgal on 11/2/2017.
 */
public interface ApiInterface {

    @GET("sample.json")
    Call<List<ApiResponseModel>> getCountriesCall();

}
