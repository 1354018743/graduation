package com.lz.common.controller;  
  
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;  
import java.util.Map;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.lz.commn.uitl.WordUtil;
import com.lz.student.service.ApplyUploadService;  
   
  
/**  
 * Servlet implementation class MainServlet  
 */  
@WebServlet("/word/*")
public class WordExport extends BaseController{
	public void export(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        // TODO Auto-generated method stub  
        System.out.println(">>>>>>>>>>>>>>>>> come in !!!!");  
          
        String fileName = "张三简历.doc";  
          
        Map<String, Object> mapvalue = new HashMap<String, Object>();  
        mapvalue.put("name", "张三");//这里的name就是前文中word转ftl后的 ${name} 部分，下同  
        mapvalue.put("sex", "男");  
        mapvalue.put("address", "北京市上地园区09号");  
        mapvalue.put("jingli", "2017年7月毕业于西安交通大学计算机专业；");  
        mapvalue.put("title1", "标题1");  
        mapvalue.put("title2", "biaoTi002");//  
        mapvalue.put("title3", "标题三003");  
        mapvalue.put("value1", "内容项目1");  
        mapvalue.put("value2", "s的发生的发生的发生的发生的发生的飞阿什顿发生的飞");  
        mapvalue.put("value3", "内容项目1内容项目1内容项目1内容项目1内容项目1内容项目1内容项目1内容项目1内容项目3");  
          
          
//      WordUtil wUtil = new WordUtil();  
//      wUtil.createDoc(mapvalue, fileurl);  
          
        String context = req.getSession().getServletContext().toString();  
          
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>context:"+context);  
          
        String endCodeFileName = new String(fileName  
                .getBytes("GBK"), "ISO8859-1");  
        resp.reset();  
        resp.setHeader("Content-Type",  
                    "application/octet-stream;charset=UTF-8");  
        resp.setHeader("Content-Disposition",  
                    "attachment;filename=" + endCodeFileName);  
        resp.setHeader("Connection", "close");  
          
        WordUtil wUtil = new WordUtil();  
        wUtil.createDoc(mapvalue, resp.getOutputStream());  
    }  
  
}  