package com.yuan7.tomcat.ui.main.commu.aq;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AQFragment extends BaseFragment {

    @BindView(R.id.aq_container)
    FrameLayout aqContainer;
    @BindView(R.id.aq_good_container)
    FrameLayout goodContainer;
    @BindView(R.id.aq_hot_container)
    FrameLayout hotContainer;
    @BindView(R.id.aq_new_container)
    FrameLayout newContainer;
    @BindView(R.id.rg_tab)
    RadioGroup rgTab;
    @BindView(R.id.rb_new)
    RadioButton rbNew;
    @BindView(R.id.rb_hot)
    RadioButton rbHot;
    @BindView(R.id.rb_good)
    RadioButton rbGood;

    private AQContentFragment hotFragment, goodFragment, newFragment;
    private Bundle bundle;
    private boolean newReplaceFlag, goodReplaceFlag, hotReplaceFlag = false;

    public AQFragment() {

    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_aq, container, false);
    }

    @Override
    protected void bindData() {
        String content = getArguments().getString("content");
        newFragment = setFragmentArgs("new");
        goodFragment = setFragmentArgs("good");
        hotFragment = setFragmentArgs("hot");

        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == rbNew.getId()) {
                    selectFragment(1);
                } else if (checkedId == rbGood.getId()) {
                    selectFragment(2);
                } else if (checkedId == rbHot.getId()) {
                    selectFragment(3);
                }
            }
        });
    }

    @Override
    protected void lazyLoad() {
        selectFragment(1);
    }

    public AQContentFragment setFragmentArgs(String type) {
        AQContentFragment fragment = new AQContentFragment();
        bundle = new Bundle();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void selectFragment(int mode) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (mode) {
            case 1:
                newContainer.setVisibility(View.VISIBLE);
                goodContainer.setVisibility(View.GONE);
                hotContainer.setVisibility(View.GONE);
                if (!newReplaceFlag) {
                    transaction.setCustomAnimations(R.anim.alpha_in, R.anim.alpha_out);
                    transaction.replace(R.id.aq_new_container, newFragment).commit();
                    newReplaceFlag = true;
                }
                break;
            case 2:
                newContainer.setVisibility(View.GONE);
                goodContainer.setVisibility(View.VISIBLE);
                hotContainer.setVisibility(View.GONE);
                if (!goodReplaceFlag) {
                    transaction.setCustomAnimations(R.anim.alpha_in, R.anim.alpha_out);
                    transaction.replace(R.id.aq_good_container, goodFragment).commit();
                    goodReplaceFlag = true;
                }
                break;
            case 3:
                transaction.setCustomAnimations(R.anim.alpha_in, R.anim.alpha_out);
                newContainer.setVisibility(View.GONE);
                goodContainer.setVisibility(View.GONE);
                hotContainer.setVisibility(View.VISIBLE);
                if (!hotReplaceFlag) {
                    transaction.replace(R.id.aq_hot_container, hotFragment).commit();
                    hotReplaceFlag = true;
                }
                break;
        }
    }

}
