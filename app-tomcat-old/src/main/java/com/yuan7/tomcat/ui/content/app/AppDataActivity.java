package com.yuan7.tomcat.ui.content.app;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.yuan.library.dmanager.download.DownloadManager;
import com.yuan.library.dmanager.download.DownloadTask;
import com.yuan.library.dmanager.download.DownloadTaskListener;
import com.yuan.library.dmanager.download.TaskEntity;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.module.ServiceModule;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.bean.ResultBean;
import com.yuan7.tomcat.bean.impl.DetailBean;
import com.yuan7.tomcat.bean.impl.HotAdBean;
import com.yuan7.tomcat.ui.content.app.adapter.DataHotAdapter;
import com.yuan7.tomcat.ui.content.app.adapter.DataImageAdapter;
import com.yuan7.tomcat.ui.content.app.inject.AppDataModule;
import com.yuan7.tomcat.ui.content.app.inject.DaggerAppDataComponent;
import com.yuan7.tomcat.utils.GlideImageLoader;
import com.yuan7.tomcat.utils.Helper;
import com.yuan7.tomcat.widget.DownloadProgressButton;
import com.yuan7.tomcat.widget.ImageViewDialog;

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

    private PackageReceiver receiver;

    private ImageViewDialog imageViewDialog;


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

        hotAdapter = new DataHotAdapter(new ArrayList<ResultBean>());
        hotAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        rvApps.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvApps.setAdapter(hotAdapter);
        rvApps.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Helper.startContentActivity(mContext, ((DataHotAdapter) adapter).getData().get(position));
            }
        });

        imageAdapter = new DataImageAdapter(new ArrayList<String>());
        imageAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        rvImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvImages.setAdapter(imageAdapter);
        rvImages.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (adapter.getData() != null) {
                    ArrayList<String> images = (ArrayList<String>) adapter.getData();
                    if (images.size() > 0) {
                        if (imageViewDialog != null) {
                            imageViewDialog.show();
                        } else {
                            imageViewDialog = new ImageViewDialog(mContext, images, position);
                            imageViewDialog.show();
                        }
                    }
                }
            }
        });

        mPresenter.bindDetailData(getIntent().getStringExtra("id"));
        mPresenter.bindHotData();

        receiver = new PackageReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addDataScheme("package");
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        mPresenter.onDestroy();
        mPresenter = null;
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
        String score = bean.getResult().getAppScore() == null ? "0.0" : bean.getResult().getAppScore();
        tvAppScore.setText(getResources().getString(R.string.str_score) + score);
        tvAppSize.setText(Helper.getPrintSize(bean.getResult().getSize()));
        tvDownloadCount.setText(getResources().getString(R.string.str_download) + "\t" + bean.getResult().getDownloadTimes());
        wvAppContent.loadDataWithBaseURL(null,
                String.valueOf(bean.getResult().getContent()), "text/html", "utf-8", null);
        imageAdapter.getData().addAll(bean.getResult().getAppImgs());
        imageAdapter.notifyDataSetChanged();

        if (bean.getResult().getDlUrl() != null) {
            apkUrl = ServiceModule.BASE_URL + bean.getResult().getDlUrl();
            btnDownloadInit();
        }

    }

    @Override
    public void bindHotData(HotAdBean bean) {
        hotAdapter.getData().addAll(bean.getResult());
        hotAdapter.notifyDataSetChanged();
    }

    @Override
    public void bindDataEvent(int failCode, String message) {
        Toast.makeText(this, "code:" + failCode + "; message:" + message, Toast.LENGTH_SHORT).show();
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
                btnDownload.setCurrentText(getResources().getString(R.string.str_download));
                break;
            case 1:
                btnDownload.setState(DownloadProgressButton.STATE_FINISH);
                btnDownload.setCurrentText(getResources().getString(R.string.downStr_open));
                break;
            case 2:
                btnDownload.setState(DownloadProgressButton.STATE_FINISH);
                btnDownload.setCurrentText(getResources().getString(R.string.downStr_install));
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
                    int code = 0;
                    if (btnDownload.getCurrentText().equals(getResources().getString(R.string.downStr_install))) {
                        code = 0;
                    } else if (btnDownload.getCurrentText().equals(getResources().getString(R.string.downStr_open))) {
                        code = 1;
                    }
                    switch (code) {
                        case 0:
                            Log.i(TAG, taskEntity.getFilePath() + taskEntity.getFileName());
                            Helper.openInstallApp(mContext, taskEntity.getFilePath() + "/" + taskEntity.getFileName());
                            break;
                        case 1:
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
                btnDownload.setCurrentText(getResources().getString(R.string.downStr_waiting));
            }

            @Override
            public void onConnecting(DownloadTask downloadTask) {
                btnDownload.setState(DownloadProgressButton.STATE_PAUSE);
                btnDownload.setCurrentText(getResources().getString(R.string.downStr_loading));
            }

            @Override
            public void onStart(DownloadTask downloadTask) {
                btnDownload.setState(DownloadProgressButton.STATE_DOWNLOADING);
                btnDownload.setProgressText(getResources().getString(R.string.downStr_downloading) + ":", Integer.parseInt(Helper.getPercent(taskEntity.getCompletedSize(), taskEntity.getTotalSize())));
            }

            @Override
            public void onPause(DownloadTask downloadTask) {
                btnDownload.setState(DownloadProgressButton.STATE_PAUSE);
                btnDownload.setCurrentText(getResources().getString(R.string.downStr_continue));
            }

            @Override
            public void onCancel(DownloadTask downloadTask) {
                Log.e(TAG, "onCancel------" + downloadTask.getTaskEntity().getFilePath() + downloadTask.getTaskEntity().getFileName());
                btnDownload.setState(DownloadProgressButton.STATE_NORMAL);
                btnDownload.setCurrentText(getResources().getString(R.string.str_download));
            }

            @Override
            public void onFinish(DownloadTask downloadTask) {
                btnDownload.setState(DownloadProgressButton.STATE_FINISH);
                btnDownload.setCurrentText(getResources().getString(R.string.downStr_install));
                Log.e(TAG, downloadTask.getTaskEntity().getFilePath() + "/" + downloadTask.getTaskEntity().getFileName());
            }

            @Override
            public void onError(DownloadTask downloadTask, int codeError) {
                btnDownload.setState(DownloadProgressButton.STATE_PAUSE);
                btnDownload.setCurrentText(getResources().getString(R.string.downStr_retry));
                switch (codeError) {
                    case TASK_STATUS_REQUEST_ERROR:
                        Toast.makeText(AppDataActivity.this, getResources().getString(R.string.downStr_requestError), Toast.LENGTH_SHORT).show();
                        break;
                    case TASK_STATUS_STORAGE_ERROR:
                        Toast.makeText(AppDataActivity.this, getResources().getString(R.string.downStr_saveFileError), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public class PackageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)) {
                String packageName = intent.getData().getSchemeSpecificPart();
                if (packageName.equals(apkPackage)) {
                    btnDownload.setState(DownloadProgressButton.STATE_FINISH);
                    btnDownload.setCurrentText(getResources().getString(R.string.downStr_open));
                }
            }
        }
    }

}
