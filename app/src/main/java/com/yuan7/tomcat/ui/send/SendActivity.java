package com.yuan7.tomcat.ui.send;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.yuan7.tomcat.AppConfig;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.constant.Constant;
import com.yuan7.tomcat.entity.PictureEntity;
import com.yuan7.tomcat.ui.send.inject.DaggerSendComponent;
import com.yuan7.tomcat.ui.send.inject.SendModule;
import com.yuan7.tomcat.utils.IconUtil;
import com.yuan7.tomcat.utils.LogUtil;
import com.yuan7.tomcat.utils.VideoPicUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class SendActivity extends BaseActivity<SendContract.Presenter> implements SendContract.View {

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
    @BindView(R.id.iv_delete1)
    ImageView ivDelete1;
    @BindView(R.id.iv_delete2)
    ImageView ivDelete2;
    @BindView(R.id.iv_delete3)
    ImageView ivDelete3;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_content)
    EditText etContent;

    private ArrayAdapter<String> typeAdapter;
    private ArrayAdapter<String> goldAdapter;

    private List<LocalMedia> selectList = null;

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
        DaggerSendComponent.builder()
                .appComponent(appComponent)
                .sendModule(new SendModule(this))
                .build()
                .inject(this);
    }

    @OnClick({R.id.iv_left, R.id.tv_right, R.id.btn_send, R.id.fl_picture1, R.id.fl_picture2, R.id.fl_picture3, R.id.iv_delete1, R.id.iv_delete2, R.id.iv_delete3})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_right:
                break;
            case R.id.btn_send:
                send();
                Toast.makeText(mContext, "send", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fl_picture1:
                if (hasImage) {
                    openPicture(PictureMimeType.ofImage(), Constant.PICTURE_CODE2);
                } else {
                    openPicture(PictureMimeType.ofAll(), Constant.PICTURE_CODE1);
                }
                break;
            case R.id.fl_picture2:
                openPicture(PictureMimeType.ofImage(), Constant.PICTURE_CODE2);
                break;
            case R.id.fl_picture3:
                openPicture(PictureMimeType.ofImage(), Constant.PICTURE_CODE3);
                break;
            case R.id.iv_delete1:
                deletePicture(1);
                break;
            case R.id.iv_delete2:
                deletePicture(2);
                break;
            case R.id.iv_delete3:
                deletePicture(3);
                break;
        }
    }

    private void send() {
        String title = etTitle.getText().toString();
        String content = etContent.getText().toString();
        int typePosition = spinnerType.getSelectedItemPosition();

        if (selectList != null && !title.equals("") && !content.equals("")) {
            Map<String, Object> map = new HashMap<>();
//            LogUtil.i("title:" + title);
//            LogUtil.i("content:" + content);
//            LogUtil.i("type:" + typePosition);
//            for (int i = 0; i < selectList.size(); i++) {
//                LogUtil.i("selectListType:" + selectList.get(i).getPictureType() + "   selectListPath:" + selectList.get(i).getPath());
//            }
            map.put("title", title);
            map.put("type", typePosition + 1);
            map.put("text", content);
            map.put("appId", AppConfig.APP_ID);

            if (selectList.size() > 1) {
                String[] filePaths = new String[selectList.size()];
                for (int i = 0; i < selectList.size(); i++) {
                    filePaths[i] = selectList.get(i).getPath();
                }
                mPresenter.sendPictureMessage(map, filePaths);
            } else {
                if (selectList.get(0).getPictureType().contains("video")) {
                    mPresenter.sendVideoMessage(map, selectList.get(0).getPath());
                } else {
                    mPresenter.sendPictureMessage(map, new String[]{selectList.get(0).getPath()});
                }

            }

        } else {
            Toast.makeText(mContext, "条件不符合", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Constant.PICTURE_CODE1:
                    setPicture(data, Constant.PICTURE_CODE1);
                    break;
                case Constant.PICTURE_CODE2:
                    setPicture(data, Constant.PICTURE_CODE2);
                    break;
                case Constant.PICTURE_CODE3:
                    setPicture(data, Constant.PICTURE_CODE3);
                    break;
            }
        } else {
            Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show();
        }
    }


    public void openPicture(int mode, int code) {
        PictureSelector.create(this)
                .openGallery(mode)
                .maxSelectNum(1)
                .minSelectNum(1)
                .forResult(code);
    }

    private ArrayList<PictureEntity> pics = new ArrayList<>();
    private boolean hasImage = false;

    public void setPicture(Intent data, int code) {
        selectList = PictureSelector.obtainMultipleResult(data);
        LocalMedia localMedia = selectList.get(0);

        if (code == Constant.PICTURE_CODE1) {
            if (localMedia.getPictureType().contains(Constant.PICTURE_TYPE_IMAGE)) {
                Bitmap bitmap = IconUtil.getSmallBitmap(localMedia.getPath(), 200, 200);
                flPicture1.setBackground(new BitmapDrawable(bitmap));
                ivDelete1.setVisibility(View.VISIBLE);
                flPicture2.setVisibility(View.VISIBLE);
                hasImage = true;

            } else if (localMedia.getPictureType().contains(Constant.PICTURE_TYPE_VIDEO)) {
                Bitmap bitmap = VideoPicUtil.getVideoThumbnail(localMedia.getPath());
                flPicture1.setBackground(new BitmapDrawable(bitmap));
                hasImage = false;
            }
            if (pics.size() == 1) {
                pics.get(0).setPath(localMedia.getPath());
            } else {
                pics.add(0, new PictureEntity(localMedia.getPath()));
            }
        } else if (code == Constant.PICTURE_CODE2) {
            Bitmap bitmap = IconUtil.getSmallBitmap(localMedia.getPath(), 200, 200);
            flPicture2.setBackground(new BitmapDrawable(bitmap));
            ivDelete2.setVisibility(View.VISIBLE);
            flPicture3.setVisibility(View.VISIBLE);
            if (pics.size() == 2) {
                pics.get(1).setPath(localMedia.getPath());
            } else {
                pics.add(1, new PictureEntity(localMedia.getPath()));
            }

        } else if (code == Constant.PICTURE_CODE3) {
            Bitmap bitmap = IconUtil.getSmallBitmap(localMedia.getPath(), 200, 200);
            flPicture3.setBackground(new BitmapDrawable(bitmap));
            ivDelete3.setVisibility(View.VISIBLE);
            if (pics.size() == 3) {
                pics.get(2).setPath(localMedia.getPath());
            } else {
                pics.add(2, new PictureEntity(localMedia.getPath()));
            }
        }
    }

    private void deletePicture(int code) {
        switch (code) {
            case 1:
                if (pics.size() == 3) {
                    pics.remove(0);
                    ivDelete3.setVisibility(View.INVISIBLE);
                    flPicture3.setBackground(getResources().getDrawable(R.mipmap.send_pic));
                    flPicture1.setBackground(new BitmapDrawable(IconUtil.getSmallBitmap(pics.get(0).getPath(), 200, 200)));
                    flPicture2.setBackground(new BitmapDrawable(IconUtil.getSmallBitmap(pics.get(1).getPath(), 200, 200)));
                } else if (pics.size() == 2) {
                    pics.remove(0);
                    ivDelete3.setVisibility(View.INVISIBLE);
                    flPicture3.setVisibility(View.INVISIBLE);
                    ivDelete2.setVisibility(View.INVISIBLE);
                    flPicture2.setBackground(getResources().getDrawable(R.mipmap.send_pic));
                    flPicture1.setBackground(new BitmapDrawable(IconUtil.getSmallBitmap(pics.get(0).getPath(), 200, 200)));
                } else if (pics.size() == 1) {
                    pics.remove(0);
                    ivDelete2.setVisibility(View.INVISIBLE);
                    flPicture2.setVisibility(View.INVISIBLE);
                    ivDelete1.setVisibility(View.INVISIBLE);
                    flPicture1.setBackground(getResources().getDrawable(R.mipmap.send_pic));
                    hasImage = false;
                }
                break;
            case 2:
                if (pics.size() == 3) {
                    pics.remove(1);
                    ivDelete3.setVisibility(View.INVISIBLE);
                    flPicture3.setBackground(getResources().getDrawable(R.mipmap.send_pic));
                    flPicture2.setBackground(new BitmapDrawable(IconUtil.getSmallBitmap(pics.get(1).getPath(), 200, 200)));
                } else if (pics.size() == 2) {
                    pics.remove(1);
                    flPicture3.setVisibility(View.INVISIBLE);
                    ivDelete2.setVisibility(View.INVISIBLE);
                    flPicture2.setBackground(getResources().getDrawable(R.mipmap.send_pic));
                }
                break;
            case 3:
                pics.remove(2);
                ivDelete3.setVisibility(View.INVISIBLE);
                flPicture3.setBackground(getResources().getDrawable(R.mipmap.send_pic));
                break;
        }
    }

    @Override
    public void bindDataEvent(int code, String message) {

    }
}
