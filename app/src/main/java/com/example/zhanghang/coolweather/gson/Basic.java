package com.example.zhanghang.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhanghang on 2017/10/2.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
