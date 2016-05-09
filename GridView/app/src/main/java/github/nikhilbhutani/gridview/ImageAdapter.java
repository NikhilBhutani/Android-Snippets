package github.nikhilbhutani.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Nikhil Bhutani on 5/9/2016.
 */
public class ImageAdapter extends BaseAdapter {

    private Context myContext;

    public ImageAdapter(Context c)
    {
        myContext = c;
    }


    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if(view == null)
        {
            imageView = new ImageView(myContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1,1,1,1);

        }
        else
        {
            imageView = (ImageView)view;
        }
        imageView.setImageResource(mThumbIds[i]);
        return imageView;

    }

    //Keeping all images in the array
    private Integer[] mThumbIds={

            R.drawable.ariana_grande,
            R.drawable.beatles,
            R.drawable.beyonce,
            R.drawable.bob_dylan,
            R.drawable.britney_spears,
            R.drawable.bruno_mars,
            R.drawable.calvin_haris,
            R.drawable.chris_brown,
            R.drawable.demo_lovato,
            R.drawable.dr_dre,
            R.drawable.drake,
    };
}
