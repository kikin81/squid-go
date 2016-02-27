package us.kikin.app.squidgo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import us.kikin.app.squidgo.R;
import us.kikin.app.squidgo.models.Stage;

/**
 * Created by fvelazquez on 1/7/16.
 */
public class StageView extends RelativeLayout {

    private ImageView mapImage;
    private TextView mapTitleTextView;

    public StageView(Context context) {
        super(context);

        init();
    }

    public StageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public StageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.stage_view, this);
        this.mapImage = (ImageView) findViewById(R.id.map_image);
        this.mapTitleTextView = (TextView) findViewById(R.id.map_title);
    }

    public void setStage(Stage stage) {
        if (this.mapTitleTextView != null) {
            this.mapTitleTextView.setText(stage.getName());
        }
    }
}
