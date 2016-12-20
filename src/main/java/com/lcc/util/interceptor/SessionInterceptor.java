package com.lcc.util.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcc.util.ConfUtil;
import com.lcc.util.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lcc on 2016/12/21.
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (session == null){
            httpServletResponse.sendRedirect(ConfUtil.getProperty("redirectUrl"));
            return  false;
        }else {
            Object object = session.getAttribute(Constants.Token.RONCOO);
            if (object == null){
                httpServletResponse.sendRedirect(ConfUtil.getProperty("redirectUrl"));
                return  false;
            }else {
                return true;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
