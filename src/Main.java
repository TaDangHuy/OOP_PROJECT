import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//Doc file lay du lieu
		//Doc 8 diem dau tien luu vao list inputRoomPoint	
		ArrayList<Point> inputRoomPoint = new ArrayList<Point>();
		{
			inputRoomPoint.add(new Point(0.0, 0.0, 0.0));
			inputRoomPoint.add(new Point(2.0, 0.0, 0.0));
			inputRoomPoint.add(new Point(2.0, 1.0, 0.0));
			inputRoomPoint.add(new Point(0.0, 1.0, 0.0));
			inputRoomPoint.add(new Point(0.0, 0.0, 1.0));
			inputRoomPoint.add(new Point(2.0, 0.0, 1.0));
			inputRoomPoint.add(new Point(2.0, 0.0, 1.0));
			inputRoomPoint.add(new Point(0.0, 1.0, 1.0));
		}
		
		ArrayList<Point> inputMonoPoint = new ArrayList<Point>();
		{
			inputMonoPoint.add(new Point(0.5, 0.25, 0.0));
			inputMonoPoint.add(new Point(1.5, 0.25, 0.0));
			inputMonoPoint.add(new Point(1.5, 0.75, 0.0));
			inputMonoPoint.add(new Point(0.5, 0.75, 0.0));
			inputMonoPoint.add(new Point(0.5, 0.25, 0.0));
			inputMonoPoint.add(new Point(1.5, 0.25, 1.0));
			inputMonoPoint.add(new Point(1.5, 0.75, 1.0));
			inputMonoPoint.add(new Point(0.5, 0.75, 0.0));
		}
		
		Room rom = new Room(inputRoomPoint.get(0),inputRoomPoint.get(1),inputRoomPoint.get(2)
							,inputRoomPoint.get(3),inputRoomPoint.get(4),inputRoomPoint.get(5),inputRoomPoint.get(6),inputRoomPoint.get(7));
		
		Mono mono1 = new Mono(inputMonoPoint.get(0),inputMonoPoint.get(1),inputMonoPoint.get(2)
				,inputMonoPoint.get(3),inputMonoPoint.get(4),inputMonoPoint.get(5),inputMonoPoint.get(6),inputMonoPoint.get(7));
		//mono1.isRectangular();
		
		
		Camera camera1 = new Camera(new Point(0.0, 0.5, 0.5), 90.0, 90.0);
		Camera camera2 = new Camera(new Point(1.0, 1.0, 0.5), 90.0, 90.0);
		
		rom.addMono(mono1);

		rom.addCamera(camera1);
		rom.addCamera(camera2);
		
		/// lam cau c
		Point inputPoint = new Point(null, null, null);
		switch (rom.chucnangc(inputPoint)) {
		case 1: //
		case 2: //
		case 3: //
		default:
			throw new IllegalArgumentException("Unexpected value: " + rom);
		}
		
		
	}

}
