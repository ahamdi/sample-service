package org.exoplatform.training.service;

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

  public TrainingServiceImpl() {
    LOG.info("Service training created successfully !");
  }

  @Override
  public void start() {
    LOG.info("START : Service training started successfully !");
    LOG.info("Executing plugins");
    for(TrainingPlugin plugin : plugins) {
      LOG.info("Executing first plugin : {}", plugin.getName());
      LOG.info("############# {} #############", plugin.transform(TEXT));
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
