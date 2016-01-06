package us.kikin.app.squidgo.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fvelazquez on 1/5/16.
 */
public class ScheduleWrapper {

    private long updateTime;
    @SerializedName("splatfest")
    private boolean isSplatfest;
    @SerializedName("schedule")
    private List<Schedule> scheduleList;

    public ScheduleWrapper() {}

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isSplatfest() {
        return isSplatfest;
    }

    public void setSplatfest(boolean splatfest) {
        isSplatfest = splatfest;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
