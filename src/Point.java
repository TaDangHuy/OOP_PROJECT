
public class Point {
	Double x ;
	Double y ;
	Double z ;
	
	public Point(Double x, Double y, Double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean isInPlane (Plane plane) {
		if((plane.a*x+plane.b*y+plane.c*z+plane.d) ==0) {
			return true;
		}
		
		return false;
	}
	
	public boolean isInsideRectangular(Rectangular rectangular) { // Kiem tra xem 1 diem co thuoc Rectangular ko
		Double volumeRec = rectangular.volume;
		
		Double sumVolume = 0.0;
		
		for(int i=0; i<rectangular.planes.size() ;i++) {
			Double height = calculateDistancetoPlane(this, rectangular.planes.get(i));
			sumVolume += calculateVolumeOfPyramid(height, rectangular.areas.get(i));
		}
		
		if(volumeRec== sumVolume) return true;
		
		return false;
	}
	
	//Ham bo tro
	public static Double calculateDistancetoPlane(Point point,Plane plane) {// Tinh khoang cach tu 1 diem den mat phang
		Double result = 0.0;
		//
		return result;
	}
	
	public static Double calculateVolumeOfPyramid(Double height,Double area ) {// Tinh khoang cach tu 1 diem den mat phang
		Double result = ((double)1/3)*height*area; // nen check lai
		
		return result;
	}

}
