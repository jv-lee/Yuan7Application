package com.yuan7.tomcat.ui.menu.code;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.UserParams;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.impl.UserEntity;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.ui.menu.code.inject.CodeModule;
import com.yuan7.tomcat.ui.menu.code.inject.DaggerCodeComponent;
import com.yuan7.tomcat.utils.SPUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CodeFragment extends BaseFragment<CodeContract.Presenter> implements CodeContract.View {

    @BindView(R.id.et_my_code)
    EditText etMyCode;
    @BindView(R.id.et_input_code)
    EditText etInputCode;
    @BindView(R.id.btn_code)
    Button btnCode;
    @BindView(R.id.tv_code_num)
    TextView tvCodeNum;


    private boolean hasCode = false;

    private TitleBarListener listener;

    public CodeFragment(TitleBarListener listener) {
        this.listener = listener;
    }


    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerCodeComponent.builder()
                .appComponent(appComponent)
                .codeModule(new CodeModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_code, container, false);
    }

    @Override
    protected void bindData() {
        listener.setTitleText("邀请码");


        String myCode = (String) SPUtil.get(UserParams.USER_INVITECODE, "");
        if (!myCode.equals("")) {
            etMyCode.setText(myCode);
        } else {
            etMyCode.setText("邀请码异常");
        }

        hasCode = (boolean) SPUtil.get(UserParams.USER_HAS_INVITECODE, false);
        if (hasCode) {
            String toCode = (String) SPUtil.get(UserParams.USER_WRITE_INVITECODE, "");
            etInputCode.setEnabled(false);
            etInputCode.setTextIsSelectable(true);
            if (!toCode.equals("")) {
                etInputCode.setText(toCode);
            } else {
                etInputCode.setText("邀请码异常");
            }

        } else {
            etInputCode.setEnabled(true);
        }

        mPresenter.bindCodeData();

    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick(R.id.btn_code)
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.btn_code:
                if (etInputCode.equals("")) {
                    Toast.makeText(mActivity, "请填写邀请码", Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.sendCodeToServer(etInputCode.getText().toString());
                }
                break;
        }
    }

    @Override
    public void sendCodeResponse(ResultBeanEntity resultBeanEntity) {
        if (resultBeanEntity.getCode() == 2000) {
            etInputCode.setEnabled(false);
            etInputCode.setTextIsSelectable(true);
            btnCode.setVisibility(View.GONE);
            SPUtil.save(UserParams.USER_HAS_INVITECODE, true);
            SPUtil.save(UserParams.USER_WRITE_INVITECODE, etInputCode.getText().toString() );
            Toast.makeText(mActivity, resultBeanEntity.getMessage(), Toast.LENGTH_SHORT).show();
        } else if (resultBeanEntity.getCode() == 4404) {
            etInputCode.setEnabled(true);
            btnCode.setVisibility(View.VISIBLE);
            Toast.makeText(mActivity, resultBeanEntity.getMessage(), Toast.LENGTH_SHORT).show();
        } else if (resultBeanEntity.getCode() == 4405) {
            etInputCode.setEnabled(true);
            btnCode.setVisibility(View.VISIBLE);
            Toast.makeText(mActivity, resultBeanEntity.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void bindCodeData(ResultBeanEntity<List<UserEntity>> resultEntity) {
        tvCodeNum.setText(resultEntity.getObj().size() + "人");
    }

    @Override
    public void bindDataEvent(int code, String message) {

    }
}
