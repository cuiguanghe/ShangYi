package cn.com.shangyi.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTempLate {
	
	private HttpServletRequest request;
	@SuppressWarnings("unused")
	private HttpServletResponse respones;
	private String TempLateName;
	private String outFileName;
	
	public FreeMarkerTempLate(HttpServletRequest request,HttpServletResponse respones,String TemplateName,String outFileName){
		this.request = request;
		this.respones = respones;
		this.TempLateName = TemplateName;
		this.outFileName = outFileName;
	}
	
	
	
	public void createTemplate(tempLateDatahandle handle) throws Exception{
		//公用代码块的抽象

		String tplpath = request.getSession().getServletContext().getRealPath("/")+"portal/tpl";
		
		//创建一个Configuration对象：该实例负责管理FreeMarker的模板加载路径,负责生成模板实例
		Configuration cfg = new Configuration();
		
		//配置freemarker从什么地方加载模板文件，通过创建的Configuration对象加载模板文件
		cfg.setDirectoryForTemplateLoading(new File(tplpath));
		cfg.setDefaultEncoding("UTF-8");
		
		//加载模板，生成模板实例对象，同时制定所使用的模板文件
		Template template = cfg.getTemplate(TempLateName);
		template.setEncoding("UTF-8");
		//定义数据模型（Map对象），并填充数据
		
		//handle回调(查询数据库)
 		//Map<String,String[]> root = new HashMap<String,String[]>();
		
		Map<?,?> root =  handle.doHandle();
						
		//定义输出，将其输出到指定文件中去
		Writer out = new BufferedWriter(new OutputStreamWriter(  
	            new FileOutputStream(tplpath+"/"+outFileName), "UTF-8"));  
		//Writer out = new FileWriter(tplpath+"/menu.html");
		//处理 执行，将模板与数据进行合并
		template.process(root, out);
		out.flush();
		
	}
	
	

}
