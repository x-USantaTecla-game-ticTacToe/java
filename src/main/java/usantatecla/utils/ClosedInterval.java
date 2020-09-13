package usantatecla.utils;

public class ClosedInterval {
  
  private final int MIN;
  private final int MAX;

  public ClosedInterval(int min, int max){
    this.MIN = min;
    this.MAX = max;
  }

  public ClosedInterval(int max){
    this(0, max);
  }
  

  public boolean isIncluded(int value){
    return this.MIN <= value && value <= this.MAX;
  }

}
