package crystal;

import java.awt.Graphics2D;

public class Bullet
{
	Tower   m_tower;
	Monster m_monster;
	double  m_progress;
	double  m_speed;
	
	public Bullet(Tower tower, Monster monster)
	{
		m_tower = tower;
		m_monster = monster;
		m_progress = 0;
		m_speed = 0.03;
	}
	
	public void update()
	{
		m_progress += m_speed;
		if (m_progress >= 1) m_progress = 0;
	}
	
	public void paint(Graphics2D g2d)
	{
		Vector2i towerPos = TowerView.getCenter(m_tower);
		Vector2i monsterPos = m_monster.getCenter();
		Vector2i dir = monsterPos.sub(towerPos);
		Vector2i offset = dir.setLenD(m_progress * dir.lengthD()).toVector2i();
		Vector2i pos = towerPos.add(offset);
		Vector2i dims = new Vector2i(5, 5);
		Vector2i corner = pos.sub(dims.scale(0.5));
		
		g2d.setColor(m_tower.getColorAvg());
		g2d.drawOval(corner.getX(), corner.getY(), dims.getX(), dims.getY());
	}
}
