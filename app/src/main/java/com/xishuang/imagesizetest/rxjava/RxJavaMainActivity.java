package com.xishuang.imagesizetest.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xiaomi.mipush.sdk.MiPushClient;
import com.xishuang.imagesizetest.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.observable.ObservableAll;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RxJavaMainActivity extends AppCompatActivity {

    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        observable();
//        zipobserable();
//        concatObserable();
//        flapMapOrConcatMapObserable();
//        distinctObserable();
//        filterObserable();
//        bufferObserable();
//        timerObserable();
//        intervalObserable();
//        doOnNextObserable();
//        skipObserable();
//        takeObserable();
//        debounceObserable();
//        deferObserable();
//        lastObserable();
//        mergeObserable();
//        reduceObserable();
//        scanObserable();
        windowObserable();
    }

    private void windowObserable() {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(15)
                .window(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Observable<Long>>() {
                    @Override
                    public void accept(Observable<Long> longObservable) throws Exception {
                        Log.e("星星", "window");
                        longObservable.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<Long>() {
                                    @Override
                                    public void accept(Long aLong) throws Exception {
                                        Log.e("星星", "accept" + aLong);
                                    }
                                });
                    }
                });
    }

    private void scanObserable() {
        Observable.just(1, 2, 3)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e("星星", "accept" + integer);
            }
        });
    }

    private void reduceObserable() {
            Observable.just(1, 2, 3)
                    .reduce(new BiFunction<Integer, Integer, Integer>() {
                        @Override
                        public Integer apply(Integer integer, Integer integer2) throws Exception {
                            return integer + integer2;
                        }
                    }).subscribe(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) throws Exception {
                    Log.e("星星", "accept" + integer);
                }
            });
    }

    private void mergeObserable() {
        Observable.merge(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("星星", "accept" + integer);
                    }
                });
    }

    private void lastObserable() {
        Observable.just(1, 2, 3)
                .last(1)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("星星", "accept" + integer);
                    }
                });
    }

    private void deferObserable() {
        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(1, 2, 3);
            }
        });
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("星星", "onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("星星", "onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e("星星", "onComplete");
            }
        });
    }

    private void debounceObserable() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1); // skip
                Thread.sleep(400);
                emitter.onNext(2); // deliver
                Thread.sleep(105);
                emitter.onNext(3); // skip
                Thread.sleep(100);
                emitter.onNext(4); // deliver
                Thread.sleep(605);
                emitter.onNext(5); // deliver
                Thread.sleep(510);
                emitter.onComplete();
            }
        }).debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("星星", "accept " + integer);
                    }
                });
    }

    private void takeObserable() {
        Observable.just(1, 2, 3, 4, 5)
                .take(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("星星", "accept " + integer);
                    }
                });
    }

    private void skipObserable() {
        Observable.just(1, 2, 3, 4, 5)
                .skip(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("星星", "accept " + integer);
                    }
                });
    }

    private void doOnNextObserable() {
        Observable.just(1, 1, 2, 3)
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("Little星", "accept " + integer);
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e("星星", "accept " + integer);
            }
        });
    }

    private void intervalObserable() {
        final long[] startTime = {System.currentTimeMillis()};
        mDisposable = Observable.interval(3, 2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        long endTime = System.currentTimeMillis();
                        Log.e("星星", "accept " + (endTime - startTime[0]));
                        startTime[0] = endTime;
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    private void timerObserable() {
        final long startTime = System.currentTimeMillis();
        Observable.timer(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e("星星", "thread " + Thread.currentThread().getName());
                        Log.e("星星", "accept " + (System.currentTimeMillis() - startTime));
                    }
                });
    }

    private void bufferObserable() {
        Observable.just(1, 2, 5, 10)
                .buffer(3, 2)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        Log.e("星星", "buffer size:" + integers.size());
                        for (Integer integer : integers) {
                            Log.e("星星", "accept" + integer);
                        }
                    }
                });
    }

    private void filterObserable() {
        Observable.just(1, 2, 5, 10, -10, 3)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer >= 5;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e("星星", "accept" + integer);
            }
        });
    }

    private void distinctObserable() {
        Observable.just(1, 1, 1, 2, 5, 5, 5)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("星星", "accept" + integer);
                    }
                });
    }

    private void flapMapOrConcatMapObserable() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.e("星星", "thread create" + Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
//        }).concatMap(new Function<Integer, ObservableSource<String>>() {
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                Log.e("星星", "thread apply" + Thread.currentThread().getName());
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list.add("I am value " + integer + ":" + i);
                }
                int delayTime = (int) (1 + Math.random() * 10);

                return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("星星", "accept" + s);
//                        Log.e("星星", "thread subscribe" + Thread.currentThread().getName());
                    }
                });
    }

    private void concatObserable() {
        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("星星", "accept" + integer);
                    }
                });
    }

    private void observable() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e("星星", "subscribe");
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
                e.onNext(4);
            }
        });
        observable.map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return integer * 10 + "";
                    }
                }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("星星", "onSubscribe");
            }

            @Override
            public void onNext(String integer) {
                Log.e("星星", "onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("星星", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("星星", "onComplete");
            }
        });
        observable.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return integer * 10 + "";
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("星星", "onSubscribe");
            }

            @Override
            public void onNext(String integer) {
                Log.e("星星", "onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("星星", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("星星", "onComplete");
            }
        });
    }

    private void zipobserable() {
        Observable<String> observable1 = getZipObserable1();
        Observable<Integer> observable2 = getZipObserable2();

        Observable.zip(observable1, observable2, new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String o, Integer o2) throws Exception {
                Log.e("星星", "apply" + o + ":" + o2);
                return o + o2;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String o) throws Exception {
                Log.e("星星", "accept" + o);
            }
        });
    }

    private Observable<String> getZipObserable1() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("A");
                e.onNext("B");
                e.onNext("C");
                e.onNext("D");
            }
        });
    }

    private Observable<Integer> getZipObserable2() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        });
    }
}
