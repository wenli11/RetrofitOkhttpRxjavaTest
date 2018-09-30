package dg.bin.com.retrofitokhttprxjavatest.retrofit.interfaces;

import java.util.Map;

import dg.bin.com.retrofitokhttprxjavatest.model.TokenModel;
import dg.bin.com.retrofitokhttprxjavatest.model.TranslationModel;
import dg.bin.com.retrofitokhttprxjavatest.model.UserModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by b on 2018/9/26.
 * 定义网络请求需要的参数
 *
 * 请求方法
 * @GET  get请求
 * @POST post请求
 *
 *
 * 请求参数
 * 所有请求中都会用到
 * @HTTP 替换 @GET、@POST、@PUT、@DELETE、@HEAD 注解的作用 及 更多功能拓展
 * @Url 直接传入一个请求的 URL 变量 用于 URL 设置
 * @Path 网络请求路径中的缺省值
 * @Header 添加请求头（不固定的请求头）
 * @Headers 添加请求头（固定的请求头）
 *
 * 一般用于 get 请求
 * @Query 网络请求路径中问号后面的单个内容
 * @QueryMap 网络请求路径中问号后面的内容（将数据以键值对的形式存储在 map 中）
 *
 * 一般用于 post 请求
 * @Field 发送 post 请求时提交请求的表单字段
 * @FieldMap 发送 post 请求时提交请求的表单字段（将数据以键值对的形式存储在 map 中）
 * @Body 暂时不理解
 *
 * 暂时未使用下载文件
 * 一般用于下载文件
 * 没有请求参数用于下载文件
 *
 * 暂时未使用上传文件
 * 一般用于上传文件
 * @Part 发送 Post请求 时提交请求的表单字段
 * @PartMap 发送 Post请求 时提交请求的表单字段
 * 与@Field的区别：功能相同，但携带的参数类型更加丰富，包括数据流，所以适用于 有文件上传 的场景
 *
 * 标记类
 * @FormUrlEncoded 表示发送 form-encoded 的数据（适用于提交表单数据）
 * @Multipart 表示发送form-encoded的数据（也可以用于提交表单数据，但是传输内容更加丰富，包括数据流，适用于 有文件 上传的场景）
 * @Streaming 表示返回的数据以流的形式返回（适用于返回数据较大的场景，如下载文件），如果没有使用该注解，默认把返回的数据全部载入内存中，之后获取内容也是从内存中获取
 */

public interface RetrofitInterface {

    public static final String translateUrl = "http://fy.iciba.com/";

    public static final String tokenUrl = "http://api.cn.ronghub.com/";

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello world")
    Call<TranslationModel> getTranslate();

    //hasBody 只在post请求中起作用
    @HTTP(method = "GET", path = "ajax.php?a=fy&f=auto&t=auto&w=hello world", hasBody = false)
    Call<TranslationModel> getTranslate2();

    @GET("{ajax}.php?a=fy&f=auto&t=auto&w=hello world")
    Call<TranslationModel> getTranslate(@Path("ajax") String ajax);

    @GET("{ajax}.php")
    Call<TranslationModel> getTranslate(@Path("ajax") String ajax, @Query("a") String a, @Query("f") String f, @Query("t") String t, @Query("w") String w);

    @GET("{ajax}.php")
    Call<TranslationModel> getTranslate(@Path("ajax") String ajax, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    //表示发送 form-encoded 的数据；每个键值对需要用 @Filed 来注解键名，随后的对象需要提供值。
//    @Headers({
//            "App-Key:uwd1c0sxdlx2",
//            "Content-Type: application/x-www-form-urlencoded"
//    })
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("user/getToken.json")
    Call<TokenModel> getToken(@Header("App-Key") String App_Key, @Header("Nonce") String Nonce, @Header("Timestamp") String Timestamp, @Header("Signature") String Signature, @Field("userId") String userId);

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST
    Call<TokenModel> getToken(@Url String url, @Header("App-Key") String App_Key, @Header("Nonce") String Nonce, @Header("Timestamp") String Timestamp, @Header("Signature") String Signature, @Field("userId") String userId);

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("user/getToken.json")
    Call<TokenModel> getToken(@Header("App-Key") String App_Key, @Header("Nonce") String Nonce, @Header("Timestamp") String Timestamp, @Header("Signature") String Signature, @FieldMap Map<String, String> map);

    //暂时不会使用，待验证
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("user/getToken.json")
    Call<ResponseBody> getToken(@Header("App-Key") String App_Key, @Header("Nonce") String Nonce, @Header("Timestamp") String Timestamp, @Header("Signature") String Signature, @Body UserModel userModel);


}
