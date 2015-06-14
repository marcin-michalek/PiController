/**
 * Created by Marcin Michałek on 2015-02-10.
 *
 */
package pl.michalek.marcin.picontroller.network;

import android.util.Log;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.retry.RetryPolicy;
import pl.michalek.marcin.picontroller.config.Constants;

/**
 * TODO Add class description...
 *
 * @author Marcin Michałek
 */
public class TenTimesLongDelay implements RetryPolicy {
  @Override
  public int getRetryCount() {
    return 10;
  }

  @Override
  public void retry(SpiceException e) {
    Log.e(Constants.LOGTAG, e.getMessage(), e);
  }

  @Override
  public long getDelayBeforeRetry() {
    return 10000;
  }
}
