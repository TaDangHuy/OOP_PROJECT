package Controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Camera.Camera;
import Object3D.Object3D;
import Room.Room;
import Tool.Point;

public class Main {

	public static void main(String[] args) {
        String url = "C:\\Users\\ADMIN\\eclipse-workspace\\CameraPro\\src\\Tool\\input.txt";

        List<String> listLine = readInput(url);
        
        String line1 = listLine.get(0);
        Room room = makeRoom(line1);
        
        int numObject = Integer.parseInt(listLine.get(1));
        
        List<Object3D> listObject3ds = makeListObject3Ds(listLine);
        
        List<Camera> listCameras = makeListCameras(listLine, numObject);
        
        
        Point testPoint = new Point(2,0,1);
        
        System.err.println(listCameras.get(0).includePoint(testPoint, room));
        
    }
	
	public static List <String> readInput(String url){
		FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        List <String> listLine = new ArrayList<String>();
        try {
            fileInputStream = new FileInputStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                listLine.add(line);
                line = bufferedReader.readLine();
            }
        }catch (Exception ex){
            System.out.println("Khong tim thay file");
        }
        
        return listLine;
	}
	
	public static Room makeRoom(String input) {
		String str = input.replaceFirst("\\(","");
        String str1 = str.substring(0, str.length()-1);
        String [] points = str1.split("\\) \\(");
        List<Point> listPointRoom = new ArrayList<Point>(8);
        for (int i = 0; i< points.length; i++){
            String [] xyz = points[i].split(", ");
            listPointRoom.add(new Point(Double.parseDouble(xyz[0]),Double.parseDouble(xyz[1]),Double.parseDouble(xyz[2])));
        }
		return new Room(listPointRoom);
	}
	
	public static List<Object3D> makeListObject3Ds(List<String> input){
		List<Object3D> object3ds = new ArrayList<Object3D>();
		
        for(int i=2;i<2+Integer.parseInt(input.get(1));i++){
            String str2 = input.get(i).replaceFirst("\\(","");
            String str3 = str2.substring(0, str2.length()-1);
            String [] pointS = str3.split("\\) \\(");
            List<Point> listPointObject = new ArrayList<Point>(8);
            for (int j = 0; j< pointS.length; j++){
                String [] xyz = pointS[j].split(", ");
                listPointObject.add(new Point(Double.parseDouble(xyz[0]),Double.parseDouble(xyz[1]),Double.parseDouble(xyz[2])));
            }
            object3ds.add(new Object3D(listPointObject));
        }
		return object3ds;
	}
	
	public static List<Camera> makeListCameras(List<String> input, int soVat){
		List<Camera> cameras = new ArrayList<Camera>();
		
		int k = (soVat+2)+1;
  
        for(int i = k;i<k+Integer.parseInt(input.get(k-1));i++){
            String [] cameraSpec = input.get(i).split("\\) ");
            String str2 = cameraSpec[0].replaceFirst("\\(","");
            String [] xyz = str2.split(", ");
            String [] view = cameraSpec[1].split(" ");
            Point cameraPoint = new Point(Double.parseDouble(xyz[0]),Double.parseDouble(xyz[1]),Double.parseDouble(xyz[2]));
           
           
            cameras.add(new Camera(cameraPoint,Double.parseDouble(view[0]),Double.parseDouble(view[1])));
        }
		
		return cameras;
	}
}