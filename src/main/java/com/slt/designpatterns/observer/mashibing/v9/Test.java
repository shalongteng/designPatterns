package com.slt.designpatterns.observer.mashibing.v9;

import java.util.ArrayList;
import java.util.List;


public class Test {
	public static void main(String[] args) {
		Button b = new Button();
		b.addActionListener(new MyActionListener());
		b.addActionListener(new MyActionListener2());
		//模拟 键盘按下 事件
		b.buttonPressed();
	}
}

class Button {
	private List<ActionListener> actionListeners = new ArrayList<ActionListener>();

	public void buttonPressed() {
		ActionEvent e = new ActionEvent(System.currentTimeMillis(),this);
		for(int i=0; i<actionListeners.size(); i++) {
			ActionListener l = actionListeners.get(i);
			l.actionPerformed(e);
		}
	}

	public void addActionListener(ActionListener l) {
		actionListeners.add(l);
	}
}

interface ActionListener {
	public void actionPerformed(ActionEvent e);
}

class MyActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("button pressed!");
	}

}

class MyActionListener2 implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("button pressed 2!");
	}

}

/**
 * 很多事件 根据事件源对象不同  处理方法不同
 */
class ActionEvent {
	long when;
	Object source;

	public ActionEvent(long when, Object source) {
		super();
		this.when = when;
		this.source = source;
	}

	public long getWhen() {
		return when;
	}

	public Object getSource() {
		return source;
	}
}
