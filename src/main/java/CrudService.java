import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudService {

    BufferedReader br;

    public void readData(DQLService dql) {
        List<Map<String, Object>>  resultList = dql.selectAll();
        dql.printMapList(resultList);
    }

    public HashMap<String, Object> createData() {

//        int num;
//        String name;
//        int korScore;
//        int engScore;
//        int mathScore;
//        String grade;
//        String regDate;
        int id;
        String name;
        double temp;
        int hour;
        int min;
        String abroad_visit;
        String regDate;

        final HashMap<String, Object> dataMap = new HashMap<String, Object>();

        try {
            System.out.println("이름 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            name = br.readLine();
            dataMap.put("NAME"   , name);

            System.out.println("체온 입력 (ex. 36.5)");
            temp = Double.parseDouble(br.readLine());
            dataMap.put("TEMP"   , temp);

            System.out.println("입장 시간 입력(시 ex. 13)");
            hour = Integer.parseInt(br.readLine());
            dataMap.put("HOUR" , hour);

            System.out.println("입장 시간 입력(분 ex. 30)");
            min = Integer.parseInt(br.readLine());
            dataMap.put("MIN" , min);

            System.out.println("2주 내 해외 방문 여부 (y/n)");
            abroad_visit = br.readLine();
            if(abroad_visit.equals("y")||abroad_visit.equals("n"))
                dataMap.put("ABROAD_VISIT"   , abroad_visit);
            else
                System.out.println("y 또는 n으로만 입력해주세요");

        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        regDate = date.format(formatter);

        dataMap.put("REG_DATE" , regDate);

        return dataMap;
    }

    public HashMap<String, Object> updateData() {

//        int num;
//        String name;
//        int korScore;
//        int engScore;
//        int mathScore;
//        String grade;
//        String regDate;
        int id;
        String name;
        double temp;
        int hour;
        int min;
        String abroad_visit;
        String regDate;

        final HashMap<String, Object> updateMap = new HashMap<String, Object>();

        try {
            System.out.println("수정할 번호 입력");
            br = new BufferedReader(new InputStreamReader(System.in));

            id = Integer.parseInt(br.readLine());
            updateMap.put("updateID" , id);

            System.out.println("이름 입력");
            name = br.readLine();
            updateMap.put("NAME"   , name);

            System.out.println("체온 입력 (ex. 36.5)");
            temp = Integer.parseInt(br.readLine());
            updateMap.put("TEMP"   , temp);

            System.out.println("입장 시간 입력(시 ex. 13)");
            hour = Integer.parseInt(br.readLine());
            updateMap.put("HOUR" , hour);

            System.out.println("입장 시간 입력(분 ex. 30)");
            min = Integer.parseInt(br.readLine());
            updateMap.put("MIN" , min);

            System.out.println("2주 내 해외 방문 여부 (y/n)");
            abroad_visit = br.readLine();
            if(abroad_visit.equals("y")||abroad_visit.equals("n"))
                updateMap.put("ABROAD_VISIT"   , abroad_visit);
            else
                System.out.println("y 또는 n으로만 입력해주세요");

            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            regDate = date.format(formatter);
            updateMap.put("REG_DATE" , regDate);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return updateMap;
    }

    public int deleteData() {

        int num = 0;

        try {
            System.out.println("삭제할 번호 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return num;
    }

}

