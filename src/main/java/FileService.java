import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileService {

    public void saveFile(List<Map<String, Object>> list) {

        try {
            // fileUtils 사용
            File file = new File("data.txt");
            FileUtils.write(file, "", false);

            for(int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);

                String name = (String) map.get("NAME");
                double temp = Double.parseDouble(map.get("TEMP").toString());
                int hour = Integer.parseInt(map.get("HOUR").toString());
                int min = Integer.parseInt(map.get("MIN").toString());
                String abroad_visit = (String) map.get("ABROAD_VISIT");
                String reg_date = (String) map.get("REG_DATE");

                FileUtils.write (file,name + " / " + temp + " / " + hour + " / " + min + " / " + abroad_visit + " / "+ reg_date + "\n", true);
            }
            // fileUtils 사용
        }catch (FileNotFoundException e) {
            System.out.println("data.txt 파일이 존재하지 않습니다.");
        }catch(IOException e){
            System.out.println(e);
        }
    }
}