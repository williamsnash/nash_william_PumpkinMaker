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
class DrawingPanel extends JPanel
{
	private int pumpWidth;
	private int pumpHeight;
	private int pumpX;
	private int pumpY;
	private String txtEye;
	private String txtNose;
	private String txtMouth;
	public String error;
	
	public DrawingPanel(int pumpWidth, int pumpHeight, int pumpX, int pumpY, String txtEye, String txtNose, String txtMouth)
	{
		setPumpWidth(pumpWidth);
		setPumpHeight(pumpHeight);
		setPumpX(pumpX);
		setPumpY(pumpY);
		setPumpEye(txtEye);
		setPumpNose(txtNose);
		setPumpMouth(txtMouth);
	}
	public DrawingPanel()
	{
		this(100,100, 200, 100, "C", "C", "O");
	}
	public void setPumpWidth(int pumpWidth)
	{
		this.pumpWidth = pumpWidth;
	}
	
	public void setPumpHeight(int pumpHeight)
	{
		this.pumpHeight = pumpHeight;
	}
	
	public void setPumpX(int pumpX)
	{
		this.pumpX = pumpX;
	}

	public void setPumpY(int pumpY)
	{
		this.pumpY = pumpY;
	}
	
	public void setPumpEye(String txtEye)
	{
		this.txtEye = txtEye;
	}

	public void setPumpNose(String txtNose)
	{
		this.txtNose = txtNose;
	}
	
	public void setPumpMouth(String txtMouth)
	{
		this.txtMouth = txtMouth;
	}
	
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
		else if(txtEye.equalsIgnoreCase("T"))//Triangel Eye
		{
			System.out.println("If T");
			g.setColor(Color.WHITE);
			g.fillOval((pumpX + (pumpWidth/2)-(pumpWidth/20)), (pumpY-(pumpHeight/10)), (pumpWidth/10), (pumpHeight/10));
		}
		else
		{
			JOptionPane.showMessageDialog(null, txtEye + " is not an option for Eye.");
		}
	}
	
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
		else if(txtNose.equalsIgnoreCase("T"))
		{
			g.setColor(Color.WHITE);
			g.fillOval((pumpX + (pumpWidth/2)-5), (pumpY + (pumpHeight/2)-5), (pumpWidth/10), (pumpHeight/10));
		}
		else
		{
			JOptionPane.showMessageDialog(null, txtNose + " is not an option for Nose.");
			//f.remove(f);
		}
	}
	
	public void mouthPaint(Graphics g)
	{
		if(txtMouth.equalsIgnoreCase("O"))
		{
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
			JOptionPane.showMessageDialog(null, txtMouth + " is not an option for Mouth.");
		}
	}
	
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
class MyCustomFrame extends JFrame
{
	
	public MyCustomFrame(String title, int left, int top, int width, int height, int closeOp)//non-default constructor, takes in settings
	{
		setLook(title,left,top,width,height);
		setDefaultCloseOperation(closeOp);
	}
	public void setLook(String title, int left, int top, int width, int height) {
        setTitle(title);
        setBounds(left,top,width,height);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panelSouth = new JPanel();
        
        DrawingPanel drawPanel = new DrawingPanel();
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
            	/*
            	int widthSize;
            	try {
            		widthSize = Integer.parseInt(txtWidth.getText());
            	}catch(Exception ex){
            		widthSize = -1;
            	}
            	if(widthSize == 0)
            	{
            		JOptionPane.showMessageDialog(null, "You can't Leave the Width field blank");
            	}
            	else if(widthSize == -1)
            	{
            		JOptionPane.showMessageDialog(null, "The Width must be an Integer");
            	}
            	else
            	{
            		drawPanel.setPumpWidth(Integer.parseInt(txtWidth.getText()));
            	}
            	*/
            	errorCheckInt(txtLeft,drawPanel, "Left");
            	errorCheckInt(txtTop,drawPanel, "Top");
            	errorCheckInt(txtWidth, drawPanel, "Width");
            	errorCheckInt(txtHeight,drawPanel, "Height");
            	
            	
                drawPanel.setPumpEye(txtEye.getText());
                drawPanel.setPumpNose(txtNose.getText());
                drawPanel.setPumpMouth(txtMouth.getText());
                repaint();
            }
        });
        panelSouth.add(btnDraw);
        c.add(panelSouth,BorderLayout.SOUTH);
        
	}
	
	public void errorCheckInt(JTextField txtOp, DrawingPanel drawPanel, String name)
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
    		JOptionPane.showMessageDialog(null, "You can't Leave the " + name + " field blank");
    	}
    	else if(setSize == -1)
    	{
    		JOptionPane.showMessageDialog(null, "The " + name + " must be an Integer");
    	}
    	else
    	{
    		
    		//drawPanel.setPumpWidth(Integer.parseInt(txtOp.getText()));//ERROR
    	}
	}
	public void errorCheckString(JTextField txtOp, DrawingPanel drawPanel, String name)
	{
		String setString = txtOp.getText().trim();
		
		if(setString.length() == 0)
    	{
    		JOptionPane.showMessageDialog(null, "You can't Leave the " + name + " field blank");
    	}
    	else
    	{
    		
    		//drawPanel.setPumpWidth(txtOp.getText());//ERROR
    	}
	}
}



public class Pumpkin_Maker
{
	public static void main(String[] args)
	{
		MyCustomFrame frm1 = new MyCustomFrame("Pumkin Maker",100,100,800,480,JFrame.EXIT_ON_CLOSE);
		frm1.setVisible(true);
	}
}
