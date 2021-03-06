package implBug;

import java.util.Arrays;

import contracts.CowContract;
import contracts.EntityContract;
import services.EnvironmentService;
import services.MobService;
import services.PlayerService;
import utils.Cell;
import utils.Command;
import utils.Dir;

public class PlayerBugImpl implements PlayerService{
	int x;
	int y;
	int hp;
	Dir orientation;
	EnvironmentService env;
	Command lastCom;


	public int getHP() {
		return hp;
	}

	public void init(EnvironmentService env, int x, int y, Dir d, int hp) {
		this.env = env;
		this.x=x;
		this.y=y;
		orientation = d;
		this.hp = hp;
	}

	public void step() {
		if(lastCom!=null) {
			switch(lastCom){
			case FF:
				backward();
				break;
			case BB:
				forward();
				break;
			case RR:
				strafeL();
				break;
			case LL:
				strafeR();
				break;
			case TL:
				turnR();
				break;
			case TR:
				turnL();
				break;
			case HIT:
				hit();
				break;
			}
		}

		lastCom=null;
	}

	public EnvironmentService getEnv() {
		return env;
	}

	public int getCol() {
		return x;
	}

	public int getRow() {
		return y;
	}

	public Dir getFace() {
		return orientation;
	}

	public void init(EnvironmentService e, int x, int y, Dir d) {
		env=e;
		this.x=x;
		this.y=y;
		orientation=d;
		hp=10;
	}

	

	public void forward() {

		int xatpre = this.x;
		int yatpre = this.y;

		int xnew = -1;
		int ynew = -1;

		MobService entatpre = getEnv().getCellContent(this.x, this.y);

		switch(orientation){
		case N:
			ynew=yatpre+1;
			xnew=xatpre;
			break;
		case S:
			ynew=yatpre-1;
			xnew=xatpre;
			break;
		case E:
			xnew=xatpre+1;
			ynew=yatpre;
			break;
		case W:
			xnew=xatpre-1;
			ynew=yatpre;
			break;
		}

		if(!(Arrays.asList(Cell.DNC,Cell.DWC,Cell.WLL).contains(env.getCellNature(xnew,ynew))) && env.getCellContent(xnew, ynew)==null){
			env.setCellContent(xatpre, yatpre, null);
			env.setCellContent(xnew, ynew, entatpre);
			this.x=xnew;
			this.y=ynew;
		}

	}

	public void backward() {
		int xatpre = this.x;
		int yatpre = this.y;

		int xnew = -1;
		int ynew = -1;

		MobService entatpre = getEnv().getCellContent(this.x, this.y);

		switch(orientation){
		case N:
			ynew=yatpre-1;
			xnew=xatpre;
			break;
		case S:
			ynew=yatpre+1;
			xnew=xatpre;
			break;
		case E:
			xnew=xatpre-1;
			ynew=yatpre;
			break;
		case W:
			xnew=xatpre+1;
			ynew=yatpre;
			break;
		}

		if(!(Arrays.asList(Cell.DNC,Cell.DWC,Cell.WLL).contains(env.getCellNature(xnew,ynew))) && env.getCellContent(xnew, ynew)==null){
			env.setCellContent(xatpre, yatpre, null);
			env.setCellContent(xnew, ynew, entatpre);
			this.x=xnew;
			this.y=ynew;
		}

	}

	public void turnL() {
		switch(orientation){
		case N:
			orientation = Dir.W;
			break;
		case S:
			orientation = Dir.E;
			break;
		case E:
			orientation = Dir.N;
			break;
		case W:
			orientation = Dir.S;
			break;
		}
	}

	public void turnR() {

		switch(orientation){
		case N:
			orientation = Dir.E;
			break;
		case S:
			orientation = Dir.W;
			break;
		case E:
			orientation = Dir.S;
			break;
		case W:
			orientation = Dir.N;
			break;
		}

	}

	public void strafeL() {
		int xatpre = this.x;
		int yatpre = this.y;

		int xnew = -1;
		int ynew = -1;

		MobService entatpre = getEnv().getCellContent(this.x, this.y);

		switch(orientation){
		case N:
			ynew=yatpre;
			xnew=xatpre-1;
			break;
		case S:
			ynew=yatpre;
			xnew=xatpre+1;
			break;
		case E:
			xnew=xatpre;
			ynew=yatpre+1;
			break;
		case W:
			xnew=xatpre;
			ynew=yatpre-1;
			break;
		}

		if(!(Arrays.asList(Cell.DNC,Cell.DWC,Cell.WLL).contains(env.getCellNature(xnew,ynew))) && env.getCellContent(xnew, ynew)==null){
			env.setCellContent(xatpre, yatpre, null);
			env.setCellContent(xnew, ynew, entatpre);
			this.x=xnew;
			this.y=ynew;
		}
	}

	public void strafeR() {
		int xatpre = this.x;
		int yatpre = this.y;

		int xnew = -1;
		int ynew = -1;

		MobService entatpre = getEnv().getCellContent(this.x, this.y);

		switch(orientation){
		case N:
			ynew=yatpre;
			xnew=xatpre+1;
			break;
		case S:
			ynew=yatpre;
			xnew=xatpre-1;
			break;
		case E:
			xnew=xatpre;
			ynew=yatpre-1;
			break;
		case W:
			xnew=xatpre;
			ynew=yatpre+1;
			break;
		}

		if(!(Arrays.asList(Cell.DNC,Cell.DWC,Cell.WLL).contains(env.getCellNature(xnew,ynew))) && env.getCellContent(xnew, ynew)==null){
			env.setCellContent(xatpre, yatpre, null);
			env.setCellContent(xnew, ynew, entatpre);
			this.x=xnew;
			this.y=ynew;
		}

	}

	public Command getLastCom() {
		return lastCom;
	}

	public MobService getContent(int x, int y) {
		return env.getCellContent(this.x, this.y);
	}

	public Cell getNature(int x, int y) {
		return env.getCellNature(x, y);
	}

	public boolean getViewable(int x, int y) {
		//TODO
		//X=0
		if(x==0 && y==0) return true;
		if(x==0 && y<0) return true;
		else if(x==0 && y>0){
			for(int i=1; i<y; i++){

				if(Arrays.asList(Cell.DNC,Cell.DWC,Cell.WLL).contains(env.getCellNature(this.x+x, this.y+i))){
					return false;
				}
			}
			return true;
		}

		//X<0
		else if(x<0 && y==0)return true;
		else if(x<0 && y<0){
			if(getViewable(x,y+1) && getViewable(x+1,y)){
				return true;
			}
		}
		else if(x<0 && y > 0){
			for(int i = 1 ;i<y;i++){
				if(Arrays.asList(Cell.DNC,Cell.DWC,Cell.WLL).contains(env.getCellNature(this.x+x, this.y+i))){
					return false;
				}
			}
			return true;
		}

		//X>0
		else if(x>0 && y==0)return true;

		else if(x>0 && y<0){
			if(getViewable(x-1,y) && getViewable(x,y+1)){
				return true;
			}
		}

		else if(x>0 && y>0){
			for(int i = 1 ;i<y;i++){
				if(Arrays.asList(Cell.DNC,Cell.DWC,Cell.WLL).contains(env.getCellNature(this.x+x, this.y+i))){
					return false;
				}
			}
			return true;
		}

		return false;

	}


	public void setLastCom(Command com){
		this.lastCom = com ;
	}


	public void takeHit() {
		System.out.println("AIE");
		hp--;
		System.out.println("Maintenant j'ai " + hp + " HP");
	}
	
	public void hit(){
		System.out.println("impl hit");
		switch(orientation) {
		case N:
			if(getEnv().getCellContent(this.x, this.y+1) instanceof EntityContract) {;
				getEnv().getCellContent(this.x, this.y+1).takeHit();
			}
			else if(getEnv().getCellContent(this.x, this.y+1) instanceof CowContract) {
				getEnv().getCellContent(this.x, this.y+1).takeHit();
			}
			else if(getEnv().getCellNature(this.x, this.y+1) == Cell.DWC ) {
				getEnv().openDoor(this.x, this.y+1);
			}
			else if(getEnv().getCellNature(this.x, this.y+1) == Cell.DNC) {
				getEnv().openDoor(this.x, this.y+1);
			}
			else if(getEnv().getCellNature(this.x, this.y+1) == Cell.DWO ) {
				getEnv().closeDoor(this.x, this.y+1);
			}
			else if(getEnv().getCellNature(this.x, this.y+1) == Cell.DNO) {
				getEnv().closeDoor(this.x, this.y+1);
			}
			else {
			}
			break;
		case S:
			if(getEnv().getCellContent(this.x, this.y-1) instanceof EntityContract) {
				getEnv().getCellContent(this.x, this.y-1).takeHit();
			}
			else if(getEnv().getCellContent(this.x, this.y-1) instanceof CowContract) {
				getEnv().getCellContent(this.x, this.y-1).takeHit();
			}
			else if(getEnv().getCellNature(this.x, this.y-1) == Cell.DWC) {
				getEnv().openDoor(this.x, this.y-1);
			}
			else if( getEnv().getCellNature(this.x, this.y-1) == Cell.DNC) {
				getEnv().openDoor(this.x, this.y-1);
			}
			else if(getEnv().getCellNature(this.x, this.y-1) == Cell.DWO) {
				getEnv().closeDoor(this.x, this.y-1);
			}
			else if(getEnv().getCellNature(this.x, this.y-1) == Cell.DNO) {
				getEnv().closeDoor(this.x, this.y-1);
			}
			else {
			}
			break;
		case E:
			if(getEnv().getCellContent(this.x+1, this.y) instanceof EntityContract) {
				getEnv().getCellContent(this.x+1, this.y).takeHit();
			}
			else if(getEnv().getCellContent(this.x+1, this.y) instanceof CowContract) {
				getEnv().getCellContent(this.x+1, this.y).takeHit();
			}
			else if(getEnv().getCellNature(this.x+1, this.y) == Cell.DWC) {
				getEnv().openDoor(this.x+1, this.y);
			}
			else if(getEnv().getCellNature(this.x+1, this.y) == Cell.DNC) {
				getEnv().openDoor(this.x+1, this.y);
			}
			else if(getEnv().getCellNature(this.x+1, this.y) == Cell.DWO ) {
				getEnv().closeDoor(this.x+1, this.y);
			}
			else if(getEnv().getCellNature(this.x+1, this.y) == Cell.DNO) {
				getEnv().closeDoor(this.x+1, this.y);
			}
			else {
			}
			break;
		case W:
			if(getEnv().getCellContent(this.x-1, this.y) instanceof EntityContract) {
				getEnv().getCellContent(this.x-1, this.y).takeHit();
			}
			else if(getEnv().getCellContent(this.x-1, this.y) instanceof CowContract) {
				getEnv().getCellContent(this.x-1, this.y).takeHit();
			}
			else if(getEnv().getCellNature(this.x-1, this.y) == Cell.DWC ) {
				getEnv().openDoor(this.x-1, this.y);
			}
			else if(getEnv().getCellNature(this.x-1, this.y) == Cell.DNC) {
				getEnv().openDoor(this.x-1, this.y);
			}
			else if(getEnv().getCellNature(this.x-1, this.y) == Cell.DWO) {
				getEnv().closeDoor(this.x-1, this.y);
			}
			else if(getEnv().getCellNature(this.x-1, this.y) == Cell.DNO) {
				getEnv().closeDoor(this.x-1, this.y);
			}
			else {
			}
			break;
		}
	}



}
