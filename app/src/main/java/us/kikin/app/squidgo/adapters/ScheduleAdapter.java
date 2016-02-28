package us.kikin.app.squidgo.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import us.kikin.app.squidgo.R;
import us.kikin.app.squidgo.models.Schedule;

/**
 * Created by fvelazquez on 1/6/16.
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleCellHolder> {

    private List<Schedule> scheduleList = new ArrayList<>();
    private Context context;

    /**
     * Provide a reference to the views for each data item
     */
    public static class ScheduleCellHolder extends RecyclerView.ViewHolder {

        public TextView startTime;
        public TextView battleMode;
        public TextView regularMapTitle;
        public TextView regularMapTitleTwo;
        public TextView rankedMapTitle;
        public TextView rankedMapTitleTwo;
        public ImageView mapImage;
        public ImageView mapImageTwo;
        public ImageView rankedMapImage;
        public ImageView rankedMapImageTwo;

        public ScheduleCellHolder(View view) {
            super(view);

            startTime = (TextView) view.findViewById(R.id.start_time);
            battleMode = (TextView) view.findViewById(R.id.battle_mode);
            regularMapTitle = (TextView) view.findViewById(R.id.reg_map_title);
            regularMapTitleTwo = (TextView) view.findViewById(R.id.reg_map_title_two);
            rankedMapTitle = (TextView) view.findViewById(R.id.ran_map_title);
            rankedMapTitleTwo = (TextView) view.findViewById(R.id.ran_map_title_two);
            mapImage = (ImageView) view.findViewById(R.id.map_image);
            mapImageTwo = (ImageView) view.findViewById(R.id.map_image_two);
            rankedMapImage = (ImageView) view.findViewById(R.id.ranked_map_image);
            rankedMapImageTwo = (ImageView) view.findViewById(R.id.ranked_map_image_two);
        }
    }

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
        if (position < scheduleList.size()) {
            Schedule schedule = scheduleList.get(position);
            if (schedule != null) {
                Resources res = context.getResources();
                String finalString = schedule.getStartTimeString() + " to " + schedule.getEndTimeString();
                String battleMode = String.format(res.getString(R.string.battle_mode), schedule.getRankedMode().getRuleName());
                holder.startTime.setText(finalString);
                holder.battleMode.setText(battleMode);
                Log.d("SPLATGO", String.format("finalString: %s battleMode: %s", finalString, battleMode));
                // TODO: safety check brah
                String firstMapTitle = schedule.getRegularMode().getStages().get(0).getName();
                String secondMapTitle = schedule.getRegularMode().getStages().get(1).getName();
                String rankedMapTitle = schedule.getRankedMode().getStages().get(0).getName();
                String rankedMapTitleTwo = schedule.getRankedMode().getStages().get(1).getName();
                if (firstMapTitle != null) {
                    holder.regularMapTitle.setText(firstMapTitle);
                    holder.regularMapTitleTwo.setText(secondMapTitle);
                    holder.rankedMapTitle.setText(rankedMapTitle);
                    holder.rankedMapTitleTwo.setText(rankedMapTitleTwo);
                    Picasso.with(context).load("file:///android_asset/stage_arowanamall.jpg").into(holder.mapImage);
                    Picasso.with(context).load("file:///android_asset/stage_arowanamall.jpg").into(holder.mapImageTwo);
                    Picasso.with(context).load("file:///android_asset/stage_arowanamall.jpg").into(holder.rankedMapImage);
                    Picasso.with(context).load("file:///android_asset/stage_arowanamall.jpg").into(holder.rankedMapImageTwo);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        // TODO: check null
        int size = 0;
        if (scheduleList != null) size = scheduleList.size();

        return size;
    }

    public void addItems(List<Schedule> items) {
        this.scheduleList.addAll(items);
        this.notifyDataSetChanged();
    }
}
