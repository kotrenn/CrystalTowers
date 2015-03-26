# CrystalTowers
Timeline:  Spring 2015

A tower defense style game with potential influences from SpaceChem and Infinifactory.

The main focus of this project was to gain a refresher on Java, Java Swing, and contemporary software development practices.

The original project comes from a game I worked on right after finishing high school in 2008.  A couple friends had challenged me to make my own tower defense game, and I put together a basic engine real quick in C++.  Much adolescent praise was had.  During the summer, I started adding a few nifty features and developed my own (simple) GUI from scratch.

The main unique thing about my Crystal Tower Defense game was that each tower had four slots for crystals to be placed inside.  Players could buy crystals from a shop of varying colors.  Each color gave a different effect:

Red - Splash damage
Yellow - Multiple shots
Green - Poison damage over time
Blue - Slows enemies
Purple - Faster firing rate

The effects would stack and combine with each other.  Thus a player could put together a tower with the effects that are needed in a particular area.  Additionally, there was emphasis on specialization.  Towers which had several red crystals would have a much larger splash radius than a tower which had one each of four colors.

To add in a bit of balance with adding crystals, I made it so that towers which had at least three out of four of their crystal slots occupied grow.  Once a tower reached three crystals, it would take up a 2x2 area in the overworld grid, as opposed to the initial 1x1 area.  This then gave an additional resource management challenge for players with spatial layout and density of towers.

The project died fairly quickly.  I revisited it occasionally over time, thinking of new ways to spice up the game.

When it came time to look for jobs and develop myself professionally in 2015, I chose the Crystal Tower Defense game as a practice project.  The idea was that I would have a clear vision of where several things would go since I had a model to base it upon.  Yet now that I wasn't simply a fresh out of high school student, I could actually use the knowledge I had accrued in the meantime.  Particularly, I wanted a chance to practice GUI development and general interface design.  I chose Swing since I had experience with it, the organization of the library was simple, and would likely have many similarities to anything I might work with in industry.

Currently the project is on hold as I focus on finding a job and stability in life.  At the moment the project just runs a simple loop of enemies walking down a fixed path with a tower repeatedly firing at them.

The first milestone will be to get it to about the level it was at when I abandoned the project before college.  This will include:

- Enemies having health points and the capability of dying
- Purchasing of different colored crystals
- Having random crystals which offer the opportunity to obtain non-basic crystals (such as purple)
- Implementing the basic effects
- Making a usable, but not necessarily polished, interface

After this, my goals are to expand the game into a large-scale world.  I've been interested in doing a tower defense game that incorporates enemies moving along branching paths.  I also enjoy games which involve setting up stable production lines, such as SpaceChem, Infinifactory, and Factorio.  So one potential long-term goal is to make a procedurally generated overworld where players focus on setting up a reliable defense system for various locations.  There will of course need to be some kind of central renewable / invulnerable area in case a player messes up and finds everything around them is failing.
