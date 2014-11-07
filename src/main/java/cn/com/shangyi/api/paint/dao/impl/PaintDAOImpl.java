package cn.com.shangyi.api.paint.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.shangyi.api.paint.dao.PaintDAO;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class PaintDAOImpl implements PaintDAO {
	@Autowired
	private SqlMapClient sqlMapClient;

}
