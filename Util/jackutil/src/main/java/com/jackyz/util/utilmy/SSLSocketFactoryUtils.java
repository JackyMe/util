package com.jackyz.util.utilmy;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
 * author  : Created by JackyZ
 * date    : on 2017/10/16.
 * blog&git: http://blog.csdn.net/u011200604 & https://github.com/JackyMe/github.io
 * <p>
 * desc    : https 单项验证 信任所有证书
 * 参考: http://blog.csdn.net/u013768203/article/details/72874242
 * http://blog.csdn.net/lmj623565791/article/details/48129405
 * 双向验证:http://blog.csdn.net/u011394071/article/details/52880062
 * retrofit支持加密Https传输 http://www.jianshu.com/p/16994e49e2f6
 */

public class SSLSocketFactoryUtils {
    /**
     * ---------------------------------------信任所有证书的方法------------------------------------------------------------
     */
    /*
    * 默认信任所有的证书
    * todo 最好加上证书认证，主流App都有自己的证书
    * */
    public static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory sslSocketFactory = null;
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{createTrustAllManager()}, new SecureRandom());
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (Exception e) {

        }
        return sslSocketFactory;
    }


    public static X509TrustManager createTrustAllManager() {
        X509TrustManager tm = null;
        try {
            tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    //do nothing，接受任意客户端证书
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    //do nothing，接受任意服务端证书
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
        } catch (Exception e) {

        }
        return tm;
    }

    public static class TrustAllHostnameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    protected static HostnameVerifier getHostnameVerifier() {
        final String hosts[] = {"https://yidou.easyto.com", "https://news.easyto.test"};
        HostnameVerifier TRUSTED_VERIFIER = new HostnameVerifier() {

            public boolean verify(String hostname, SSLSession session) {
                boolean ret = false;
                for (String host : hosts) {
                    if (host.equalsIgnoreCase(hostname)) {
                        ret = true;
                    }
                }
                return ret;
            }
        };

        return TRUSTED_VERIFIER;
    }


    /**
     * ---------------------------------------验证c文件的方法------------------------------------------------------------
     */
    //TODO 下面为新
    //static int keyServerStroreID = R.raw.yidou_ca;
    static int keyServerStroreID ; //填写文件地址

    public static SSLSocketFactory createSSLSocketFactory(Context context) {
        SSLSocketFactory mSSLSocketFactory = null;
        if (mSSLSocketFactory == null) {
            synchronized (SSLSocketFactoryUtils.class) {
                if (mSSLSocketFactory == null) {

                    InputStream trustStream = context.getResources().openRawResource(keyServerStroreID);
                    SSLContext sslContext;
                    try {
                        sslContext = SSLContext.getInstance("TLS");
                    } catch (NoSuchAlgorithmException e) {
                        Log.e("httpDebug", "createSingleSSLSocketFactory", e);
                        return null;
                    }
                    //获得服务器端证书
                    TrustManager[] turstManager = getTurstManager(trustStream);

                    //初始化ssl证书库
                    try {
                        sslContext.init(null, turstManager, new SecureRandom());
                    } catch (KeyManagementException e) {
                        Log.e("httpDebug", "createSingleSSLSocketFactory", e);
                    }

                    //获得sslSocketFactory
                    mSSLSocketFactory = sslContext.getSocketFactory();
                }
            }
        }
        return mSSLSocketFactory;
    }

    /**
     * 获得指定流中的服务器端证书库
     */

    public static TrustManager[] getTurstManager(InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            int index = 0;
            for (InputStream certificate : certificates) {
                if (certificate == null) {
                    continue;
                }
                Certificate certificate1;
                try {
                    certificate1 = certificateFactory.generateCertificate(certificate);
                } finally {
                    certificate.close();
                }

                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificate1);
            }

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);
            return trustManagerFactory.getTrustManagers();

        } catch (Exception e) {
            Log.e("httpDebug", "SSLSocketFactoryUtils", e);
        }

        return getTurstAllManager();
    }

    /**
     * 获得信任所有服务器端证书库
     */
    public static TrustManager[] getTurstAllManager() {
        return new X509TrustManager[]{new MyX509TrustManager()};
    }

    public static class MyX509TrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) {
            System.out.println("cert: " + chain[0].toString() + ", authType: " + authType);
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}
