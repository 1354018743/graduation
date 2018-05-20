package com.lz.commn.uitl;  
  
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.io.OutputStreamWriter;  
import java.io.UnsupportedEncodingException;  
import java.io.Writer;  
import java.util.Map;  
  
import freemarker.template.Configuration;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;  
  
public class WordUtil {  
    private Configuration configuration = null;  
      
    public WordUtil(){  
        configuration = new Configuration();  
        configuration.setDefaultEncoding("utf-8");  
    }  
      
    public void createDoc(Map<String, Object> dataMap,String fileName) throws UnsupportedEncodingException {  
  
        configuration.setClassForTemplateLoading(this.getClass(), "/");  
//      System.out.println(">>>>>class:"+this.getClass());  
        Template doct = null;  
        try {  
             doct = configuration.getTemplate("test.ftl");  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
          
        File outfile = new File(fileName);  
          
        Writer out =null;  
        FileOutputStream outputStream =null;  
  
          
        try {  
            outputStream = new FileOutputStream(outfile);  
            OutputStreamWriter oWriter = new OutputStreamWriter(outputStream,"UTF-8");  
            out = new BufferedWriter(oWriter);  
              
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
          
        try {  
            doct.process(dataMap, out);  
            out.close();  
            outputStream.close();  
              
        } catch (TemplateException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
    }  
    public void createDoc(Map<String, Object> dataMap,OutputStream outfil) throws UnsupportedEncodingException {  
          
        configuration.setClassForTemplateLoading(this.getClass(), "/");  
//      System.out.println(">>>>>class:"+this.getClass());  
        Template doct = null;  
        try {  
            doct = configuration.getTemplate("test.ftl");  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
          
//      File outfile = new File(fileName);  
          
        Writer out =null;  
          
    //  outputStream = new FileOutputStream(outfile);  
        OutputStreamWriter oWriter = new OutputStreamWriter(outfil,"UTF-8");  
        out = new BufferedWriter(oWriter);  
          
          
        try {  
            doct.process(dataMap, out);  
            out.close();  
              
        } catch (TemplateException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
    }  
  
}  
