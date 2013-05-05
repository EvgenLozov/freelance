package com.example;


public class CauchyAnnealing extends AnnealingSimulation
{
  protected CauchyAnnealing( SingleVariableFunction function )
  {
    super( function );
  }

  @Override
  protected double nextState( double state, double temperature )
  {
      return cauchyRandom(state, startingTemperature);
  }

  @Override
  protected double cooling( int iteration )
  {
    return startingTemperature/iteration;
  }

  @Override
  protected double initState()
  {
    return cauchyRandom(0, startingTemperature);
  }

  private double cauchyRandom(double mean, double std)
  {
    return mean + std * Math.tan( Math.PI * (Math.random() - 1/2) );
  }
}
