package impl;

import services.EnvironmentService;
import services.MobService;
import services.PlayerService;
import utils.Cell;
import utils.Command;
import utils.Dir;

public class PlayerImpl implements PlayerService{
	int x;
	int y;
	int hp;
	Dir orientation;
	EnvironmentService env;
	
	
	@Override
	public int getHP() {
		return hp;
	}

	@Override
	public void init(EnvironmentService env, int x, int y, Dir d, int hp) {
		this.env = env;
		this.x=x;
		this.y=y;
		orientation = d;
		this.hp = hp;
	}

	@Override
	public void step() {
		//TODO
	}

	@Override
	public EnvironmentService getEnv() {
		return env;
	}

	@Override
	public int getCol() {
		return x;
	}

	@Override
	public int getRow() {
		return y;
	}

	@Override
	public Dir getFace() {
		return orientation;
	}

	@Override
	public void init(EnvironmentService e, int x, int y, Dir d) {
		env=e;
		this.x=x;
		this.y=y;
		orientation=d;
		hp=10;
		
	}

	@Override
	public void forward() {
	}

	@Override
	public void backward() {
	}

	@Override
	public void turnL() {
	}

	@Override
	public void turnR() {	
	}

	@Override
	public void strafeL() {	
	}

	@Override
	public void strafeR() {
	}

	@Override
	public Command getLastCom() {
		return null;
	}

	@Override
	public MobService getContent(int x, int y) {
		
		return env.getCellContent(x, y);
	}

	@Override
	public Cell getNature(int x, int y) {
		return env.getCellNature(x, y);
	}

	@Override
	public boolean getViewable(int x, int y) {
		return this.getViewable(x, y);
	}

}
