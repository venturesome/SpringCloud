package com.venture.some.zuul.service.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter2 extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getParameter("isSuccess"));
        
        return (boolean) ctx.get("isSuccess");  
	}

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        String password = request.getParameter("password");// 获取请求的参数  
        if(null != password && password.equals("123456")) {// 如果请求的参数不为空，且值为chhliu时，则通过  
            ctx.setSendZuulResponse(true);// 对该请求进行路由  
            ctx.setResponseStatusCode(200);  
            ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态  
            return null;  
        }else{  
            ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由  
            ctx.setResponseStatusCode(401);// 返回错误码  
            ctx.setResponseBody("{\"result\":\"password is not correct!\"}");// 返回错误内容  
            ctx.set("isSuccess", false);  
            return null;  
        }  
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
