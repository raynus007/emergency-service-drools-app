/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.salaboy.emergencyservice.worldui.slick.events;

import com.wordpress.salaboy.CityEntitiesUtils;
import com.wordpress.salaboy.services.GridEmergencyService;
import com.wordpress.salaboy.events.HospitalReachedNotifierEvent;
import com.wordpress.salaboy.events.NotifierEvent;
import com.wordpress.salaboy.events.WorldEventNotifier;
import java.util.Iterator;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;
import com.wordpress.salaboy.model.Hospital;
import com.wordpress.salaboy.model.Patient;
import com.wordpress.salaboy.model.events.PatientAtHospitalEvent;

/**
 *
 * @author salaboy
 */
public class MapHospitalReachedEventNotifier implements WorldEventNotifier {

    private Long hospitalId;

    public MapHospitalReachedEventNotifier(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Override
    public void notify(NotifierEvent event) {
        Long ambulanceId = ((HospitalReachedNotifierEvent)event).getAmbulanceId();

       // AmbulanceMonitorService.getInstance().stop();
        GridEmergencyService.getInstance().sendPatientAtTheHospitalEvent(new PatientAtHospitalEvent(), ambulanceId);



        QueryResults results = GridEmergencyService.getInstance().getQueryResults("getPatient");
        Iterator<QueryResultsRow> it = results.iterator();
        Patient patient = null;
        while (it.hasNext()) {
            Object o = it.next().get(results.getIdentifiers()[0]);
            patient = (Patient) o;
        }
        Hospital hospital = CityEntitiesUtils.getHospitalById(hospitalId);
        hospital.addPatient(patient);
     //   UserTaskListUI.getInstance().getGame().removeHospital(hospitalId);
    }
}
