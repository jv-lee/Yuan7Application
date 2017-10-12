package com.yuan7.tomcat.ui.content;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yuan7.tomcat.R;
import com.yuan7.tomcat.entity.impl.ActiviEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */

public class AcActivity extends Activity {
    private ImageView ivOne, ivTwo, ivThree, ivFour, ivFive, ivSix, ivSeven, ivClick, ivClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac);

        List<ActiviEntity> activiEntities = initData();

        initView();

        for (int i = 0; i < activiEntities.size(); i++) {
            ActiviEntity entity = activiEntities.get(i);
            switch (i) {
                case 0: {
                    if (entity.getThisStatus() == 1) {
                        ivOne.setImageResource(R.mipmap.ic_one_no);
                    } else if (entity.getThisStatus() == 2) {
                        ivOne.setImageResource(R.mipmap.ic_one_ok);
                    } else if (entity.getThisStatus() == 3) {
                        ivOne.setImageResource(R.mipmap.ic_one);
                    }
                }
                break;
                case 1: {
                    if (entity.getThisStatus() == 1) {
                        ivTwo.setImageResource(R.mipmap.ic_two_no);
                    } else if (entity.getThisStatus() == 2) {
                        ivTwo.setImageResource(R.mipmap.ic_two_ok);
                    } else if (entity.getThisStatus() == 3) {
                        ivTwo.setImageResource(R.mipmap.ic_two);
                    }
                }
                break;
                case 2:
                    if (entity.getThisStatus() == 1) {
                        ivThree.setImageResource(R.mipmap.ic_three_no);
                    } else if (entity.getThisStatus() == 2) {
                        ivThree.setImageResource(R.mipmap.ic_three_ok);
                    } else if (entity.getThisStatus() == 3) {
                        ivThree.setImageResource(R.mipmap.ic_three);
                    }
                    break;
                case 3:
                    if (entity.getThisStatus() == 1) {
                        ivFour.setImageResource(R.mipmap.ic_four_no);
                    } else if (entity.getThisStatus() == 2) {
                        ivFour.setImageResource(R.mipmap.ic_four_ok);
                    } else if (entity.getThisStatus() == 3) {
                        ivFour.setImageResource(R.mipmap.ic_four);
                    }
                    break;
                case 4:
                    if (entity.getThisStatus() == 1) {
                        ivFive.setImageResource(R.mipmap.ic_five_no);
                    } else if (entity.getThisStatus() == 2) {
                        ivFive.setImageResource(R.mipmap.ic_five_ok);
                    } else if (entity.getThisStatus() == 3) {
                        ivFive.setImageResource(R.mipmap.ic_five);
                    }
                    break;
                case 5:
                    if (entity.getThisStatus() == 1) {
                        ivSix.setImageResource(R.mipmap.ic_six_no);
                    } else if (entity.getThisStatus() == 2) {
                        ivSix.setImageResource(R.mipmap.ic_six_ok);
                    } else if (entity.getThisStatus() == 3) {
                        ivSix.setImageResource(R.mipmap.ic_six);
                    }
                    break;
                case 6:
                    if (entity.getThisStatus() == 1) {
                        ivSeven.setImageResource(R.mipmap.ic_seven_no);
                    } else if (entity.getThisStatus() == 2) {
                        ivSeven.setImageResource(R.mipmap.ic_seven_ok);
                    } else if (entity.getThisStatus() == 3) {
                        ivSeven.setImageResource(R.mipmap.ic_seven);
                    }
                    break;
            }
        }

        ivFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    return;
                }
                flag = true;
                Toast.makeText(AcActivity.this, "领取成功", Toast.LENGTH_SHORT).show();
                ivFive.setImageResource(R.mipmap.ic_five_ok);
                ivClick.setImageResource(R.mipmap.ic_sign_ok_btn);
            }
        });

        ivClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    return;
                }
                flag = true;
                Toast.makeText(AcActivity.this, "领取成功", Toast.LENGTH_SHORT).show();
                ivFive.setImageResource(R.mipmap.ic_five_ok);
                ivClick.setImageResource(R.mipmap.ic_sign_ok_btn);
            }
        });

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
            }
        });

    }

    private boolean flag = false;

    private void initView() {
        ivOne = (ImageView) findViewById(R.id.iv_one);
        ivTwo = (ImageView) findViewById(R.id.iv_two);
        ivThree = (ImageView) findViewById(R.id.iv_three);
        ivFour = (ImageView) findViewById(R.id.iv_four);
        ivFive = (ImageView) findViewById(R.id.iv_five);
        ivSix = (ImageView) findViewById(R.id.iv_six);
        ivSeven = (ImageView) findViewById(R.id.iv_seven);
        ivClick = (ImageView) findViewById(R.id.iv_click);
        ivClose = (ImageView) findViewById(R.id.iv_close);
    }

    private void setIvStatus(ImageView iv, ActiviEntity entity) {

    }

    private List<ActiviEntity> initData() {
        List<ActiviEntity> entities = new ArrayList<>();
        entities.add(new ActiviEntity(1, 1, false));
        entities.add(new ActiviEntity(2, 2, false));
        entities.add(new ActiviEntity(3, 1, false));
        entities.add(new ActiviEntity(4, 1, false));
        entities.add(new ActiviEntity(5, 3, true));
        entities.add(new ActiviEntity(6, 3, false));
        entities.add(new ActiviEntity(7, 3, false));
        return entities;
    }
}
