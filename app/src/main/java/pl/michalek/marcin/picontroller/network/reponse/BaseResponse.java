package pl.michalek.marcin.picontroller.network.reponse;

import java.io.Serializable;

/**
 * Created by Marcin on 2015-02-14.
 */
public class BaseResponse implements Serializable {
    public boolean success;
    public String message;
    public int code;

    public BaseResponse(boolean success, String message, int code) {
        this.success = success;
        this.message = message;
        this.code = code;
    }
}
