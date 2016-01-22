package com.tormentaLabs.riobus.map.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tormentaLabs.riobus.R;
import com.tormentaLabs.riobus.core.model.LineModel;
import com.tormentaLabs.riobus.favorite.view.FavoriteStarView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by limazix on 14/01/16.
 */
@EViewGroup(R.layout.view_line_map_controller)
public class LineMapControllerView extends RelativeLayout implements View.OnClickListener {

    private LineModel line;

    @ViewById(R.id.changeSenseButton)
    ImageButton changeSenseButton;

    @ViewById(R.id.firstLineEndPoint)
    TextView firstLineEndPoint;

    @ViewById(R.id.secondLineEndPoint)
    TextView secondLineEndPoint;

    @ViewById(R.id.favoriteStarView)
    FavoriteStarView favoriteStarView;

    public LineMapControllerView(Context context) {
        super(context);
    }

    public LineMapControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineMapControllerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void build(LineModel line) {
        this.line = line;
        favoriteStarView.build(line);
        changeSenseButton.setOnClickListener(this);
        buildEndPoints();;
    }

    private void buildEndPoints () {
        if(line.description == null) return;

        if(line.description.equals("desconhecido")) {
            firstLineEndPoint.setText("sentido");
            secondLineEndPoint.setText("desconhecido");
        }else {
            String[] endPoints = line.description.split("X");
            firstLineEndPoint.setText(endPoints[0].trim());
            secondLineEndPoint.setText(endPoints[1].trim());
        }
    }

    @Override
    public void onClick(View view) {

    }
}