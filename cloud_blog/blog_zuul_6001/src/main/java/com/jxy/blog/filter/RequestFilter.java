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
public class RequestFilter extends ZuulFilter {
    @Autowired
    private Tracer tracer;
    @Override
    public String filterType() {
        return "pre";
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
        String id=tracer.currentSpan().context().traceIdString();
        System.out.println("correlation-id:"+id+ " pre time: "+new Date().getTime());
        return null;
    }
}
