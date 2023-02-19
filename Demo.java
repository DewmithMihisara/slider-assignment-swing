import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Slider extends JFrame {
	private JSlider sldr;
	private JPanel sldrPnl;
	static int value;
	
	Slider(int length) {
		initComponents(length);
	}
	void initComponents(int length) {
		setSize(200, 250);
		setTitle("Slider " +length);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		sldrPnl = new JPanel();
		sldr = new JSlider(JSlider.VERTICAL, 10, 50, 25);
		sldr.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sldr.setValue(value);
		
		sldr.addChangeListener((event) -> {
			if (!sldr.getValueIsAdjusting()) {
				value = sldr.getValue();

				for (int i = 0; i < MainWindow.sliderAr.length; i++) {
					MainWindow.sliderAr[i].sldr.setValue(value);	
				}
			}
		});

		sldrPnl.add(sldr);
		add(sldrPnl);
	}
}

class MainWindow extends JFrame {
	private JButton b1;
	private JPanel btnPnl;
	static Slider[] sliderAr;
	
	MainWindow() {
		initComponents();
	}
	
	void extendsArray() {
		Slider[] temp = new Slider[sliderAr.length + 1];
		for (int i = 0; i < sliderAr.length; i++) {
			temp[i] = sliderAr[i];
		}
		sliderAr = temp;
	}
	
	void initComponents() {
		setSize(200, 100);
		setTitle("Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		sliderAr = new Slider[0];
		
		btnPnl=new JPanel();
		b1= new JButton("Create");
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		b1.addActionListener((event) -> {
			extendsArray();
			
			Slider c1 = new Slider(sliderAr.length);
			sliderAr[sliderAr.length - 1] = c1;

			c1.setVisible(true);
		});
		
		btnPnl.add(b1);
		add(btnPnl,BorderLayout.CENTER);
	}
}

class Demo {
	public static void main(String args[]) {
		new MainWindow().setVisible(true);
	}	
}
