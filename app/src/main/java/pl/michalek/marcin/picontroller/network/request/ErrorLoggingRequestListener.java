/**
 * Created by Marcin Michałek on 2015-02-10.
 *
 */
package pl.michalek.marcin.picontroller.network.request;

import android.util.Log;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import pl.michalek.marcin.picontroller.config.Constants;

/**
 * TODO Add class description...
 *
 * @author Marcin Michałek
 */
public abstract class ErrorLoggingRequestListener<Response> implements RequestListener<Response> {
  @Override
  public void onRequestFailure(SpiceException spiceException) {
    Log.e(Constants.LOGTAG, spiceException.getMessage(), spiceException);
  }

  @Override
  public abstract void onRequestSuccess(Response response);
}
