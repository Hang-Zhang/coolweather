package com.example.zhanghang.coolweather.gson;

/**
 * Created by zhanghang on 2017/10/2.
 */

public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
