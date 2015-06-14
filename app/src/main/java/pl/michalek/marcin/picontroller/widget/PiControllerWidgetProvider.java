package pl.michalek.marcin.picontroller.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;
import pl.michalek.marcin.picontroller.R;
import pl.michalek.marcin.picontroller.config.WidgetAction;
import pl.michalek.marcin.picontroller.service.BackgroundNetworkingService;

/**
 * Created by Marcin Michalek on 2015-06-14.
 * File belongs to project SendIt!
 */
public class PiControllerWidgetProvider extends AppWidgetProvider {
  public static String WIDGET_ACTION_KEY = PiControllerWidgetProvider.class.getName() + "WIDGET_ACTION";

  @Override
  public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    ComponentName thisWidget = new ComponentName(context, PiControllerWidgetProvider.class);
    int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
    for (int widgetId : allWidgetIds) {
      final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.app_widget);
      Intent intent = new Intent(context, PiControllerWidgetProvider.class);
      intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
      PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
          0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
      remoteViews.setOnClickPendingIntent(R.id.lights_switch, pendingIntent);
      appWidgetManager.updateAppWidget(widgetId, remoteViews);
    }
  }

  @Override
  public void onReceive(@NonNull Context context, @NonNull Intent intent) {
    super.onReceive(context, intent);
    Intent serviceIntent = new Intent(context, BackgroundNetworkingService.class);
    serviceIntent.putExtra(WIDGET_ACTION_KEY, WidgetAction.TOOGLE_LIGHTS);
    context.startService(serviceIntent);
  }
}
