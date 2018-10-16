package dg.bin.com.retrofitokhttprxjavatest.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import dg.bin.com.retrofitokhttprxjavatest.R;
import io.reactivex.Observable;

public class RxjavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        RxjavaManager mRxjavaManager = new RxjavaManager();
        Observable observable = mRxjavaManager.rxjava_Create_Method();
    }
}
