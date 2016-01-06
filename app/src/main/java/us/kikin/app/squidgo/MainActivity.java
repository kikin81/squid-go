package us.kikin.app.squidgo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import us.kikin.app.squidgo.models.ScheduleWrapper;
import us.kikin.app.squidgo.service.SquidService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SquidService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SquidService squidService = retrofit.create(SquidService.class);
        Call<ScheduleWrapper> call = squidService.getSchedule();
        call.enqueue(new Callback<ScheduleWrapper>() {
            @Override
            public void onResponse(Response<ScheduleWrapper> response, Retrofit retrofit) {
                Log.d(TAG, response.code() + "\nbody:" + response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());
            }
        });
    }
}
