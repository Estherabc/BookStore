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
		this.setLocationRelativeTo(getOwner());  //����
		//�����������
		Container contain=getContentPane();
		contain.setLayout(new BoxLayout(contain,BoxLayout.Y_AXIS));
		//������
		//-----------begin---------------
		JPanel cont =new JPanel(new GridLayout(6,2));
		//�û���
		cont.add(new JLabel("�û���"));
		username =new JTextField(10);
		cont.add(username);
		//����
		cont.add(new JLabel("����"));
		password =new JPasswordField(10);
		cont.add(password);
		//����һ������
		cont.add(new JLabel("����һ������"));
		passwordagain =new JPasswordField(10);
		cont.add(passwordagain);
		//�Ա�
		cont.add(new JLabel("�Ա�"));
		sexmale=new JRadioButton("��",true);
		sexfemale =new JRadioButton("Ů");
		ButtonGroup bg=new ButtonGroup();
		bg.add(sexmale);
		bg.add(sexfemale);
		sex=new JPanel(new GridLayout(1,2));
		sex.add(sexmale);
		sex.add(sexfemale);
		cont.add(sex);
		//��������
		cont.add(new JLabel("��������"));
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
		//����
		cont.add(new JLabel("����"));
		f1=new JCheckBox("�˶�");
		f2=new JCheckBox("����Ӱ");
		f3=new JCheckBox("�Ķ�");
		fav=new JPanel();
		fav.add(f1);
		fav.add(f2);
		fav.add(f3);
		cont.add(fav);
		//����
		JPanel cont1=new JPanel(new GridLayout(1,2));
		cont1.add(new JLabel("����"));
		remmond =new JTextArea(5,10);
		scroll=new JScrollPane(remmond);
		cont1.add(scroll);
		//��ť
		JPanel cont2=new JPanel(new GridLayout(1,2));
		register=new JButton("ע��");
		cancel=new JButton("ȡ��");
		cont2.add(register);
		cont2.add(cancel);
		//���뵽�������
		contain.add(cont);
		contain.add(cont1);
		contain.add(cont2);
		
		//ע�������
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//register�¼�����
				String pass=new String(password.getPassword());
				String passagain=new String(passwordagain.getPassword());
				if(passagain.equals(pass)) {
					//���ע����Ϣ
					String s;
					s="�û�����"+username.getText()+"\n";
					s+="���룺"+pass+"\n";
					s+="�Ա�"+(sexmale.isSelected()?sexmale.getText():sexfemale.getText())+"\n";
		            s+="�������ڣ�"+year.getText()+"-"+month.getSelectedItem()+"-"+day.getSelectedItem()+"\n";
		            s+="���ã�"+(f1.isSelected()?f1.getText():"")+(f2.isSelected()?f2.getText():"")+(f3.isSelected()?f3.getText():"")+"\n";
				    s+="������"+remmond.getText();
				    JOptionPane.showMessageDialog(null, s);
				}
				else {
					JOptionPane.showMessageDialog(null, "���벻һ�£�");
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