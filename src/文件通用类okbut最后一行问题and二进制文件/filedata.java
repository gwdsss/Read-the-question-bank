package �ļ�ͨ����okbut���һ������and�������ļ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//�򻯹����ļ�������
public class filedata {
	public static void main(String[] args) {//����
		String fp="src\\002.txt";
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.print(filedata.readfromtxt(fp));
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
	}
	public static String readfromnew(String txtfp){//compressed.length()+"λ"
		BufferedReader br=filedata._br(txtfp);
		String s="";
		try {
			s+=br.readLine();
			br.close();
		} catch (IOException e) {
		}
		return s;
	}
	//��ȡһ��txt�ļ�������һ�м�һ��\r\n���ɣ�ת��Ϊ��һ��String
	public static String readfromtxt(String txtfp){//compressed.length()+"λ"
		BufferedReader br=filedata._br(txtfp);
		String line=null,text="";
		int _line=filedata._line(txtfp);//������һ���Ƿ��� ��(��)һ�У���
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
	//��fp�ļ�����BufferedReader
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
	//��fp�ļ�����BufferedWriter
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
	//�����ļ�����line
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
			System.out.println("filedata_line_�ر�ʧ��");
		}
		return i;
	}
}
