package com.assignmenttwo.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.assignmenttwo.R;
import com.assignmenttwo.adapter.CustomSpinnerAdapter;
import com.assignmenttwo.interfaces.GetSpinnerData;
import com.assignmenttwo.models.ApiResponseModel;
import com.assignmenttwo.presenter.ApiPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements GetSpinnerData {

    @BindView(R.id.spinner_countries)
    Spinner spinnerCountries;
    private List<ApiResponseModel> countries;

    @BindView(R.id.btn_next)
    Button btnNext;

    @BindView(R.id.tv_train_value)
    TextView trainValue;

    @BindView(R.id.tv_car_value)
    TextView carValue;
    private ApiResponseModel selectedSpinnerModel = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ApiPresenter apiPresenter = new ApiPresenter(this, this);
        showProgressDialog(getResources().getString(R.string.loading), MainActivity.this);
        apiPresenter.callSampleService();
        setSpinnerEventListener();
    }

    private void setSpinnerEventListener() {
        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectedSpinnerModel = countries.get(position);
                trainValue.setText(String.format(getString(R.string.trains),selectedSpinnerModel.getFromcentral().getTrain()));
                carValue.setText(String.format(getString(R.string.cars),selectedSpinnerModel.getFromcentral().getCar()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initializeSpinner(List<ApiResponseModel> countries) {
        this.countries = countries;
        CustomSpinnerAdapter adapter =
                new CustomSpinnerAdapter(MainActivity.this,
                        android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountries.setAdapter(adapter);
    }

    @Override
    public void getSpinnerData(List<ApiResponseModel> countries) {
        dismissProgressDialog();
        initializeSpinner(countries);
    }

    @OnClick(R.id.btn_next)
    public void onNextClick() {
        launchMapsIntent();
    }

    private void launchMapsIntent() {
        StringBuilder builder = new StringBuilder("http://maps.google.com/maps?q=loc:");
        builder.append(selectedSpinnerModel.getLocation().getLatitude());
        builder.append(",");
        builder.append(selectedSpinnerModel.getLocation().getLongitude());
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(builder.toString()));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }
}
