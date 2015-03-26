package crystal;

import java.awt.Color;
import java.awt.Graphics2D;

public class TowerView
{
	public final static int WIDTH  = 20;
	public final static int HEIGHT = 20;
	
	public static void paint(Graphics2D g2d, Tower tower, boolean selected)
	{
		if (tower.getNumCrystals() == 0 && !selected) return;
		
		Color color = selected? Color.BLACK : tower.getColorAvg();
		g2d.setColor(color);
		
		int width = TowerView.getWidth(tower);
		int height = TowerView.getHeight(tower);
		
		Vector2i corner = tower.getPos().scale(TowerView.WIDTH,
		                                       TowerView.HEIGHT);
		g2d.drawRect(corner.getX(), corner.getY(), width, height);
	}
	
	public static int getWidth(Tower tower)
	{
		return tower.getSize() * TowerView.WIDTH;
	}
	
	public static int getHeight(Tower tower)
	{
		return tower.getSize() * TowerView.HEIGHT;
	}
	
	public static Vector2i getCenter(Tower tower)
	{
		Vector2i dims = new Vector2i(TowerView.WIDTH, TowerView.HEIGHT);
		Vector2i towerDims = dims.scale(tower.getSize());
		Vector2i center = tower.getPos().scale(dims).add(towerDims.scale(0.5));
		return center;
	}
}
