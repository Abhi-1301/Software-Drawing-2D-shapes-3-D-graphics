package oom_project;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class main {
	
	private static Dialogue dialogBox;
	private static shape_list list;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("World of Shapes");
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		
		dialogBox = new Dialogue();
		dialogBox.entrance("Welcome to ScaleiT\n");
		
		String name = dialogBox.askname();
		
		if(name.isEmpty())
		{
			dialogBox.leaving();
			System.exit(0);
		}
		int a=0;
		for(int i=0;i<name.length();++i)
		{
			if(name.charAt(i)==' ')
			{
				a++;
			}
		}
		if(a==name.length())
		{
			dialogBox.leaving();
			System.exit(0);
		}
		if(name==null)
		{
			System.exit(0);
		}
		else {
			
			list=new shape_list();
			list.adduser(name);
			
			if(dialogBox.ask(name)==JOptionPane.YES_OPTION)
			{
				String shape[];
				int index=dialogBox.ShapeType("Choose the dimensions of shape");
				
				if(index==0)
				{
					shape=new String[list.shapes2D.size()];
					
					for(int i=0;i<list.shapes2D.size();++i)
					{
						shape[i]=list.shapes2D.get(i).name;
					}
					
					int index2D=dialogBox.type(shape,"Choose a shape");
					Shape_2dimension make2d=new Shape_2dimension(index2D);
					frame.add(make2d);
					
				}
				else {
					
					shape=new String[list.shapes3D.size()];
					
					for(int i=0;i<list.shapes3D.size();++i)
					{
						shape[i]=list.shapes3D.get(i).name;
					}
					
					int index3D=dialogBox.type(shape,"Choose a shape");
					if(dialogBox.ques()==JOptionPane.NO_OPTION)
					{
						Shape_3dimension make3d=new Shape_3dimension(index3D,false);
						frame.add(make3d);
					}
					else
					{
						Shape_3dimension make3d=new Shape_3dimension(index3D,true);
						frame.add(make3d);
					}
				}
			}
			else {
				dialogBox.leaving(name);
				System.exit(0);
			}
			
		}
		frame.setResizable(false);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
