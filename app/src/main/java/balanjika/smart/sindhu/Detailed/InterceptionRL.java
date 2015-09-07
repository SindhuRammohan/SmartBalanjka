package balanjika.smart.sindhu.Detailed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class InterceptionRL extends RelativeLayout {

	public InterceptionRL(Context context) {
		super(context);
	}
	public InterceptionRL(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public InterceptionRL(Context context, AttributeSet attrs, int i) {
		super(context, attrs, i);
	}
	public Runnable r;
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		r.run();
		return super.dispatchTouchEvent(ev);
	}
}
