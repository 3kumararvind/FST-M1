package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    public List<String> passangers;
    public int maxPassengers;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;
    public Plane(int maxPassengers){
        this.maxPassengers = maxPassengers;
        this.passangers = new ArrayList<>();

    }
    public void onboard(String passanger){
        this.passangers.add(passanger);

    }
    public Date takeOff(){
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;

    }
    public void land(){
        this.lastTimeLanded = new Date();
        this.passangers.clear();
    }


    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassangers(){
        return passangers;
    }
}

public class Activity6{
    public static void main(String args[]) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("John");
        plane.onboard("Steve");
        plane.onboard("anna");
        System.out.println("Plane Take off at: " + plane.takeOff());

        System.out.println("People in Plane: " + plane.getPassangers());

        Thread.sleep(5000);

        System.out.println("Plane Landed at: " + plane.getLastTimeLanded());

        System.out.println("People on plane after landed: " + plane.getPassangers());

    }
}
