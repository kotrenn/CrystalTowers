package crystal;

public class Route
{
	private Vector2i[] m_points;
	
	public Route()
	{
		m_points = new Vector2i[] { new Vector2i(0, 3), new Vector2i(5, 3),
		                            new Vector2i(5, 14), new Vector2i(17, 14), new Vector2i(17, 8),
		                            new Vector2i(10, 8), new Vector2i(10, 3), new Vector2i(20, 3) };
	}
	
	public Vector2i[] getPoints()
	{
		return m_points;
	}
	
	public Vector2i getSource()
	{
		return m_points[0];
	}
	
	public Vector2i getPos(int i)
	{
		if (i < 0) return getPos(m_points.length - 1 + i);
		
		return m_points[i];
	}
	
	public Vector2i getDir(int i)
	{
		if (i < 0) return getDir(m_points.length - 1 + i);
		
		Vector2i p0 = m_points[i];
		Vector2i p1 = m_points[i + 1];
		Vector2i dir = p1.sub(p0);
		
		return dir;
	}
	
	public double getLen(int i)
	{
		Vector2i dir = getDir(i);
		return dir.lengthD();
	}
}
