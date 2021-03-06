package biz.advancedcalendar.views.accessories;

import pl.polidea.treeview.R;
import pl.polidea.treeview.TreeNodeInfo;
import pl.polidea.treeview.TreeStateManager;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ActionMode;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class FancyColouredVariousSizesAdapter extends SimpleStandardAdapter {
    public FancyColouredVariousSizesAdapter(final Activity activity,
            //final Set<Long> selected,
            final TreeStateManager treeStateManager,
            final int numberOfLevels, final ActionMode.Callback actionModeCallback) {
        super(activity, treeStateManager, numberOfLevels, actionModeCallback);
    }

    @Override
    public LinearLayout updateView(final View view,
            final TreeNodeInfo treeNodeInfo) {
        final LinearLayout viewLayout = super.updateView(view, treeNodeInfo);
        final TextView descriptionView = (TextView) viewLayout
                .findViewById(R.id.demo_list_item_description);
        final TextView levelView = (TextView) viewLayout
                .findViewById(R.id.demo_list_item_level);
        descriptionView.setTextSize(20 - 2 * treeNodeInfo.getLevel());
        levelView.setTextSize(20 - 2 * treeNodeInfo.getLevel());
        return viewLayout;
    }

    @Override
    public Drawable getBackgroundDrawable(final TreeNodeInfo treeNodeInfo) {
        switch (treeNodeInfo.getLevel()) {
        case 0:
            return new ColorDrawable(Color.WHITE);
        case 1:
            return new ColorDrawable(Color.GRAY);
        case 2:
            return new ColorDrawable(Color.YELLOW);
        default:
            return null;
        }
    }
}