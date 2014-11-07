package cn.com.shangyi.common.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import cn.com.shangyi.common.util.JsonUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义异常处理类
 * 
 * @version 1.0
 * @author Darren
 * 
 */
public class ExceptionHandle extends SimpleMappingExceptionResolver {
	private static Logger logger = Logger.getLogger(ExceptionHandle.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// Expose ModelAndView for chosen error view.
		// String viewName = determineViewName(ex, request);
		// JSP格式返回
		/*
		 * if (!(request.getHeader("accept").indexOf("application/json") > -1 ||
		 * (request .getHeader("X-Requested-With") != null && request.getHeader(
		 * "X-Requested-With").indexOf("XMLHttpRequest") > -1))) {// 如果不是异步请求 //
		 * Apply HTTP status code for error views, if specified. // Only apply
		 * it if we're processing a top-level request. Integer statusCode =
		 * determineStatusCode(request, viewName); if (statusCode != null) {
		 * applyStatusCodeIfPossible(request, response, statusCode);
		 * logger.error(ex); ex.printStackTrace(); return
		 * getModelAndView(viewName, ex, request); }
		 * 
		 * } else {// ajax JSON格式返回
		 */
		respErrInfo(response, ex);// http请求接口的返回
		ex.printStackTrace();
		logger.error(ex);
		return new ModelAndView();
		// }
		// return new ModelAndView();
	}

	@Override
	protected Integer determineStatusCode(HttpServletRequest request,
			String viewName) {
		return super.determineStatusCode(request, viewName);
	}

	@Override
	protected void applyStatusCodeIfPossible(HttpServletRequest request,
			HttpServletResponse response, int statusCode) {
		super.applyStatusCodeIfPossible(request, response, statusCode);
	}

	@Override
	protected String determineViewName(Exception ex, HttpServletRequest request) {
		return super.determineViewName(ex, request);
	}

	@Override
	protected ModelAndView getModelAndView(String viewName, Exception ex) {
		return super.getModelAndView(viewName, ex);
	}

	/**
	 * 返回错误提示信息
	 * 
	 * @param response
	 * @param ex
	 */
	public void respErrInfo(HttpServletResponse response, Exception ex) {
		try {
			PrintWriter out = response.getWriter();
			Map<String, Map<String, Object>> json = JsonUtil.toMap(null,
					ex.toString(), HttpReqStatus.Exception, true);
			ObjectMapper obj = new ObjectMapper();
			String result = obj.writeValueAsString(json);
			out.print(result);
			out.flush();
			out.close();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}
