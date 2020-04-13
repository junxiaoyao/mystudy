package com.jxy.blog.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author jxy
 * @className AuthFilter
 * @description 描述
 * @date 2020/4/13 21:37
 */
@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context=RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();
        //放过权限相关请求
        if (request.getRequestURL().toString().contains("auth")){
            return null;
        }
        String token=request.getHeader("Authorization");
        System.out.println("token:"+token);
        if (token==null){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("there is no token");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return null;
    }
}
