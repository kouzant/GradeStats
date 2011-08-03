package gui;

import static util.SwingConsole.run;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import business.Main;

public class SwingMain extends JFrame{
	private JTextField urlField = new JTextField(25);
	private JTextArea board = new JTextArea(30,30);
	private JButton button = new JButton("Go");
	private String url;
	class UrlListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			url = urlField.getText();
			StringBuilder results = Main.compute(url);
			board.setText(results.toString());
		}
	}
	
	public SwingMain(){
		UrlListener listener = new UrlListener();
		button.addActionListener(listener);
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(new JLabel("Enter desired url"));
		panel.add(urlField);
		panel.add(button);
		add(BorderLayout.NORTH, panel);
		add(new JScrollPane(board));
		urlField.setText("url");
	}
	public static void main(String args[]){
		run(new SwingMain(), 500, 500);
	}
}
