package com.yuan7.tomcat.server;

import com.yuan7.tomcat.entity.ResultBeanEntity;
import com.yuan7.tomcat.entity.ResultBeansEntity;
import com.yuan7.tomcat.entity.ResultDataEntity;
import com.yuan7.tomcat.entity.impl.BannerEntity;
import com.yuan7.tomcat.entity.impl.ContentEntity;
import com.yuan7.tomcat.entity.impl.FileResponseEntity;
import com.yuan7.tomcat.entity.impl.FriendEntity;
import com.yuan7.tomcat.entity.impl.MessageEntity;
import com.yuan7.tomcat.entity.impl.PostEntity;
import com.yuan7.tomcat.entity.impl.ProductEntity;
import com.yuan7.tomcat.entity.impl.ProductOrderEntity;
import com.yuan7.tomcat.entity.impl.ReplyEntity;
import com.yuan7.tomcat.entity.impl.SearchEntity;
import com.yuan7.tomcat.entity.impl.SettingsUserEntity;
import com.yuan7.tomcat.entity.impl.StartEntity;
import com.yuan7.tomcat.entity.impl.UserEntity;
import com.yuan7.tomcat.entity.impl.UserMessage;

import java.util.List;
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
    Observable<ResultDataEntity<ContentEntity>> doPostHotList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("appid") int appId);


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
    Observable<ResultDataEntity<ContentEntity>> doPostVideoList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("type") int type, @Field("appid") int appId);

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
    Observable<ResultDataEntity<ContentEntity>> doPostNewsList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("type") int type, @Field("appid") int appId);


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
    Observable<ResultDataEntity<ContentEntity>> doPostCommunityList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("type") int type, @Field("appid") int appId);


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
    Observable<ResultDataEntity<ContentEntity>> doPostAQList(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("type") int type, @Field("appid") int appId);


    /**
     * 获取好友列表数据
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @FormUrlEncoded
    @POST("friends/getFriendList")
    Observable<ResultDataEntity<FriendEntity>> doPostFriend(@Field("order") int order, @Field("page") int page, @Field("pageNumber") int pageNumber);

    /**
     * 获取我的发帖列表
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @FormUrlEncoded
    @POST("appUser/getMyNewsList")
    Observable<ResultDataEntity<PostEntity>> doPostSend(@Field("page") int page, @Field("pageNumber") int pageNumber);

    /**
     * 获取我的回帖列表
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @FormUrlEncoded
    @POST("appUser/getMyReplies")
    Observable<ResultDataEntity<ReplyEntity>> doPostReply(@Field("page") int page, @Field("pageNumber") int pageNumber);

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
    Observable<ResultDataEntity<PostEntity>> doPostUserSend(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("userId") int userId);

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
    Observable<ResultDataEntity<ReplyEntity>> doPostUserReply(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("userId") int userId);


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
    Observable<ResultDataEntity<MessageEntity>> doPostMessage(@Field("msgType") int type, @Field("page") int page, @Field("pageNumber") int pageNumber);

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
    @POST("appUser/updateUserImage")
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
    Observable<ResultBeanEntity> doPostAddVideo(@PartMap Map<String, Object> paramsMap, @Part MultipartBody.Part file);


    /**
     * 上传多文件接口
     *
     * @param paramsMap
     * @param files
     * @return
     */
    @Multipart
    @POST("appUser/addMyNews")
    Observable<ResultBeanEntity> doPostAddPicture(@PartMap Map<String, Object> paramsMap, @PartMap Map<String, RequestBody> files);

    /**
     * 积分商城兑换
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @FormUrlEncoded
    @POST("commodity/pagelist")
    Observable<ResultDataEntity<ProductEntity>> doPostProduct(@Field("page") int page, @Field("pageNumber") int pageNumber);

    @POST("commodity/banner")
    Observable<ResultBeansEntity<ProductEntity>> doPostProductBanner();


    /**
     * 启动页
     *
     * @param appId
     * @return
     */
    @FormUrlEncoded
    @POST("appConfig/select")
    Observable<StartEntity> doPostStartApp(@Field("appId") int appId);


    @FormUrlEncoded
    @POST("order/addOrder")
    Observable<ResultDataEntity> doPostAddOrder(@Field("id") int id, @Field("count") int count, @Field("address") String address);


    @FormUrlEncoded
    @POST("order/myOrderList")
    Observable<ResultDataEntity<ProductOrderEntity>> doPostOrder(@Field("page") int page, @Field("pageNumber") int pageNumber);

    @FormUrlEncoded
    @POST("newssearch/bytitle")
    Observable<ResultDataEntity<SearchEntity>> doPostSearch(@Field("page") int page, @Field("pageNumber") int pageNumber, @Field("title") String title, @Field("appid") int appId);

    @FormUrlEncoded
    @POST("friends/checkUser")
    Observable<ResultBeanEntity<FriendEntity>> doPostCheckUser(@Field("userId") int userId);

    @FormUrlEncoded
    @POST("appUser/addFriends")
    Observable<ResultBeanEntity<Boolean>> doPostAddFriend(@Field("userId") int userID, @Field("friendId") int friendId);


    @FormUrlEncoded
    @POST("appUser/firstLogin")
    Observable<ResultBeanEntity> doPostFirstLogin(@Field("userId") int userId);

    @POST("appUser/getUserMsgForm")
    Observable<ResultBeanEntity<UserMessage>> doPostUserMessage();

    @FormUrlEncoded
    @POST("appUser/invite")
    Observable<ResultBeanEntity> doPostInvite(@Field("code") String code);

    @POST("appUser/getMyInvite")
    Observable<ResultBeanEntity<List<UserEntity>>> doPostGetMyInvite();

}
