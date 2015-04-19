/**
 * Created by Marcin Michałek on 2015-01-02.
 *
 */
package pl.michalek.marcin.picontroller.network.request;

import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;
import pl.michalek.marcin.picontroller.network.NoRetryPolicy;
import pl.michalek.marcin.picontroller.network.ServicePaths;

/**
 * TODO Add class description...
 *
 * @author Marcin Michałek
 */
public class LightsOnRequest extends SpringAndroidSpiceRequest<String> {

  public LightsOnRequest() {
    super(String.class);
    setRetryPolicy(new NoRetryPolicy());
  }

  @Override
  public String loadDataFromNetwork() throws Exception {
    return getRestTemplate().getForObject(ServicePaths.LIGHTS_ON, String.class);
  }
}
