package com.yuan7.tomcat.ui.main.info.video;


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
import com.yuan7.tomcat.constant.Constant;


import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseFragment {

    @BindView(R.id.video_container)
    FrameLayout videoContainer;
    @BindView(R.id.video_new_container)
    FrameLayout newContainer;
    @BindView(R.id.video_good_container)
    FrameLayout goodContainer;
    @BindView(R.id.video_hot_container)
    FrameLayout hotContainer;
    @BindView(R.id.rg_tab)
    RadioGroup rgTab;
    @BindView(R.id.rb_new)
    RadioButton rbNew;
    @BindView(R.id.rb_good)
    RadioButton rbGood;
    @BindView(R.id.rb_hot)
    RadioButton rbHot;

    private VideoContentFragment newFragment, goodFragment, hotFragment;
    private Bundle bundle;
    private boolean newReplaceFlag, goodReplaceFlag, hotReplaceFlag = false;

    private String[] selectTabs = null;

    public VideoFragment() {
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    protected void bindData() {
        selectTabs = new String[]{getString(R.string.select_tab_new), getString(R.string.select_tab_good), getString(R.string.select_tab_hot)};

        String content = getArguments().getString(Constant.FRAGMENT_CONTENT);
        newFragment = setFragmentArgs(Constant.FRAGMENT_TYPE_NEW);
        goodFragment = setFragmentArgs(Constant.FRAGMENT_TYPE_GOOD);
        hotFragment = setFragmentArgs(Constant.FRAGMENT_TYPE_HOT);

        rbNew.setText(selectTabs[0]);
        rbGood.setText(selectTabs[1]);
        rbHot.setText(selectTabs[2]);

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

    private VideoContentFragment setFragmentArgs(String type) {
        VideoContentFragment fragment = new VideoContentFragment();
        bundle = new Bundle();
        bundle.putString(Constant.FRAGMENT_TYPE, type);
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
                    transaction.replace(R.id.video_new_container, newFragment).commit();
                    newReplaceFlag = true;
                }
                break;
            case 2:
                newContainer.setVisibility(View.GONE);
                goodContainer.setVisibility(View.VISIBLE);
                hotContainer.setVisibility(View.GONE);
                if (!goodReplaceFlag) {
                    transaction.setCustomAnimations(R.anim.alpha_in, R.anim.alpha_out);
                    transaction.replace(R.id.video_good_container, goodFragment).commit();
                    goodReplaceFlag = true;
                }
                break;
            case 3:
                newContainer.setVisibility(View.GONE);
                goodContainer.setVisibility(View.GONE);
                hotContainer.setVisibility(View.VISIBLE);
                if (!hotReplaceFlag) {
                    transaction.setCustomAnimations(R.anim.alpha_in, R.anim.alpha_out);
                    transaction.replace(R.id.video_hot_container, hotFragment).commit();
                    hotReplaceFlag = true;
                }
                break;
        }
    }

}
