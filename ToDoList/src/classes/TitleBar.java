package classes;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleBar extends JPanel{

	TitleBar()
	{
		this.setPreferredSize(new Dimension(400,80));
		
		JLabel titleText = new JLabel("To Do List");
		titleText.setPreferredSize(new Dimension(200,60));
		titleText.setFont(new Font("Sans-serif",Font.BOLD, 20));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		this.add(titleText);
	}
}
