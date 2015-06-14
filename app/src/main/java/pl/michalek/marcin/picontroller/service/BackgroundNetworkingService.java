package pl.michalek.marcin.picontroller.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import pl.michalek.marcin.picontroller.config.Constants;
import pl.michalek.marcin.picontroller.config.WidgetAction;
import pl.michalek.marcin.picontroller.network.reponse.BaseResponse;
import pl.michalek.marcin.picontroller.network.request.ToggleLightsRequest;
import pl.michalek.marcin.picontroller.widget.PiControllerWidgetProvider;

/**
 * Created by Marcin Michalek on 2015-06-14.
 * File belongs to project SendIt!
 */
public class BackgroundNetworkingService extends IntentService {
  private SpiceManager spiceManager = new SpiceManager(SpiceService.class);

  public BackgroundNetworkingService() {
    super(BackgroundNetworkingService.class.getSimpleName());
  }

  @Override
  public void onStart(Intent intent, int startId) {
    super.onStart(intent, startId);
    spiceManager.start(getApplicationContext());
  }

  @Override
  public void onDestroy() {
    spiceManager.shouldStop();
    super.onDestroy();
  }

  private void toggleLights() {
    spiceManager.execute(new ToggleLightsRequest(), new RequestListener<BaseResponse>() {
      @Override
      public void onRequestFailure(SpiceException spiceException) {
        Log.e(Constants.LOGTAG, spiceException.getMessage(), spiceException);
      }

      @Override
      public void onRequestSuccess(BaseResponse baseResponse) {

      }
    });
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    if (WidgetAction.TOOGLE_LIGHTS == intent.getIntExtra(PiControllerWidgetProvider.WIDGET_ACTION_KEY, -1)) {
      toggleLights();
    }
  }
}
