package com.example.second;

abstract class AnnealingSimulation{

    private SingleVariableFunction function;

    private double minimalTemperature = 0.1;
    private int maxIteration = Integer.MAX_VALUE;

    protected AnnealingSimulation(SingleVariableFunction function) {
        this.function = function;
    }

    public double search(){
        //init state
        double currentState = initState();
        int iteration = 0;
        double temperature = cooling(iteration++);

        do {
            double nextState = nextState(currentState, temperature);

            double currentStateEnergy = function.evaluate(currentState);
            double nextStateEnergy = function.evaluate(nextState);

            if(Math.random() > probability(currentStateEnergy, nextStateEnergy, temperature))
                currentState = nextState;

            temperature = cooling(iteration++);
        }while ( temperature > minimalTemperature|| iteration < maxIteration );

        return currentState;
    }

    public double probability(double currentStateEnergy, double nextStateEnergy, double temperature) {
        return (nextStateEnergy-currentStateEnergy)/temperature;
    }

    public double getMinimalTemperature() {
        return minimalTemperature;
    }

    public void setMinimalTemperature(double minimalTemperature) {
        this.minimalTemperature = minimalTemperature;
    }

    public int getMaxIteration() {
        return maxIteration;
    }

    public void setMaxIteration(int maxIteration) {
        this.maxIteration = maxIteration;
    }

    public SingleVariableFunction getFunction() {
        return function;
    }

    public void setFunction(SingleVariableFunction function) {
        this.function = function;
    }

    protected abstract double nextState(double state, double temperature);

    protected abstract double cooling(double temperature);

    protected abstract double initState();

}
