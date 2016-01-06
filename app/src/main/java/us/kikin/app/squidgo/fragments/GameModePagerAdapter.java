package us.kikin.app.squidgo.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import us.kikin.app.squidgo.models.ScheduleWrapper;
import us.kikin.app.squidgo.service.SquidService;

/**
 * Created by fvelazquez on 1/5/16.
 */
public class GameModePagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "FragmentPagerAdapter";
    private ScheduleWrapper scheduleObject;

    public GameModePagerAdapter(FragmentManager fm) {
        super(fm);

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
                if (response.body() != null) {
                    scheduleObject = (ScheduleWrapper) response.body();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());
            }
        });
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "new fragment");
        return new GameModeFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Regular";
            case 1:
                return "Ranked";
        }

        return null;
    }
}
