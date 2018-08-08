package com.jzk.commonwms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jzk.httplibrary.rxbus.EventMsg;
import com.jzk.httplibrary.rxbus.RxBus;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void sendMsg(View view) {
        RxBus.getInstance().post(new EventMsg<String>("更改的内容！！！！！！"));
    }
}
