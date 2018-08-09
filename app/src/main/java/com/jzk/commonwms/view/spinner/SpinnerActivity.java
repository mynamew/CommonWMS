package com.jzk.commonwms.view.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jzk.commonwms.R;
import com.jzk.mvplibrary.utils.ToastUtils;
import com.jzk.spinnerlibrary.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerActivity extends AppCompatActivity {

    @BindView(R.id.spinner)
    MaterialSpinner spinner;
    @BindView(R.id.tv_select_position)
    TextView tvSelectPosition;
    private List<String> mSpinnerStrs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);
        for (int i = 0; i < 20; i++) {
            mSpinnerStrs.add("spinner---->" + i);
        }
        spinner.setItems(mSpinnerStrs);
        spinner.setOnItemSelectedListener((view, position, id, item) -> {
            ToastUtils.showShort(SpinnerActivity.this, mSpinnerStrs.get(position));
            tvSelectPosition.setText(String.valueOf(spinner.getSelectedIndex()));
        });
    }
}
