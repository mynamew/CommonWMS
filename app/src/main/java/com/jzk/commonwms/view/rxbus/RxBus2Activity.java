package com.jzk.commonwms.view.rxbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jzk.commonwms.R;
import com.jzk.httplibrary.rxbus.EventMsg;
import com.jzk.httplibrary.rxbus.RxBus;

/**
  * 发送事件
  * @author   jzk
  * create at: 2018/8/7 17:46
  */  
public class RxBus2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus2);
    }
    public void sendMsg(View view) {
        RxBus.getInstance().post(new EventMsg<String>("更改的内容！！！！！！"));
    }
}
