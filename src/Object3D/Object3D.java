package Object3D;

import java.util.ArrayList;
import java.util.List;

import Tool.Point;

public class Object3D {
	
	private List<Point> Object3DPoints =new ArrayList<Point>();

	public List<Point> getObject3DPoints() {
		return Object3DPoints;
	}

	public void setObject3DPoints(List<Point> object3dPoints) {
		Object3DPoints = object3dPoints;
	}

	public Object3D(List<Point> object3dPoints) {
		super();
		Object3DPoints = object3dPoints;
	}
	
	
}

