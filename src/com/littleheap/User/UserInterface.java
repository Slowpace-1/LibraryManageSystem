package com.littleheap.User;

import javax.swing.JPanel;

import com.littleheap.MainInterface;
import com.littleheap.Static.Information;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UserInterface extends JPanel implements ActionListener{
	private JButton back;
	private JLabel label;
	private static JLabel lb_user;
	private JButton btn_return;
	private JButton btn_borrow;

	/**
	 * Create the panel.
	 */
	public UserInterface() {
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("����", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);
		
		label = new JLabel("\u7528\u6237\u754C\u9762");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("����", Font.BOLD, 40));
		label.setBounds(512, 47, 294, 105);
		add(label);
		
		lb_user = new JLabel("New label");
		lb_user.setHorizontalAlignment(SwingConstants.CENTER);
		lb_user.setFont(new Font("����", Font.BOLD, 28));
		lb_user.setBounds(944, 0, 356, 56);
		add(lb_user);
		
		btn_borrow = new JButton("\u501F\u4E66");
		btn_borrow.setFont(new Font("����", Font.BOLD, 40));
		btn_borrow.setBounds(269, 233, 280, 505);
		add(btn_borrow);
		btn_borrow.addActionListener(this);
		
		btn_return = new JButton("\u8FD8\u4E66");
		btn_return.setFont(new Font("����", Font.BOLD, 40));
		btn_return.setBounds(740, 233, 280, 505);
		add(btn_return);
		btn_return.addActionListener(this);

	}

	public static void setUser() {
		lb_user.setText("��ǰ�û���"+Information.user);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			MainInterface.UsertoMain();
		}else if(e.getSource() == btn_borrow){
			MainInterface.UsertoBorrow();
		}else if(e.getSource() == btn_return) {
			MainInterface.UsertoReturn();
		}
	}
}