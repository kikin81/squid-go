package us.kikin.app.squidgo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import us.kikin.app.squidgo.R;

/**
 * Created by fvelazquez on 1/5/16.
 */
public class GameModeFragment extends Fragment {

    public GameModeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_mode, container, false);
        return rootView;
    }
}
