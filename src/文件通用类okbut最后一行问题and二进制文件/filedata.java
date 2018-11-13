package 文件通用类okbut最后一行问题and二进制文件;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//简化过的文件处理类
public class filedata {
	public static void main(String[] args) {//测试
		String fp="src\\002.txt";
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.print(filedata.readfromtxt(fp));
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
	}
	public static String readfromnew(String txtfp){//compressed.length()+"位"
		BufferedReader br=filedata._br(txtfp);
		String s="";
		try {
			s+=br.readLine();
			br.close();
		} catch (IOException e) {
		}
		return s;
	}
	//读取一个txt文件，读完一行加一个\r\n即可，转化为了一个String
	public static String readfromtxt(String txtfp){//compressed.length()+"位"
		BufferedReader br=filedata._br(txtfp);
		String line=null,text="";
		int _line=filedata._line(txtfp);//解决最后一行是否换行 少(多)一行？？
		try {
			for(int i=0;i<_line-1;i++){
				line=br.readLine();
				text+=line;
				text+="\r\n";
			}
			line=br.readLine();
			text+=line;
//			text+="\r\n";
			br.close();
		} catch (IOException e) {
			
		}
		return text;
	}
	//打开fp文件反回BufferedReader
	public static BufferedReader _br(String fp){
		BufferedReader br=null;
		try {
			FileInputStream fis=new FileInputStream(fp);
			InputStreamReader isr=new InputStreamReader(fis/*,"UTF-8"*/);
			br=new BufferedReader(isr);
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("1");
		}
		catch (IOException e3) {
			e3.printStackTrace();
			System.out.println("3");
		}
		return br;
	}
	//对fp文件创建BufferedWriter
	public static BufferedWriter _bw(String fp){
		BufferedWriter bw=null;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fp);
			OutputStreamWriter ow=new OutputStreamWriter(fos);
			bw=new BufferedWriter(ow);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bw;
	}
	//返回文件行数line
	public static int _line(String fp){
		BufferedReader br=filedata._br(fp);
		int i=0;
		try {
			while(br.readLine()!=null){
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("filedata_line_关闭失败");
		}
		return i;
	}
}
