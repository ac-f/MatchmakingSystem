/*
 * Copyright (c) 2023
 * author: ac-f
 * email: fantasy1621821@gmail.com
 * website: https://ac-f.io/
 */

import java.text.MessageFormat;
import java.util.*;

public class MatchmakingSystem {
  private final List<Individual> individuals = new ArrayList<>();
  private final StrategyInterface strategyType = new HabitStrategy();

  public void match() {
    for (Individual individual : individuals) {
      var targetIndividuallist = individuals.stream()
              .filter(matchIndividual -> !Objects.equals(matchIndividual.getId(), individual.getId()))
              .toList();
      var resultList = individual.makeStrategy(targetIndividuallist, strategyType, false);
      var msg = MessageFormat.format("對{0}來說， 最佳的配對為： {1}", individual.getId(), resultList.get(0).getId());
      System.out.println(msg);
      individual.getStrategyResult(resultList.get(0), strategyType);
      System.out.println("===================================");
    }

  }

  public void addIndividual(Individual individual) {
    this.individuals.add(individual);
  }

}
