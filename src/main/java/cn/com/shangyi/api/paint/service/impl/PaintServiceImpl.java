package cn.com.shangyi.api.paint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.shangyi.api.paint.dao.PaintDAO;
import cn.com.shangyi.api.paint.service.PaintService;

@Service
public class PaintServiceImpl implements PaintService {
	@Autowired
	private PaintDAO paintDao;
}
