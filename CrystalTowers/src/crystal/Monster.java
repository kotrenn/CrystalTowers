package crystal;

import java.awt.Color;
import java.awt.Graphics2D;

public class Monster
{
	private Route  m_route;
	private int    m_pos;
	private double m_progress;
	
	public Monster(Route route, double progress)
	{
		m_route = route;
		m_pos = 0;
		m_progress = progress;
	}
	
	public void update()
	{
		m_progress += 0.03;
		if (m_progress >= m_route.getLen(m_pos))
		{
			m_pos++;
			m_progress = 0;
		}
		if (m_pos >= m_route.getPoints().length - 1)
		{
			m_pos = 0;
			m_progress = 0;
		}
	}
	
	public void paint(Graphics2D g2d)
	{
		Vector2i pos = getCorner();
		Vector2i dims = new Vector2i(TowerView.WIDTH, TowerView.HEIGHT);
		
		g2d.setColor(Color.RED);
		g2d.drawRect(pos.getX(), pos.getY(), dims.getX(), dims.getY());
	}
	
	public Vector2i getCorner()
	{
		Vector2d pos = m_route.getPos(m_pos).toVector2d();
		Vector2d offset = m_route.getDir(m_pos).setLenD(m_progress);
		pos = pos.add(offset);
		
		Vector2d dims = new Vector2d(TowerView.WIDTH, TowerView.HEIGHT);
		pos = pos.scale(dims);
		
		return pos.toVector2i();
	}
	
	public Vector2i getCenter()
	{
		Vector2i dims = new Vector2i(TowerView.WIDTH, TowerView.HEIGHT);
		Vector2i corner = getCorner();
		Vector2i center = corner.add(dims.scale(0.5));
		
		return center;
	}
}
