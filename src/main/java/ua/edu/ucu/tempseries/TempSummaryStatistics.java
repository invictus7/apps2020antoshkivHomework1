package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {

    private final double avg;
    private final double dev;
    private final double min;
    private final double max;


public TempSummaryStatistics (double avg, double dev, double min, double max){

    this.avg = avg;
    this.dev = dev;
    this.min = min;
    this.max = max;
}

    public double getAvg() {
        return avg;
    }
    public double Dev(){

    return dev;
    }
  public double Min(){
    return min;
  }
    public double Max(){
    return max;
    }

}


