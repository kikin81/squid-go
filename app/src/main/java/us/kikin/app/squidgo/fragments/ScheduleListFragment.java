package us.kikin.app.squidgo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import us.kikin.app.squidgo.R;
import us.kikin.app.squidgo.adapters.ScheduleAdapter;
import us.kikin.app.squidgo.models.Schedule;
import us.kikin.app.squidgo.models.ScheduleWrapper;
import us.kikin.app.squidgo.service.SquidService;

/**
 * Created by fvelazquez on 1/6/16.
 */
public class ScheduleListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ScheduleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        adapter = new ScheduleAdapter(this.getContext());

        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        fetchSchedule();

        return view;
    }

    private void fetchSchedule() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SquidService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SquidService squidService = retrofit.create(SquidService.class);
        Call<ScheduleWrapper> call = squidService.getSchedule();
        call.enqueue(new Callback<ScheduleWrapper>() {
            @Override
            public void onResponse(Response<ScheduleWrapper> response, Retrofit retrofit) {
                if (response.body() != null) {
                    List<Schedule> scheduleList = response.body().getScheduleList();
                    if (scheduleList != null) {
                        adapter.addItems(scheduleList);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("SPLATGO", "failure" + t.getLocalizedMessage());
            }
        });
    }
}
