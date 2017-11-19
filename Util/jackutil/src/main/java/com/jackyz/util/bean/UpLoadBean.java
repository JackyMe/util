package com.jackyz.util.bean;

/**
 * author  : Created by JackyZ
 * date    : on 2017/10/16.
 * blog&git: http://blog.csdn.net/u011200604 & https://github.com/JackyMe/github.io
 * <p>
 * desc    :
 */

public class UpLoadBean {

    /**
     * path : /images/seller/user/20171016/20171016e7d7d292-27cc-4f9c-8099-96c329d82cb6.jpg
     * res_msg : 文件上传成功
     * res_code : 000000
     */

    private String path;
    private String res_msg;
    private String res_code;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRes_msg() {
        return res_msg;
    }

    public void setRes_msg(String res_msg) {
        this.res_msg = res_msg;
    }

    public String getRes_code() {
        return res_code;
    }

    public void setRes_code(String res_code) {
        this.res_code = res_code;
    }
}
