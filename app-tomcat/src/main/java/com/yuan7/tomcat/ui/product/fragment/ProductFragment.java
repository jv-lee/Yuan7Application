package com.yuan7.tomcat.ui.product.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.interfaces.ProductSelectInterface;
import com.yuan7.tomcat.rx.EventBase;
import com.yuan7.tomcat.rx.RxBus;
import com.yuan7.tomcat.ui.product.AddressActivity;
import com.yuan7.tomcat.ui.product.ProductContract;
import com.yuan7.tomcat.ui.product.inject.DaggerProductComponent;
import com.yuan7.tomcat.ui.product.inject.ProductModule;
import com.yuan7.tomcat.utils.AStringUtil;
import com.yuan7.tomcat.utils.SPUtil;
import com.yuan7.tomcat.utils.StatusBarUtil;
import com.yuan7.tomcat.widget.AmountView;
import com.yuan7.tomcat.widget.banner.MZBannerView;
import com.yuan7.tomcat.widget.banner.holder.ContentBannerViewHolder;
import com.yuan7.tomcat.widget.banner.holder.MZHolderCreator;
import com.yuan7.tomcat.widget.banner.holder.MZViewHolder;
import com.yuan7.tomcat.widget.banner.holder.StringBannerViewHolder;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends BaseFragment<ProductContract.Presenter> implements ProductContract.View {

    @BindView(R.id.product_container)
    LinearLayout productContainer;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_get_product)
    Button btnGet;
    @BindView(R.id.tv_product_message)
    TextView tvProductMessage;
    @BindView(R.id.tv_product_price)
    TextView tvProductPrice;
    @BindView(R.id.tv_product_count)
    TextView tvProductCount;
    @BindView(R.id.tv_product_num)
    TextView tvProductNum;
    @BindView(R.id.pb_product_size)
    ProgressBar pbProductSize;
    @BindView(R.id.bv_product_pic)
    MZBannerView<String> bvProduct;

    private View view;
    private PopupWindow popupWindow;
    private FrameLayout flAddress;
    private ImageView ivAddressEdit;
    private ImageView ivClose;
    private Button btnAddress;
    private Button btnExchange;
    private AmountView amountView;
    private TextView tvAddressContent;
    private TextView tvMoneyNum;
    private TextView tvGetMoney;


    private int productId, productCount, productNum, productPrice, userGlob = 0;
    private String content, url;
    private boolean addressFlag = false;

    private Observable observable;
    private ProductSelectInterface productSelectInterface;

    public ProductFragment(ProductSelectInterface productSelectInterface) {
        this.productSelectInterface = productSelectInterface;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerProductComponent.builder()
                .appComponent(appComponent)
                .productModule(new ProductModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product, container, false);
    }


    @SuppressLint("StringFormatMatches")
    @Override
    protected void bindData() {
        tvTitle.setText("我的礼品");
        userGlob = (int) SPUtil.get(UserParams.USER_GLOB, 0);
        addressFlag = (boolean) SPUtil.get(Constant.ADDRESS_FLAG, false);
        productCount = mActivity.getIntent().getIntExtra(Constant.PRODUCT_COUNT, 0);
        productId = mActivity.getIntent().getIntExtra(Constant.PRODUCT_ID, 0);
        productNum = mActivity.getIntent().getIntExtra(Constant.PRODUCT_NUM, 0);
        productPrice = mActivity.getIntent().getIntExtra(Constant.PRODUCT_PRICE, 0);
        content = mActivity.getIntent().getStringExtra(Constant.PRODUCT_TEXT_CONTENT);
        url = mActivity.getIntent().getStringExtra(Constant.PRODUCT_PIC_URL);
        String urls = mActivity.getIntent().getStringExtra(Constant.PRODUCT_PIC_URLS);


        List<String> list = Arrays.asList(urls.split(","));
        bvProduct.setPages(list, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new StringBannerViewHolder();
            }
        });


//        GlideImageLoader.loadImage(url, ivPic);

        pbProductSize.setMax(productCount);
        pbProductSize.setProgress(productNum);
        tvProductMessage.setText(content);
        tvProductPrice.setText(AStringUtil.format(mActivity, R.string.str_price, productPrice));
        tvProductCount.setText(AStringUtil.format(mActivity, R.string.str_count, productCount));
        tvProductNum.setText(AStringUtil.format(mActivity, R.string.str_num, productNum));

        initPopupWindow();

        observable = RxBus.getInstance().register(this);
        observable.subscribe(new Consumer<EventBase>() {
            @Override
            public void accept(@NonNull EventBase eventBase) throws Exception {
                if ((int) eventBase.getOption() == Constant.RX_BUS_PRODUCT_ADDRESS) {
                    if (tvAddressContent != null) {
                        tvAddressContent.setText((String) eventBase.getObj());
                        addressFlag = true;
                        flAddress.setVisibility(View.VISIBLE);
                        btnAddress.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    @SuppressLint("StringFormatMatches")
    @Override
    protected void lazyLoad() {

    }

    @OnClick({R.id.btn_get_product, R.id.iv_left})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.btn_get_product:
                popupWindow.showAtLocation(productContainer, Gravity.BOTTOM, 0, 0);
                StatusBarUtil.backgroundAlpha(mActivity, 0.5f);
                break;
            case R.id.iv_left:
                mActivity.finish();
                break;
        }
    }

    @SuppressLint("StringFormatMatches")
    private void initPopupWindow() {
        view = LayoutInflater.from(mActivity).inflate(R.layout.layout_product_edit_popoup, null);
        btnAddress = ButterKnife.findById(view, R.id.btn_address_add);
        amountView = ButterKnife.findById(view, R.id.av_edit_count);
        tvMoneyNum = ButterKnife.findById(view, R.id.tv_money_num);
        tvGetMoney = ButterKnife.findById(view, R.id.tv_get_money);
        flAddress = ButterKnife.findById(view, R.id.fl_address);
        tvAddressContent = ButterKnife.findById(view, R.id.tv_address_content);
        ivAddressEdit = ButterKnife.findById(view, R.id.iv_address_edit);
        ivClose = ButterKnife.findById(view, R.id.iv_close);
        btnExchange = ButterKnife.findById(view, R.id.btn_exchange);

        if (addressFlag) {
            flAddress.setVisibility(View.VISIBLE);
            btnAddress.setVisibility(View.GONE);
            tvAddressContent.setText((String) SPUtil.get(Constant.ADDRESS, ""));

        } else {
            flAddress.setVisibility(View.GONE);
            btnAddress.setVisibility(View.VISIBLE);
        }

        tvMoneyNum.setText(AStringUtil.format(mActivity, R.string.str_this_money, userGlob));

        if (userGlob >= (amountView.getAmount() * productPrice)) {
            tvGetMoney.setText(AStringUtil.format(mActivity, R.string.str_put_money, (amountView.getAmount() * productPrice)));
        } else {
            tvGetMoney.setText(AStringUtil.format(mActivity, R.string.str_not_money));
        }


        amountView.setGoods_storage(productCount);
        amountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                if (userGlob >= (amount * productPrice)) {
                    tvGetMoney.setText(AStringUtil.format(mActivity, R.string.str_put_money, productPrice * amount));
                } else {
                    tvGetMoney.setText(AStringUtil.format(mActivity, R.string.str_not_money));
                }
            }
        });

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        ivAddressEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, AddressActivity.class));
            }
        });
        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, AddressActivity.class));
            }
        });
        btnExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addressFlag != true) {
                    Toast.makeText(mActivity, "地址信息未完善", Toast.LENGTH_SHORT).show();
                    return;
                } else if (userGlob <= (productPrice * amountView.getAmount())) {
                    Toast.makeText(mActivity, "金币不足", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    globCount = amountView.getAmount() * productPrice;
                    mPresenter.shopToPost(productId, amountView.getAmount(), tvAddressContent.getText().toString());
                    return;
                }
            }
        });

        int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(spec, spec);
        int height = view.getMeasuredHeight();

        popupWindow = new PopupWindow(view, Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT);
        popupWindow.setAnimationStyle(android.R.style.Animation_Toast);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F8F8F8")));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                StatusBarUtil.backgroundAlpha(mActivity, 1.0f);
            }
        });
    }

    int globCount = 0;

    @Override
    public void shopResponse(int code, String message) {
        if (code == 2000) {
            SPUtil.save(UserParams.USER_GLOB, userGlob - globCount);
            popupWindow.dismiss();
            productSelectInterface.setUpSuccess();
        } else {
            Toast.makeText(mActivity, "code:" + code + "\tmessage:" + message, Toast.LENGTH_SHORT).show();
        }
    }
}
