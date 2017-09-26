package com.yuan7.tomcat.ui.product;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smarttop.library.bean.City;
import com.smarttop.library.bean.County;
import com.smarttop.library.bean.Province;
import com.smarttop.library.bean.Street;
import com.smarttop.library.widget.AddressSelector;
import com.smarttop.library.widget.BottomDialog;
import com.smarttop.library.widget.OnAddressSelectedListener;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.helper.AHelper;
import com.yuan7.tomcat.rx.EventBase;
import com.yuan7.tomcat.rx.RxBus;
import com.yuan7.tomcat.rx.entity.AddressEntity;
import com.yuan7.tomcat.ui.main.MainActivity;
import com.yuan7.tomcat.utils.SPUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class AddressActivity extends BaseActivity {

    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.ll_item_province)
    LinearLayout itemProvince;
    @BindView(R.id.ll_item_city)
    LinearLayout itemCity;
    @BindView(R.id.ll_item_county)
    LinearLayout itemCounty;
    @BindView(R.id.ll_item_street)
    LinearLayout itemStreet;

    @BindView(R.id.tv_province)
    TextView tvProvince;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_county)
    TextView tvCounty;
    @BindView(R.id.tv_street)
    TextView tvStreet;

    @BindView(R.id.et_linkman)
    EditText etLinkman;
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.et_address_des)
    EditText etAddressDes;

    @Override
    protected int bindRootView() {
        return R.layout.activity_address;
    }

    @Override
    protected void bindData() {
        tvTitle.setText("添加地址");
        ivRight.setImageDrawable(getDrawable(R.drawable.selector_appbar_save));
        ivRight.setVisibility(View.VISIBLE);


        initData();

        initSelectDialog();
    }

    private void initData() {
        etLinkman.setText((String) SPUtil.get(Constant.ADDRESS_LINKMAN, ""));
        etPhoneNumber.setText((String) SPUtil.get(Constant.ADDRESS_PHONE_NUMBER, ""));
        etAddressDes.setText((String) SPUtil.get(Constant.ADDRESS_DES, ""));
        tvProvince.setText((String) SPUtil.get(Constant.ADDRESS_PROVINCE, ""));
        tvCity.setText((String) SPUtil.get(Constant.ADDRESS_CITY, ""));
        tvCounty.setText((String) SPUtil.get(Constant.ADDRESS_COUNTY, ""));
        tvStreet.setText((String) SPUtil.get(Constant.ADDRESS_STREET, ""));
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }


    @OnClick({R.id.ll_item_province, R.id.ll_item_city, R.id.ll_item_county, R.id.ll_item_street, R.id.iv_left, R.id.iv_right})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.iv_right:
                AHelper.toEvent(this,"T_1010");
                saveAddressData();
                break;
            case R.id.ll_item_province:
                dialog.show();
                break;
            case R.id.ll_item_city:
                dialog.show();
                break;
            case R.id.ll_item_county:
                dialog.show();
                break;
            case R.id.ll_item_street:
                dialog.show();
                break;
        }
    }

    private void saveAddressData() {
        if (etLinkman.getText().toString().equals("")
                || etPhoneNumber.getText().toString().equals("")
                || etAddressDes.getText().toString().equals("")
                || tvProvince.getText().toString().equals("")
                || tvCity.getText().toString().equals("")
                || tvCounty.getText().toString().equals("")) {
            SPUtil.save(Constant.ADDRESS_FLAG, false);
            Toast.makeText(mContext, "无法保存，请填写完整信息", Toast.LENGTH_SHORT).show();
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(etLinkman.getText().toString() + "\t")
                    .append(etPhoneNumber.getText().toString() + "\n")
                    .append(tvProvince.getText().toString() + "\t")
                    .append(tvCity.getText().toString() + "\t")
                    .append(tvCounty.getText().toString() + "\t")
                    .append(tvStreet.getText().toString() + "\n")
                    .append(etAddressDes.getText().toString());

            SPUtil.save(Constant.ADDRESS, builder.toString());

            SPUtil.save(Constant.ADDRESS_LINKMAN, etLinkman.getText().toString());
            SPUtil.save(Constant.ADDRESS_PHONE_NUMBER, etPhoneNumber.getText().toString());
            SPUtil.save(Constant.ADDRESS_DES, etAddressDes.getText().toString());
            SPUtil.save(Constant.ADDRESS_PROVINCE, tvProvince.getText().toString());
            SPUtil.save(Constant.ADDRESS_CITY, tvCity.getText().toString());
            SPUtil.save(Constant.ADDRESS_COUNTY, tvCounty.getText().toString());
            SPUtil.save(Constant.ADDRESS_STREET, tvStreet.getText().toString());
            SPUtil.save(Constant.ADDRESS_FLAG, true);

            RxBus.getInstance().post(new EventBase(Constant.RX_BUS_PRODUCT_ADDRESS, builder.toString()));

            finish();
        }
    }

    BottomDialog dialog = null;

    public void initSelectDialog() {
        if (dialog == null) {
            dialog = new BottomDialog(this);
            dialog.setOnAddressSelectedListener(new OnAddressSelectedListener() {
                @Override
                public void onAddressSelected(Province province, City city, County county, Street street) {
                    tvProvince.setText(province == null ? "" : province.name);
                    tvCity.setText(city == null ? "" : city.name);
                    tvCounty.setText(county == null ? "" : county.name);
                    tvStreet.setText(street == null ? "" : street.name);
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            });
            dialog.setDialogDismisListener(new AddressSelector.OnDialogCloseListener() {
                @Override
                public void dialogclose() {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            });
        }
    }

}
