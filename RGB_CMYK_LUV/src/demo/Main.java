package demo;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

public class Main {
	private JFrame frame;
	Integer red = 0, green = 0, blue = 0;
	Integer cyan = 255, magenta = 255, yellow = 255, black = 255;
	Integer h = 0, s = 0, v = 100;
	final Double X = 95.047, Y = 100.0, Z = 108.883;
	Integer x = 0, y = 0, z = 0;
	Integer L = 0, U = 0, V = 0;
	JButton button;
	private JTextField textFieldR, textFieldG, textFieldB;
	private JTextField textFieldC, textFieldM, textFieldY, textFieldK;
	private JTextField textFieldH, textFieldS, textFieldV;
	private JTextField textFieldL, textFieldU, textFieldv;
	private JTextField textFieldX, textFieldy, textFieldZ;
	private JSlider sliderR, sliderG, sliderB;
	private JSlider sliderC, sliderM, sliderYe;
	private JSlider sliderH, sliderS, sliderV;
	private JSlider sliderX, sliderY, sliderZ;
	private JSlider sliderL, sliderU, sliderv;
	private boolean roundR = false, roundG = false, roundB = false;
	private JLabel lblL;
	private JLabel lblU;
	private JLabel lblV_1;
	BufferedImage image;


	private void ClearRound() {
		roundB = false;
		roundG = false;
		roundR = false;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	private void slidersInit() {
		sliderR = new JSlider();
		sliderR.setValue(0);
		sliderR.setMaximum(255);
		sliderR.setBounds(37, 239, 200, 23);
		frame.getContentPane().add(sliderR);

		sliderG = new JSlider();
		sliderG.setValue(0);
		sliderG.setMaximum(255);
		sliderG.setBounds(37, 272, 200, 23);
		frame.getContentPane().add(sliderG);

		sliderB = new JSlider();
		sliderB.setValue(0);
		sliderB.setMaximum(255);
		sliderB.setBounds(37, 306, 200, 23);
		frame.getContentPane().add(sliderB);

		sliderC = new JSlider();
		sliderC.setMaximum(255);
		sliderC.setValue(255);
		sliderC.setBounds(37, 353, 200, 31);
		frame.getContentPane().add(sliderC);

		sliderM = new JSlider();
		sliderM.setMaximum(255);
		sliderM.setValue(255);
		sliderM.setBounds(37, 395, 200, 31);
		frame.getContentPane().add(sliderM);

		sliderYe = new JSlider();
		sliderYe.setMaximum(255);
		sliderYe.setValue(255);
		sliderYe.setBounds(37, 437, 200, 31);
		frame.getContentPane().add(sliderYe);

		sliderH = new JSlider();
		sliderH.setValue(0);
		sliderH.setMaximum(359);
		sliderH.setBounds(473, 11, 200, 31);
		frame.getContentPane().add(sliderH);

		sliderS = new JSlider();
		sliderS.setValue(0);
		sliderS.setBounds(473, 44, 200, 31);
		frame.getContentPane().add(sliderS);

		sliderV = new JSlider();
		sliderV.setValue(100);
		sliderV.setBounds(473, 78, 200, 31);
		frame.getContentPane().add(sliderV);

		sliderX = new JSlider();
		sliderX.setValue(0);
		sliderX.setMaximum(95);
		sliderX.setBounds(473, 316, 200, 23);
		frame.getContentPane().add(sliderX);

		sliderY = new JSlider();
		sliderY.setValue(0);
		sliderY.setBounds(473, 353, 200, 23);
		frame.getContentPane().add(sliderY);

		sliderZ = new JSlider();
		sliderZ.setMaximum(108);
		sliderZ.setValue(0);
		sliderZ.setBounds(473, 398, 200, 23);
		frame.getContentPane().add(sliderZ);

		sliderL = new JSlider();
		sliderL.setValue(0);
		sliderL.setBounds(473, 167, 200, 23);
		frame.getContentPane().add(sliderL);

		sliderU = new JSlider();
		sliderU.setValue(0);
		sliderU.setBounds(473, 201, 200, 23);
		frame.getContentPane().add(sliderU);

		sliderv = new JSlider();
		sliderv.setValue(0);
		sliderv.setBounds(473, 239, 200, 23);
		frame.getContentPane().add(sliderv);
	}

	private void refreshSliders() {
		sliderR.setValue(red);
		sliderG.setValue(green);
		sliderB.setValue(blue);
		sliderC.setValue(cyan);
		sliderM.setValue(magenta);
		sliderYe.setValue(yellow);
		sliderH.setValue(h);
		sliderS.setValue(s);
		sliderV.setValue(v);
		sliderX.setValue(x);
		sliderY.setValue(y);
		sliderZ.setValue(z);
		sliderL.setValue(L);
		sliderU.setValue(U);
		sliderv.setValue(V);
	}

	private void HSV2RGB() {
		int hi = (h / 60);
		double vmin = (100 - s) * v / 100;
		double a = (v - vmin) * ((h % 60) / 60.0);
		double vinc = vmin + a;
		double vdec = v - a;
		vmin = vmin * 255 / 100;
		vinc = vinc * 255 / 100;
		vdec = vdec * 255 / 100;
		double vi = v * 255 / 100;
		switch (hi) {
		case 0:
			red = (int) vi;
			green = (int) vinc;
			blue = (int) vmin;
			break;
		case 1:
			red = (int) vdec;
			green = (int) vi;
			blue = (int) vmin;
			break;
		case 2:
			red = (int) vmin;
			green = (int) vi;
			blue = (int) vinc;
			break;
		case 3:
			red = (int) vmin;
			green = (int) vdec;
			blue = (int) vi;
			break;
		case 4:
			red = (int) vinc;
			green = (int) vmin;
			blue = (int) vi;
			break;
		case 5:
			red = (int) vi;
			green = (int) vmin;
			blue = (int) vdec;
			break;
		}
	}

	private void rgb2hsv() {
		double r = red / 255.0;
		double g = green / 255.0;
		double b = blue / 255.0;
		double max = max(red, green, blue) / 255.0;
		double min = min(red, green, blue) / 255.0;
		double delta = max - min;
		if (delta == 0)
			h = 0;
		else if (max == r && g >= b)
			h = (int) (60 * (g - b) / delta);
		else if (max == r)
			h = (int) (60 * (g - b) / delta + 360);
		else if (max == g)
			h = (int) (60 * (b - r) / delta + 120);
		else if (max == b)
			h = (int) (60 * (r - g) / delta + 240);
		if (max == 0)
			s = 0;
		else
			s = (int) ((1 - min / max) * 100);
		v = (int) (max * 100);
	}

	private void luv2rgb() {
		double u = U / 100.0; 
        double v = V / 100.0;
        double var_Y = (L + 16) / 116.0;
        if (Math.pow(var_Y, 3) > 0.008856)
            var_Y = Math.pow(var_Y, 3);
        else
            var_Y = (var_Y - 16 / 116.0) / 7.787;

        if (v == 0)
        {
        	xyz2rgb();
            return;
        }
        y = (int) (var_Y * Y);
        x = (int) -((9 * y * u) / ((u - 4) * v - v * u));
        z = (int) ((9 * y - 15 * v * y - v * x) / (3 * v));
        xyz2rgb();
        return;
	}

	private void rgb2luv() {
		rgb2xyz();
		if (x == 0 && y == 0 && z == 0) {
			L = 0;
			U = 0;
			V = 0;
			return;
		}
		U = 100 * 4 * x / (x + 15 * y + 3 * z);
		V = 100 * 9 * y / (x + 15 * y + 3 * z);
		double y1 = y / Y;
		if (y1 <= Math.pow(6.0 / 29.0, 3))
			L = (int) (Math.pow(29.0 / 3.0, 3) * y1);
		else
			L = (int) (116 * Math.pow(y1, 1.0 / 3.0) - 16);
	}

	private void rgb2luv2(){
		rgb2xyz();
		if (x == 0 && y == 0 && z == 0) {
			L = 0;
			U = 0;
			V = 0;
			return;
		}
        double us = 4 * x / (x + 15 * y + 3 * z);
        double vs = 9 * y / (x + 15 * y + 3 * z);

        double usW = 4 * X / (X + 15 * Y + 3 * Z);
        double vsW = 9 * Y / (X + 15 * Y + 3 * Z);

        double y1 = y / Y;
		if (y1 <= Math.pow(6.0 / 29.0, 3))
			L = (int) (Math.pow(29.0 / 3.0, 3) * y1);
		else
			L = (int) (116 * Math.pow(y1, 1.0 / 3.0) - 16);

        U = (int) (13 * L * (us - usW));
        V = (int) (13 * L * (vs - vsW));
	}
	
	private void luv2rgb2(){
         double usW = 4 * X / (X + 15 * Y + 3 * Z);
         double vsW = 9 * Y / (X + 15 * Y + 3 * Z);
         double us = L == 0 ? usW : U / (13 * L) + usW;
         double vs = L == 0 ? vsW : V / (13 * L) + vsW;
         if (L <= 8)
             y = (int) (Y * L * Math.pow(3.0 / 29.0, 3));
         else
             y = (int) (Y * Math.pow((L + 16) / 116.0, 3));

         if (vs == 0){
         	xyz2rgb();
             return ;
         }
         x = (int) ((y * 9 * us) / (4 * vs));
         z = (int) (y * (12 - 3 * us - 20 * vs) / (4 * vs));
         xyz2rgb();
	}
	
	private void xyz2rgb() {
		double var_X = x / 100.0; // X from 0 to 95.047
		double var_Y = y / 100.0; // Y from 0 to 100.000
		double var_Z = z / 100.0; // Z from 0 to 108.883

		double var_R = var_X * 3.2406 + var_Y * -1.5372 + var_Z * -0.4986;
		double var_G = var_X * -0.9689 + var_Y * 1.8758 + var_Z * 0.0415;
		double var_B = var_X * 0.0557 + var_Y * -0.2040 + var_Z * 1.0570;

		if (var_R > 0.0031308)
			var_R = 1.055 * Math.pow(var_R, 1.0 / 2.4) - 0.055;
		else
			var_R = 12.92 * var_R;
		if (var_G > 0.0031308)
			var_G = 1.055 * Math.pow(var_G, 1.0 / 2.4) - 0.055;
		else
			var_G = 12.92 * var_G;
		if (var_B > 0.0031308)
			var_B = 1.055 * Math.pow(var_B, 1.0 / 2.4) - 0.055;
		else
			var_B = 12.92 * var_B;
		ClearRound();
		var_R = var_R * 255;
		var_G = var_G * 255;
		var_B = var_B * 255;
		if (var_R < 0) {
			var_R = 0;
			roundR = true;
		}
		if (var_R > 255) {
			var_R = 255;
			roundR = true;
		}
		if (var_G < 0) {
			var_G = 0;
			roundG = true;
		}
		if (var_G > 255) {
			var_G = 255;
			roundG = true;
		}
		if (var_B < 0) {
			var_B = 0;
			roundB = true;
		}
		if (var_B > 255) {
			var_B = 255;
			roundB = true;
		}
		red = (int) var_R;
		green = (int) var_G;
		blue = (int) var_B;
	}

	private void rgb2xyz() {
		double var_R = red / 255.0; 
		double var_G = green / 255.0; 
		double var_B = blue / 255.0; 

		if (var_R > 0.04045)
			var_R = Math.pow((var_R + 0.055) / 1.055, 2.4);
		else
			var_R = var_R / 12.92;
		if (var_G > 0.04045)
			var_G = Math.pow((var_G + 0.055) / 1.055, 2.4);
		else
			var_G = var_G / 12.92;
		if (var_B > 0.04045)
			var_B = Math.pow((var_B + 0.055) / 1.055, 2.4);
		else
			var_B = var_B / 12.92;

		var_R = var_R * 100;
		var_G = var_G * 100;
		var_B = var_B * 100;

		// Observer. = 2°, Illuminant = D65
		x = (int) (var_R * 0.4124 + var_G * 0.3576 + var_B * 0.1805);
		y = (int) (var_R * 0.2126 + var_G * 0.7152 + var_B * 0.0722);
		z = (int) (var_R * 0.0193 + var_G * 0.1192 + var_B * 0.9505);
	}

	private void slidersEvents() {
		sliderR.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				red = sliderR.getValue();
				button.setBackground(new Color(red, green, blue));
				refreshTFs();
				rgb2cmyk();
				rgb2hsv();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});
		sliderG.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				green = sliderG.getValue();
				button.setBackground(new Color(red, green, blue));
				refreshTFs();
				rgb2cmyk();
				rgb2hsv();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});
		sliderB.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				blue = sliderB.getValue();
				button.setBackground(new Color(red, green, blue));
				refreshTFs();
				rgb2cmyk();
				rgb2hsv();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});

		sliderC.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				recountCMYK();
				refreshTFs();
				cmyk2rgb();
				button.setBackground(new Color(red, green, blue));
				rgb2hsv();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});
		sliderM.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				recountCMYK();
				refreshTFs();
				cmyk2rgb();
				button.setBackground(new Color(red, green, blue));
				rgb2hsv();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});
		sliderYe.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				recountCMYK();
				refreshTFs();
				cmyk2rgb();
				button.setBackground(new Color(red, green, blue));
				rgb2hsv();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});

		sliderH.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				h = sliderH.getValue();
				HSV2RGB();
				refreshTFs();
				button.setBackground(new Color(red, green, blue));
				rgb2cmyk();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});
		sliderS.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				s = sliderS.getValue();
				HSV2RGB();
				refreshTFs();
				button.setBackground(new Color(red, green, blue));
				rgb2cmyk();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});
		sliderV.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				v = sliderV.getValue();
				HSV2RGB();
				refreshTFs();
				button.setBackground(new Color(red, green, blue));
				rgb2cmyk();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});

		sliderX.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				x = sliderX.getValue();
				xyz2rgb();
				refreshTFs();
				button.setBackground(new Color(red, green, blue));
				rgb2hsv();
				rgb2cmyk();
				rgb2luv();
				refreshSliders();
			}
		});
		sliderY.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				y = sliderY.getValue();
				xyz2rgb();
				refreshTFs();
				button.setBackground(new Color(red, green, blue));
				rgb2hsv();
				rgb2cmyk();
				rgb2luv();
				refreshSliders();
			}
		});
		sliderZ.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				z = sliderZ.getValue();
				xyz2rgb();
				refreshTFs();
				button.setBackground(new Color(red, green, blue));
				rgb2hsv();
				rgb2cmyk();
				rgb2luv();
				refreshSliders();
			}
		});

		sliderL.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				L = sliderL.getValue();
				luv2rgb();
				refreshTFs();
				button.setBackground(new Color(red, green, blue));
				rgb2hsv();
				rgb2cmyk();
				rgb2xyz();
				refreshSliders();
			}
		});
		sliderU.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				U = sliderU.getValue();
				luv2rgb();
				refreshTFs();
				button.setBackground(new Color(red, green, blue));
				rgb2hsv();
				rgb2cmyk();
				rgb2xyz();
				refreshSliders();
			}
		});
		sliderv.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				V = sliderv.getValue();
				luv2rgb();
				refreshTFs();
				button.setBackground(new Color(red, green, blue));
				rgb2hsv();
				rgb2cmyk();
				rgb2xyz();
				refreshSliders();
			}
		});
	}
	
	private void initTFs() {
		textFieldR = new JTextField();
		textFieldR.setText("0");
		textFieldR.setBounds(243, 239, 86, 20);
		frame.getContentPane().add(textFieldR);
		textFieldR.setColumns(10);

		textFieldG = new JTextField();
		textFieldG.setText("0");
		textFieldG.setColumns(10);
		textFieldG.setBounds(243, 273, 86, 20);
		frame.getContentPane().add(textFieldG);

		textFieldB = new JTextField();
		textFieldB.setText("0");
		textFieldB.setColumns(10);
		textFieldB.setBounds(243, 306, 86, 20);
		frame.getContentPane().add(textFieldB);

		textFieldC = new JTextField();
		textFieldC.setText("255");
		textFieldC.setColumns(10);
		textFieldC.setBounds(243, 353, 86, 20);
		frame.getContentPane().add(textFieldC);

		textFieldM = new JTextField();
		textFieldM.setText("255");
		textFieldM.setColumns(10);
		textFieldM.setBounds(243, 395, 86, 20);
		frame.getContentPane().add(textFieldM);

		textFieldY = new JTextField();
		textFieldY.setText("255");
		textFieldY.setColumns(10);
		textFieldY.setBounds(243, 437, 86, 20);
		frame.getContentPane().add(textFieldY);

		textFieldK = new JTextField();
		textFieldK.setText("255");
		textFieldK.setColumns(10);
		textFieldK.setBounds(243, 479, 86, 20);
		frame.getContentPane().add(textFieldK);

		JLabel lblR = new JLabel("R");
		lblR.setBounds(12, 239, 15, 14);
		frame.getContentPane().add(lblR);
		
		textFieldH = new JTextField();
		textFieldH.setBounds(677, 11, 86, 20);
		frame.getContentPane().add(textFieldH);
		textFieldH.setColumns(10);
		
		textFieldS = new JTextField();
		textFieldS.setColumns(10);
		textFieldS.setBounds(677, 47, 86, 20);
		frame.getContentPane().add(textFieldS);
		
		textFieldV = new JTextField();
		textFieldV.setColumns(10);
		textFieldV.setBounds(677, 84, 86, 20);
		frame.getContentPane().add(textFieldV);
		
		textFieldL = new JTextField();
		textFieldL.setColumns(10);
		textFieldL.setBounds(677, 167, 86, 20);
		frame.getContentPane().add(textFieldL);
		
		textFieldU = new JTextField();
		textFieldU.setColumns(10);
		textFieldU.setBounds(677, 201, 86, 20);
		frame.getContentPane().add(textFieldU);
		
		textFieldv = new JTextField();
		textFieldv.setColumns(10);
		textFieldv.setBounds(677, 239, 86, 20);
		frame.getContentPane().add(textFieldv);
		
		textFieldX = new JTextField();
		textFieldX.setColumns(10);
		textFieldX.setBounds(677, 319, 86, 20);
		frame.getContentPane().add(textFieldX);
		
		textFieldy = new JTextField();
		textFieldy.setColumns(10);
		textFieldy.setBounds(677, 353, 86, 20);
		frame.getContentPane().add(textFieldy);
		
		textFieldZ = new JTextField();
		textFieldZ.setColumns(10);
		textFieldZ.setBounds(677, 395, 86, 20);
		frame.getContentPane().add(textFieldZ);
	}

	private void labels() {
		JLabel lblG = new JLabel("G");
		lblG.setBounds(12, 272, 15, 14);
		frame.getContentPane().add(lblG);

		JLabel lblB = new JLabel("B");
		lblB.setBounds(12, 306, 15, 14);
		frame.getContentPane().add(lblB);

		JLabel lblC = new JLabel("C");
		lblC.setBounds(12, 353, 15, 14);
		frame.getContentPane().add(lblC);

		JLabel lblM = new JLabel("M");
		lblM.setBounds(12, 398, 15, 14);
		frame.getContentPane().add(lblM);

		JLabel lblY = new JLabel("Y");
		lblY.setBounds(12, 440, 15, 14);
		frame.getContentPane().add(lblY);

		JLabel lblH = new JLabel("H");
		lblH.setBounds(450, 20, 15, 14);
		frame.getContentPane().add(lblH);

		JLabel lblS = new JLabel("S");
		lblS.setBounds(450, 53, 15, 14);
		frame.getContentPane().add(lblS);

		JLabel lblV = new JLabel("V");
		lblV.setBounds(450, 87, 15, 14);
		frame.getContentPane().add(lblV);

		JLabel label = new JLabel("Y");
		label.setBounds(450, 356, 15, 14);
		frame.getContentPane().add(label);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(448, 316, 15, 14);
		frame.getContentPane().add(lblX);

		JLabel lblZ = new JLabel("Z");
		lblZ.setBounds(450, 398, 15, 14);
		frame.getContentPane().add(lblZ);

		lblL = new JLabel("L");
		lblL.setBounds(450, 167, 15, 14);
		frame.getContentPane().add(lblL);

		lblU = new JLabel("U");
		lblU.setBounds(450, 201, 15, 14);
		frame.getContentPane().add(lblU);

		lblV_1 = new JLabel("V");
		lblV_1.setBounds(450, 239, 15, 14);
		frame.getContentPane().add(lblV_1);
	}

	private int min(int a, int b, int c) {
		int rez = a;
		if (b < rez)
			rez = b;
		if (c < rez)
			rez = c;
		return rez;
	}

	private int max(int a, int b, int c) {
		int rez = a;
		if (b > rez)
			rez = b;
		if (c > rez)
			rez = c;
		return rez;
	}

	private void recountCMYK() {
		int k = 255;
		cyan = sliderC.getValue();
		magenta = sliderM.getValue();
		yellow = sliderYe.getValue();
		k = min(cyan, magenta, yellow);
		if (k != black) {
			try {
				cyan *= black / k;
				magenta *= black / k;
				yellow *= black / k;
				black = k;
			} catch (ArithmeticException e) {
			}
		}
	}

	private void rgb2cmyk() {
		int k = min(255 - red, 255 - green, 255 - blue);
		try {
			cyan = (255 - red);
			magenta = (255 - green);
			yellow = (255 - blue);
		} catch (ArithmeticException e) {
		}
		black = k;
	}

	private void cmyk2rgb() {
		red = (255 - cyan);
		green = (255 - magenta);
		blue = (255 - yellow);
	}

	private void refreshTFs() {
		recountCMYK();
		button.setBackground(new Color(red, green, blue));
		textFieldR.setText("" + red);
		textFieldG.setText("" + green);
		textFieldB.setText("" + blue);
		textFieldC.setText("" + cyan);
		textFieldM.setText("" + magenta);
		textFieldY.setText("" + yellow);
		textFieldK.setText("" + black);
		textFieldH.setText("" + h);
		textFieldS.setText("" + s);
		textFieldV.setText("" + v);
		textFieldX.setText("" + x);
		textFieldy.setText("" + y);
		textFieldZ.setText("" + z);
		textFieldL.setText("" + L);
		textFieldU.setText("" + U);
		textFieldv.setText("" + V);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		button = new JButton("");
		button.setBackground(Color.BLACK);
		button.setEnabled(false);
		button.setBounds(305, 87, 93, 80);
		frame.getContentPane().add(button);
		ImageIcon imic = new ImageIcon("colorsSet.jpg");
		JLabel label = new JLabel(imic);
		image = new BufferedImage(imic.getIconWidth(), 
				imic.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		Image im = imic.getImage();
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.drawImage(im, 0, 0, null);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int pixel = image.getRGB(e.getX(), e.getY());
				textFieldK.setText(""+Integer.toHexString(pixel)+" "+e.getX()+" "+e.getY());
				red   = (pixel & 0x00ff0000) >> 16;
				green = (pixel & 0x0000ff00) >> 8;
				blue  =  pixel & 0x000000ff;
				button.setBackground(new Color(red, green, blue));
				rgb2cmyk();
				rgb2hsv();
				rgb2xyz();
				rgb2luv();
				refreshSliders();
			}
		});
		label.setBackground(Color.WHITE);
		label.setBounds(0, 0, 225, 225);
		frame.getContentPane().add(label);
		
		slidersInit();
		labels();
		slidersEvents();

		initTFs();
	}
}
