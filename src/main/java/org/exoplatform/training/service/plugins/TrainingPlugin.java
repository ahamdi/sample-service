package org.exoplatform.training.service.plugins;

import org.exoplatform.container.component.BaseComponentPlugin;

public abstract class TrainingPlugin extends BaseComponentPlugin {
    public abstract String transform(String text);
}
