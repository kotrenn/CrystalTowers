package crystal.world;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.JPanel;

import crystal.*;

public class WorldView extends JPanel implements MouseListener,
                                     MouseMotionListener
{
	private static final long serialVersionUID = 458381638719285588L;
	
	private World             m_world;
	private TowerEditorView   m_towerEditorView;
	
	public WorldView(World world, TowerEditorView towerEditorView)
	{
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		m_world = world;
		m_towerEditorView = towerEditorView;
		
		int windowWidth = m_world.getWidth() * TowerView.WIDTH;
		int windowHeight = m_world.getHeight() * TowerView.HEIGHT;
		setMinimumSize(new Dimension(windowWidth, windowHeight));
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
		for (int x = 0; x < m_world.getWidth(); ++x)
			for (int y = 0; y < m_world.getHeight(); ++y)
			{
				boolean selected = false;
				Vector2i curPos = new Vector2i(x, y);
				if (curPos.equals(m_world.getSelection())) selected = true;
				
				Tower tower = m_world.getTower(new Vector2i(x, y));
				TowerView.paint(g2d, tower, selected);
			}
		
		Route route = m_world.getRoute();
		RouteView.paint(g2d, route);
		
		LinkedList<Monster> monsterList = m_world.getMonsterList();
		for (Monster monster : monsterList)
			monster.paint(g2d);
		
		LinkedList<Bullet> bulletList = m_world.getBulletList();
		for (Bullet bullet : bulletList)
			bullet.paint(g2d);
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		Vector2i cell = getCell(e.getX(), e.getY());
		Tower tower = m_world.getTower(cell);
		m_towerEditorView.setTower(tower);
	}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
	}
	
	@Override
	public void mouseExited(MouseEvent e)
	{
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		Vector2i v = getCell(e.getX(), e.getY());
		m_world.setSelection(v);
	}
	
	public Vector2i getCell(int x, int y)
	{
		int width = TowerView.WIDTH;
		int height = TowerView.HEIGHT;
		
		int tileX = x / width;
		int tileY = y / height;
		
		return new Vector2i(tileX, tileY);
	}
}
