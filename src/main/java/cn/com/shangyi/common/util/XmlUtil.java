package cn.com.shangyi.common.util;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;

import org.dom4j.io.XMLWriter;


public class XmlUtil {
	
	
	public static String[] getXml(HttpServletRequest req) throws DocumentException{
		String path =req.getSession().getServletContext().getRealPath("/")+"WEB-INF/classes/cn/com/infohold/portal/xml/Model.xml";
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path));
		//读取真个文件的根节点
		Element root = document.getRootElement();
		Element userList = root.element("functionlist");
		
		@SuppressWarnings("unchecked")
		List<Element> nodes = userList.elements("item");
		String[] methodStr = new String[nodes.size()];
		int Index = 0;
		for (Element element : nodes) {
			methodStr[Index++] = element.attributeValue("methodName");
		}
		
		return methodStr;
	}
	
	
	/**
	 * 写入xml文件
	 * @param req
	 * @throws DocumentException
	 * @throws Throwable
	 */
	public static void addNode(HttpServletRequest req) throws DocumentException, Throwable{
		String path =req.getSession().getServletContext().getRealPath("/")+"WEB-INF/classes/cn/com/infohold/config/xml/Model.xml";
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path));
		//读取真个文件的根节点
		Element root = document.getRootElement();
		Element userList = root.element("functionlist");
		
		
		
		
		@SuppressWarnings("unchecked")
		List<Element> nodes = userList.elements("functionlist");
		
		for (Element element : nodes) {
			//添加节点的测试
			if(element.attributeValue("index").equals("1")){
				//在element 后添加节点
				Element newelement = element.addElement("item");
				newelement.addAttribute("index", "test1");
				newelement.addAttribute("methodName", "李乐1");
				nodes.add(newelement);
				
			}
		}
		
		
		//写入xml文件
		OutputFormat opf = new OutputFormat("\t",true,"UTF-8");
		opf.setTrimText(true);
		XMLWriter write = new XMLWriter(new FileOutputStream(new File(path)), opf);
	    write.write(document);
	    write.close();
	}
	
	
	
	public static void delNode(){
		
	}

}
