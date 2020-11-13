package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }


    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationOneEl() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expResult = 0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00000001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationEmpty() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.deviation();


    }

    @Test
    public void testDeviationSample() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.741657;
        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test
    public void MinOneEl() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expResult = -1.0;
        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);


    }

    @Test(expected = IllegalArgumentException.class)
    public void MinEmpty() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();


    }

    @Test
    public void MinSample() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;
        double actResult = seriesAnalysis.min();

        assertEquals(expResult, actResult, 0.00001);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestToZeroSample() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
seriesAnalysis.findTempClosestToZero();

    }

  
    

    @Test(expected = IllegalArgumentException.class)
    public void TestToValueZeroSample() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(0);

    }
 
    @Test
    public void TestToValueSample() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 2, -1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0;
        double actResult = seriesAnalysis.findTempClosestToValue(1);


        assertEquals(expResult, actResult, 0.00001);
    }
   
   
    @Test(expected = IllegalArgumentException.class)
    public void TestFindLessEmpty(){
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.findTempsLessThen(0);
    }

    @Test
    public void TestFindOneElGreater(){
        double[] temperatureSeries = {3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double [] expresult = {};
        double [] actResult = seriesAnalysis.findTempsGreaterThen(2);

        assertArrayEquals(expresult, actResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestFindGreaterEmpty(){
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.findTempsLessThen(0);
    }





}




