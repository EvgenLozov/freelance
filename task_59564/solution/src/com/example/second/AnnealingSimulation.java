package com.example.second;

abstract class AnnealingSimulation{

    private SingleVariableFunction function;

    protected AnnealingSimulation(SingleVariableFunction function) {
        this.function = function;
    }

    public double search(){
        //todo

        return 0;
    }

    protected abstract double nextState(double state, double T);

    protected abstract double cooling(double temperature);

    protected abstract double probability(double oldStateEnergy, double newStateEnergy, double temperature);


}
