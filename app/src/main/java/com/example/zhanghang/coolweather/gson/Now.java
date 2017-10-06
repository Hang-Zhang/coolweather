package com.example.zhanghang.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhanghang on 2017/10/2.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
