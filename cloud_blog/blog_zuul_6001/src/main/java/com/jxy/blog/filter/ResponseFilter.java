package com.jxy.blog.filter;

import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jxy
 * @className ResponseFilter
 * @description 描述
 * @date 2020/4/14 21:43
 */
@Component
public class ResponseFilter extends ZuulFilter {
    @Autowired
    private Tracer tracer;
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context=RequestContext.getCurrentContext();
        String id=tracer.currentSpan().context().traceIdString();
        context.getResponse().addHeader("tmx-correlation-id",id);
        System.out.println("correlation-id:"+id+ " post time: "+new Date().getTime());
        return null;
    }
}
