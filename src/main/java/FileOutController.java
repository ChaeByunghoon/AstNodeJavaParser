import Node.ParsingNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by chaebyeonghun on 2018. 2. 22..
 */
//파일 출력 클래스
public class FileOutController {

    public static String outputPath;
    String projectName;
    ArrayList<ArrayList<ParsingNode>> nodeDatas;
    ArrayList<String> paths;

    public FileOutController(ArrayList<ArrayList<ParsingNode>> nodeDatas, ArrayList<String> paths, String outputPath, String projectName){
        this.nodeDatas = nodeDatas;
        this.paths = paths;
        this.outputPath = outputPath;
        this.projectName = projectName;

    }
    //벡터 표현을 받아서 실행
    public void fileOut() throws IOException{
        BufferedWriter bw;

        try{
            for(int i = 0; i < paths.size(); i++){
                bw = new BufferedWriter(new FileWriter( outputPath + projectName +"_" + this.paths.get(i)+".txt"));
                for(int j = 0; j < nodeDatas.get(i).size(); j++){
                    bw.write(nodeDatas.get(i).get(j).getNodeRepresentation());
                    bw.newLine();
                }
                bw.close();
            }

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("System fail");
        }finally {
            System.out.println("Node Creation Success!");
        }

    }
}
