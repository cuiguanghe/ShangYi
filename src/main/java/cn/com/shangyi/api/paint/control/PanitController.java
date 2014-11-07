package cn.com.shangyi.api.paint.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.shangyi.api.paint.service.PaintService;
import cn.com.shangyi.common.exception.HttpReqStatus;
import cn.com.shangyi.common.util.Contants;
import cn.com.shangyi.common.util.JsonUtil;

@Controller
@RequestMapping("/paint")
public class PanitController {
	@Autowired
	private PaintService paintService;

	/*
	 * 首页添加时获取所有分类及子类接口
	 */
	@RequestMapping("/getAllCategory")
	@ResponseBody
	public Map<String, Map<String, Object>> getAllCategory() throws Exception {

		Map<String, Map<String, Object>> map = JsonUtil.toMap(null,
				Contants.MSG_QUERY_SUCCESS, HttpReqStatus.Success, true);
		return map;
	}

}
