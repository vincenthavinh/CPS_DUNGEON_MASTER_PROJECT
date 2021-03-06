package decorators;

import services.CowService;
import services.EnvironmentService;
import utils.Dir;

public class CowDecorator implements CowService{
	private final CowService delegate;
	
	public CowDecorator(CowService delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public void init(EnvironmentService env, int x, int y, Dir d, int hp) {
		delegate.init(env, x, y, d, hp);
	}

	@Override
	public int getHP() {
		return delegate.getHP();
	}

	@Override
	public void step() {
		delegate.step();
	}

	@Override
	public EnvironmentService getEnv() {
		return delegate.getEnv();
	}

	@Override
	public int getCol() {
		return delegate.getCol();
	}

	@Override
	public int getRow() {
		return delegate.getRow();
	}

	@Override
	public Dir getFace() {
		return delegate.getFace();
	}

	@Override
	public void init(EnvironmentService e, int x, int y, Dir d) {
		delegate.init(e, x, y, d);
		
	}

	@Override
	public void forward() {
		delegate.forward();
		
	}

	@Override
	public void backward() {
		delegate.backward();
		
	}

	@Override
	public void turnL() {
		delegate.turnL();
	}

	@Override
	public void turnR() {
		delegate.turnR();
	}

	@Override
	public void strafeL() {
		delegate.strafeL();
	}

	@Override
	public void strafeR() {
		delegate.strafeR();
	}

	@Override
	public void hit() {
		delegate.hit();
	}

	@Override
	public void takeHit() {
		delegate.takeHit();
	}
	
	

}
