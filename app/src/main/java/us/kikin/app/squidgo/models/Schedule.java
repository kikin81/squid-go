package us.kikin.app.squidgo.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fvelazquez on 1/5/16.
 */
public class Schedule {

    private long startTime;
    private long endTime;
    @SerializedName("ranked")
    private RankedMode rankedMode;
    @SerializedName("regular")
    private RegularMode regularMode;

    public Schedule() {}

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public RankedMode getRankedMode() {
        return rankedMode;
    }

    public void setRankedMode(RankedMode rankedMode) {
        this.rankedMode = rankedMode;
    }

    public RegularMode getRegularMode() {
        return regularMode;
    }

    public void setRegularMode(RegularMode regularMode) {
        this.regularMode = regularMode;
    }
}
