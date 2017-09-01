package com.yuan7.tomcat.ui.send;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SendActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.spinner_type)
    Spinner spinnerType;
    @BindView(R.id.spinner_gold)
    Spinner spinnerGold;
    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.fl_picture1)
    FrameLayout flPicture1;
    @BindView(R.id.fl_picture2)
    FrameLayout flPicture2;
    @BindView(R.id.fl_picture3)
    FrameLayout flPicture3;

    private ArrayAdapter<String> typeAdapter;
    private ArrayAdapter<String> goldAdapter;

    @Override
    protected int bindRootView() {
        return R.layout.activity_send;
    }

    @Override
    protected void bindData() {
        typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner_type));
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(typeAdapter);

        goldAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner_gold));
        goldAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGold.setAdapter(goldAdapter);

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    spinnerGold.setVisibility(View.VISIBLE);
                } else if (position == 0) {
                    spinnerGold.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @OnClick({R.id.iv_left,R.id.tv_right,R.id.btn_send,R.id.fl_picture1,R.id.fl_picture2,R.id.fl_picture3})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_right:
                break;
            case R.id.btn_send:
                Toast.makeText(mContext, "send", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_picture1:
                Toast.makeText(mContext, "picture1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_picture2:
                Toast.makeText(mContext, "picture2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_picture3:
                Toast.makeText(mContext, "picture3", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
