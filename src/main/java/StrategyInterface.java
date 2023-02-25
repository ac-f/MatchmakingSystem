/*
 * Copyright (c) 2023
 * author: ac-f
 * email: fantasy1621821@gmail.com
 * website: https://ac-f.io/
 */

import java.util.List;

public interface StrategyInterface {
  List<Individual> makeStrategy(Individual individual, List<Individual> targetIndividualList);
  void getStrategyResult(Individual individual, Individual targetIndividual);
}
