package spreadoffiresimulation_ver2;

/**
 *
 * @author Anakan
 */
public class Timing{
    private int year;
    private int month;
    
    public Timing(){
        year = 0;
        month = 1;
    }
    
    public void timeRunning(){
        while(true){
            try{
                Thread.sleep(500);
            }catch(Exception e){
                //
            }
            month++;
            if(month >= 12){
                year++;
                month = 0;
            }
        }
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getYear(){
        return year;
    }
    
}
