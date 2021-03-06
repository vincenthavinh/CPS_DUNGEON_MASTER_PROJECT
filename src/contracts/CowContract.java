package contracts;

import decorators.CowDecorator;
import errors.PostconditionError;
import errors.PreconditionError;
import services.CowService;
import services.EnvironmentService;
import utils.Dir;

public class CowContract extends CowDecorator{

	public CowContract(CowService delegate) {
		super(delegate);
	}

	public void checkInvariants() {

	}

	public void init(EnvironmentService env, int x, int y, Dir d, int hp) {
		//pre
		if(hp>4 || hp <3) {
			throw new PreconditionError("Error illegal hp value for CowService init");
		}

		//run
		super.init(env, x, y, d, hp);

		//inv post
		checkInvariants();
	}

	@Override
	public void step() {
		//pre

		//inv pre
		checkInvariants();

		//capture
		int col_atpre = getCol();
		int row_atpre = getRow();

		//run
		super.step();

		//inv post
		checkInvariants();

		//post

		//post Col(M) - 1 ≤ Col(step(M)) ≤ Col(M) + 1
		if(!(col_atpre - 1 <= getCol()) || !(col_atpre +1 >= getCol())) {
			throw new PostconditionError("Error while moving column");
		}


		//post Row(M) - 1 ≤ Row(step(M)) ≤ Row(M) + 1
		if(!(row_atpre - 1 <= getRow()) || !(row_atpre +1 >= getRow())) {
			throw new PostconditionError("Error while moving row");
		}
	}

	@Override
	public void hit() {
		System.out.println("Meeeeh");
		checkInvariants();
		super.hit();
		checkInvariants();
	}

	@Override
	public void takeHit() {
		//pre
		// takeHit(E) implies HP(E)>0
		if(getHP()<=0){
			throw new PreconditionError("Error cannot kill the dead");
		}

		//inv pre
		checkInvariants();

		//capture
		int hp_atpre = super.getHP();
		//run
		super.takeHit();

		//inv post
		checkInvariants();

		//post 
		//takeHit(E) implies HP(E) = HP@pre - 1
		if(super.getHP()!=hp_atpre-1){
			throw new PostconditionError("Error hit didn't take 1 damage");
		}

	}

}
