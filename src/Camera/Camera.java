package Camera;

import Room.Room;
import Tool.Math3D;
import Tool.Point;
import Tool.Pyramid;

public class Camera extends Pyramid {
	public Camera(Point p, double horizontalFieldOfView, double verticalFieldOfView) {
		super(p, horizontalFieldOfView, verticalFieldOfView);
	}
	
	public boolean includePoint(Point point, Room room) {
		Math3D tool = new Math3D();
		return tool.IsPointInPyramidInCuboid(point, this, room.getRoomPoints());
	}
}
