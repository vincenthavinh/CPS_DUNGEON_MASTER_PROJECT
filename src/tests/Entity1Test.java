package tests;

import contracts.EntityContract;
import impl.EntityImpl;

public class Entity1Test extends AbstractEntityTest {

	@Override
	public void beforeTests() {
		setEntity(new EntityContract(new EntityImpl()));
		//setEntity(new EntityImpl(
	}
}
