package pl.michalek.marcin.picontroller.network.reponse;

/**
 * Created by Marcin on 2015-02-14.
 */
public class LightsStateResponse extends BaseResponse {
    public boolean lightsOn;
    public LightsStateResponse(String message, boolean lightsOn) {
        super(true, message, 0);
    }
}
