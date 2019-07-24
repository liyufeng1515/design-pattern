package cn.dwyane.designpattern.factory;

public class FactoryTest {
    public static void main(String[] args){
        Sender senderA = SenderFactory.produceMail();
        Sender senderB = SenderFactory.produceSms();
        senderA.send();
        senderB.send();


        Provider providerC = new SmsSenderFactory();
        Sender senderC = providerC.produce();
        senderC.send();

        Provider providerD = new MailSenderFactory();
        Sender senderD = providerD.produce();
        senderD.send();
    }
}
