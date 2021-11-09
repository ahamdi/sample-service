package org.exoplatform.training.service.listener;

import org.exoplatform.services.listener.Event;
import org.exoplatform.services.listener.Listener;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.service.plugins.TrainingPlugin;

public class TextTransformListener extends Listener<TrainingPlugin, String> {

  private static final Log LOG = ExoLogger.getLogger(TextTransformListener.class);

  @Override
  public void onEvent(Event<TrainingPlugin,String> event) throws Exception {
    TrainingPlugin plugin = event.getSource();
    String transformedText = event.getData();
    String eventName = event.getEventName();
    LOG.info("Event {} fired from plugin {} with text : {}", eventName, plugin.getName(), transformedText);
  }
}
