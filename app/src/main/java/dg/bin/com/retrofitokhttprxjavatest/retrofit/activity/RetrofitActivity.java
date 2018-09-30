package dg.bin.com.retrofitokhttprxjavatest.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

import dg.bin.com.retrofitokhttprxjavatest.R;
import dg.bin.com.retrofitokhttprxjavatest.retrofit.interfaces.RetrofitInterface;
import dg.bin.com.retrofitokhttprxjavatest.retrofit.manager.RetrofitManager;
import dg.bin.com.retrofitokhttprxjavatest.tools.SHA1;
import dg.bin.com.retrofitokhttprxjavatest.model.TokenModel;
import dg.bin.com.retrofitokhttprxjavatest.model.TranslationModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtGettranslate, mBtGettranslate1, mBtGettranslate2, mBtGettranslate3, mBtGettranslate4, mBtGettoken, mBtGettoken1, mBtGettoken2;

    String App_Key = "y745wfm8yjegv";
    String App_Secret = "1TrkTwz7DOY";
    String Nonce = "111111";
    String Timestamp = System.currentTimeMillis()+"";
    String Signature = "";
    StringBuffer sb = new StringBuffer(App_Secret);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        initView();
    }

    private void initView() {
        mBtGettranslate = findViewById(R.id.bt_getTraslate);
        mBtGettranslate.setOnClickListener(this);

        mBtGettranslate1 = findViewById(R.id.bt_getTraslate_1);
        mBtGettranslate1.setOnClickListener(this);

        mBtGettranslate2 = findViewById(R.id.bt_getTraslate_2);
        mBtGettranslate2.setOnClickListener(this);

        mBtGettranslate3 = findViewById(R.id.bt_getTraslate_3);
        mBtGettranslate3.setOnClickListener(this);

        mBtGettranslate4 = findViewById(R.id.bt_getTraslate_4);
        mBtGettranslate4.setOnClickListener(this);

        mBtGettoken = findViewById(R.id.bt_getToken);
        mBtGettoken.setOnClickListener(this);

        mBtGettoken1 = findViewById(R.id.bt_getToken_1);
        mBtGettoken1.setOnClickListener(this);

        mBtGettoken2 = findViewById(R.id.bt_getToken_2);
        mBtGettoken2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_getTraslate:
                RetrofitManager.getInstance().getTranslate(RetrofitInterface.translateUrl, new Callback<TranslationModel>() {
                    @Override
                    public void onResponse(Call<TranslationModel> call, Response<TranslationModel> response) {
                        Log.e("onResponse: ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<TranslationModel> call, Throwable t) {
                        Log.e("onFailure: ", getString(R.string.connect_fail));
                    }
                });
                break;

            case R.id.bt_getTraslate_1:
                RetrofitManager.getInstance().getTranslate2(RetrofitInterface.translateUrl, new Callback<TranslationModel>() {
                    @Override
                    public void onResponse(Call<TranslationModel> call, Response<TranslationModel> response) {
                        Log.e("onResponse: ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<TranslationModel> call, Throwable t) {
                        Log.e("onFailure: ", getString(R.string.connect_fail));
                    }
                });
                break;

            case R.id.bt_getTraslate_2:
                RetrofitManager.getInstance().getTranslate(RetrofitInterface.translateUrl, "ajax", new Callback<TranslationModel>() {
                    @Override
                    public void onResponse(Call<TranslationModel> call, Response<TranslationModel> response) {
                        Log.e("onResponse: ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<TranslationModel> call, Throwable t) {
                        Log.e("onFailure: ", getString(R.string.connect_fail));
                    }
                });
                break;

            case R.id.bt_getTraslate_3:
                RetrofitManager.getInstance().getTranslate(RetrofitInterface.translateUrl, "ajax", "fy", "auto", "auto", "hello world", new Callback<TranslationModel>() {
                    @Override
                    public void onResponse(Call<TranslationModel> call, Response<TranslationModel> response) {
                        Log.e("onResponse: ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<TranslationModel> call, Throwable t) {
                        Log.e("onFailure: ", getString(R.string.connect_fail));
                    }
                });
                break;

            case R.id.bt_getTraslate_4:
                HashMap<String, String> map = new HashMap();
                map.put("a", "fy");
                map.put("f", "auto");
                map.put("t", "auto");
                map.put("w", "hello world");
                RetrofitManager.getInstance().getTranslate(RetrofitInterface.translateUrl, "ajax", map, new Callback<TranslationModel>() {
                    @Override
                    public void onResponse(Call<TranslationModel> call, Response<TranslationModel> response) {
                        Log.e("onResponse: ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<TranslationModel> call, Throwable t) {
                        Log.e("onFailure: ", getString(R.string.connect_fail));
                    }
                });
                break;

            case R.id.bt_getToken:
                sb = new StringBuffer(App_Secret);
                sb.append(Nonce);
                sb.append(Timestamp);
                Signature = SHA1.main(sb.toString());
                RetrofitManager.getInstance().getToken(RetrofitInterface.tokenUrl, App_Key, Nonce, Timestamp, Signature, "12", new Callback<TokenModel>() {
                    @Override
                    public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                        Log.e("onResponse: ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<TokenModel> call, Throwable t) {
                        Log.e("onFailure: ", getString(R.string.connect_fail));
                    }
                });
                break;

            case R.id.bt_getToken_1:
                sb = new StringBuffer(App_Secret);
                sb.append(Nonce);
                sb.append(Timestamp);
                Signature = SHA1.main(sb.toString());
                RetrofitManager.getInstance().getToken(RetrofitInterface.tokenUrl, "user/getToken.json", App_Key, Nonce, Timestamp, Signature, "12", new Callback<TokenModel>() {
                    @Override
                    public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                        Log.e("onResponse: ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<TokenModel> call, Throwable t) {
                        Log.e("onFailure: ", getString(R.string.connect_fail));
                    }
                });
                break;

            case R.id.bt_getToken_2:
                sb = new StringBuffer(App_Secret);
                sb.append(Nonce);
                sb.append(Timestamp);
                Signature = SHA1.main(sb.toString());
                HashMap<String, String> map2 = new HashMap<>();
                map2.put("userId", "12");
                RetrofitManager.getInstance().getToken(RetrofitInterface.tokenUrl, App_Key, Nonce, Timestamp, Signature, map2, new Callback<TokenModel>() {
                    @Override
                    public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                        Log.e("onResponse: ", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<TokenModel> call, Throwable t) {
                        Log.e("onFailure: ", getString(R.string.connect_fail));
                    }
                });
                break;
        }
    }
}
