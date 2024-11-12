package org.matsim.prepare.olympiastadion_study.Version60.s9;

import org.matsim.api.core.v01.Id;
import org.matsim.pt.transitSchedule.api.*;
import org.matsim.vehicles.Vehicle;
import org.matsim.vehicles.Vehicles;
import org.matsim.vehicles.VehiclesFactory;

import java.util.ArrayList;
import java.util.List;

public class S9GamedaySchedule {
	public static void prepare(TransitSchedule transitSchedule, Vehicles transitVehicles) {
		TransitScheduleFactory transitScheduleFactory = transitSchedule.getFactory();
		VehiclesFactory vehiclesFactory = transitVehicles.getFactory();

		// prepare s9 gameday schedule
		TransitLine s9Transitline = transitSchedule.getTransitLines().get(Id.create("S9---10170_109", TransitLine.class));

		{//remove Depature for Route 4 from 17:00-30:00(Spandau-Flughafen)
			TransitRoute s9transitRoute4 = s9Transitline.getRoutes().get(Id.create("S9---10170_109_4", TransitRoute.class));

			List<Departure> toRemove4 = new ArrayList<>();
			for (Departure departure : s9transitRoute4.getDepartures().values()) {
				if (departure.getDepartureTime() >= 17 * 3600 && departure.getDepartureTime() < 30 * 3600) {
					toRemove4.add(departure);
				}
			}

			for (Departure departure : toRemove4) {
				s9transitRoute4.removeDeparture(departure);
			}

			//create depatures
			int depatureCounter = 1;
			double interval = 600;
			double firstDepatureTime = 17 * 3600 + 9 * 60; //first Depature @ 17:09

			for (double depatureTime = firstDepatureTime; depatureTime < 30 * 3600; depatureTime += interval) {
				Departure departure = transitScheduleFactory.createDeparture(Id.create("950832_" + depatureCounter, Departure.class), depatureTime);
				Id<Vehicle> vehicleId = Id.createVehicleId("pt_S9---10170_109_4_" + depatureCounter);
				transitVehicles.getVehicles().get(vehicleId);
				if (transitVehicles.getVehicles().get(vehicleId) == null) {
					transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
						transitVehicles.getVehicleTypes().get(Id.create("S-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
					));
					departure.setVehicleId(vehicleId);
					s9transitRoute4.addDeparture(departure);
					depatureCounter++;
				}
			}
		}

		//remove Depature for Route 8 from 17:00-30:00(Flughafen-Spandau)
		TransitRoute s9transitRoute8 = s9Transitline.getRoutes().get(Id.create("S9---10170_109_8", TransitRoute.class));

		List<Departure> toRemove8 = new ArrayList<>();
		for (Departure departure : s9transitRoute8.getDepartures().values()) {
			if (departure.getDepartureTime() >= 17 * 3600 && departure.getDepartureTime() < 30 * 3600) {
				toRemove8.add(departure);
			}
		}

		for (Departure departure : toRemove8) {
			s9transitRoute8.removeDeparture(departure);
		}

		//create depatures
		int depatureCounter = 1;
		double interval = 600;
		double firstDepatureTime = 17 * 3600 + 9 * 60; //first Depature @ 17:09

		for (double depatureTime = firstDepatureTime; depatureTime < 30 * 3600; depatureTime += interval) {
			Departure departure = transitScheduleFactory.createDeparture(Id.create("950833_" + depatureCounter, Departure.class), depatureTime);
			Id<Vehicle> vehicleId = Id.createVehicleId("pt_S9---10170_109_8_" + depatureCounter);
			transitVehicles.getVehicles().get(vehicleId);
			if (transitVehicles.getVehicles().get(vehicleId) == null) {
				transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
					transitVehicles.getVehicleTypes().get(Id.create("S-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
				));
				departure.setVehicleId(vehicleId);
				s9transitRoute8.addDeparture(departure);
				depatureCounter++;
			}

		}
	}

}
