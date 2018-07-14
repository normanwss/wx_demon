package com.example.wc.utils;

import com.google.common.base.Splitter;
import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class DateRange {

    private String dateRange;
    private Timestamp startTime;
    private Timestamp endTime;

    private Date startDate;
    private Date endDate;

    public DateRange() {
    }

    public DateRange(String dateRange) {
        setDateRange(dateRange);
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;

        String startTimeStr = null;
        String endTimeStr = null;
        if (StringUtils.hasText(dateRange)) {
            List<String> dateList = Splitter.on(" - ").trimResults().omitEmptyStrings().splitToList(dateRange);
            if (!CollectionUtils.isEmpty(dateList)) {
                startTimeStr = dateList.get(0);
                if (dateList.size() > 1) {
                    endTimeStr = dateList.get(1);
                }
            }
        }
        if (StringUtils.hasText(startTimeStr)) {
            startTime = new Timestamp(new DateTime(startTimeStr + " 00:00:00").getMillis());
            startDate = new DateTime(startTimeStr).toDate();
        }
        if (StringUtils.hasText(endTimeStr)) {
            endTime = new Timestamp(new DateTime(startTimeStr + " 23:59:59").getMillis());
            endDate = new DateTime(endTimeStr).toDate();
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

}
