package impl;

import services.EnvironmentService;
import services.MapService;
import services.MobService;
import utils.Cell;

public class EnvironmentImpl implements EnvironmentService{
	int h;
	int w;
	public MapService map;
	MobService[][] mapmob;

	@Override
	public int getHeight() {
		return h;
	}

	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public Cell getCellNature(int x, int y) {
		if(x>=map.getWidth()||y>=map.getHeight()) return null;
		return map.getCellNature(x, y);
		
	}


	public void init(MapService map) {
		this.map = map;
		this.mapmob= new MobService[map.getHeight()][map.getWidth()];
		this.h=map.getHeight();
		this.w=map.getWidth();
	}

	@Override
	public void openDoor(int x, int y) {
		if(map.getCellNature(x, y)==Cell.DNC || map.getCellNature(x, y)==Cell.DWC) {
			map.openDoor(x,y);
		}
	}

	@Override
	public MobService getCellContent(int x, int y) {
		return mapmob[y][x];
	}

	@Override
	public void closeDoor(int x, int y) {
		if(map.getCellNature(x, y)==Cell.DNO || map.getCellNature(x, y)==Cell.DWO) {
			map.closeDoor(x,y);
		}
	}

	@Override
	public void init(int w, int h) {
		throw new Error("init w, h EnvironmentService should not be called.");
	}

	@Override
	public void setCellContent(int x, int y, MobService mob) {
		mapmob[y][x] = mob;
	}


}





