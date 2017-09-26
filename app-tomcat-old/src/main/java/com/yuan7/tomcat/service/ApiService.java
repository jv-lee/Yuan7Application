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
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/5/17.
 */

public interface ApiService {

    /**
     * 获取轮播图
     *
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/banner.action")
    Observable<BannerBean> doGetBanner(@Field("appId") String appId);

    /**
     * 获取宣传图
     *
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/propagate.action")
    Observable<ProPagateBean> doGetProPatate(@Field("appId") String appId);

    /**
     * 获取新闻内容
     *
     * @param pageNo
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/news.action")
    Observable<NewsBean> doGetNews(@Field("pageNo") int pageNo, @Field("appId") String appId);

    /**
     * 获取视频
     *
     * @param pageNo
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/vedio.action")
    Observable<VideoBean> doGetVideo(@Field("pageNo") int pageNo, @Field("appId") String appId);

    /**
     * 获取攻略
     *
     * @param pageNo
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/guide.action")
    Observable<RaidersBean> doGetRaiders(@Field("pageNo") int pageNo, @Field("appId") String appId);

    /**
     * 获取推荐
     *
     * @param pageNo
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/recommend.action")
    Observable<RecommendBean> doGetRecommend(@Field("pageNo") int pageNo, @Field("appId") String appId);

    /**
     * 详情页面
     *
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/recommend!detail.action")
    Observable<DetailBean> doGetDetail(@Field("id") String id, @Field("appId") String appId);


    /**
     * 获取热门推荐
     *
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/recommend!hot.action")
    Observable<HotAdBean> doGetHot(@Field("appId") String appId);

    /**
     * 是否开启
     *
     * @return
     */
    @FormUrlEncoded
    @POST("catServer/recommend!status.action")
    Observable<IsOpenBean> isOpen(@Field("appId") String appId);

}
