package com.sx.frame;
import com.sx.DBC.SearchUser;
import com.sx.User.User;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField uname;
	private JPasswordField upass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 623, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(135, 196, 141, 70);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u5B66\u53F7/\u5DE5\u53F7\uFF1A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(135, 116, 141, 70);
		frame.getContentPane().add(label);
		
		uname = new JTextField();
		uname.setBounds(286, 132, 174, 43);
		frame.getContentPane().add(uname);
		uname.setColumns(10);
		
		JButton LoginButton = new JButton("\u767B\u5F55");
		LoginButton.addActionListener(e -> {
			User user = new User();
			user.setUid(uname.getText());
			user.setUpass(upass.getText());
			if (user.getUid().equals("") || user.getUpass().equals(""))
			{
				 JOptionPane.showMessageDialog(null, "请输入用户名或密码");
			}
			else{
				SearchUser search = new SearchUser(user);
				int result =  search.S();
				System.out.println("身份类型："+result);
				switch (result){
					case 1: new Manager(user); frame.dispose();break;
					case 2: new Teacher(user); frame.dispose();break;
					case 3: new Student(user); frame.dispose();break;
					case 10:JOptionPane.showMessageDialog(null,"用户名不存在");break;
					case 11:JOptionPane.showMessageDialog(null,"密码错误");break;
				}
			}
		});

		LoginButton.setFont(new Font("宋体", Font.PLAIN, 20));
		LoginButton.setBounds(135, 297, 141, 51);
		frame.getContentPane().add(LoginButton);
		
		JButton LoginDispose = new JButton("\u9000\u51FA");
		//取消 按钮；退出系统
		LoginDispose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		LoginDispose.setFont(new Font("宋体", Font.PLAIN, 20));
		LoginDispose.setBounds(342, 297, 141, 51);
		frame.getContentPane().add(LoginDispose);
		
		upass = new JPasswordField();
		upass.setBounds(286, 210, 174, 48);
		frame.getContentPane().add(upass);
	}
}
