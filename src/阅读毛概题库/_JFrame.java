package �Ķ�ë�����;

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
	//����������
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
	//���ݹ̶���ʽ��ȡ������
	private void read(){
		count++;
		try {
			a1=null;a2=null;a3=null;a4=null;re=null;all="";//����
			for(;(s=br.readLine())!=null;){
				if(!s.equals("\r\n")){
					if(s.startsWith("1")||s.startsWith("2")||s.startsWith("3")||s.startsWith("4")||s.startsWith("5")||
							s.startsWith("6")||s.startsWith("7")||s.startsWith("8")||s.startsWith("9")){
						que=s;
					}
					if(s.startsWith("A")||s.startsWith("��")){//����
						a1=s;
					}
					if(s.startsWith("B")||s.startsWith("��")){
						a2=s;
					}
					if(s.startsWith("C")||s.startsWith("��")){
						a3=s;
					}
					if(s.startsWith("D")||s.startsWith("��")){
						a4=s;
					}
					if(s.startsWith("��")){
						restr=s;
						re="";
						for(int i=3;i<s.length();i++){
							switch(s.charAt(i)){
							case'A':re+="A";break;
							case'B':re+="B";break;
							case'C':re+="C";break;
							case'D':re+="D";break;
							case'��':re+="��";all=que+"\n\t\t\t\t"+"["+count+"]"+restr;return;
							case'��':re+="��";all=que+"\n\t\t\t\t"+"["+count+"]"+restr;return;
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
	//������
	public _JFrame(String fp){
		super("ë��"+fp);
		this.setSize(650, 450);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		try {
			br=_JFrame._br(fp);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "�ļ��򲻿���");
		}
		this.read();
		ta=new JTextArea(all);
		ta.setFont(new Font("����",1,20));
		ta.setEditable(false);
		ta.setLineWrap(true);
		JScrollPane sp=new JScrollPane(ta);
		this.getContentPane().add(sp);
		JButton bu=new JButton("��һ��");
		bu.addActionListener(this);
		this.getContentPane().add(bu,"East");
		this.setVisible(true);
	}
	//�¼�������
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��һ��")){
			this.read();
			this.ta.setText(all);
		}
	}
	//��fp�ļ�����BufferedReader
	public static BufferedReader _br(String fp) throws IOException{
		BufferedReader br=null;
		FileInputStream fis=new FileInputStream(fp);
		InputStreamReader isr=new InputStreamReader(fis/*,"UTF-8"*/);
		br=new BufferedReader(isr);
		return br;
	}
}