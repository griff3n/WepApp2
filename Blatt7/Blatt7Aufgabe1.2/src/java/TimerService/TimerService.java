/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimerService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author admin
 */
@WebService(serviceName = "TimerService")
public class TimerService {
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getSec")
    public long getSec(@WebParam(name = "jahr") int jahr,
            @WebParam(name = "monat") int monat,
            @WebParam(name = "tag") int tag,
            @WebParam(name = "stunde") int stunde,
            @WebParam(name = "minute") int minute,
            @WebParam(name = "sekunde") int sekunde) {
        if(monat < 1 || monat > 12 
            || tag < 1 || tag > 31 
            || stunde < 0 || stunde > 23 
            || minute < 0 || minute > 59
            || sekunde < 0 || sekunde > 59) {
            throw new IllegalArgumentException();
        }
        
        int[] monts = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int schaltjahre = ((jahr - 1) - 1968) / 4
                        - ((jahr - 1) - 1900) / 100
                        + ((jahr - 1) - 1600) / 400;
        long tage = 0;
        boolean schaltjahr;
        schaltjahr = isSchaltJahr(jahr);
        tage = (jahr - 1970) * 365 + schaltjahre + monts[monat - 1] + tag - 1;
        if(schaltjahr && monat > 2) {
            tage++;
        }
        return sekunde + 60 *(minute + 60 * (stunde + 24 * tage));
    }
    
    private boolean isSchaltJahr(int jahr) {
        if((jahr % 4 == 0 && jahr % 100 == 0 && jahr % 400 == 0)
                || (jahr % 4 == 0 && jahr % 100 != 0)) {
            return true;
        }
        return false;
    }
}
