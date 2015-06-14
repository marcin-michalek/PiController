/**
 * Created by Marcin Michałek on 2015-01-02.
 *
 */
package pl.michalek.marcin.picontroller.network.request;

import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;
import pl.michalek.marcin.picontroller.network.TenTimesLongDelay;
import pl.michalek.marcin.picontroller.network.ServicePaths;

/**
 * TODO Add class description...
 *
 * @author Marcin Michałek
 */
public class LightsOffRequest extends SpringAndroidSpiceRequest<String> {

  public LightsOffRequest() {
    super(String.class);
    setRetryPolicy(new TenTimesLongDelay());
  }

  @Override
  public String loadDataFromNetwork() throws Exception {
    return getRestTemplate().getForObject(ServicePaths.LIGHTS_OFF, String.class);
  }
}
