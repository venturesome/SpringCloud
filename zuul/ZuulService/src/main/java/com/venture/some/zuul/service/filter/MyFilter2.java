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
        
        String password = request.getParameter("password");// ��ȡ����Ĳ���  
        if(null != password && password.equals("123456")) {// �������Ĳ�����Ϊ�գ���ֵΪchhliuʱ����ͨ��  
            ctx.setSendZuulResponse(true);// �Ը��������·��  
            ctx.setResponseStatusCode(200);  
            ctx.set("isSuccess", true);// ��ֵ������һ��Filter������һ��Filter��״̬  
            return null;  
        }else{  
            ctx.setSendZuulResponse(false);// ���˸����󣬲��������·��  
            ctx.setResponseStatusCode(401);// ���ش�����  
            ctx.setResponseBody("{\"result\":\"password is not correct!\"}");// ���ش�������  
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
