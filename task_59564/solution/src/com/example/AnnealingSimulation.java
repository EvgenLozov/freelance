package com.example;

abstract class AnnealingSimulation{

    private SingleVariableFunction function; //1-dimensional energy function,

    private int maxIteration = 10000;  // default max iteration

    public double startingTemperature = 1000; //

    protected AnnealingSimulation(SingleVariableFunction function) {
        this.function = function;
    }

    public double search(){
        double currentState = initState();
        int iteration = 1;
        double temperature = cooling(iteration++);

        do {
            double nextState = nextState(currentState, temperature);

            double currentStateEnergy = function.evaluate(currentState);
            double nextStateEnergy = function.evaluate(nextState);

            if(Math.random() < probability(currentStateEnergy, nextStateEnergy, temperature)){
                currentState = nextState;
            }

            temperature = cooling(iteration++);
        }while ( iteration < maxIteration );

        return currentState;
    }

    private double probability(double currentStateEnergy, double nextStateEnergy, double temperature) {
        return 1/(1+Math.exp((nextStateEnergy-currentStateEnergy)/temperature));
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

    public double getStartingTemperature() {
        return startingTemperature;
    }

    public void setStartingTemperature(double startingTemperature) {
        this.startingTemperature = startingTemperature;
    }

    //transition
    protected abstract double nextState(double state, double temperature);

    //the cooling schedule
    protected abstract double cooling(int iteration);

    // generate initial point
    protected abstract double initState();

}
