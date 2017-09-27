package com.yuan7.tomcat.ui.search;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yuan7.tomcat.R;
import com.yuan7.tomcat.adapter.SearchAdapter;
import com.yuan7.tomcat.base.app.AppComponent;
import com.yuan7.tomcat.base.mvp.BaseActivity;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.SearchEntity;
import com.yuan7.tomcat.helper.AHelper;
import com.yuan7.tomcat.ui.content.ContentActivity;
import com.yuan7.tomcat.ui.search.inject.DaggerSearchComponent;
import com.yuan7.tomcat.ui.search.inject.SearchModule;
import com.yuan7.tomcat.utils.IntentUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity<SearchContract.Presenter> implements SearchContract.View {

    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;
    @BindView(R.id.pb_load_data)
    ProgressBar progressBar;

    private SearchAdapter dataAdapter;
    private int page = 1;
    private String title = "";

    @Override
    protected int bindRootView() {
        return R.layout.activity_search;
    }

    @Override
    protected void bindData() {
        progressBar.setVisibility(View.GONE);

        dataAdapter = new SearchAdapter(new ArrayList<SearchEntity>());
        dataAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        dataAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.layout_empty_search, null));
        dataAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.bindSearchData(title, page);
            }
        });
        dataAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SearchEntity entity = ((SearchAdapter) adapter).getData().get(position);
                IntentUtil.setParamsIntoActivity(mContext, ContentActivity.class, IntentUtil.getParamsMap(entity));
            }
        });

        rvContainer.setLayoutManager(new LinearLayoutManager(this));
        rvContainer.setAdapter(dataAdapter);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerSearchComponent.builder()
                .appComponent(appComponent)
                .searchModule(new SearchModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void bindSearchData(int pageNo, ResultDataEntity<SearchEntity> resultEntity) {
        if (pageNo == 1 && resultEntity.getObj().getRows().size() == 0) {
            progressBar.setVisibility(View.GONE);
            return;
        }
        if (pageNo > resultEntity.getObj().getCountPage()) {
            dataAdapter.loadMoreEnd();
            return;
        }
        if (pageNo == 1) {
            progressBar.setVisibility(View.GONE);
        }
        dataAdapter.getData().addAll(resultEntity.getObj().getRows());
        dataAdapter.notifyDataSetChanged();
        page++;
        dataAdapter.loadMoreComplete();
    }

    @Override
    public void bindDataEvent(int code, String message) {

    }

    @OnClick({R.id.iv_left, R.id.iv_right})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
            case R.id.iv_right:
                AHelper.toEvent(this,"T_1004");
                page = 1;
                title = etSearch.getText().toString();
                if (!title.equals("")) {
                    dataAdapter.getData().clear();
                    dataAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.VISIBLE);
                    mPresenter.bindSearchData(title, page);
                } else {
                    Toast.makeText(mContext, "请输入搜索内容", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
