package com.example.dotfitness;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;


public class LoadingDialog {
    Activity activity;
    AlertDialog dialog;

    public LoadingDialog(Activity activity) {
        this.activity = activity;
    }

    void startDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog_layout,null));
        builder.setCancelable(true);
        dialog = builder.create();
        dialog.show();
    }

    void  stopDialog(){
        dialog.dismiss();
    }
}
