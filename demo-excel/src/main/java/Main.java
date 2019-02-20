import com.demo.excel.institution.Excel;
import com.demo.excel.institution.Sql;
import com.demo.excel.jdbc.JdbcTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String sql = Sql.sql0 ;
        String fileName = "机构活动打卡数据%s.xls";

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime startTime = LocalDateTime.parse("2018-10-01 00:00:00", format);
        LocalDateTime endTime = LocalDateTime.parse("2018-10-31 00:00:00", format);

        for (int i = 0; i < endTime.compareTo(startTime) + 1; i++) {
            String currentTime = startTime.plusDays(i).format(format);
            String currentDay = startTime.plusDays(i).format(formatDay);
            String exeSql = sql.replace("dayStartTime", currentTime).replace("dayEndTime", startTime.plusDays(i + 1).format(format));

            String fileNameVarDay = String.format(fileName, currentDay);

//            System.out.print(exeSql);
//            System.out.println(fileNameVarDay);
            Excel.export(JdbcTemplate.exeSql(exeSql), fileNameVarDay);
            Thread.sleep(500);
        }
    }
}
