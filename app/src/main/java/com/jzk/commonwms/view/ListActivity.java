package com.jzk.commonwms.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jzk.commonwms.R;
import com.jzk.commonwms.view.http.HttpActivity;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public void jumpActivity(View view) {
        switch (view.getId()) {
            case R.id.tv_http:
                startActivity(new Intent(this, HttpActivity.class));
                break;
            case R.id.tv_rxbus:
                startActivity(new Intent(this, HttpActivity.class));
                break;
            default:
                break;
        }
    }
}
