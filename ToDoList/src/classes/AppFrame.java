package classes;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


public class AppFrame extends JFrame{
	
	private TitleBar title;
	private Footer footer;
	private List list;
	
	private JButton newTask;
	private JButton clear;
	
	AppFrame()
	{
		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		title = new TitleBar();
		footer = new Footer();
		list = new List();
		
		this.add(title,BorderLayout.NORTH);
		this.add(footer,BorderLayout.SOUTH);
		this.add(list,BorderLayout.CENTER);
		
		newTask = footer.getNewTask();
		clear = footer.getClear();
		
		addListeners();
	}
	
	
	public void addListeners()
	{
		newTask.addMouseListener(new MouseAdapter()
		{
			@override
			public void mousePressed(MouseEvent e)
			{
				Task task = new Task();
				list.add(task);
				list.updateNumbers();
				
				
				task.getDone().addMouseListener(new MouseAdapter()
				{
					@override
					public void mousePressed(MouseEvent e)
					{
						
						task.changeState();
						list.updateNumbers();
						revalidate();
						
					}
				});
			}
			
		});
		
		
		clear.addMouseListener(new MouseAdapter()
		{
			@override
			public void mousePressed(MouseEvent e)
			{
				list.removeCompletedTasks();
				repaint();
			}
		});
	}	
	
}
