package dg.bin.com.retrofitokhttprxjavatest.rxjava;

import android.support.annotation.NonNull;
import android.util.Log;

import org.reactivestreams.Publisher;

import java.util.Iterator;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by b on 2018/10/15.
 * 主要关于 rxjava2
 * rxjava2 主要对象为观察者和被观察者
 * 被观察者分为 Observable 和 Flowable
 * 观察者分为 Obserber 和 Subcriber
 * Observable 和 Observer 不支持背压
 * Flowable 和 Subcriber 支持背压
 *
 * 背压：控制流速的一种策略；
 * 当被观察者发射数据的速度比观察者或者其他处理数据对象的处理速度快的时候，会造成大量数据堆积；
 * 例如：使用zip操作符的时候，其中一个被观察者的速度比另一个被观察者的速度慢，这个时候为了等待比较慢的被观察者，速度快的被观察者会堆积数据
 *
 *
 * Observable
 * 创建 Observable
 * creat  被订阅后才会发射数据，
 *
 * defer
 *
 *
 * 线程调度器  用来控制观察者和被观察者中操作的线程
 * subscribeOn  指定发射数据事件所在的线程，可以多次指定，但只有第一个执行
 *
 * observeOn  指定订阅者接受事件的线程，多次指定，多次执行
 *
 * Schedulers.io()  代表io操作的线程, 通常用于网络,读写文件等io密集型的操作
 *
 * Schedulers.newThread()  代表一个常规的新线程
 *
 * Schedulers.computation()   代表CPU计算密集型的操作, 例如需要大量计算的操作
 *
 * AndroidSchedulers.mainThread()  代表Android的主线程
 *
 */

public class RxjavaManager {

    /**
     * 创建Observable
     */
    protected Observable rxjava_Create_Method(){

        Observable<String> stringObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                    e.onNext("start");
                    e.onNext("start2");
                    e.onNext("start3");
                    e.onComplete();
            }
        });
        stringObservable.subscribe(new Observer<String>() {
            Disposable mDisposable;
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.e("onNext: ", s);
                //mDisposable.isDisposed() true 取消订阅 false 已订阅
                Log.e("onNext: ", mDisposable.isDisposed()+"");
                if(s.equals("start2")){
                    //取消订阅
                    mDisposable.dispose();
                }

                Log.e("onNext: ", mDisposable.isDisposed()+"1");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return stringObservable;
    }

    protected Observable rxjava_Defer_Method(){
        Observable<Object> defer_true = Observable.defer(new Callable<ObservableSource<?>>() {
            @Override
            public ObservableSource<?> call() throws Exception {
                return null;
            }
        });
        defer_true.subscribe(new Observer<Object>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return defer_true;
    }

}
