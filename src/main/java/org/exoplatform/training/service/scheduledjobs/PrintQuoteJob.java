package org.exoplatform.training.service.scheduledjobs;

import org.exoplatform.container.PortalContainer;
import org.exoplatform.training.service.TrainingService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PrintQuoteJob implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    TrainingService trainingService = PortalContainer.getInstance().getComponentInstanceOfType(TrainingService.class);
    trainingService.printRandomQuote();
  }
}
