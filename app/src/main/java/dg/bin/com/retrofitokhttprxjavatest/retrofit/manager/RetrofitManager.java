package dg.bin.com.retrofitokhttprxjavatest.retrofit.manager;

import android.util.Log;

import java.util.Map;

import dg.bin.com.retrofitokhttprxjavatest.BuildConfig;
import dg.bin.com.retrofitokhttprxjavatest.retrofit.interfaces.RetrofitInterface;
import dg.bin.com.retrofitokhttprxjavatest.model.TokenModel;
import dg.bin.com.retrofitokhttprxjavatest.model.TranslationModel;
import dg.bin.com.retrofitokhttprxjavatest.model.UserModel;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by b on 2018/9/26.
 */

public class RetrofitManager {

    public static RetrofitManager mRetrofitManager;

    private Retrofit mRetrofit;
    private RetrofitInterface mRetrofitInterface;

    public static RetrofitManager getInstance(){
        if(mRetrofitManager == null){
            Integer i = 1;
            synchronized (i){
                mRetrofitManager = new RetrofitManager();
            }
        }
        return mRetrofitManager;
    }

    public void creatRetrofit(String url){

        mRetrofit = new Retrofit.Builder()
                .baseUrl(url) // 设置 网络请求 Url
//                .addConverterFactory（设置解析器，用于返回数据解析）
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析（需要加入依赖）
                .client(setInterceptor().build())
                .build();

        mRetrofitInterface = mRetrofit.create(RetrofitInterface.class);
    }

    //设置拦截器
    private OkHttpClient.Builder setInterceptor(){

        OkHttpClient.Builder builder = new OkHttpClient()
                .newBuilder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("TEST2", "ApiServiceHelper.createApiService().HttpLoggingInterceptor.log().message -> " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


//        builder
//                //设置连接服务器的时间，超时报错：java.net.SocketException: connetct time out
////                .connectTimeout(5*1000, TimeUnit.SECONDS)
//                //设置从服务器读取数据的时间，网络不佳的时候，超时报错：Java.net.SocketException: read time out
////                .readTimeout(10*1000, TimeUnit.SECONDS)
//                //设置向服务器写入数据的时间
////                .writeTimeout(10*1000, TimeUnit.SECONDS)
//                .addInterceptor(loggingInterceptor)//重写 HttpLoggingInterceptor 的 Logger 接口
//                .addInterceptor(new CustomInterceptor());//系统自带拦截器
        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            //没有日志打印
//            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
//            builder.addInterceptor(interceptor);//未作任何处理的 HttpLoggingInterceptor

//            HttpLoggingInterceptor interceptor2 = new HttpLoggingInterceptor();
//            //只打印请求地址以及是否成功
//            interceptor2.setLevel(HttpLoggingInterceptor.Level.BASIC);
//            builder.addInterceptor(interceptor2);//未作任何处理的 HttpLoggingInterceptor

//            HttpLoggingInterceptor interceptor3 = new HttpLoggingInterceptor();
//            //只打印消息头中的信息
//            interceptor3.setLevel(HttpLoggingInterceptor.Level.HEADERS);
//            builder.addInterceptor(interceptor3);//未作任何处理的 HttpLoggingInterceptor

            HttpLoggingInterceptor interceptor4 = new HttpLoggingInterceptor();
            //打印消息头和返回的数据
            interceptor4.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor4);//未作任何处理的 HttpLoggingInterceptor
        }
        return builder;
    }

    public void getTranslate(String url, Callback<TranslationModel> callback){
        creatRetrofit(url);
        Call<TranslationModel> translate = mRetrofitInterface.getTranslate();
        translate.enqueue(callback);
    }

    public void getTranslate2(String url, Callback<TranslationModel> callback){
        creatRetrofit(url);
        Call<TranslationModel> translate = mRetrofitInterface.getTranslate();
        translate.enqueue(callback);
    }

    public void getTranslate(String url, String ajax, Callback<TranslationModel> callback){
        creatRetrofit(url);
        Call<TranslationModel> translate = mRetrofitInterface.getTranslate(ajax);
        translate.enqueue(callback);
    }

    public void getTranslate(String url, String ajax, String a, String f, String t, String w, Callback<TranslationModel> callback){
        creatRetrofit(url);
        Call<TranslationModel> translate = mRetrofitInterface.getTranslate(ajax, a, f, t, w);
        translate.enqueue(callback);
    }

    public void getTranslate(String url, String ajax, Map<String, String> map, Callback<TranslationModel> callback){
        creatRetrofit(url);
        Call<TranslationModel> translate = mRetrofitInterface.getTranslate(ajax, map);
        translate.enqueue(callback);
    }

    public void getToken(String url, String App_Key, String Nonce, String Timestamp, String Signature, String userId, Callback<TokenModel> callback){
        creatRetrofit(url);
        Call<TokenModel> token = mRetrofitInterface.getToken(App_Key, Nonce, Timestamp, Signature, userId);
        token.enqueue(callback);
    }

    public void getToken(String url, String url2, String App_Key, String Nonce, String Timestamp, String Signature, String userId, Callback<TokenModel> callback){
        creatRetrofit(url);
        Call<TokenModel> token = mRetrofitInterface.getToken(url2, App_Key, Nonce, Timestamp, Signature, userId);
        token.enqueue(callback);
    }

    public void getToken(String url, String App_Key, String Nonce, String Timestamp, String Signature, Map<String, String> map, Callback<TokenModel> callback){
        creatRetrofit(url);
        Call<TokenModel> token = mRetrofitInterface.getToken(App_Key, Nonce, Timestamp, Signature, map);
        token.enqueue(callback);
    }

    public void getToken(String url, String App_Key, String Nonce, String Timestamp, String Signature, UserModel userModel, Callback<ResponseBody> callback){
        creatRetrofit(url);
        Call<ResponseBody> token = mRetrofitInterface.getToken(App_Key, Nonce, Timestamp, Signature, userModel);
        token.enqueue(callback);
    }
}
