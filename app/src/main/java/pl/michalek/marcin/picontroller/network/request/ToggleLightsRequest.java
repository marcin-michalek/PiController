/**
 * Created by Marcin Michałek on 2015-01-02.
 *
 */
package pl.michalek.marcin.picontroller.network.request;

import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;
import pl.michalek.marcin.picontroller.network.TenTimesLongDelay;
import pl.michalek.marcin.picontroller.network.ServicePaths;
import pl.michalek.marcin.picontroller.network.reponse.BaseResponse;

/**
 * TODO Add class description...
 *
 * @author Marcin Michałek
 */
public class ToggleLightsRequest extends SpringAndroidSpiceRequest<BaseResponse> {

  public ToggleLightsRequest() {
    super(BaseResponse.class);
    setRetryPolicy(new TenTimesLongDelay());
  }

  @Override
  public BaseResponse loadDataFromNetwork() throws Exception {
    return getRestTemplate().getForObject(ServicePaths.LIGHTS_TOGGLE, BaseResponse.class);
  }
}
