package org.exoplatform.training.service;

import org.exoplatform.services.listener.ListenerService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.service.plugins.TrainingPlugin;
import org.picocontainer.Startable;

import java.util.ArrayList;
import java.util.List;

public class TrainingServiceImpl implements TrainingService, Startable {

  private static final Log LOG = ExoLogger.getLogger(TrainingServiceImpl.class);
  private final List<TrainingPlugin> plugins = new ArrayList<>();
  private static String TEXT = "Education is learning what you didn’t even know you didn’t know";
  private final ListenerService listenerService;

  public TrainingServiceImpl(ListenerService listenerService) {
    this.listenerService = listenerService;
    LOG.info("Service training created successfully !");
  }

  @Override
  public void start() {
    LOG.info("START : Service training started successfully !");
    LOG.info("Executing plugins");
    for(TrainingPlugin plugin : plugins) {
      LOG.info("Executing first plugin : {}", plugin.getName());
      String transformedText = plugin.transform(TEXT);
      LOG.info("############# {} #############", transformedText);
      try {
        listenerService.broadcast("text-transformed", plugin, transformedText);
      } catch (Exception e) {
        LOG.error("Could not execute plugin {}", plugin.getName());
      }
    }

  }

  @Override
  public void stop() {
    LOG.info("STOP : Service training stopped successfully !");
  }

  public void addPlugin(TrainingPlugin plugin) {
    this.plugins.add(plugin);
  }
}
