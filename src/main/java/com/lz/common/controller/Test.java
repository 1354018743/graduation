package com.lz.common.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Test {
	
	
	public static void main(String[] args) throws IOException, TemplateException {
		Map<String,String> dataMap = new HashMap<String,String>();

		dataMap.put("name", "Tom");

		dataMap.put("age", "20");

		dataMap.put("province", "江苏");

		Configuration configuration = new Configuration();

		configuration.setDefaultEncoding("utf-8");

		configuration.setDirectoryForTemplateLoading(new File("E:\\Graduation\\graduation\\src\\main\\java"));

		// 输出文档路径及名称

		File outFile = new File("C:\\Users\\master\\Desktop\\1.doc");

		//以utf-8的编码读取ftl文件

		Template t =  configuration.getTemplate("moddle.xml","utf-8");

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);

		t.process(dataMap, out);

		out.close();
	}

}
