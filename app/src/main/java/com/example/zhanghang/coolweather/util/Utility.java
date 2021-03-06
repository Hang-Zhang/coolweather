package com.example.zhanghang.coolweather.util;

import android.text.TextUtils;

import com.example.zhanghang.coolweather.db.City;
import com.example.zhanghang.coolweather.db.County;
import com.example.zhanghang.coolweather.db.Province;
import com.example.zhanghang.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhanghang on 2017/10/1.
 */

public class Utility {
    //解析和处理服务器返回的省级数据
    public static boolean handleProvinceResponse(String resopnse){
        if (!TextUtils.isEmpty(resopnse)){
            try {
                JSONArray allProvinces = new JSONArray(resopnse);
                for (int i=0; i<allProvinces.length(); i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String resopnse, int provinceID){
        if (!TextUtils.isEmpty(resopnse)){
            try {
                JSONArray allCities = new JSONArray(resopnse);
                for (int i=0; i<allCities.length(); i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceID);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResponse(String resopnse, int cityId){
        if (!TextUtils.isEmpty(resopnse)){
            try {
                JSONArray allCounties = new JSONArray(resopnse);
                for (int i=0; i<allCounties.length(); i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    //将返回的Json数据解析成Weather实体类
    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            //System.out.println("jsonObject---->" + jsonObject);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            //System.out.println("JSONArray---->" + jsonArray);
            String weatherContent = jsonArray.getJSONObject(0).toString();
            //System.out.println("weatherContent---->" + weatherContent);

            Gson gson = new Gson();
            Weather weather = gson.fromJson(weatherContent,Weather.class);
            return weather;

        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println("6");
        return null;
    }
}
























