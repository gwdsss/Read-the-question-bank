package �Ķ�ë�����;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
//�ļ�ѡ�������棬����JFileChooser.showOpenDialog����һ���ļ�
public class choose extends JFrame{
	private File file=null;
	public choose(){
		super();
		JFileChooser fc=new JFileChooser();
		if(fc.showOpenDialog(this)==0)
			file=fc.getSelectedFile();
	}
	public File _file(){
		return file;
	}
}