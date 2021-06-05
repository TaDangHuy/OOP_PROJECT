package Room;

import java.util.ArrayList;
import java.util.List;

import Object3D.Object3D;
import Tool.Math3D;
import Tool.Point;

public class Room {
	private List<Point> RoomPoints = new ArrayList<Point>();
	
	public List<Point> getRoomPoints() {
		return RoomPoints;
	}

	public void setRoomPoints(List<Point> roomPoints) {
		RoomPoints = roomPoints;
	}
	
	public Room(List<Point> roomPoints) {
		super();
		RoomPoints = roomPoints;
	}

	//
	public boolean includePoint(Point point) {
		Math3D tool = new Math3D();
		return tool.IsPointInCuboid(point, RoomPoints);
	}
	
	public boolean includeObject3D(Object3D object3d) {
		Math3D tool = new Math3D();
		return tool.IsSmallCuboidInBigCuboid(object3d.getObject3DPoints(), this.RoomPoints);
	}
	
	
}
