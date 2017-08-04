package test;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFirstApplet extends JApplet {

	private static final long serialVersionUID = 1L;

	public void init() {
		JLabel jl = new JLabel("hello,applet!", SwingConstants.CENTER);
		add(jl);
	}
}
