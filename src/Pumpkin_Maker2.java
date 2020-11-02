import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings({ "serial", "unused" })
class DrawingPanel2 extends JPanel
{
	private int pumpWidth;
	private int pumpHeight;
	private int pumpX;
	private int pumpY;
	private String txtEye;
	private String txtNose;
	private String txtMouth;
	
	/**
	 * Default constructor of the DrawingPanel2 class
	 * @param pumpWidth user inputed value
	 * @param pumpHeight user inputed value
	 * @param pumpX user inputed value
	 * @param pumpY user inputed value
	 * @param txtEye user inputed value
	 * @param txtNose user inputed value
	 * @param txtMouth user inputed value
	 */
	public DrawingPanel2(int pumpWidth, int pumpHeight, int pumpX, int pumpY, String txtEye, String txtNose, String txtMouth)
	{
		setPumpWidth(pumpWidth);
		setPumpHeight(pumpHeight);
		setPumpX(pumpX);
		setPumpY(pumpY);
		setPumpEye(txtEye);
		setPumpNose(txtNose);
		setPumpMouth(txtMouth);
	}
	
	/**
	 * Default Constructor if no values are giving
	 */
	public DrawingPanel2()
	{
		this(100,100, 200, 100, "C", "C", "O");
	}
	
	/**
	 * Sets the value of the private variable pumpWidth to be used in paintComponent
	 * @param pumpWidth The integer of the text field to be set as the width of the pumpkin
	 */
	public void setPumpWidth(int pumpWidth)
	{
		this.pumpWidth = pumpWidth;
	}
	
	/**
	 * Sets the value of the private variable pumpHeight to be used in paintComponent
	 * @param pumpHeight The integer of the text field to be set as the height of the pumpkin
	 */
	public void setPumpHeight(int pumpHeight)
	{
		this.pumpHeight = pumpHeight;
	}
	
	/**
	 * Sets the value of the private variable pumpX to be used in paintComponent
	 * @param pumpWX The integer of the text field to be set as the X coord of the pumpkin
	 */
	public void setPumpX(int pumpX)
	{
		this.pumpX = pumpX;
	}

	/**
	 * Sets the value of the private variable pumpY to be used in paintComponent
	 * @param pumpY The integer of the text field to be set as the Y coord of the pumpkin
	 */
	public void setPumpY(int pumpY)
	{
		this.pumpY = pumpY;
	}
	
	/**
	 * Sets the value of the private variable txtEye to be used in paintComponent
	 * @param txtEye The integer of the text field to be set as the style of the eyes of the pumpkin
	 */
	public void setPumpEye(String txtEye)
	{
		this.txtEye = txtEye;
	}

	/**
	 * Sets the value of the private variable pumpWidth to be used in paintComponent
	 *@param txtNose The integer of the text field to be set as the style of the nose of the pumpkin
	 */
	public void setPumpNose(String txtNose)
	{
		this.txtNose = txtNose;
	}
	
	/**
	 * Sets the value of the private variable pumpWidth to be used in paintComponent
	 * @param txtMouth The integer of the text field to be set as the style of the mouth of the pumpkin
	 */
	public void setPumpMouth(String txtMouth)
	{
		this.txtMouth = txtMouth;
	}
	
	/**
	 * This holds code to determine what option the user picked for the eye
	 * @param g needed to be able to draw the three types of eye
	 */
	public void eyePaint(Graphics g)
	{
		if(txtEye.equalsIgnoreCase("C"))//Circle Eye
		{ 
			g.setColor(Color.WHITE);
			g.fillOval((pumpX+(pumpWidth/4)), (pumpY+(pumpHeight/5)), (pumpWidth/10), (pumpHeight/10));
			g.fillOval((pumpX+pumpWidth-(pumpWidth/3)), (pumpY+(pumpHeight/5)), (pumpWidth/10), (pumpHeight/10));
		}
		else if(txtEye.equalsIgnoreCase("S"))//Square Eye
		{
			g.setColor(Color.WHITE);
			g.fillRect((pumpX+(pumpWidth/4)), (pumpY+(pumpHeight/5)), (pumpWidth/10), (pumpHeight/10));
			g.fillRect((pumpX+pumpWidth-(pumpWidth/3)), (pumpY+(pumpHeight/5)), (pumpWidth/10), (pumpHeight/10));
		}
		else if(txtEye.equalsIgnoreCase("T"))//Triangel Eye //FINISH
		{
			int newX = (pumpX+(pumpWidth/4));
			int newY = (pumpY+(pumpHeight/5));
			int newXX = (pumpX+pumpWidth-(pumpWidth/3));
			int newYY = (pumpY+(pumpHeight/5));
			int[] pumpCordX = {(newX+(pumpWidth/10)), newX, (newX+((pumpWidth/10)/2))};
			int[] pumpCordY = {(newY+(pumpHeight/10)), (newY+(pumpHeight/10)), newY};
			int[] pumpCordXX = {(newXX+(pumpWidth/10)), newXX, (newXX+((pumpWidth/10)/2))};
			int[] pumpCordYY = {(newYY+(pumpHeight/10)), (newYY+(pumpHeight/10)), newYY};
			g.setColor(Color.WHITE);
			g.fillPolygon(pumpCordX, pumpCordY, 3);
			g.fillPolygon(pumpCordXX, pumpCordYY, 3);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.fillOval((pumpX+(pumpWidth/4)), (pumpY+(pumpHeight/5)), (pumpWidth/10), (pumpHeight/10));
			g.fillOval((pumpX+pumpWidth-(pumpWidth/3)), (pumpY+(pumpHeight/5)), (pumpWidth/10), (pumpHeight/10));
		}
	}
	
	/**
	 * This holds code to determine what option the user picked for the Nose
	 * @param g needed to be able to draw the three types of noses
	 */
	public void nosePaint(Graphics g)
	{
		if(txtNose.equalsIgnoreCase("C"))
		{
			g.setColor(Color.WHITE);
			g.fillOval((pumpX + (pumpWidth/2)-5), (pumpY + (pumpHeight/2)-5), (pumpWidth/10), (pumpHeight/10));
		}
		else if(txtNose.equalsIgnoreCase("S"))
		{
			g.setColor(Color.WHITE);
			g.fillRect((pumpX + (pumpWidth/2)-5), (pumpY + (pumpHeight/2)-5), (pumpWidth/10), (pumpHeight/10));
		}
		else if(txtNose.equalsIgnoreCase("T"))//FINISH
		{
			int newX = (pumpX + (pumpWidth/2)-5);
			int newY = (pumpY + (pumpHeight/2)-5);
			int[] pumpCordX = {(newX+(pumpWidth/10)), newX, (newX+((pumpWidth/10)/2))};
			int[] pumpCordY = {(newY+(pumpHeight/10)), (newY+(pumpHeight/10)), newY};
			g.setColor(Color.WHITE);
			g.fillPolygon(pumpCordX, pumpCordY, 3);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.fillOval((pumpX + (pumpWidth/2)-5), (pumpY + (pumpHeight/2)-5), (pumpWidth/10), (pumpHeight/10));
		}
	}
	
	/**
	 * This holds code to determine what option the user picked for the mouth
	 * @param g needed to be able to draw the two types of mouths
	 */
	public void mouthPaint(Graphics g)
	{
		if(txtMouth.equalsIgnoreCase("O"))
		{
			//Cords are wrong for all mouth lines
			g.setColor(Color.WHITE);
			g.fillOval((pumpX+(pumpWidth/2)-(pumpWidth/6)), (pumpY+(pumpWidth/2)+(pumpWidth/5)), (pumpWidth/3), (pumpHeight/10));
			//x,y,w,h
		}
		else if(txtMouth.equalsIgnoreCase("R"))
		{
			g.setColor(Color.WHITE);
			g.fillRect((pumpX+(pumpWidth/2)-(pumpWidth/6)), (pumpY+(pumpWidth/2)+(pumpWidth/5)), (pumpWidth/3), (pumpHeight/10));
		}
		else
		{
			g.setColor(Color.WHITE);
			g.fillOval((pumpX+(pumpWidth/2)-(pumpWidth/6)), (pumpY+(pumpWidth/2)+(pumpWidth/5)), (pumpWidth/3), (pumpHeight/10));
		}
	}
	
	/**
	 * paintComponet does the drawing of all the objects seen on screen
	 * it directly draws the body and the stem
	 * it indirectly draws the eyes, mouth, and nose
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.ORANGE); //Pumpkin
		g.fillOval(pumpX, pumpY, pumpWidth, pumpHeight);
		
		g.setColor(Color.WHITE); //Stem
		g.fillRect((pumpX + (pumpWidth/2)-(pumpWidth/20)), (pumpY-(pumpHeight/10)), (pumpWidth/10), (pumpHeight/10));
		eyePaint(g); //eye Painting
		nosePaint(g);//nose Painting
		mouthPaint(g);
	}
}

@SuppressWarnings("serial")
class MyCustomFrame2 extends JFrame
{
	/**
	 * Default Constructor
	 * @param title Taken from the main function in the Pumpkin_Maker2 class/ Sets the title of the frame
	 * @param left Taken from the main function in the Pumpkin_Maker2 class/ Sets the x position of the frame
	 * @param top Taken from the main function in the Pumpkin_Maker2 class/ Sets the y position of the frame
	 * @param width Taken from the main function in the Pumpkin_Maker2 class/ Sets the width of the frame
	 * @param height Taken from the main function in the Pumpkin_Maker2 class/ Sets the height of the frame
	 * @param closeOp Taken from the main function in the Pumpkin_Maker2 class/ Sets the close operation of the frame
	 */
	public MyCustomFrame2(String title, int left, int top, int width, int height, int closeOp)//non-default constructor, takes in settings
	{
		setLook(title,left,top,width,height);
		setDefaultCloseOperation(closeOp);
	}
	/**
	 * Takes the information from the default constructor and makes the frame to spec.
	 * It creates the buttons for user input
	 * Then class the classes needed to draw the pumpkin at users spec.
	 * @param title Taken from the main function in the Pumpkin_Maker2 class/ Sets the title of the frame
	 * @param left Taken from the main function in the Pumpkin_Maker2 class/ Sets the x position of the frame
	 * @param top Taken from the main function in the Pumpkin_Maker2 class/ Sets the y position of the frame
	 * @param width Taken from the main function in the Pumpkin_Maker2 class/ Sets the width of the frame
	 * @param height Taken from the main function in the Pumpkin_Maker2 class/ Sets the height of the frame
	 * @param closeOp Taken from the main function in the Pumpkin_Maker2 class/ Sets the close operation of the frame
	 */
	public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left,top,width,height);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panelSouth = new JPanel();
        
        DrawingPanel2 drawPanel = new DrawingPanel2();
        c.add(drawPanel, BorderLayout.CENTER);
        
        panelSouth.setLayout(new FlowLayout());
        //Left
        panelSouth.add(new JLabel("Left: "));
        JTextField txtLeft = new JTextField(3);
        panelSouth.add(txtLeft);
        //Top
        panelSouth.add(new JLabel("Top: "));
        JTextField txtTop = new JTextField(3);
        panelSouth.add(txtTop);
        //Width
        panelSouth.add(new JLabel("Width: "));
        JTextField txtWidth = new JTextField(3);
        panelSouth.add(txtWidth);
        //Height
        panelSouth.add(new JLabel("Height: "));
        JTextField txtHeight = new JTextField(3);
        panelSouth.add(txtHeight);
        //Eye
        panelSouth.add(new JLabel("Eye (C S T): "));
        JTextField txtEye = new JTextField(1);
        panelSouth.add(txtEye);
        //Nose
        panelSouth.add(new JLabel("Nose (C S T): "));
        JTextField txtNose = new JTextField(1);
        panelSouth.add(txtNose);
        //Mouth
        panelSouth.add(new JLabel("Mouth (O R): "));
        JTextField txtMouth = new JTextField(1);
        panelSouth.add(txtMouth);
        
        
        
        JButton btnDraw = new JButton("Draw");
        btnDraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	drawPanel.setPumpX(errorCheckInt(txtLeft, "Left"));
            	drawPanel.setPumpY(errorCheckInt(txtTop, "Top"));
            	drawPanel.setPumpWidth(errorCheckInt(txtWidth, "Width"));
            	drawPanel.setPumpHeight(errorCheckInt(txtHeight, "Height"));
            	
            	
                drawPanel.setPumpEye(errorCheckString(txtEye, "Eye"));
                drawPanel.setPumpNose(errorCheckString(txtNose, "Nose"));
                drawPanel.setPumpMouth(errorCheckString(txtMouth, "Mouth"));
                repaint();
            }
        });
        panelSouth.add(btnDraw);
        c.add(panelSouth,BorderLayout.SOUTH);
        
	}
	
	/**
	 * Takes in the text field and a string name to insure that the values enter in the boxes are valid
	 * @param txtOp The JTextField containing the information to be checked
	 * @param name A String with a name corresponding to the text field
	 * @return An integer to be used in the DrawingPanel2 class
	 */
	public int errorCheckInt(JTextField txtOp, String name)
	{
		String setString = txtOp.getText().trim();
		int setSize;
    	try {
    		setSize = Integer.parseInt(txtOp.getText());
    	}catch(Exception ex){
    		setSize = -1;
    	}
    	if(setString.length() == 0)
    	{
    		JOptionPane.showMessageDialog(null, "You can't leave the " + name + " field blank");
    		setSize = 100;
    	}
    	else if(setSize == -1)
    	{
    		JOptionPane.showMessageDialog(null, "The " + name + " must be an Integer");
    		setSize = 100;
    	}
    	else
    	{
    		return setSize;
    	}
    	return setSize;
	}
	
	/**
	 * Takes in a text field to be checked if input is valid
	 * @param txtOp JTextField containing user input
	 * @param name A string corresponding the the text field
	 * @return A string to be uses in the DrawingPanel2 class
	 */
	public String errorCheckString(JTextField txtOp, String name)
	{
		String setString = txtOp.getText().trim();
		int checkting;
		boolean stringCheck = false;
		try
		{
			checkting = Integer.parseInt(setString);
			JOptionPane.showMessageDialog(null, "The " + name + " must be a String");
		}catch(Exception ex)
		{
			stringCheck = true;
		}
		
		if(setString.length() == 0)
    	{
    		JOptionPane.showMessageDialog(null, "You can't Leave the " + name + " field blank");
    	}
		else if(stringCheck = false)
		{
			JOptionPane.showMessageDialog(null, name + " must be a String");
		}
    	else
    	{
    		if(name.equalsIgnoreCase("Eye"))
    		{
    			if(!setString.equalsIgnoreCase("C") & !setString.equalsIgnoreCase("S") & !setString.equalsIgnoreCase("T"))
    			{
    				JOptionPane.showMessageDialog(null, setString + " is not an option for Eye (C, S, T)");
    			}
    		}
    		else if(name.equalsIgnoreCase("Nose"))
    		{
    			if(!setString.equalsIgnoreCase("C") & !setString.equalsIgnoreCase("S") & !setString.equalsIgnoreCase("T"))
    			{
    				JOptionPane.showMessageDialog(null, setString + " is not an option for Nose (C, S, T)");
    			}
    		}
    		else if(name.equalsIgnoreCase("Mouth"))
    		{
    			if(!setString.equalsIgnoreCase("R") & !setString.equalsIgnoreCase("O"))
    			{
    				JOptionPane.showMessageDialog(null, setString + " is not an option for mouth (O, R)");
    			}
    		}
    		return setString;
    	}
		return setString;
	}
}



public class Pumpkin_Maker2
{
	/**
	 * Very simple main program to start the process of creating the JPanel
	 * @param args
	 */
	public static void main(String[] args)
	{
		MyCustomFrame2 frm1 = new MyCustomFrame2("Pumkin Maker",100,100,800,480,JFrame.EXIT_ON_CLOSE);
		frm1.setVisible(true);
	}
}
