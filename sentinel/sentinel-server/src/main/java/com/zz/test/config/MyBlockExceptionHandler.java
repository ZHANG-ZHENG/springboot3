package com.zz.test.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;



/**
 * 自定义异常
 * @author zz
 *
 */
@Configuration
public class MyBlockExceptionHandler implements BlockExceptionHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        MyResponse errorResponse = new MyResponse();
        // 不同的异常返回不同的提示语
        if (e instanceof FlowException) {
            errorResponse.setMsg("被限流了");
            errorResponse.setStatus(1);
        } else if (e instanceof DegradeException) {
            errorResponse.setMsg("服务降级了");
            errorResponse.setStatus(2);
        } else if (e instanceof ParamFlowException) {
            errorResponse.setMsg("被限流了");
            errorResponse.setStatus(3);
        } else if (e instanceof SystemBlockException) {
            errorResponse.setMsg("被系统保护了");
            errorResponse.setStatus(4);
        } else if (e instanceof AuthorityException) {
            errorResponse.setMsg("被授权了");
            errorResponse.setStatus(5);
        }

        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        //response.getWriter().print(new Gson().toJson(errorResponse));
        response.getWriter().print(errorResponse.getMsg());
		
	}

	/**
	 * 简单的响应结构体
	 */
	class MyResponse {
	    private Integer status;
	    private String msg;
	    public Integer getStatus() {
	        return status;
	    }
	    public static Object builder() {
	        // TODO Auto-generated method stub
	        return null;
	    }
	    public void setStatus(Integer status) {
	        this.status = status;
	    }
	    public String getMsg() {
	        return msg;
	    }
	    public void setMsg(String msg) {
	        this.msg = msg;
	    }
	    
	}
}

