package com.lovo.bean;


public class SysKaoqing {

  private long sysKqId;
  private SysStudent sysStu;
  private String sysType;
  private String sysTime;
  private String sysMan;
  private String sysInsertTime;


  public long getSysKqId() {
    return sysKqId;
  }

  public void setSysKqId(long sysKqId) {
    this.sysKqId = sysKqId;
  }

  public SysStudent getSysStu() {
    return sysStu;
  }

  public void setSysStu(SysStudent sysStu) {
    this.sysStu = sysStu;
  }

  public String getSysType() {
    return sysType;
  }

  public void setSysType(String sysType) {
    this.sysType = sysType;
  }


  public String getSysTime() {
    return sysTime;
  }

  public void setSysTime(String sysTime) {
    this.sysTime = sysTime;
  }


  public String getSysMan() {
    return sysMan;
  }

  public void setSysMan(String sysMan) {
    this.sysMan = sysMan;
  }


  public String getSysInsertTime() {
    return sysInsertTime;
  }

  public void setSysInsertTime(String sysInsertTime) {
    this.sysInsertTime = sysInsertTime;
  }

}
