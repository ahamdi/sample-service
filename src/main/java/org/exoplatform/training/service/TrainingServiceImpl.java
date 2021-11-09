package org.exoplatform.training.service;

import org.exoplatform.services.listener.ListenerService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.service.plugins.TrainingPlugin;
import org.picocontainer.Startable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TrainingServiceImpl implements TrainingService, Startable {

  private static final Log LOG = ExoLogger.getLogger(TrainingServiceImpl.class);
  private final List<TrainingPlugin> plugins = new ArrayList<>();
  private static String TEXT = "Education is learning what you didn’t even know you didn’t know";
  private static List<String> quotes = Arrays.asList(
          "“Being a student is easy. Learning requires actual work.”\n" +
                  "— William Crawford",
          "“Study without desire spoils the memory, and it retains nothing that it takes in.”\n" +
                  "— Leonardo da Vinci",
          "“The great aim of education is not knowledge but action.”\n" +
                  "— Herbert Spencer",
          "“If you think education is expensive, try estimating the cost of ignorance.”\n" +
                  "— Howard Gardner",
          "“Education without application is just entertainment.”\n" +
                  "— Tim Sanders",
          "“I am still learning.”\n" +
                  "— Michelangelo",
          "“Recipes tell you nothing. Learning techniques is the key.”\n" +
                  "— Tom Colicchio",
          "“A man who carries a cat by the tail learns something he can learn in no other way.”\n" +
                  "— Mark Twain",
          "“The object of opening the mind, as of opening the mouth, is to close it again on something solid.”\n" +
                  "— G. K. Chesterton",
          "“For the things we have to learn before we can do them, we learn by doing them.”\n" +
                  "― Aristotle"
          );
  private final ListenerService listenerService;

  public TrainingServiceImpl(ListenerService listenerService) {
    this.listenerService = listenerService;
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

  public void addPlugin(TrainingPlugin plugin) {
    this.plugins.add(plugin);
    LOG.info("Plugin {} was successfully registered !", plugin.getName());
  }

  @Override
  public void printRandomQuote() {
    int randomIndex = new Random().nextInt(10);
    LOG.info("Executing plugins on the random Quote");
    for(TrainingPlugin plugin : plugins) {
      LOG.info("Executing first plugin : {}", plugin.getName());
      String transformedText = plugin.transform(quotes.get(randomIndex));
      LOG.info("############# {} #############", transformedText);
      try {
        listenerService.broadcast("text-transformed", plugin, transformedText);
      } catch (Exception e) {
        LOG.error("Could not execute plugin {}", plugin.getName());
      }
    }
  }
}
