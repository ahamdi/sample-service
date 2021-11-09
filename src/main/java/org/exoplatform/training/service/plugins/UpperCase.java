package org.exoplatform.training.service.plugins;

public class UpperCase extends TrainingPlugin{
  @Override
  public String transform(String text) {
    return text.toUpperCase();
  }
}
