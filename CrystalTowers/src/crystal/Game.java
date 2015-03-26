package crystal;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import crystal.world.World;
import crystal.world.WorldView;

public class Game
{
	private JFrame          m_frame;
	private World           m_world;
	private WorldView       m_worldView;
	private TowerEditorView m_towerView;
	private CrystalShopView m_shopView;
	
	public Game()
	{
		m_frame = new JFrame("Crystal Towers");
		m_frame.setSize(800, 600);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		m_towerView = new TowerEditorView();
		m_shopView = new CrystalShopView();
		
		JSplitPane shopSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
		                                      m_towerView, m_shopView);
		
		m_world = new World();
		m_worldView = new WorldView(m_world, m_towerView);
		
		JSplitPane worldSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
		                                       m_worldView, shopSplit);
		m_frame.add(worldSplit);
		
		// Put this at the end to recursively make all components visible
		m_frame.setVisible(true);
	}
	
	public void run() throws InterruptedException
	{
		while (true)
		{
			m_world.update();
			m_frame.repaint();
			Thread.sleep(10);
		}
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Game game = new Game();
		
		game.run();
	}
}
