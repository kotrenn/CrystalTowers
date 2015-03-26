package crystal;

import java.awt.Color;

public class Tower
{
	private Vector2i  m_pos;
	private int       m_maxCrystals;
	private int       m_numCrystals;
	private Crystal[] m_crystals;
	
	public Tower(int x, int y)
	{
		m_pos = new Vector2i(x, y);
		m_maxCrystals = 4;
		m_numCrystals = 0;
		m_crystals = new Crystal[m_maxCrystals];
		for (int i = 0; i < m_maxCrystals; ++i)
			m_crystals[i] = Crystal.NONE;
	}
	
	public Color getColorAvg()
	{
		int[] avg = new int[] { 0, 0, 0 };
		for (int i = 0; i < m_numCrystals; ++i)
		{
			Color curColor = m_crystals[i].getColor();
			avg[0] += curColor.getRed();
			avg[1] += curColor.getGreen();
			avg[2] += curColor.getBlue();
		}
		
		for (int i = 0; i < 3; ++i)
			avg[i] /= m_numCrystals;
		
		return new Color(avg[0], avg[1], avg[2]);
	}
	
	public boolean addCrystal(Crystal crystal)
	{
		if (m_numCrystals >= m_maxCrystals) return false;
		
		m_crystals[m_numCrystals++] = crystal;
		return true;
	}
	
	public int getSize()
	{
		return getSize(0);
	}
	
	public int getSize(int surplus)
	{
		return (m_numCrystals + surplus) <= 2? 1 : 2;
	}
	
	public Vector2i getPos()
	{
		return m_pos;
	}
	
	public boolean isEmpty()
	{
		return m_numCrystals == 0;
	}
	
	public boolean isFull()
	{
		return m_numCrystals >= m_maxCrystals;
	}
	
	public int getNumCrystals()
	{
		return m_numCrystals;
	}
	
	public int getMaxCrystals()
	{
		return m_maxCrystals;
	}
	
	public Crystal getCrystal(int i)
	{
		return m_crystals[i];
	}
}
