/**
 * Created by Marcin Michałek on 2015-02-07.
 */
package pl.michalek.marcin.picontroller.network;

/**
 * TODO Add class description...
 *
 * @author Marcin Michałek
 */
public class ServicePaths {
  public static final String ROOT = "http://192.168.2.196:8081";
  public static final String LIGHTS_ON = ROOT + "/light/on";
  public static final String LIGHTS_OFF = ROOT + "/light/off";
  public static final String LIGHTS_TOGGLE = ROOT + "/light/toggle";
  public static final String PLAY_SOUND = ROOT + "/music/play";
}
