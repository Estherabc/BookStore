package com.njit;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class registerframe extends JFrame{
	private JTextField username;
	private JPasswordField password,passwordagain;
	private JRadioButton sexfemale,sexmale;
	private JPanel sex,birth,fav;
	private JTextField year;
	private JComboBox month,day;
	private JCheckBox f1,f2,f3;
	private JButton register,cancel;
	private JTextArea remmond;
	private JScrollPane scroll;
	public registerframe() {
		super();
		this.setSize(450,400);
		this.setTitle("Login");
		this.setLocationRelativeTo(getOwner());  //居中
		//设置组件布局
		Container contain=getContentPane();
		contain.setLayout(new BoxLayout(contain,BoxLayout.Y_AXIS));
		//添加组件
		//-----------begin---------------
		JPanel cont =new JPanel(new GridLayout(6,2));
		//用户名
		cont.add(new JLabel("用户名"));
		username =new JTextField(10);
		cont.add(username);
		//密码
		cont.add(new JLabel("密码"));
		password =new JPasswordField(10);
		cont.add(password);
		//再输一次密码
		cont.add(new JLabel("再输一次密码"));
		passwordagain =new JPasswordField(10);
		cont.add(passwordagain);
		//性别
		cont.add(new JLabel("性别"));
		sexmale=new JRadioButton("男",true);
		sexfemale =new JRadioButton("女");
		ButtonGroup bg=new ButtonGroup();
		bg.add(sexmale);
		bg.add(sexfemale);
		sex=new JPanel(new GridLayout(1,2));
		sex.add(sexmale);
		sex.add(sexfemale);
		cont.add(sex);
		//出生日期
		cont.add(new JLabel("出生日期"));
		year=new JTextField(4);
		month=new JComboBox();
		int i;
		for(i=1;i<=12;i++)
			month.addItem(i);
		day=new JComboBox();
		for(i=1;i<=31;i++)
			day.addItem(i);
		birth=new JPanel();
		birth.add(year);
		birth.add(new JLabel("-"));
		birth.add(month);
		birth.add(new JLabel("-"));
		birth.add(day);
		cont.add(birth);
		//爱好
		cont.add(new JLabel("爱好"));
		f1=new JCheckBox("运动");
		f2=new JCheckBox("看电影");
		f3=new JCheckBox("阅读");
		fav=new JPanel();
		fav.add(f1);
		fav.add(f2);
		fav.add(f3);
		cont.add(fav);
		//简历
		JPanel cont1=new JPanel(new GridLayout(1,2));
		cont1.add(new JLabel("简历"));
		remmond =new JTextArea(5,10);
		scroll=new JScrollPane(remmond);
		cont1.add(scroll);
		//按钮
		JPanel cont2=new JPanel(new GridLayout(1,2));
		register=new JButton("注册");
		cancel=new JButton("取消");
		cont2.add(register);
		cont2.add(cancel);
		//加入到内容面板
		contain.add(cont);
		contain.add(cont1);
		contain.add(cont2);
		
		//注册监听器
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//register事件处理：
				String pass=new String(password.getPassword());
				String passagain=new String(passwordagain.getPassword());
				if(passagain.equals(pass)) {
					//输出注册信息
					String s;
					s="用户名："+username.getText()+"\n";
					s+="密码："+pass+"\n";
					s+="性别："+(sexmale.isSelected()?sexmale.getText():sexfemale.getText())+"\n";
		            s+="出生日期："+year.getText()+"-"+month.getSelectedItem()+"-"+day.getSelectedItem()+"\n";
		            s+="爱好："+(f1.isSelected()?f1.getText():"")+(f2.isSelected()?f2.getText():"")+(f3.isSelected()?f3.getText():"")+"\n";
				    s+="简历："+remmond.getText();
				    JOptionPane.showMessageDialog(null, s);
				}
				else {
					JOptionPane.showMessageDialog(null, "密码不一致！");
				}
			}
		});
		//-----------------end--------------------
	}
	
	public static void main(String[] args) {
		registerframe w=new registerframe();
		w.setVisible(true);
	}
}