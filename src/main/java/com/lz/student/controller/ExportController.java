package com.lz.student.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lz.common.controller.BaseController;
import com.lz.common.entity.Apply;
import com.lz.common.entity.ApplyProgress;
import com.lz.common.entity.Student;
import com.lz.student.service.ApplyMessageService;
import com.lz.student.service.ExoportService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 机场信息相关类
 * @author ASUS
 *
 */
@WebServlet("/Export/*")
public class ExportController extends BaseController{
	//加载所有机场信息
	public ExoportService es=new ExoportService();
	public void export(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, TemplateException {
		
		int aid=Integer.parseInt(req.getParameter("aid"));
		List<Apply> apply=es.loadApply(aid);
		HttpSession session=req.getSession();
		Student student=(Student)session.getAttribute("student");
		String name=student.getName();
		String grade=student.getGrade();
		String studentno=student.getStuno();
		Map<String,String> dataMap = new HashMap<String,String>();
		
		dataMap.put("name", name);

		dataMap.put("grade", grade);

		dataMap.put("studentno", studentno);
		dataMap.put("country", apply.get(0).getCountry());
	
		dataMap.put("allowances", apply.get(0).getAllowances());
		
		dataMap.put("subsidize", apply.get(0).getSubsidize());
		System.out.println(apply.get(0).getSubsidize());
		Configuration configuration = new Configuration();

		configuration.setDefaultEncoding("utf-8");

		configuration.setDirectoryForTemplateLoading(new File("E:\\Graduation\\graduation\\src\\main\\java"));

		// 输出文档路径及名称

		File outFile = new File("C:\\Users\\master\\Desktop\\apply.doc");

		//以utf-8的编码读取ftl文件

		Template t =  configuration.getTemplate("apply.xml","utf-8");

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);

		t.process(dataMap, out);

		out.close();
		boolean result=true;
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(result+"");
	}

		
	
}
