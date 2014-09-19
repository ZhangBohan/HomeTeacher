package com.jiajiaohello.support.core;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 * User: bohan
 * Date: 9/14/14
 * Time: 11:36 PM
 */
public class CommonHelper {
    public static final Log LOG = LogFactory.getLog("root");

    public static Date now() {
        return new Date();
    }

    private static Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    public static final String API_URL = "http://ip.taobao.com/service/getIpInfo.php";

    /**
     * <p>淘宝IP地址库</p>
     *
     * <b>注意：</b>为了保障服务正常运行，每个用户的访问频率需小于10qps。
     *
     * @param ip IP地址
     * @return  国家 、省（自治区或直辖市）、市（县）、运营商信息
     */
    public static IpData analyzeIp(String ip) {
        HttpRequest request = HttpRequest.get(API_URL, true, "ip", ip);
        if (request.ok()) {
            ResultData resultData = gson.fromJson(request.body(), ResultData.class);
            if (resultData.isSuccess()) {
                return resultData.getData();
            } else {

                return null;
            }
        }
        return null;
    }
}


class ResultData {
    private Integer code;

    private IpData data;

    @Override
    public String toString() {
        return "ResultData{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public IpData getData() {
        return data;
    }

    public void setData(IpData data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return code == 0;
    }
}