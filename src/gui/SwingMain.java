/*
   Copyright (C) 2011
   Kouzoupis Antonis
   
   This file is part of GradeStats.
 
    GradeStats is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as 
    published by the Free Software Foundation, either version 3 of the 
    License, or (at your option) any later version.

    GradeStats is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with GradeStats.  If not, see <http://www.gnu.org/licenses/>.
 */
package gui;

import static util.SwingConsole.run;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import business.Compute;

public class SwingMain extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField urlField = new JTextField(25);
	private JTextArea board = new JTextArea(8,10);
	private JButton button = new JButton("Go");
	private String url;
	class UrlListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			url = urlField.getText();
			StringBuilder results = Compute.compute(url);
			board.setText(results.toString());
		}
	}
	
	public SwingMain(){
		UrlListener listener = new UrlListener();
		button.addActionListener(listener);
		urlField.addActionListener(listener);
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(new JLabel("Enter desired url:"));
		panel.add(urlField);
		panel.add(button);
		add(BorderLayout.NORTH, panel);
		add(new JScrollPane(board));
		urlField.requestFocusInWindow();
	}
	public static void main(String args[]){
		run(new SwingMain(), 500, 150);
	}
}
