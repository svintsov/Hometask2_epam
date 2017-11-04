package com.bazyl.credits;

public class Model {

  private int secretValue;
  private int minLimit;
  private int maxLimit;

  Model(int minLimit,int maxLimit){
    secretValue=RandomGenerator.rand();
    this.minLimit=minLimit;
    this.maxLimit=maxLimit;
  }

  public int getSecretValue() {
    return secretValue;
  }

  public void setSecretValue(int secretValue) {
    this.secretValue = secretValue;
  }

  public int getMinLimit() {
    return minLimit;
  }

  public void setMinLimit(int minLimit) {
    this.minLimit = minLimit;
  }

  public int getMaxLimit() {
    return maxLimit;
  }

  public void setMaxLimit(int maxLimit) {
    this.maxLimit = maxLimit;
  }



  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Range[");
    sb.append("minLimit=").append(minLimit);
    sb.append(", maxLimit=").append(maxLimit);
    sb.append(']');
    return sb.toString();
  }
}
