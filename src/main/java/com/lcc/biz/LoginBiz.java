package com.lcc.biz;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.lcc.bean.Result;
import com.lcc.util.ConfUtil;
import com.lcc.util.RestTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 登录
 */
@Component
public class LoginBiz {
    private static final Logger logger = LoggerFactory.getLogger(LoginBiz.class);

    /**
     * 跳转登录
     */
    public Result<String> login() {
        Result<String> result = new Result<String>();
        String url = ConfUtil.getProperty("baseUrl") + ConfUtil.getProperty("oauth2AuthorizeUrl");
        try {
            url = url.replace("{CLIENTID}", ConfUtil.getProperty("clientId")).replace("{RESPONSETYPE}", "code").replace("{REDIRECTURI}", URLEncoder.encode(ConfUtil.getProperty("redirectUrl"), "utf-8"));
            result.setStatus(true);
            result.setErrCode(0);
            result.setResultData(url);
        } catch (UnsupportedEncodingException e) {
            logger.error(url, e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 授权登录
     */
    public Result<String> oauth(String code) {
        Result<String> result = new Result<String>();
        if (StringUtils.isEmpty(code)) {
            return result;
        }

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("clientId", ConfUtil.getProperty("clientId"));
        param.put("clientSecret", ConfUtil.getProperty("clientSecret"));
        param.put("code", code);
        param.put("grantType", "authorization_code");
        String url = ConfUtil.getProperty("baseUrl") + ConfUtil.getProperty("apiAccessTokenUrl");
        JsonNode json = RestTemplateUtil.postForObject(url, param);
        int status = json.get("errCode").asInt();
        if (0 == status) {
            String roncooNo = json.get("resultData").get("roncooNo").asText();
            result.setStatus(true);
            result.setErrCode(0);
            result.setResultData(roncooNo);
        }
        return result;
    }

}
