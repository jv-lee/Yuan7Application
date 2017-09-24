package com.yuan7.tomcat.server;

import com.yuan7.tomcat.bean.ResultEntity;
import com.yuan7.tomcat.bean.impl.BannerEntity;
import com.yuan7.tomcat.bean.impl.ContentEntity;
import com.yuan7.tomcat.bean.impl.FileResponseEntity;
import com.yuan7.tomcat.bean.impl.FriendEntity;
import com.yuan7.tomcat.bean.impl.MessageEntity;
import com.yuan7.tomcat.bean.impl.PostEntity;
import com.yuan7.tomcat.bean.impl.ProdouctEntity;
import com.yuan7.tomcat.bean.impl.ReplyEntity;
import com.yuan7.tomcat.bean.impl.SettingsUserEntity;
import com.yuan7.tomcat.bean.impl.StartEntity;
import com.yuan7.tomcat.bean.impl.UserEntity;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by Administrator on 2017/5/17.
 */

public interface ApiServer {

    @FormUrlEncoded
    @POST("login")
    Observable<Response<UserEntity>> doPostLogin(
            @Field("type") int type
            , @Field("username") String username
            , @Field("password") String password
            , @Field("imei") String imei
            , @Field("rememberMe") boolean remember);

    @FormUrlEncoded
    @POST("appUser/autoRegister")
    Observable<Response<UserEntity>> doPostFlyLogin(
            @Field("imei") String imei
            , @Field("appId") int appId);

    @FormUrlEncoded
    @POST("appUser/register")
    Observable<Response<UserEntity>> doPostRegister(
            @Field("userName") String username
            , @Field("password") String password
            , @Field("imei") String imei
            , @Field("appId") int appId);

    /**
     * 获取轮播图
     *
     * @param appId
     * @return
     */
    @FormUrlEncoded
    @POST("hotNews/getBannerList")
    Observable<BannerEntity<ContentEntity>> doPostBanner(@Field("appid") int appId);


    /**
     * 获取首页 hot新闻列表
     *
     * @param page       当前查询页
     * @param pageNumber 当前查询总条数
     * @param appId      当前appId
     * @return
     */
    @FormUrlEncoded
    @POST("hotNews/getHotList")
    Observable<ResultEntity<ContentEntity>> doPostHotList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("appid") int appId);


    /**
     * 获取视频新闻列表
     *
     * @param page       当前查询页
     * @param pageNumber 当前总页数
     * @param type       查询类型
     * @param appId      查询app
     * @return
     */
    @FormUrlEncoded
    @POST("videoNews/getVideoList")
    Observable<ResultEntity<ContentEntity>> doPostVideoList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("type") int type, @Field("appid") int appId);

    /**
     * 获取普通新闻列表
     *
     * @param page       当前查询页
     * @param pageNumber 当前总页数
     * @param type       查询类型
     * @param appId      查询app
     * @return
     */
    @FormUrlEncoded
    @POST("normalNews/getNormalList")
    Observable<ResultEntity<ContentEntity>> doPostNewsList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("type") int type, @Field("appid") int appId);


    /**
     * 获取社区列表
     *
     * @param page       当前查询页
     * @param pageNumber 当前总页数
     * @param type       查询类型
     * @param appId      查询app
     * @return
     */
    @FormUrlEncoded
    @POST("community/getCommunityList")
    Observable<ResultEntity<ContentEntity>> doPostCommunityList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("type") int type, @Field("appid") int appId);


    /**
     * 获取社区列表
     *
     * @param page       当前查询页
     * @param pageNumber 当前总页数
     * @param type       查询类型
     * @param appId      查询app
     * @return
     */
    @FormUrlEncoded
    @POST("QA/getQAList")
    Observable<ResultEntity<ContentEntity>> doPostAQList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("type") int type, @Field("appid") int appId);


    /**
     * 获取好友列表数据
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @FormUrlEncoded
    @POST("friends/getFriendList")
    Observable<ResultEntity<FriendEntity>> doPostFriend(@Field("order") int order, @Field("page") int page, @Field("pageNumber") int pageNumber);

    /**
     * 获取我的发帖列表
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @FormUrlEncoded
    @POST("appUser/getMyNewsList")
    Observable<ResultEntity<PostEntity>> doPostSend(@Field("page") int page, @Field("pageNumber") int pageNumber);

    /**
     * 获取我的回帖列表
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @FormUrlEncoded
    @POST("appUser/getMyReplies")
    Observable<ResultEntity<ReplyEntity>> doPostReply(@Field("page") int page, @Field("pageNumber") int pageNumber);

    /**
     * 获取指定用户 发帖列表
     *
     * @param page
     * @param pageNumber
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("appUser/getUserNewsList")
    Observable<ResultEntity<PostEntity>> doPostUserSend(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("userId") int userId);

    /**
     * 获取指定用户 回帖列表
     *
     * @param page
     * @param pageNumber
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("appUser/getUserReplies")
    Observable<ResultEntity<ReplyEntity>> doPostUserReply(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("userId") int userId);


    /**
     * 获取当前消息列表
     *
     * @param type
     * @param page
     * @param pageNumber
     * @return
     */
    @FormUrlEncoded
    @POST("appUser/getAppUserMsg")
    Observable<ResultEntity<MessageEntity>> doPostMessage(@Field("msgType") int type, @Field("page") int page, @Field("pageNumber") int pageNumber);

    /**
     * 更改用户信息 接口
     *
     * @param paramsMap
     * @return
     */
    @FormUrlEncoded
    @POST("appUser/updateUser")
    Observable<SettingsUserEntity> doPostUpdateUser(@FieldMap Map<String, Object> paramsMap);

    /**
     * 更改头像接口
     *
     * @param file
     * @return
     */
    @Multipart
    @POST("appUser/uploadFile")
    Observable<FileResponseEntity> doPostUploadFile(@Part MultipartBody.Part file);

    /**
     * 上传视频文件接口
     *
     * @param paramsMap
     * @param file
     * @return
     */
    @Multipart
    @POST("appUser/addMyNews")
    Observable<String> doPostAddVideo(@PartMap Map<String, Object> paramsMap, @Part MultipartBody.Part file);


    /**
     * 上传多文件接口
     *
     * @param paramsMap
     * @param files
     * @return
     */
    @Multipart
    @POST("appUser/addMyNews")
    Observable<String> doPostAddPicture(@PartMap Map<String, Object> paramsMap, @PartMap Map<String, RequestBody> files);

    /**
     * 积分商城兑换
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @FormUrlEncoded
    @POST("commodity/pagelist")
    Observable<ResultEntity<ProdouctEntity>> doPostProdouct(@Field("page") int page, @Field("pageNumber") int pageNumber);

    /**
     * 启动页
     *
     * @param appId
     * @return
     */
    @FormUrlEncoded
    @POST("appConfig/select")
    Observable<StartEntity> doPostStartApp(@Field("appId") int appId);

}
