package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;

@SuppressWarnings("unused")
public class IoWork 
{
    public static void main( String[] args ) throws IOException
    {
	 
    	URL url=new URL("http://www.madore.org/~david/math/padics.pdf");
    	URLConnection huc= url.openConnection();
		huc.connect();
		HttpURLConnection httpc=(HttpURLConnection) huc;
		if(httpc.getResponseCode()==HttpURLConnection.HTTP_OK){
			InputStream is=httpc.getInputStream();
			BufferedInputStream bis=new BufferedInputStream(is);
			
			OutputStream out=null;
			out=new FileOutputStream("6.pdf");
			BufferedOutputStream bos=new BufferedOutputStream(out);
			byte input[]=new byte[100];
			while(bis.read(input)!=-1){
				bos.write(input);
			}
			bos.close();
			out.close();
			bis.close();
			is.close();
			System.out.println("done");
		}
		else{
			System.out.println("获取数据失败！");
		}
		
    	
		/*
		 * 一句就可以
		 */
//		FileUtils.copyURLToFile(new URL("http://www.madore.org/~david/math/padics.pdf"), new File("newfile.pdf"));
		
		
		/**
		 * 拷贝
		 */
		
//		FileUtils.copyURLToFile(new URL("http://www.madore.org/~david/math/padics.pdf"), new File("newfile.pdf"));
//		FileInputStream fis=new FileInputStream("newfile.pdf");
//		FileOutputStream fos=new FileOutputStream("2.pdf");
//		
//		BufferedInputStream bis=new BufferedInputStream(is);
//		BufferedOutputStream bos=new BufferedOutputStream(fos);
//		byte input[]=new byte[1024];
//		while (bis.read(input)!=-1){
//			bos.write(input);
//		}
//	   bos.close();
//	   bis.close();
//	   fos.close();
////	   fis.close();
//	   System.out.println("done");
    }
}
