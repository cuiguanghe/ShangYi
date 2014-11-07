package cn.com.shangyi.common.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json格式转换
 * 
 * @version 1.0
 * @author Darren
 * 
 */
public class JsonUtil {
	static ObjectMapper objectMapper;
	private String message;
	private String ex_msg;
	private String responseStatus;
	private Boolean isSuccess;

	/**
	 * @return the isSuccess
	 */
	public Boolean getIsSuccess() {
		return isSuccess;
	}

	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the ex_msg
	 */
	public String getEx_msg() {
		return ex_msg;
	}

	/**
	 * @param ex_msg
	 *            the ex_msg to set
	 */
	public void setEx_msg(String ex_msg) {
		this.ex_msg = ex_msg;
	}

	/**
	 * @return the responseStatus
	 */
	public String getResponseStatus() {
		return responseStatus;
	}

	/**
	 * @param responseStatus
	 *            the responseStatus to set
	 */
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public JsonUtil() {

	}

	public JsonUtil(String message, String ex_msg, String responseStatus,Boolean isSuccess) {
		this.message = message;
		this.ex_msg = ex_msg;
		this.responseStatus = responseStatus;
		this.isSuccess = isSuccess;
	}

	/**
	 * 接口应用返回json格式数据
	 * 
	 * @param model
	 *            对象数据字符串
	 * @param message
	 *            提示信息
	 * @param responseStatus
	 *            请求状态码
	 * @param isSuccess
	 *            请求是否成功
	 * @return
	 */
	public static String toJson(String model, String message,
			String responseStatus, Boolean isSuccess) {

		StringBuffer json = new StringBuffer();
		json.append("{\"returnBody\":{");
		json.append("\"model\":");
		json.append(model);
		json.append(",\"message\":");
		json.append(message);
		json.append(",\"return_code\":");
		json.append(responseStatus);
		json.append(",\"isSuccess\":");
		json.append(isSuccess);
		json.append("}}");
		return json.toString();
	}

	public static Map<String, Map<String, Object>> toMap(Object model,
			String message, String responseStatus, Boolean isSuccess) {
		Map<String, Map<String, Object>> returnMap = new HashMap<String, Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("model", model);
		map.put("message", message);
		map.put("return_code", responseStatus);
		map.put("isSuccess", isSuccess);
		returnMap.put("returnBody", map);
		return returnMap;
	}
	
	
	public static Map<String, Map<String, Object>> toMap(Object model,
		Integer totalPage,Integer page,Integer records,String message, String responseStatus, Boolean isSuccess) {
		Map<String, Map<String, Object>> returnMap = new HashMap<String, Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("model", model);
		map.put("message", message);
		map.put("return_code", responseStatus);
		map.put("isSuccess", isSuccess);
	    map.put("total",totalPage);
	    map.put("page", page);
	    map.put("records", records);
		returnMap.put("returnBody", map);
		return returnMap;
	}

}
