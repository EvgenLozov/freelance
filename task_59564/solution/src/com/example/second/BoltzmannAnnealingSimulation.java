package com.example.second;


public class BoltzmannAnnealingSimulation extends AnnealingSimulation {

    protected BoltzmannAnnealingSimulation(SingleVariableFunction function) {
        super(function);
    }

    @Override
    protected double nextState(double state, double temperature) {
        return 0;
    }

    @Override
    protected double cooling(int iteration) {
        return startingTemperature/Math.log(1+iteration);
    }

    @Override
    protected double initState() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
