package com.nt.test;

import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CoreJavaI18nTest {

	public static void main(String[] args) {
	    Locale locale=null;
	    ResourceBundle bundle=null;
	    String title=null;
	    String cap1=null,cap2=null,cap3=null;
	    JFrame frame=null;
	    JButton btn1=null,btn2=null,btn3=null;
	    long  regFee=102006008;
	    String fRegFee=null;
	    NumberFormat nFormat=null;
	    JLabel  label1=null,label2=null;
	    String fDate=null;
	    DateFormat dFormat=null;
	    //prepare Locale object
	    locale=new Locale(args[0],args[1]);
	    //Create ResourceBundler object having Locale
	    bundle=ResourceBundle.getBundle("com/nt/commons/App",locale);
	    //get Messages
	    title=bundle.getString("screen.title");
	    cap1=bundle.getString("btn1.cap");
	    cap2=bundle.getString("btn2.cap");
	    cap3=bundle.getString("btn3.cap");
	    //get Fomated Number
	    nFormat=NumberFormat.getInstance(locale);
	    fRegFee=nFormat.format(regFee);
	    //get Formated Date
	    dFormat=DateFormat.getDateInstance(DateFormat.SHORT,locale);
	    fDate=dFormat.format(new Date());
	    
	    
	    //create Frame window
	    frame=new JFrame();
	    frame.setTitle(title);
	    frame.setSize(200, 200);
	    frame.setLayout(new FlowLayout());
	    
	    //add Comps
	    label1=new JLabel(fRegFee);
	    frame.add(label1);
	    btn1=new JButton(cap1);
	    frame.add(btn1);
	    btn2=new JButton(cap2);
	    frame.add(btn2);
	    btn3=new JButton(cap3);
	    frame.add(btn3);
	    label2=new JLabel(fDate);
	    frame.add(label2);
	    
	    
	    
	    frame.pack();
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//main
}//class
