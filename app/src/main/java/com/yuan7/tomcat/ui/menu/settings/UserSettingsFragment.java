package com.yuan7.tomcat.ui.menu.settings;


import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseFragment;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.interfaces.TitleBarListener;
import com.yuan7.tomcat.utils.IconUtil;
import com.yuan7.tomcat.widget.roundImageView.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserSettingsFragment extends BaseFragment {

    @BindView(R.id.fl_item_icon)
    FrameLayout itemIcon;
    @BindView(R.id.fl_item_name)
    FrameLayout itemName;
    @BindView(R.id.fl_item_sex)
    FrameLayout itemSex;
    @BindView(R.id.fl_item_birthday)
    FrameLayout itemBirthday;
    @BindView(R.id.fl_item_level)
    FrameLayout itemLevel;
    @BindView(R.id.btn_unLogin)
    Button btnUnLogin;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.riv_userIcon)
    RoundedImageView rivUserIcon;

    private int REQUEST_IMAGE_GET = 0x001;
    private int REQUEST_IMAGE_CAPTURE = 0x002;
    private String picPatch = null;
    List<LocalMedia> selectList = null;

    private AlertDialog alertIcon;
    private View vIcon;

    private AlertDialog alertName;
    private View vName;
    private EditText etName;

    private AlertDialog alertSex;
    private View vSex;
    private RadioGroup groupSex;

    private Calendar calendar;
    private DatePickerDialog alertDate;

    private TitleBarListener listener;

    public UserSettingsFragment(TitleBarListener listener) {
        this.listener = listener;
    }


    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected View bindRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_settings, container, false);
    }

    @Override
    protected void bindData() {
        listener.setTitleText(getString(R.string.menu_item_userSettings));


    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick({R.id.fl_item_icon,R.id.fl_item_name, R.id.fl_item_sex, R.id.fl_item_birthday, R.id.fl_item_level})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.fl_item_icon:
                showIconAlert();
                break;
            case R.id.fl_item_name:
                showNameAlert();
                break;
            case R.id.fl_item_sex:
                showSexAlert();
                break;
            case R.id.fl_item_birthday:
                showBirthdayAlert();
                break;
            case R.id.fl_item_level:
                break;
        }
    }

    private void showIconAlert(){
        if (alertIcon == null) {
            vIcon = LayoutInflater.from(mActivity).inflate(R.layout.layout_alert_icon, null);
            vIcon.findViewById(R.id.rl_photo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PictureSelector.create(UserSettingsFragment.this)
                            .openGallery(PictureMimeType.ofImage())
                            .maxSelectNum(1)
                            .minSelectNum(1)
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                    if (alertIcon.isShowing()) {
                        alertIcon.hide();
                    }
                }
            });
            vIcon.findViewById(R.id.rl_camera).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PictureSelector.create(UserSettingsFragment.this)
                            .openCamera(PictureMimeType.ofImage())
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                    if (alertIcon.isShowing()) {
                        alertIcon.hide();
                    }
                }
            });
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(mActivity);
            alertIcon = alertBuilder.setTitle(getString(R.string.settings_icon))
                    .setView(vIcon)
                    .create();
        }
        alertIcon.show();
    }

    private void showNameAlert(){
        if (alertName == null) {
            vName = LayoutInflater.from(mActivity).inflate(R.layout.layout_alert_name, null);
            etName = (EditText) vName.findViewById(R.id.et_name);
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(mActivity);
            alertName = alertBuilder.setTitle(getString(R.string.settings_name))
                    .setView(vName)
                    .setNegativeButton(getString(R.string.negative_str),null)
                    .setPositiveButton(getString(R.string.positive_str), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            tvName.setText(etName.getText());
                        }
                    }).create();
        }
        alertName.show();
    }


    /**
     * 用户选择性别
     */
    private void showSexAlert() {
        if(vSex == null && groupSex == null && alertSex == null) {
            vSex = LayoutInflater.from(mActivity).inflate(R.layout.layout_alert_sex, null);
            groupSex = (RadioGroup) vSex.findViewById(R.id.sex_group);
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(mActivity);
            alertSex = alertBuilder.setTitle(getString(R.string.settings_sex))
                    .setView(vSex)
                    .setNegativeButton(getString(R.string.negative_str),null)
                    .setPositiveButton(getString(R.string.positive_str), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (groupSex.getCheckedRadioButtonId() == R.id.rb_boy) {
                                tvSex.setText(getString(R.string.settings_sex_boy));
                            }else{
                                tvSex.setText(getString(R.string.settings_sex_girl));
                            }
                        }
                    })
                    .create();
        }
        alertSex.show();
    }


    /**
     * 选择用户生日 alert
     */
    private void showBirthdayAlert() {
        if (calendar == null && alertDate == null) {
            calendar = Calendar.getInstance();
            alertDate = new DatePickerDialog(mActivity, android.app.AlertDialog.THEME_DEVICE_DEFAULT_LIGHT, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    tvBirthday.setText(year+","+month+","+dayOfMonth);
                }
            },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
        }
        alertDate.show();
    }


    /**
     * 图片选择回调逻辑
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    break;
            }
            Bitmap bitmap = IconUtil.getSmallBitmap(selectList.get(0).getPath(), 200, 200);
            rivUserIcon.setImageBitmap(bitmap);
            rivUserIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }else{
            Toast.makeText(mActivity, "失败", Toast.LENGTH_SHORT).show();
        }

    }
}
