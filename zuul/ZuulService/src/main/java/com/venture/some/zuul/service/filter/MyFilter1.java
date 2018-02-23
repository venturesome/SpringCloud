package com.venture.some.zuul.service.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter1 extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        String username = request.getParameter("username");// ��ȡ����Ĳ���  
        if(null != username && username.equals("swj")) {// �������Ĳ�����Ϊ�գ���ֵΪchhliuʱ����ͨ��  
            ctx.setSendZuulResponse(true);// �Ը��������·��  
            ctx.setResponseStatusCode(200);  
            ctx.set("isSuccess", true);// ��ֵ������һ��Filter������һ��Filter��״̬  
            return null;  
        }else{  
            ctx.setSendZuulResponse(false);// ���˸����󣬲��������·��  
            ctx.setResponseStatusCode(401);// ���ش�����  
            ctx.setResponseBody("{\"result\":\"username is not correct!\"}");// ���ش�������  
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
		return 0;
	}

}
