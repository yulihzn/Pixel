package com.pixel.org;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Crawler extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 300;
    public static final int X_LOCATION = 100;
    public static final int Y_LOCATION = 50;
    
    //把节目分为上中三个Panel
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    
    //输入
    JTextField txtField = new JTextField(30);
    JLabel labelURL = new JLabel("image directory: ", JLabel.RIGHT);    
    //输出
    JTextArea txtArea = new JTextArea(6,40);
    JLabel labelTxt = new JLabel("Result");
    
    //按钮
    JButton startButton = new JButton("start");
    JButton cancelButton = new JButton("cancel");

    
    
    public void launchFrame() throws Exception{        
        //界面初始化
        this.setLocation(X_LOCATION, Y_LOCATION);
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(new GridLayout(3,1)); //总体为三行一列布局
        this.add(northPanel);
        this.add(centerPanel);
        this.add(southPanel);
        
        northPanel.add(labelURL);
        northPanel.add(txtField);
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(labelTxt);
        centerPanel.add(txtArea);
        southPanel.setLayout(new FlowLayout());
        southPanel.add(startButton);
        southPanel.add(cancelButton);
    
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text = txtField.getText();
                ReadColorTest rc = new ReadColorTest();
        		try {
					rc.getImagePixel(text);
					txtArea.setText(text+"导出成功");
				} catch (Exception e1) {
					txtArea.setText(e1.toString());
					e1.printStackTrace();
				}
            }
        });    
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtArea.setText("");
            }
        });    
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing (WindowEvent e){
                System.exit(0);
            }
        });    
    }
    
    public static void main(String[] args)throws Exception {
         new Crawler().launchFrame();
    }
    
}
