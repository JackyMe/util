package com.jackyz.util.utilmy;

/**
 * 作者：JackyZ fenglizizhu
 * 说明：基于rxJava1.x 事件的订阅
 */
public class RxBus {
//    private static volatile RxBus mDefaultInstance;
//    private final Subject<Object, Object> mBus;
//    private final Map<Class<?>, Object> mStickEventMap;
//
//    public RxBus() {
//        //将Subject(PublishSubject)转换为SerializedSubject
//        mBus = new SerializedSubject<>(PublishSubject.create());
//        mStickEventMap = new ConcurrentHashMap<>();
//    }
//
//    /*单例*/
//    public static RxBus getDefault() {
//        if (mDefaultInstance == null) {
//            synchronized (RxBus.class) {
//                if (mDefaultInstance == null) {
//                    mDefaultInstance = new RxBus();
//                }
//            }
//        }
//        return mDefaultInstance;
//    }
//
//    /*发送事件*/
//    public void post(Object event) {
//        try {
//            if (mBus == null) {
//                mDefaultInstance = new RxBus();
//            }
//            mBus.onNext(event);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /*订阅事件*/
//    public <T> Observable<T> toObservable(Class<T> eventType) {
//        return mBus.ofType(eventType);//ofType可以根据事件类型发送指定数据
//    }
//
//    /*发送一个新的Sticky事件*/
//    public void postSticky(Object event) {
//        synchronized (mStickEventMap) {//线程锁
//            mStickEventMap.put(event.getClass(), event);//将事件类型保存到Map集合
//        }
//        post(event);
//    }
//
//    /*订阅Sticky事件*/
//    public <T> Observable<T> tObservableStick(final Class<T> eventType) {
//        synchronized (mStickEventMap) {
//            final Observable<T> observable = mBus.ofType(eventType);//获取发送事件的Observable
//            final Object event = mStickEventMap.get(eventType);//根据事件类型作为key查找value对应的value
//            if (null != event) {
//                return observable.mergeWith(Observable.create(new Observable.OnSubscribe<T>() {//通过mergeWith合并两个Observable
//
//                    @Override
//                    public void call(Subscriber<? super T> subscriber) {
//                        //订阅 eventType.cast(event)直接将eventType转换为 T发送
//                        subscriber.onNext(eventType.cast(event));
//                    }
//                }));
//            } else {
//                return observable;//如果没有sticky 就返回observable
//            }
//        }
//    }
//
//    /*根据eventType获取事件*/
//    public <T> T getStickEvent(Class<T> eventType) {
//        synchronized (mStickEventMap) {
//            return eventType.cast(mStickEventMap.get(eventType));
//        }
//    }
//
//    /*移除指定类型的eventType的Sticky事件*/
//    public <T> T removeStickyEvent(Class<T> eventType) {
//        synchronized (mStickEventMap) {
//            return eventType.cast(mStickEventMap.remove(eventType));
//        }
//    }
//
//    /*移除所有的Sticky事件*/
//    public void removeAllStickyEvents() {
//        synchronized (mStickEventMap) {
//            mStickEventMap.clear();
//        }
//    }

}
