package com.yuan7.tomcat.ui.post.friend;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.UiPagerAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.impl.FriendEntity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.ui.post.friend.inject.DaggerFriendComponent;
import com.yuan7.tomcat.ui.post.friend.inject.FriendModule;
import com.yuan7.tomcat.ui.post.reply.ReplyFragment;
import com.yuan7.tomcat.ui.post.post.PostFragment;
import com.yuan7.tomcat.helper.GlideImageLoader;
import com.yuan7.tomcat.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.OnClick;


public class FriendActivity extends BaseActivity<FriendContract.Presenter> implements FriendContract.View {

    @BindView(R.id.rg_appbar_toolbar_tab)
    RadioGroup tabTitle;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_userIcon)
    ImageView ivUserIcon;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.tv_levelNum)
    TextView tvUserLevel;
    @BindView(R.id.tv_levelName)
    TextView tvUserLevelName;
    @BindView(R.id.vp_container)
    NoScrollViewPager vpContainer;

    @BindView(R.id.tv_friendNum)
    TextView tvFriendNum;
    @BindView(R.id.tv_postNum)
    TextView tvPostNum;
    @BindView(R.id.tv_replyNum)
    TextView tvReplyNum;

    private Fragment[] fragments = null;
    private String[] titles = null;

    private int id = 0;
    private boolean friendFlag = false;


    @Override
    protected int bindRootView() {
        return R.layout.activity_friend_post;
    }

    @Override
    protected void bindData() {
        fragments = new Fragment[]{new PostFragment(), new ReplyFragment()};
        titles = new String[]{getString(R.string.post_send), getString(R.string.post_reply)};

        tvTitle.setText("");
        ivRight.setVisibility(View.VISIBLE);
        id = getIntent().getIntExtra(Constant.FRIEND_USER_ID, 0);

        for (int i = 0; i < 2; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.FRAGMENT_CONTENT, titles[i]);
            bundle.putInt(Constant.FRAGMENT_ID, id);
            fragments[i].setArguments(bundle);
        }

        vpContainer.setAdapter(new UiPagerAdapter(mFragmentManager, fragments, titles));
        vpContainer.setOffscreenPageLimit(fragments.length - 1);

        vpContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_post)).setChecked(true);
                        break;
                    case 1:
                        ((RadioButton) tabTitle.findViewById(R.id.rb_reply)).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabTitle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_post:
                        vpContainer.setCurrentItem(0);
                        break;
                    case R.id.rb_reply:
                        vpContainer.setCurrentItem(1);
                        break;
                }
            }
        });

        mPresenter.bindFriendData(id);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFriendComponent.builder()
                .appComponent(appComponent)
                .friendModule(new FriendModule(this))
                .build()
                .inject(this);
    }

    @OnClick({R.id.iv_left, R.id.iv_right})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.iv_right:
                if (friendFlag) {
                    Toast.makeText(mContext, "已经是你的好友了噢 ~", Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.addFriend(id);
                }
                break;
        }
    }


    @Override
    public void bindFriendData(ResultBeanEntity<FriendEntity> resultEntity) {
        FriendEntity friendEntity = resultEntity.getObj();
        GlideImageLoader.loadCircleCropBg(friendEntity.getImage(), ivUserIcon);
        friendFlag = friendEntity.isFriendFlag();
        tvUserName.setText(friendEntity.getName());
        tvUserLevel.setText("LV" + friendEntity.getLevel());
        tvUserLevelName.setText(friendEntity.getLevelname());
        tvFriendNum.setText("关注 " + friendEntity.getFriendCount());
        tvPostNum.setText("发帖 " + friendEntity.getNewsNum());
        tvReplyNum.setText("回帖 " + friendEntity.getGoodNum());
    }

    @Override
    public void addFriendSuccess(String message) {
        friendFlag = true;
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addFriendError(String message) {
        friendFlag = false;
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
