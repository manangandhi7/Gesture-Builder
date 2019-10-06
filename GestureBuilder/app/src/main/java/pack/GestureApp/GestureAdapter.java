package pack.GestureApp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manan on 2/2/2015.
 */
public class GestureAdapter extends ArrayAdapter<GestureHolder> {

    private static List<GestureHolder> mGestureList;
    private Context mContext;

    public GestureAdapter(ArrayList<GestureHolder> gestureList, Context context) {
        super(context, R.layout.gestures_list, gestureList);
        this.mGestureList = gestureList;
        this.mContext = context;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        GestureViewHolder holder = new GestureViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.gesture_list_item, null);

            // fill the layout with the right values
            TextView idView = (TextView) v.findViewById(R.id.gesture_id);
            TextView nameView = (TextView) v.findViewById(R.id.gesture_name);
            ImageView gestureImageView = (ImageView) v.findViewById(R.id.gesture_image);
            TextView nameViewRef = (TextView) v.findViewById(R.id.gesture_name_ref);

            holder.gestureId = idView;
            holder.gestureName = nameView;
            holder.gestureImage = gestureImageView;
            holder.gestureNameRef = nameViewRef;

            final ImageView mMenuItemButton =  (ImageView)v.findViewById(R.id.menu_item_options);
            mMenuItemButton.setClickable(true);

            v.setTag(holder);
        }
        else
            holder = (GestureViewHolder) v.getTag();

        GestureHolder gestureHolder = mGestureList.get(position);
        holder.gestureId.setText(String.valueOf(gestureHolder.getGesture().getID()));
        holder.gestureName.setText(gestureHolder.getNaam());
        holder.gestureNameRef.setText(gestureHolder.getNaam());

        try {
            holder.gestureImage.setImageBitmap(gestureHolder.getGesture().toBitmap(30, 30, 3, Color.YELLOW));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //holder.gestureImage.setImageResource(R.drawable.ic_launcher);

        return v;
    }

    class GestureViewHolder {
        public TextView gestureId;
        public TextView gestureName;
        public ImageView gestureImage;
        public TextView gestureNameRef;

    }
}
