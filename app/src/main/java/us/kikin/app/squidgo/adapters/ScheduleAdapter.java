package us.kikin.app.squidgo.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import us.kikin.app.squidgo.R;
import us.kikin.app.squidgo.models.Schedule;
import us.kikin.app.squidgo.models.Stage;
import us.kikin.app.squidgo.views.StageView;

/**
 * Created by fvelazquez on 1/6/16.
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleCellHolder> {

    private List<Schedule> scheduleList = new ArrayList<>();
    private Context context;

    public ScheduleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ScheduleCellHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_cell, parent, false);
        ScheduleCellHolder vh = new ScheduleCellHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ScheduleCellHolder holder, int position) {
        Schedule schedule = scheduleList.get(position);
        if (schedule != null) {
            Resources res = context.getResources();
            String finalString = schedule.getStartTimeString() + " to " + schedule.getEndTimeString();
            String battleMode = String.format(res.getString(R.string.battle_mode), schedule.getRankedMode().getRuleName());
            holder.startTime.setText(finalString);
            holder.battleMode.setText(battleMode);
            // regular maps
            for (Stage stage : schedule.getRegularMode().getStages()) {
                StageView stageView = new StageView(context);
                stageView.setStage(stage);
                holder.regularLinear.addView(stageView);
            }

            for (Stage stage : schedule.getRankedMode().getStages()) {
                StageView stageView = new StageView(context);
                stageView.setStage(stage);
                holder.rankedLinear.addView(stageView);
            }
        }
    }

    @Override
    public int getItemCount() {
        // TODO: check null
        return scheduleList.size();
    }

    public void addItems(List<Schedule> items) {
        this.scheduleList.addAll(items);
        this.notifyDataSetChanged();
    }

    public static class ScheduleCellHolder extends RecyclerView.ViewHolder {

        public TextView startTime;
        public TextView battleMode;
        public LinearLayout rankedLinear;
        public LinearLayout regularLinear;

        public ScheduleCellHolder(View view) {
            super(view);

            startTime = (TextView) view.findViewById(R.id.start_time);
            battleMode = (TextView) view.findViewById(R.id.battle_mode);
            regularLinear = (LinearLayout) view.findViewById(R.id.regular_linear);
            rankedLinear = (LinearLayout) view.findViewById(R.id.ranked_linear);
        }
    }
}
