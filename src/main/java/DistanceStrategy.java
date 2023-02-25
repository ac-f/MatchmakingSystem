/*
 * Copyright (c) 2023
 * author: ac-f
 * email: fantasy1621821@gmail.com
 * website: https://ac-f.io/
 */

import java.util.Comparator;
import java.util.List;

public class DistanceStrategy implements StrategyInterface{
  @Override
  public List<Individual> makeStrategy(Individual individual, List<Individual> targetIndividualList) {
    Comparator<Individual> order = Comparator.comparing(target -> individual.getCoords().getDistance(target.getCoords()));
    return targetIndividualList
            .stream()
            .sorted(order)
            .toList();
  }

  @Override
  public void getStrategyResult(Individual individual, Individual targetIndividual) {
    var distance = individual.getCoords().getDistance(targetIndividual.getCoords());
    System.out.println("他們的距離是：" + distance);
  }
}
