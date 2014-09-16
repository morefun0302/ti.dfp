package ti.dfp;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiContext.OnLifecycleEvent;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;

@Kroll.proxy(creatableInModule = DfpModule.class)
public class ViewProxy extends TiViewProxy implements OnLifecycleEvent {
	private View adMob;
	private static final String TAG = "AdMobViewProxy";

	public ViewProxy() {
		super();
	}

	@Override
	protected KrollDict getLangConversionTable() {
		KrollDict table = new KrollDict();
		table.put("title", "titleid");
		return table;
	}

	@Override
	public TiUIView createView(Activity activity) {
		adMob = new View(this);
		return adMob;
	}

	@Kroll.method
	public void requestAd() {
		Log.d(TAG, "requestAd()");
		adMob.requestAd();
	}

	@Override
	public void onDestroy(Activity activity) {
		adMob.destroy();
	}

	@Override
	public void onPause(Activity activity) {
		adMob.pause();
	}

	@Override
	public void onResume(Activity activity) {
		adMob.resume();
	}

	@Override
	public void onStart(Activity activity) {
	}

	@Override
	public void onStop(Activity activity) {
	}

}
