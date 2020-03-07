package wat.edu.pl.visitapp.view.authenticated.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import wat.edu.pl.visitapp.R;

public class ExpandableDatesAdapter extends BaseExpandableListAdapter
{
    private Context context;
    private List<String> headersList;
    private HashMap<String, List<String>> itemsMap;

    public ExpandableDatesAdapter(Context context, List<String> headersList, HashMap<String, List<String>> itemsMap) {
        this.context = context;
        this.headersList = headersList;
        this.itemsMap = itemsMap;
    }

    @Override
    public int getGroupCount() {
        return headersList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return itemsMap.get(headersList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headersList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return itemsMap.get(headersList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group = (String) getGroup(groupPosition);
        if (convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_recyclerview_header, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.tvExpandableHeader);
        textView.setText(group);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child = (String) getChild(groupPosition, childPosition);
        if (convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_recyclerview_item, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.tvExpandableItem);
        textView.setText(child);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

//    private void animateExpand() {
//        RotateAnimation rotate =
//                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
//        rotate.setDuration(300);
//        rotate.setFillAfter(true);
//        ivArrow.setAnimation(rotate);
//    }
//
//    private void animateCollapse() {
//        RotateAnimation rotate =
//                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
//        rotate.setDuration(300);
//        rotate.setFillAfter(true);
//        ivArrow.setAnimation(rotate);
//    }
}
