import java.util.ArrayList;

public class Rectangular {
	Point A;
	Point B;
	Point C;
	Point D;
	Point E;
	Point F;
	Point G;
	Point H;
	
	Double volume ;
	
	ArrayList<Double> areas = new ArrayList<Double>(); 
	
	ArrayList<Plane> planes = new ArrayList<Plane>();
	
	public Rectangular() {
		
	}
	
	public Rectangular(Point A,Point B,Point C,Point D,Point E,Point F,Point G,Point H) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
		this.E = E;
		this.F = F;
		this.G = G;
		this.H = H;
		
		areas.add(calculateArea(A, B, C, D));
		areas.add(calculateArea(E, F, G, H));
		areas.add(calculateArea(B, C, F, G));
		areas.add(calculateArea(A, D, E, H));
		areas.add(calculateArea(A, B, G, H));
		areas.add(calculateArea(C, D, E, F));
		
		planes.add(initPlane(A, B, C));
		planes.add(initPlane(E, F, G));
		planes.add(initPlane(B, C, F));
		planes.add(initPlane(A, D, E));
		planes.add(initPlane(A, B, G));
		planes.add(initPlane(C, D, E));
		
		this.volume = calculateVolumeOfRec(this);
	}
	
	
	public boolean isRectangular() {
		//Kiem tra theo hinh da chuan hoa
		//Kiem tra xem co phai la HHCN khong
		return false;
	}
	
	//ham bo tro
	public static Double calculateArea(Point point1,Point point2,Point point3,Point point4) {
		// Tinh dien tich hinh chu nhat co cac dinh lan luon la 1, 2, 3, 4
		return 0.0;
	}
	
	public static Double calculateVolumeOfRec(Rectangular rectangular) {
		// Tinh the tich rectangular
		return 0.0;
	}
	
	
	public static Plane initPlane(Point A, Point B , Point C) { //Tao ra 1 mat phang tu 3 diem 
		
		return new Plane(null, null, null, null);
	}
	
	public static StraightLine initStraightLine(Point A , Point B) { //Tao ra 1 duong thang tu 2 diem
		
		return new StraightLine(null, null, null, null, null, null);
	}
	

	
}
