package crystal.world;

import java.util.LinkedList;

import crystal.*;

public class World
{
	int                 m_width;
	int                 m_height;
	Tower[][]           m_towers;
	Vector2i            m_selection;
	Route               m_route;
	LinkedList<Monster> m_monsterList;
	LinkedList<Bullet>  m_bulletList;
	
	public World()
	{
		m_width = 20;
		m_height = 20;
		
		m_towers = new Tower[m_width][m_height];
		for (int x = 0; x < m_width; ++x)
			for (int y = 0; y < m_height; ++y)
				m_towers[x][y] = new Tower(x, y);
		
		m_towers[3][4].addCrystal(Crystal.RED);
		
		m_selection = new Vector2i(-1, -1);
		
		m_route = new Route();
		
		m_monsterList = new LinkedList<Monster>();
		for (int i = 0; i < 5; ++i)
			m_monsterList.add(new Monster(m_route, -i));
		
		m_bulletList = new LinkedList<Bullet>();
		m_bulletList.add(new Bullet(m_towers[3][4], m_monsterList.getFirst()));
	}
	
	public void update()
	{
		for (Monster monster : m_monsterList)
			monster.update();
		for (Bullet bullet : m_bulletList)
			bullet.update();
	}
	
	public void setSelection(int x, int y)
	{
		m_selection.setXY(x, y);
	}
	
	public void setSelection(Vector2i v)
	{
		m_selection.setXY(v);
	}
	
	public Tower getTower(Vector2i v)
	{
		if (!isInBounds(v)) return null;
		
		int x = v.getX();
		int y = v.getY();
		
		Tower ret = m_towers[x][y];
		
		// Check to see if the current cell is actually part of a large tower
		if (ret.isEmpty())
		{
			Tower left = null, up = null, leftup = null;
			
			// Can maybe replace this with a loop over matching bounds, running
			// isInBounds(), and then if the distance is within the size of the
			// tower in question return it. We'll assume for convenience that
			// the layout of towers is consistent (i.e. no overlapping towers).
			if (x > 0) left = m_towers[x - 1][y];
			if (y > 0) up = m_towers[x][y - 1];
			if (x > 0 && y > 0) leftup = m_towers[x - 1][y - 1];
			
			if (x > 0 && left.getSize() > 1) ret = left;
			if (y > 0 && up.getSize() > 1) ret = up;
			if (x > 0 && y > 0 && left.getSize() > 1 && up.getSize() > 1)
				ret = leftup;
		}
		
		return ret;
	}
	
	public int getWidth()
	{
		return m_width;
	}
	
	public int getHeight()
	{
		return m_height;
	}
	
	public Vector2i getSelection()
	{
		return m_selection;
	}
	
	public Route getRoute()
	{
		return m_route;
	}
	
	public LinkedList<Monster> getMonsterList()
	{
		return m_monsterList;
	}
	
	public LinkedList<Bullet> getBulletList()
	{
		return m_bulletList;
	}
	
	public Monster getRandomMonster(Vector2i center, int radius)
	{
		Monster ret = null;
		for (Monster monster : m_monsterList)
		{
			Vector2i mCenter = monster.getCenter();
			if (center.distLeq(mCenter, radius))
			{
				ret = monster;
				break;
			}
		}
		
		return ret;
	}
	
	public boolean isInBounds(Vector2i v)
	{
		int x = v.getX();
		int y = v.getY();
		
		return x >= 0 && y >= 0 && x < m_width && y < m_height;
	}
}
