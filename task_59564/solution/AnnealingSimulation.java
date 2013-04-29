package com.example.task_59564_test;

import java.util.Arrays;

//спробуємо максимізувати функцію з двома аргументами. Пошук цих аргументів і є рішенням

public class AnnealingSimulation {

    //визначимо структуру даних, яка описуватиме дане рішення
    //це буде двомірний масив, де перший номер (рядок) - робоче рішення
    // другий рядок - поточне рішення
    double[][] decision;

    public AnnealingSimulation(){
        decision = new double[2][2];

        //задамо початкове значеня рішення, випадковим чином
        for (int i=0; i<decision[0].length; i++){
            decision[0][i] = Math.random()+1;
        }
    }

    //метод підраховує якість рішення, яке йому передається в якості параметра
    //якість рішення знаходимо використовуючи функцію оцінки
    public double mark(double[] decision){
        return (1/(1+Math.pow(decision[0],2)+Math.pow(decision[1],2)));
    }


    public void search(){
        double t = 10000;  // початкова температура
        System.out.println(decision[0][0]+"  "+decision[0][1]+"  "+mark(decision[0]));

        do{
            //отримаємо нове рішення із поточного, модифікувавши незначним чином поточне рішення
            for (int i=0; i<decision[1].length; i++){
                decision[1][i] = decision[0][i]+Math.random()*0.01-0.005;
            }
            //далі оцінимо отримане рішення і те з якого ми його ортримали
            double e1 = mark(decision[0]);
            double e2 = mark(decision[1]);

            if (e2<e1){ //нове рішення виявилось кращим
                decision[0] = Arrays.copyOf(decision[1],decision[1].length);   //затираємо рішення, замінюючи отриманим
            }else{
                // допускаємо що якщо нове рішення навіть гірше, воно може привести до кращого рішення
                // таким чином треба ввести деяку ймовірність його збереження, яка буде залежати від
                // степені помилковості нового рішення  (тобто більш помилкові рішення будуть прийматись гірше)
                // і від теператури , чим вища температура , тим легше як поганим так і хорошим рішенням ставати на місце поточного
                double p = Math.exp(e2-e1)/t;
                if (Math.random()<p){
                    decision[0] = Arrays.copyOf(decision[1],decision[1].length);
                }
            }
            t = 0.98*t;
        }while (t>0.001);
        System.out.println(decision[0][0]+"  "+decision[0][1]+"  "+mark(decision[0]));
    }

    public static void main(String[] args) {
        new AnnealingSimulation().search();
    }

}
