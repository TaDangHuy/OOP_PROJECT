package Tool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        Math3D tool = new Math3D();
        String url = "C:\\Users\\ADMIN\\eclipse-workspace\\CameraPro\\src\\Tool\\input.txt";

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
        for(int i = 0 ; i < listLine.size(); i++){
            System.out.println(listLine.get(i));
        }
        String str = listLine.get(0).replaceFirst("\\(","");
        String str1 = str.substring(0, str.length()-1);
        String [] points = str1.split("\\) \\(");
        List<Point> listPointRoom = new ArrayList<Point>(8);
        for (int i = 0; i< points.length; i++){
            String [] xyz = points[i].split(", ");
            listPointRoom.add(new Point(Double.parseDouble(xyz[0]),Double.parseDouble(xyz[1]),Double.parseDouble(xyz[2])));
        }
        System.out.println("phong "+tool.IsStadardAxisCuboid(listPointRoom));
        System.out.println("phong " + tool.IsCuboid(listPointRoom));
        System.out.println(Integer.parseInt(listLine.get(1)));
        int i;
        for(i=2;i<2+Integer.parseInt(listLine.get(1));i++){
            String str2 = listLine.get(i).replaceFirst("\\(","");
            String str3 = str2.substring(0, str2.length()-1);
            String [] pointS = str3.split("\\) \\(");
            List<Point> listPointObject = new ArrayList<Point>(8);
            for (int j = 0; j< pointS.length; j++){
                String [] xyz = pointS[j].split(", ");
                listPointObject.add(new Point(Double.parseDouble(xyz[0]),Double.parseDouble(xyz[1]),Double.parseDouble(xyz[2])));
            }

            System.out.println("Vat:"+tool.IsCuboid(listPointObject));
            System.out.println("Vat nam trong phong" + tool.IsSmallCuboidInBigCuboid(listPointObject,listPointRoom));
        }
        System.out.println("iiiiiiiii" +i );
        int k = i+1;
        List<Pyramid> pyramidList = new ArrayList<Pyramid>(8);
        for(i = k;i<k+Integer.parseInt(listLine.get(k-1));i++){
            String [] cameraSpec = listLine.get(i).split("\\) ");
            String str2 = cameraSpec[0].replaceFirst("\\(","");
            String [] xyz = str2.split(", ");
            String [] view = cameraSpec[1].split(" ");
            Point cameraPoint = new Point(Double.parseDouble(xyz[0]),Double.parseDouble(xyz[1]),Double.parseDouble(xyz[2]));
            System.out.println("cam nam tren tuong " + tool.IsPointInWall(cameraPoint,listPointRoom));
            System.out.println(""+Double.parseDouble(view[0])+", "+Double.parseDouble(view[1]));
            pyramidList.add(new Pyramid(cameraPoint,Double.parseDouble(view[0]),Double.parseDouble(view[1])));

        }
        Point testPoint = new Point(2,0,1);
        boolean abv = tool.IsPointInPyramidInCuboid(testPoint,pyramidList.get(1),listPointRoom);
        System.out.println("diem thuoc vung nhin thay khong" + abv);
    }

}
