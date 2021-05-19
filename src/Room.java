import java.util.ArrayList;

public class Room extends Rectangular {
	
	ArrayList<Camera> cameraList = new ArrayList<Camera>();
	ArrayList<Mono> monoList = new ArrayList<Mono>();
	
	public Room(Point A,Point B,Point C,Point D,Point E,Point F,Point G,Point H) {
		super(A, B, C, D, E, F, G, H);
	}
	
	// Chi can 3 toa do se fix cung thanh rectagual
	public Room(Double x, Double y ,Double z) {
		this.A = new Point(0.0 ,0.0 ,0.0);
		this.B = new Point(x ,0.0 ,0.0);
		this.C = new Point(x ,y ,0.0);
		this.D = new Point(0.0 ,y ,0.0);
		this.E = new Point(0.0 ,y, z);
		this.F = new Point(x ,y ,z);
		this.G = new Point(x ,0.0 ,z);
		this.H = new Point(0.0 ,0.0 ,z) ;
	}
	
	
	public boolean addMono(Mono mono) {//Them vat vao phong
		if (isValidMono(mono)) {  // kiem tra vat thoa man thi add
			monoList.add(mono);
			return true;
		}
		return false;
	}

	public boolean addCamera(Camera camera) {  //Them camera vao phong
		if (isValidCamera(camera)) {  //kiem tra vat thoa man thi add
			cameraList.add(camera);
			return true;
		}
		return false;
	}
	
	public boolean isValidCamera(Camera camera) {
		//Check dk (Cam dat trong phong , tren tuong hoac tren tran)
		if(camera.point.isInsideRectangular(this)) { //Diem dat camera trong phong
			for(int i=1;i<6;i++) {
				if(camera.point.isInPlane(this.planes.get(i)))
					return true;
			}
		}
			
		return false;
	}
	
	
	public boolean isValidMono(Mono mono) {  // Kiem tra xem vat vao co nam tren san hoac nam tren vat khac khong
		if(isInsideRoom(mono)) {
			if(isOnFloor(mono)) return true;
			if(isOverMono(mono)) return true;
		}
		return false;
	}
	
	public boolean isOverMono(Mono mono) {
		// Co nam tren 1 vat khac khong
		return false;
	}
	
	public boolean isOnFloor(Mono mono) {
		// Co nam tren san khong
		return false;
	}
	
	public boolean isInsideRoom(Mono mono) {
		// Co nam phong khong
		return false;
	}
	
	// Cac ham chuc nang c 
	
	public int  chucnangc(Point point) {
		if(insideMono(point)) return 1;
		else if(isinsideCamera(point)) return 2;
	    
		return 3;
		
	}
	
	public boolean isinsideCamera(Point point) {
		return false;
	}
	
	public boolean insideMono(Point point) {
		return false;
	}
	
	
	// ham bo tro
	
	
	
}
