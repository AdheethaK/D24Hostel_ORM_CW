package bo;

import bo.custom.impl.ReservationBOImpl;
import bo.custom.impl.RoomBOImpl;
import bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        RESERVATION,ROOM,STUDENT
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case  RESERVATION:
                return new ReservationBOImpl();
            case  ROOM:
                return new RoomBOImpl();
            case  STUDENT:
                return new StudentBOImpl();
            default:
                return null;
        }
    }
}
