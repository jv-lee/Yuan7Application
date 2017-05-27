package com.yuan7.tomcat.service;

import com.yuan7.tomcat.bean.impl.BannerBean;
import com.yuan7.tomcat.bean.impl.DetailBean;
import com.yuan7.tomcat.bean.impl.HotAdBean;
import com.yuan7.tomcat.bean.impl.IsOpenBean;
import com.yuan7.tomcat.bean.impl.NewsBean;
import com.yuan7.tomcat.bean.impl.ProPagateBean;
import com.yuan7.tomcat.bean.impl.RaidersBean;
import com.yuan7.tomcat.bean.impl.RecommendBean;
import com.yuan7.tomcat.bean.impl.VideoBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/5/17.
 */

public interface ApiService {

    /**
     * 获取轮播图
     *
     * @return
     */
    @POST("catServer/banner.action")
    Observable<BannerBean> doGetBanner();

    /**
     * 获取宣传图
     *
     * @return
     */
    @POST("catServer/propagate.action")
    Observable<ProPagateBean> doGetProPatate();

    /**
     * 获取新闻内容
     *
     * @param pageNo
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/news.action")
    Observable<NewsBean> doGetNews(@Field("pageNo") int pageNo);

    /**
     * 获取视频
     *
     * @param pageNo
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/vedio.action")
    Observable<VideoBean> doGetVideo(@Field("pageNo") int pageNo);

    /**
     * 获取攻略
     *
     * @param pageNo
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/guide.action")
    Observable<RaidersBean> doGetRaiders(@Field("pageNo") int pageNo);

    /**
     * 获取推荐
     *
     * @param pageNo
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/recommend.action")
    Observable<RecommendBean> doGetRecommend(@Field("pageNo") int pageNo);

    /**
     * 详情页面
     *
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/recommend!detail.action")
    Observable<DetailBean> doGetDetail(@Field("id") String id);


    /**
     * 获取热门推荐
     *
     * @return
     */
    @POST("catServer/recommend!hot.action")
    Observable<HotAdBean> doGetHot();

    /**
     * 是否开启
     *
     * @return
     */
    @POST("catServer/recommend!status.action")
    Observable<IsOpenBean> isOpen();

    /**
     * 下载文件  小文件
     *
     * @param fileUrl
     * @return
     */
    @GET
    Call<ResponseBody> downloadFileWithDynamicUrlSync(@Url String fileUrl);

}
