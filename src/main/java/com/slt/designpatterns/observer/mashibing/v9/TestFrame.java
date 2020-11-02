package com.slt.designpatterns.observer.mashibing.v9;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFrame extends Frame {
	public void launch() {
		//事件源
		Button button = new Button("press me");
		//给 观察者list 初始化
		button.addActionListener(new MyActionListener());
		button.addActionListener(new MyActionListener2());
		this.add(button);//把button 加到 窗口里
		this.pack();//按钮多大 窗口就多大

		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		this.setLocation(400, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestFrame().launch();
	}

	/**
	 * Observer 观察者
	 */
	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			((Button)e.getSource()).setLabel("press me again!");
			System.out.println("button pressed!");
		}

	}

	private class MyActionListener2 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println("button pressed 2!");
		}

	}
}
