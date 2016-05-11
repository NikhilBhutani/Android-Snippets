package github.nikhilbhutani.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Nikhil Bhutani on 5/11/2016.
 */
public class CustomView extends View {

    Paint paint = new Paint();

    public CustomView(Context context) {
        super(context);
        paint.setColor(Color.rgb(50,205,50));
        paint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Hello Custom View",370,630,paint);
        invalidate();
    }
}
