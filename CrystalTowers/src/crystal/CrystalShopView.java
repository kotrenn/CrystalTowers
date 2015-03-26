package crystal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CrystalShopView extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 8080098169903851736L;
	
	private JButton[]         m_buttons;
	
	public CrystalShopView()
	{
		int numRows = 1;
		int numCols = 5;
		setLayout(new GridLayout(numRows, numCols));
		
		m_buttons = new JButton[5];
		for (int i = 0; i < 5; ++i)
		{
			m_buttons[i] = new JButton(String.valueOf(i + 1));
			m_buttons[i].addActionListener(this);
			m_buttons[i].setActionCommand(String.valueOf(i));
			add(m_buttons[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Crystal[] opts = { Crystal.RED, Crystal.YELLOW, Crystal.GREEN,
		        Crystal.BLUE, Crystal.PURPLE };
	}
}
