
public class Camera {
	Point point;
	Double wide_angle;
	Double high_angle;
	Double range;
	
	static final Double MAX_RANGE = 100.0;
	
	public Camera(Point point, Double wide_angle, Double high_angle, Double range) {
		this.point = point;
		this.wide_angle = wide_angle;
		this.high_angle = high_angle;
		this.range = range;
	}

	public Camera(Point point, Double wide_angle, Double high_angle) {
		this.point = point;
		this.wide_angle = wide_angle;
		this.high_angle = high_angle;
		this.range = MAX_RANGE;
	}
	
	
	
}
