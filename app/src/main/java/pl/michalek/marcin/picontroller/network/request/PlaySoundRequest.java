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
public class PlaySoundRequest extends SpringAndroidSpiceRequest<String> {

  public PlaySoundRequest() {
    super(String.class);
    setRetryPolicy(new NoRetryPolicy());
  }

  @Override
  public String loadDataFromNetwork() throws Exception {
    return getRestTemplate().getForObject(ServicePaths.PLAY_SOUND, String.class);
  }
}
