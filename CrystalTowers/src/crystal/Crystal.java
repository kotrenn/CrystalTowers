package crystal;

import java.awt.Color;

public enum Crystal
{
	NONE(0, 0, 0),
	RED(255, 0, 0),
	YELLOW(255, 255, 0),
	GREEN(0, 255, 0),
	BLUE(0, 0, 255),
	PURPLE(255, 0, 255);
	
	private final Color m_color;
	
	Crystal(int r, int g, int b)
	{
		m_color = new Color(r, g, b);
	}
	
	public Color getColor()
	{
		return m_color;
	}
}
