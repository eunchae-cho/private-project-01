package com.thisIsJava.chapter07;

public class DmbCellPhoneExample {
  public static void main(String[] args) {
    DmbCellPhone d = new DmbCellPhone("자바폰","검정",10);

    System.out.println("모델: "+d.model);
    System.out.println("색상: "+d.color);
    System.out.println("채널: "+d.channel);

    d.powerOn();
    d.bell();
    d.sendVoice("여보세요");
    d.receiveVoice("안녕하세요, 저는 홍길동 인데요!");
    d.sendVoice("아 예 반갑습니다!");
    d.hangUp();

    d.turnOnDmb();
    d.changeChannelDmb(12);
    d.turnOffDmb();
  }

}
