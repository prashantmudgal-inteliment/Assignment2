package com.assignmenttwo.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by prashant.mudgal on 05/18/2017.
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getName();

    private ProgressDialog mProgressDialog;

    public void showProgressDialog(final String message, Context context) {
        if (mProgressDialog != null) {
            return;
        }
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
        mProgressDialog.setCancelable(false);
    }

    public void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
            Log.v(TAG, "dismissing progress dialog: ");
        }
        Log.v(TAG, "progress dialog: " + mProgressDialog);
    }
}


