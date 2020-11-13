package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;
import  java. lang. Math;


public class TemperatureSeriesAnalysis {

    private static final double Min = -273;
    private  double [] TemperatureArray;
    private double Average;
    private double MinOfArray;
    private double MaxOfArray;
    private double ClosestToZero;
    private double ClosetstToValue;
    private final double [] arrayLessTemp = new double[]{};
    private double [] arrayGreaterTemp;
    private double Std_Deviation;

    public TemperatureSeriesAnalysis() {
        TemperatureArray = new double[]{};

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double v: temperatureSeries){
            if (v< Min){

                throw new InputMismatchException ("Missmatch");
            }

        }
        TemperatureArray = temperatureSeries;
    }
    public double [] GetArray(){

        return TemperatureArray;
    }

    public double average() {

        if (TemperatureArray.length == 0){
            throw new IllegalArgumentException();

        }
        double sum = 0;
        for (double v : TemperatureArray){
                sum = sum + v;
            }


        Average = sum / TemperatureArray.length;
        return Average;
    }

    public double deviation() {
        if (TemperatureArray.length == 0){
            throw new IllegalArgumentException();

        }
        Average = average();
        double SumOfDeviation = 0;

        for (double v: TemperatureArray){

            SumOfDeviation = (v - average()) * (v - average()) + SumOfDeviation;

        }
        double Mean = 0;

        Mean = SumOfDeviation / TemperatureArray.length;

        Std_Deviation = Math.pow(Mean, 0.5);

        return Std_Deviation;

    }

    public double min() {
        if (TemperatureArray.length == 0){
            throw new IllegalArgumentException();

        }
        MinOfArray= TemperatureArray[0];
        for (double v : TemperatureArray) {
            if (v < MinOfArray) {
                MinOfArray = v;

            }

        }
        return MinOfArray;
    }

    public double max() {
        if (TemperatureArray.length == 0){
            throw new IllegalArgumentException();

        }
        MaxOfArray= TemperatureArray[0];
        for (double v : TemperatureArray) {
            if (v > MaxOfArray) {
                MaxOfArray = v;

            }

        }
        return MaxOfArray;
    }


    public double findTempClosestToZero() {
        if (TemperatureArray.length == 0){
            throw new IllegalArgumentException();

        }


        Arrays.sort(TemperatureArray);
        int ind_of_zero = 0;

        for (int i =0; i< TemperatureArray.length; i++){
            if (TemperatureArray[i] == 0){

                ind_of_zero = i;

            }

        }


        int ind_of_zero_1_plus = ind_of_zero+1;
        int ind_of_zero_1_minus = ind_of_zero-1;

        if ((Math.pow(TemperatureArray[ind_of_zero_1_plus], 2) > (Math.pow(TemperatureArray[ind_of_zero_1_minus],2 ))))
        {
            ClosestToZero = TemperatureArray[ind_of_zero_1_minus];

        } if ((Math.pow(TemperatureArray[ind_of_zero_1_plus], 2) < (Math.pow(TemperatureArray[ind_of_zero_1_minus],2 ))))
        {

            ClosestToZero = TemperatureArray[ind_of_zero_1_plus];
        }else   {
            ClosestToZero = TemperatureArray[ind_of_zero_1_plus];
        }
        return ClosestToZero;
    }

    public double findTempClosestToValue(double tempValue) {
        if (TemperatureArray.length == 0){
            throw new IllegalArgumentException();

        }

        Arrays.sort(TemperatureArray);
        int ind_closests_to_value = 0;

        for (int i =0; i< TemperatureArray.length; i++){
            if (TemperatureArray[i] == tempValue){

                ind_closests_to_value = i;

            }

        }
        int int_closest_to_value_1_plus = ind_closests_to_value+1;
        int int_closest_to_value_1_minus = ind_closests_to_value-1;

        if(Math.pow(TemperatureArray[int_closest_to_value_1_plus],2 )> Math.pow(TemperatureArray[int_closest_to_value_1_minus],2 )){

            ClosetstToValue = TemperatureArray[int_closest_to_value_1_minus];
        }if (Math.pow(TemperatureArray[int_closest_to_value_1_plus],2 )< Math.pow(TemperatureArray[int_closest_to_value_1_minus],2 )){
            ClosetstToValue = TemperatureArray[int_closest_to_value_1_plus];

        }else {

            ClosetstToValue = TemperatureArray[int_closest_to_value_1_plus];
        }
        return ClosetstToValue;
    }



    public double[] findTempsLessThen(double tempValue) {

        if (TemperatureArray.length == 0){
            throw new IllegalArgumentException();

        }
        int ind =0;
        for (int v =0; v< TemperatureArray.length; v++){
            if (TemperatureArray[v] < tempValue){

                arrayLessTemp[v++] = TemperatureArray[v];

            }

        }
        return arrayLessTemp;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (TemperatureArray.length == 0){
            throw new IllegalArgumentException();

        }

        for (double v: TemperatureArray){
            if (v > tempValue){

                arrayGreaterTemp = new double[]{};
            }
        }
    return arrayGreaterTemp;
    }

    public TempSummaryStatistics summaryStatistics() {

        return new TempSummaryStatistics(Average, Std_Deviation, MinOfArray, MaxOfArray);

    }

    public int addTemps(double... temps) {

        for (double temp : temps){
            if (temp < Min){

                throw new InputMismatchException("Illegal");
            }

        }
        int ind_last = TemperatureArray.length-1;


        return 0;
    }


}
