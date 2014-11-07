package cn.com.shangyi.common.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUtil {
	
	public static List<Object> toFile(MultipartFile file) throws IOException{
		List<Object> list = new ArrayList<Object>();
		String newFileName = null;
		boolean boo = false;
		if(null != file && file.getContentType().indexOf("image") >= 0){
			/*String fileName = file.getOriginalFilename();
			String [] nameSplit = null;
			String fileType = null;
			if(fileName.indexOf(".") > 0){
				nameSplit = fileName.split(".");
				if(nameSplit.length > 0){
					fileType = nameSplit[nameSplit.length-1];
				}
			}*/
			
			CommonsMultipartFile cfile = (CommonsMultipartFile)file;
			DiskFileItem dfi =(DiskFileItem)cfile.getFileItem();
			File path =dfi.getStoreLocation();
			int random = (int)(Math.random()*10000);
			newFileName = System.currentTimeMillis() + String.valueOf(random) + ".jpg";
			boo = PicBucketTool.WriteFile(path, newFileName);
		}
		list.add(newFileName);
		list.add(boo);
		return list;
	}
	
}
