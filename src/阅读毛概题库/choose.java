package 阅读毛概题库;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
//文件选择器界面，调用JFileChooser.showOpenDialog返回一个文件
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