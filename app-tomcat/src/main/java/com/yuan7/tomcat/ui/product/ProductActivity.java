package com.yuan7.tomcat.ui.product;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.interfaces.ProductSelectInterface;
import com.yuan7.tomcat.ui.product.fragment.ProductFragment;
import com.yuan7.tomcat.ui.product.fragment.SuccessFragment;


public class ProductActivity extends BaseActivity implements ProductSelectInterface {

    private ProductFragment productFragment = new ProductFragment(this);
    private SuccessFragment successFragment = new SuccessFragment(this);

    @Override
    protected int bindRootView() {
        return R.layout.activity_product;
    }

    @Override
    protected void bindData() {
        setUpProduct();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void setUpProduct() {
        mFragmentManager.beginTransaction().replace(R.id.fl_container, productFragment).commit();
    }

    @Override
    public void setUpSuccess() {
        mFragmentManager.beginTransaction().replace(R.id.fl_container, successFragment).commit();
    }
}
