package com.assignmenttwo.adapter;

/**
 * Created by prashant.mudgal on 11/2/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.assignmenttwo.R;
import com.assignmenttwo.models.ApiResponseModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/* Adapter class for setting response model to spinner */
public class CustomSpinnerAdapter extends ArrayAdapter<ApiResponseModel> {

    private List<ApiResponseModel> countries = null;
    private Context activity;

    public CustomSpinnerAdapter(Context context, int textViewResourceId,
                                List<ApiResponseModel> countries) {
        super(context, textViewResourceId, countries);
        activity = context;
        this.countries = countries;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // Set view for each row
    public View getCustomView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        View rowview = convertView;

        if (rowview==null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = inflater.inflate(R.layout.spinner_rows, null, false);
            holder = new ViewHolder(rowview);
            rowview.setTag(holder);
        }else{
            holder = (ViewHolder) rowview.getTag();
        }

        // Get model values for each row from arraylist
        ApiResponseModel tempValues = countries.get(position);

        // Set value from model to textview
        holder.txtName.setText(tempValues.getName());
        return rowview;
    }

    //View holder to hold all the views
    class ViewHolder {
        //bind textview
        @BindView(R.id.tv_spinner_item)
        TextView txtName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}