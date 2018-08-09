package com.jzk.commonwms.view.rxbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzk.commonwms.R;
import com.jzk.httplibrary.rxbus.EventMsg;
import com.jzk.httplibrary.rxbus.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RxBusActivity extends AppCompatActivity {

    @BindView(R.id.btn_rxbus_regist)
    Button btnRxbusRegist;
    @BindView(R.id.btn_rxbus_unregist)
    Button btnRxbusUnregist;
    @BindView(R.id.tv_rxbus_content)
    TextView tvRxbusContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus);
        ButterKnife.bind(this);
    }

    Disposable disposable;

    @OnClick({R.id.btn_rxbus_regist, R.id.btn_rxbus_unregist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_rxbus_regist:
                disposable = RxBus.getInstance().toObservable(EventMsg.class,
                        AndroidSchedulers.mainThread(),
                        AndroidSchedulers.mainThread(),
                        new Consumer<EventMsg>() {
                            @Override
                            public void accept(EventMsg eventMsg) throws Exception {
                                tvRxbusContent.setText(String.valueOf(eventMsg.getData()));
                            }
                        });
                startActivity(new Intent(this, RxBus2Activity.class));
                break;
            case R.id.btn_rxbus_unregist:
                RxBus.getInstance().unregister(disposable);
                break;
            default:
                break;
        }
    }
}
