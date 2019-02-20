package com.demo.excel.institution;

public interface Sql {
    String sql0 = "" +
            "select i.name  , a.name,count(distinct user.id) countNum  \n" +
            "from wechat_user user   \n" +
            "left join market_activity.review_info submit on user.wechat_code = submit.wechat_code  \n" +
            "left join activity a on a.id = submit.activity_id\n" +
            "left join institution.institution i on i.id = submit.institution_id  \n" +
            "where user.deleted = 0  \n" +
            "and submit.create_time < concat(date_format('dayEndTime','%Y-%m-%d'),' ','00:00:00') \n" +
            "and submit.create_time >= concat(date_format('dayStartTime','%Y-%m-%d'),' ','00:00:00') \n" +
            "group by submit.institution_id ,a.id ";
}
