package pl.michalek.marcin.picontroller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;
import pl.michalek.marcin.picontroller.R;
import pl.michalek.marcin.picontroller.network.request.ErrorLoggingRequestListener;
import pl.michalek.marcin.picontroller.network.request.LightsOffRequest;
import pl.michalek.marcin.picontroller.network.request.LightsOnRequest;
import pl.michalek.marcin.picontroller.network.request.PlaySoundRequest;

public class MainActivity extends BaseRestActivity {

  @InjectView(R.id.log)
  TextView log;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
  }


  @OnClick(R.id.lightToggle)
  void lightsOn(View lightToggle) {
    SpringAndroidSpiceRequest<String> lightToggleRequest =
        ((ToggleButton) lightToggle).isChecked() ? new LightsOnRequest() : new LightsOffRequest();

    spiceManager.execute(lightToggleRequest, new ErrorLoggingRequestListener<String>() {
      @Override
      public void onRequestSuccess(String s) {
        log.setText(s);
      }
    });
  }

  @OnClick(R.id.soundButton)
  void playSound(View soundButton) {
    spiceManager.execute(new PlaySoundRequest(), new ErrorLoggingRequestListener<String>() {
      @Override
      public void onRequestSuccess(String s) {
        log.setText(s);
      }
    });
  }
}
