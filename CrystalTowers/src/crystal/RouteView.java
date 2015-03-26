package crystal;

import java.awt.Color;
import java.awt.Graphics2D;

public class RouteView
{
	public static void paint(Graphics2D g2d, Route route)
	{
		Vector2i[] points = route.getPoints();
		for (int i = 1; i < points.length; ++i)
		{
			Vector2i scale = new Vector2i(TowerView.WIDTH, TowerView.HEIGHT);
			Vector2i center = new Vector2i(TowerView.WIDTH / 2,
			                               TowerView.HEIGHT / 2);
			Vector2i p0 = points[i - 1].scale(scale).add(center);
			Vector2i p1 = points[i].scale(scale).add(center);
			g2d.setColor(Color.RED);
			g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
		}
	}
}
