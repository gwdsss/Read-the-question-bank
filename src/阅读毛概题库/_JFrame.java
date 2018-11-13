package 阅读毛概题库;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class _JFrame extends JFrame implements ActionListener{
	//运行主界面
	public static void main(String[] args) {
		String fp=null;
		try{
			fp=new choose()._file().getAbsolutePath();
		}catch(NullPointerException e){
			System.exit(0);
		}
		new _JFrame(fp);
	}
	private JTextArea ta;
	BufferedReader  br;
	String s=null,que,a1,a2,a3,a4,re,restr,all;
	int count=0;
	//根据固定格式读取。。。
	private void read(){
		count++;
		try {
			a1=null;a2=null;a3=null;a4=null;re=null;all="";//重置
			for(;(s=br.readLine())!=null;){
				if(!s.equals("\r\n")){
					if(s.startsWith("1")||s.startsWith("2")||s.startsWith("3")||s.startsWith("4")||s.startsWith("5")||
							s.startsWith("6")||s.startsWith("7")||s.startsWith("8")||s.startsWith("9")){
						que=s;
					}
					if(s.startsWith("A")||s.startsWith("Ａ")){//粗略
						a1=s;
					}
					if(s.startsWith("B")||s.startsWith("Ｂ")){
						a2=s;
					}
					if(s.startsWith("C")||s.startsWith("Ｃ")){
						a3=s;
					}
					if(s.startsWith("D")||s.startsWith("Ｄ")){
						a4=s;
					}
					if(s.startsWith("答案")){
						restr=s;
						re="";
						for(int i=3;i<s.length();i++){
							switch(s.charAt(i)){
							case'A':re+="A";break;
							case'B':re+="B";break;
							case'C':re+="C";break;
							case'D':re+="D";break;
							case'是':re+="是";all=que+"\n\t\t\t\t"+"["+count+"]"+restr;return;
							case'否':re+="否";all=que+"\n\t\t\t\t"+"["+count+"]"+restr;return;
							}
						}
						all=all+que+"\n";
						for(int i=0;i<re.length();i++){
							switch(re.charAt(i)){
							case'A':all=all+a1+"\n";break;
							case'B':all=all+a2+"\n";break;
							case'C':all=all+a3+"\n";break;
							case'D':all=all+a4+"\n";break;
							}
						}
						all=all+"\t\t\t\t"+"["+count+"]"+restr;
						return;
					}
				}
				
			}
		} catch (IOException e) {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	//主界面
	public _JFrame(String fp){
		super("毛概"+fp);
		this.setSize(650, 450);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		try {
			br=_JFrame._br(fp);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "文件打不开！");
		}
		this.read();
		ta=new JTextArea(all);
		ta.setFont(new Font("楷体",1,20));
		ta.setEditable(false);
		ta.setLineWrap(true);
		JScrollPane sp=new JScrollPane(ta);
		this.getContentPane().add(sp);
		JButton bu=new JButton("下一题");
		bu.addActionListener(this);
		this.getContentPane().add(bu,"East");
		this.setVisible(true);
	}
	//事件监听器
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("下一题")){
			this.read();
			this.ta.setText(all);
		}
	}
	//打开fp文件反回BufferedReader
	public static BufferedReader _br(String fp) throws IOException{
		BufferedReader br=null;
		FileInputStream fis=new FileInputStream(fp);
		InputStreamReader isr=new InputStreamReader(fis/*,"UTF-8"*/);
		br=new BufferedReader(isr);
		return br;
	}
}