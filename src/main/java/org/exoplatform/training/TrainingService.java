package org.exoplatform.training;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.picocontainer.Startable;

public class TrainingService implements Startable{

  private static final Log    LOG                             = ExoLogger.getLogger(TrainingService.class);

  public TrainingService() {
    LOG.info("Service training created successfully !");
  }

  @Override
  public void start() {
    LOG.info("START : Service training started successfully !");
  }

  @Override
  public void stop() {
    LOG.info("STOP : Service training stopped successfully !");

  }
}
