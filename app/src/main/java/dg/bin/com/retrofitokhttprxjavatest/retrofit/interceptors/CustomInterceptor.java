package dg.bin.com.retrofitokhttprxjavatest.retrofit.interceptors;

import android.util.Log;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by b on 2018/9/28.
 * 系统自带的网络请求拦截器
 */

public class CustomInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.i("TEST", "MyIntercepter.intercept.request.toString -> " + request.toString());
        Log.i("TEST", String.format(Locale.getDefault(),
                "MyIntercepter.intercept.requestbody -> {contentType : %1$s, contentLength : %2$d, toString : %3$s}",
                request.body().contentType().toString(),
                request.body().contentLength(),
                request.body().toString()));
        Response response = chain.proceed(request);

        Log.i("TEST", "MyIntercepter.intercept.response.message -> " + response.message());
        Log.i("TEST", "MyIntercepter.intercept.response.toString -> " + response.toString());

        // 在这里不能通过这个来获取服务器返回的内容，否则会报错
        // response.body().string();
        return response;
    }
}
