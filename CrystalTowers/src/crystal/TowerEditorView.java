package crystal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TowerEditorView extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 7956295383541850207L;
	
	private Tower             m_tower;
	private JButton[]         m_buttons;
	
	public TowerEditorView()
	{
		int numRows = 2;
		int numCols = 4;
		setLayout(new GridLayout(numRows, numCols));
		m_tower = null;
		m_buttons = new JButton[4];
		for (int i = 0; i < 4; ++i)
		{
			m_buttons[i] = new JButton(String.valueOf(i + 1));
			m_buttons[i].addActionListener(this);
			m_buttons[i].setActionCommand(String.valueOf(i));
			add(m_buttons[i]);
		}
		
		for (int i = 0; i < 4; ++i)
			add(new Label("Buy " + (i + 1)));
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		                     RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (m_tower == null) return;
		
		if (m_tower.isEmpty()) return;
		
		Color color = m_tower.getColorAvg();
		g2d.setColor(color);
		g2d.drawRect(5, 5, 20, 20);
		
		int crystalWidth = 20;
		int crystalHeight = 20;
		
		for (int i = 0; i < m_tower.getMaxCrystals(); ++i)
		{
			Crystal crystal = m_tower.getCrystal(i);
			int x = (1 + 2 * i) * crystalWidth;
			int y = 200;
			paintCrystal(g2d, crystal, x, y, crystalWidth, crystalHeight);
		}
	}
	
	private void paintCrystal(Graphics2D g2d, Crystal crystal, int x, int y,
	                          int w, int h)
	{
		Color color = crystal.getColor();
		g2d.setColor(color);
		g2d.drawRect(x, y, w, h);
	}
	
	public void setTower(Tower tower)
	{
		m_tower = tower;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (m_tower == null) return;
		
		if (m_tower.isFull()) return;
		
		Crystal[] opts = { Crystal.RED, Crystal.YELLOW, Crystal.GREEN,
		                   Crystal.BLUE };
		
		int selection = Integer.parseInt(e.getActionCommand());
		Crystal crystal = opts[selection];
		m_tower.addCrystal(crystal);
	}
}
