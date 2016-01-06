package us.kikin.app.squidgo.service;

import retrofit.Call;
import retrofit.http.GET;
import us.kikin.app.squidgo.models.ScheduleWrapper;

/**
 * Created by fvelazquez on 1/5/16.
 */
public interface SquidService {

    String API_URL = "https://splatoon.ink";

    @GET("/schedule.json")
    Call<ScheduleWrapper> getSchedule();
}
