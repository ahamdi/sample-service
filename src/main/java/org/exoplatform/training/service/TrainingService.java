package org.exoplatform.training.service;

import org.exoplatform.container.xml.ComponentPlugin;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.service.plugins.TrainingPlugin;
import org.picocontainer.Startable;

public interface TrainingService {
  public void addPlugin(TrainingPlugin plugin);
}
