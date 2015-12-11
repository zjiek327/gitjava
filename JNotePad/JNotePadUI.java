
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;




public class JNotePadUI extends JFrame {

	private JMenu editMenu;
	private JPopupMenu popUpMenu;
	private JMenuItem menuOpen;
	private JMenuItem menuSave;
	private JMenuItem menuClose;
	private JMenuItem menuSaveAs;
	private JMenuItem menuCut;
	private JMenuItem menuCopy;
	private JMenuItem menuPaste;
	private JMenuItem menuAbout;
	private JTextArea textArea;
	public JNotePadUI (){
		super("新建文本文件");
		setUpUIComponent();
		setUpEventListener();
		setVisible(true);

	}




	private void setUpUIComponent() {
		// TODO Auto-generated method stub

		setSize(640,480);
		//菜单栏
		JMenuBar menuBar = new JMenuBar() ;
		//设置“文件”菜单
		JMenu fileMenu = new JMenu("文件");
		this.menuOpen = new JMenuItem("打开");

		//快捷键设置
		menuOpen.setAccelerator(
				KeyStroke.getKeyStroke(
					KeyEvent.VK_O,
					InputEvent.CTRL_MASK));
		this.menuSave =new JMenuItem ("保存");
		menuSave.setAccelerator(
				KeyStroke.getKeyStroke(
					KeyEvent.VK_S,
					InputEvent.CTRL_MASK));
		this.menuSaveAs =new JMenuItem ("另存为");
		this.menuClose =new JMenuItem ("关闭");
		menuClose.setAccelerator(
				KeyStroke.getKeyStroke(
					KeyEvent.VK_Q,
					InputEvent.CTRL_MASK));


		fileMenu.add(menuOpen);
		fileMenu.addSeparator();  //分割线
		fileMenu.add(menuSave);
		fileMenu.add(menuSaveAs);
		fileMenu.addSeparator(); //分割线
		fileMenu.add(menuClose);

		//设置编辑菜单
		JMenu editMenu = new JMenu("编辑");
		this.menuCut = new JMenuItem("剪切");
		menuCut.setAccelerator(
				KeyStroke.getKeyStroke(
					KeyEvent.VK_X,
					InputEvent.CTRL_MASK));
		this.menuCopy = new JMenuItem("复制");
		menuCut.setAccelerator(
				KeyStroke.getKeyStroke(
					KeyEvent.VK_C,
					InputEvent.CTRL_MASK));
		this.menuPaste = new JMenuItem("粘贴");
		menuPaste.setAccelerator(
				KeyStroke.getKeyStroke(
					KeyEvent.VK_V,
					InputEvent.CTRL_MASK));
		editMenu.add(menuCut);
		editMenu.add(menuCopy);
		editMenu.add(menuPaste);

		//设置关于菜单
		JMenu aboutMenu = new JMenu("关于");
		this.menuAbout = new JMenuItem ("关于JNotePad");
		aboutMenu.add(menuAbout);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		setJMenuBar(menuBar);
		//文字编辑区域
		this.textArea =new JTextArea();
		textArea.setFont(new Font ("宋体",Font.PLAIN,16));
		textArea.setLineWrap(true);
		JScrollPane panel = new JScrollPane(textArea,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
		);
		Container contentPane = getContentPane ();
		contentPane.add(panel,BorderLayout.CENTER);


		//状态栏
		JLabel stateBar = new JLabel("未修改");
		stateBar.setHorizontalAlignment(SwingConstants.LEFT);
		stateBar.setBorder(
				BorderFactory.createEtchedBorder());
		contentPane.add(stateBar,BorderLayout.SOUTH);

		popUpMenu =editMenu.getPopupMenu();

	}

	private void setUpEventListener() {
		// 单击窗口关闭按钮事件处理
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					closeFile();
				}
			}
		);
		//菜单-打开
		menuOpen.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					openFile();
				}
			}
		);
		//菜单-保存
		menuSave.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					saveFile();
				}
			}
		);

		//菜单-另存为
		menuSaveAs.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					saveFileAs();
				}
			}
		);
		//菜单-关闭文件
		menuClose.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					closeFile();
				}
			}
		);
		//菜单-剪切
		menuCut.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					cut();
				}
			}
		);
		//菜单-复制
		menuCopy.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					copy();
				}
			}
		);
		//菜单-粘贴
		menuPaste.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					paste();
				}
			}
		);
		//菜单-关于
		menuAbout.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
				//显示对话框
				JOptionPane.showOptionDialog(null,
					"程序名称:\n JNotePad \n" +
					"程序设计：\n WCS\n " +
					"简介：\n" +
					"  实验对象" +
					"欢迎下载" +
					"http://www.google.com" ,
					"关于JNotePad",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,null,null

					);                        
				}

			}
		);
		//编辑键盘事件
		textArea.addKeyListener(
			new KeyAdapter(){
				public void keyTyped(KeyEvent e){
					processTextArea();
				}
			}
		);
		//编辑鼠标事件
		textArea.addMouseListener(
			new MouseAdapter(){
				public void mouseReleased(MouseEvent e){
					if(e.getButton()== MouseEvent.BUTTON3)
						popUpMenu.show(editMenu,e.getX(),e.getY());
				}
				public void mouseClicked(MouseEvent e){
					if(e.getButton()== MouseEvent.BUTTON1)
						popUpMenu.setVisible(false);
				}
			}
		);

	}

	protected void processTextArea() {

	}

	protected void paste() {

	}

	protected void copy() {

	}

	protected void cut() {

	}

	protected void saveFileAs() {

	}

	protected void saveFile() {

	}

	protected void openFile() {

	}

	protected void closeFile() {

	}  

	public static void main(String[] args) {
		new JNotePadUI();
	}

}

