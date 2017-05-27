package com.yuan7.tomcat.ui.content.app;


import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lcodecore.tkrefreshlayout.utils.LogUtil;
import com.yuan.library.dmanager.download.DownloadManager;
import com.yuan.library.dmanager.download.DownloadTask;
import com.yuan.library.dmanager.download.DownloadTaskListener;
import com.yuan.library.dmanager.download.TaskEntity;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.bean.impl.DetailBean;
import com.yuan7.tomcat.bean.impl.HotAdBean;
import com.yuan7.tomcat.ui.content.app.adapter.DataHotAdapter;
import com.yuan7.tomcat.ui.content.app.adapter.DataImageAdapter;
import com.yuan7.tomcat.ui.content.app.inject.AppDataModule;
import com.yuan7.tomcat.ui.content.app.inject.DaggerAppDataComponent;
import com.yuan7.tomcat.utils.GlideImageLoader;
import com.yuan7.tomcat.utils.Helper;
import com.yuan7.tomcat.widget.DownloadProgressButton;

import java.util.ArrayList;

import butterknife.BindView;

import static com.yuan.library.dmanager.download.TaskStatus.TASK_STATUS_CANCEL;
import static com.yuan.library.dmanager.download.TaskStatus.TASK_STATUS_CONNECTING;
import static com.yuan.library.dmanager.download.TaskStatus.TASK_STATUS_DOWNLOADING;
import static com.yuan.library.dmanager.download.TaskStatus.TASK_STATUS_FINISH;
import static com.yuan.library.dmanager.download.TaskStatus.TASK_STATUS_INIT;
import static com.yuan.library.dmanager.download.TaskStatus.TASK_STATUS_PAUSE;
import static com.yuan.library.dmanager.download.TaskStatus.TASK_STATUS_QUEUE;
import static com.yuan.library.dmanager.download.TaskStatus.TASK_STATUS_REQUEST_ERROR;
import static com.yuan.library.dmanager.download.TaskStatus.TASK_STATUS_STORAGE_ERROR;

public class AppDataActivity extends BaseActivity<AppDataContract.Presenter> implements AppDataContract.View {

    @BindView(R.id.toolbar)
    LinearLayout toolbar;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_app_icon)
    ImageView ivAppIcon;
    @BindView(R.id.tv_app_title)
    TextView tvAppTitle;
    @BindView(R.id.tv_app_score)
    TextView tvAppScore;
    @BindView(R.id.tv_app_size)
    TextView tvAppSize;
    @BindView(R.id.tv_download_count)
    TextView tvDownloadCount;
    @BindView(R.id.rv_images)
    RecyclerView rvImages;
    @BindView(R.id.rv_apps)
    RecyclerView rvApps;
    @BindView(R.id.wv_app_content)
    WebView wvAppContent;
    @BindView(R.id.btn_download)
    DownloadProgressButton btnDownload;

    private DataHotAdapter hotAdapter;
    private DataImageAdapter imageAdapter;

    private String apkPath, apkUrl, apkPackage;

    // 下载管理器
    private DownloadManager mDownloadManager;

    @Override
    protected int bindRootView() {
        return R.layout.activity_app_data;
    }

    @Override
    protected void bindData() {
        mDownloadManager = DownloadManager.getInstance();
        apkPackage = getIntent().getStringExtra("apkPackage");

        tvTitle.setText(getResources().getString(R.string.str_details));
        ivLeft.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
        ivLeft.setVisibility(View.VISIBLE);
        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDownload.setShowBorder(false);

        wvAppContent.getSettings().setJavaScriptEnabled(true);
        wvAppContent.setWebChromeClient(new WebChromeClient());
        wvAppContent.setWebViewClient(new WebViewClient());
        wvAppContent.setBackgroundColor(0);
        wvAppContent.setBackgroundColor(getResources().getColor(R.color.backgroundContainerColor));

        hotAdapter = new DataHotAdapter(new ArrayList<HotAdBean.ResultBean>());
        hotAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        rvApps.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvApps.setAdapter(hotAdapter);
        rvApps.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });

        imageAdapter = new DataImageAdapter(new ArrayList<String>());
        imageAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        rvImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvImages.setAdapter(imageAdapter);
        rvImages.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });

        mPresenter.bindDetailData(getIntent().getStringExtra("id"));
        mPresenter.bindHotData();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerAppDataComponent.builder()
                .appComponent(appComponent)
                .appDataModule(new AppDataModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void bindDetailData(DetailBean bean) {
        if (bean == null) return;
        GlideImageLoader.loadImage(this, ServiceModule.BASE_URL + bean.getResult().getImgUrl(), ivAppIcon);
        tvAppTitle.setText(bean.getResult().getTitle());
        tvAppScore.setText(getResources().getString(R.string.str_score) + bean.getResult().getAppScore());
        tvAppSize.setText(Helper.getPrintSize(bean.getResult().getSize()));
        tvDownloadCount.setText(getResources().getString(R.string.str_download) + "\t" + bean.getResult().getDownloadTimes());
        wvAppContent.loadDataWithBaseURL(null,
                String.valueOf(bean.getResult().getContent()), "text/html", "utf-8", null);

        imageAdapter.getData().addAll(bean.getResult().getAppImgs());

        if (bean.getResult().getDlUrl() != null) {
            apkUrl = ServiceModule.BASE_URL + bean.getResult().getDlUrl();
            btnDownloadInit();
        }

    }

    /**
     * 初始化下载按钮
     */
    private void btnDownloadInit() {
        apkPath = Helper.readApk(mContext, apkPackage);
        int code = 0;
        if (apkPath != null) {
            code = Helper.readAppPathCode(mContext, apkPackage);
        }
        switch (code) {
            case 0:
                btnDownload.setState(DownloadProgressButton.STATE_NORMAL);
                btnDownload.setCurrentText("下载");
                break;
            case 1:
                btnDownload.setState(DownloadProgressButton.STATE_FINISH);
                btnDownload.setCurrentText("打开");
                break;
            case 2:
                btnDownload.setState(DownloadProgressButton.STATE_FINISH);
                btnDownload.setCurrentText("安装");
                break;
        }
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTheButton();
            }
        });
    }

    private void showTheButton() {

        String taskId = String.valueOf(apkUrl.hashCode());
        DownloadTask itemTask = mDownloadManager.getTask(taskId);

        if (itemTask == null) {
            itemTask = new DownloadTask(new TaskEntity.Builder().url(apkUrl).build());
            responseUIListener(itemTask);
            mDownloadManager.addTask(itemTask);
        } else {
            responseUIListener(itemTask);
            TaskEntity taskEntity = itemTask.getTaskEntity();
            int status = taskEntity.getTaskStatus();
            Log.e(TAG, "------------------------------" + status);
            switch (status) {
                case TASK_STATUS_QUEUE:
                    mDownloadManager.pauseTask(itemTask);
                    break;
                case TASK_STATUS_INIT:
                    mDownloadManager.addTask(itemTask);
                    break;
                case TASK_STATUS_CONNECTING:
                    mDownloadManager.pauseTask(itemTask);
                    break;
                case TASK_STATUS_DOWNLOADING:
                    mDownloadManager.pauseTask(itemTask);
                    break;
                case TASK_STATUS_CANCEL:
                    mDownloadManager.addTask(itemTask);
                    break;
                case TASK_STATUS_PAUSE:
                    mDownloadManager.resumeTask(itemTask);
                    break;
                case TASK_STATUS_FINISH:
                    switch (btnDownload.getCurrentText()) {
                        case "安装":
                            Log.i(TAG, taskEntity.getFilePath() + taskEntity.getFileName());
                            Helper.openInstallApp(mContext, taskEntity.getFilePath() + "/" + taskEntity.getFileName());
                            break;
                        case "打开":
                            Helper.openApp(mContext, apkPackage);
                            break;
                    }
                    break;
                case TASK_STATUS_REQUEST_ERROR:
                    mDownloadManager.addTask(itemTask);
                    break;
                case TASK_STATUS_STORAGE_ERROR:
                    mDownloadManager.addTask(itemTask);
                    break;
            }
        }

    }

    private void responseUIListener(@android.support.annotation.NonNull final DownloadTask itemTask) {
        final TaskEntity taskEntity = itemTask.getTaskEntity();
        itemTask.setListener(new DownloadTaskListener() {
            @Override
            public void onQueue(DownloadTask downloadTask) {
                btnDownload.setState(DownloadProgressButton.STATE_PAUSE);
                btnDownload.setCurrentText("等待中");
            }

            @Override
            public void onConnecting(DownloadTask downloadTask) {
                btnDownload.setState(DownloadProgressButton.STATE_PAUSE);
                btnDownload.setCurrentText("链接中");
            }

            @Override
            public void onStart(DownloadTask downloadTask) {
                btnDownload.setState(DownloadProgressButton.STATE_DOWNLOADING);
                btnDownload.setProgressText("下载中:", Integer.parseInt(Helper.getPercent(taskEntity.getCompletedSize(), taskEntity.getTotalSize())));
            }

            @Override
            public void onPause(DownloadTask downloadTask) {
                btnDownload.setState(DownloadProgressButton.STATE_PAUSE);
                btnDownload.setCurrentText("继续");
            }

            @Override
            public void onCancel(DownloadTask downloadTask) {
                Log.e(TAG, "onCancel------" + downloadTask.getTaskEntity().getFilePath() + downloadTask.getTaskEntity().getFileName());
                btnDownload.setState(DownloadProgressButton.STATE_NORMAL);
                btnDownload.setCurrentText("下载");
            }

            @Override
            public void onFinish(DownloadTask downloadTask) {
                btnDownload.setState(DownloadProgressButton.STATE_FINISH);
                btnDownload.setCurrentText("安装");
                Log.e(TAG, downloadTask.getTaskEntity().getFilePath() + "/" + downloadTask.getTaskEntity().getFileName());
            }

            @Override
            public void onError(DownloadTask downloadTask, int codeError) {
                btnDownload.setState(DownloadProgressButton.STATE_PAUSE);
                btnDownload.setCurrentText("重试");
                switch (codeError) {
                    case TASK_STATUS_REQUEST_ERROR:
                        Toast.makeText(AppDataActivity.this, "请求异常", Toast.LENGTH_SHORT).show();
                        break;
                    case TASK_STATUS_STORAGE_ERROR:
                        Toast.makeText(AppDataActivity.this, "存储异常", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

//    /**
//     * 下载按钮点击事件
//     */
//    private void showTheButtonRx() {
//        if (btnDownload.getState() == DownloadProgressButton.STATE_NORMAL || btnDownload.getState() == DownloadProgressButton.STATE_PAUSE) {
//            btnDownload.setState(DownloadProgressButton.STATE_PAUSE);
//            btnDownload.setCurrentText("连接中");
//            downloadRx();
//        } else if (btnDownload.getState() == DownloadProgressButton.STATE_DOWNLOADING) {
//            stopDownloadRx();
//        } else if (btnDownload.getState() == DownloadProgressButton.STATE_FINISH) {
//            switch (btnDownload.getCurrentText()) {
//                case "安装":
//                    Helper.openInstallApp(mContext, apkPath);
//                    break;
//                case "打开":
//                    Helper.openApp(mContext, apkPath);
//                    break;
//            }
//        }
//    }


//    /**
//     * 建立下载任务
//     */
//    private void downloadRx() {
//        disposable = RxDownload.getInstance(this)
//                .defaultSavePath(Environment.getExternalStorageDirectory().getPath() + "/.y7application")
//                .download(apkUrl)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<DownloadStatus>() {
//                    @Override
//                    public void accept(@NonNull DownloadStatus downloadStatus) throws Exception {
//                        btnDownload.setState(DownloadProgressButton.STATE_DOWNLOADING);
//                        btnDownload.setProgress(downloadStatus.getPercentNumber());
//                        btnDownload.setProgressText("下载中:", downloadStatus.getPercentNumber());
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(@NonNull Throwable throwable) throws Exception {
//                        btnDownload.setCurrentText("连接失败");
//                        btnDownload.setState(DownloadProgressButton.STATE_PAUSE);
//                        Toast.makeText(mContext, "下载失败", Toast.LENGTH_SHORT).show();
//                    }
//                }, new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        btnDownload.setState(DownloadProgressButton.STATE_FINISH);
//                        btnDownload.setCurrentText("安装");
//                        Toast.makeText(mContext, "下载成功", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }

    @Override
    public void bindHotData(HotAdBean bean) {
        hotAdapter.getData().addAll(bean.getResult());
    }

    @Override
    public void bindDataEvent(int failCode, String message) {
        Toast.makeText(this, "code:" + failCode + "; message:" + message, Toast.LENGTH_SHORT).show();
    }

}
