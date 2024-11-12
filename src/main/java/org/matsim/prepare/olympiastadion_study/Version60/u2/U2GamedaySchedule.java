package org.matsim.prepare.olympiastadion_study.Version60.u2;

import org.matsim.api.core.v01.Id;
import org.matsim.pt.transitSchedule.api.*;
import org.matsim.vehicles.Vehicle;
import org.matsim.vehicles.Vehicles;
import org.matsim.vehicles.VehiclesFactory;

import java.util.ArrayList;
import java.util.List;

public class U2GamedaySchedule {
	public static void prepare(TransitSchedule transitSchedule, Vehicles transitVehicles) {

		TransitScheduleFactory transitScheduleFactory = transitSchedule.getFactory();
		VehiclesFactory vehiclesFactory = transitVehicles.getFactory();

		// prepare u2 gameday schedule
		TransitLine u2Transitline = transitSchedule.getTransitLines().get(Id.create("U2---17514_400", TransitLine.class));

		//Remove Route 5, 14
		TransitRoute u2GamedayRoute5 = u2Transitline.getRoutes().get(Id.create("U2---17514_400_5", TransitLine.class));
		TransitRoute u2GamedayRoute14 = u2Transitline.getRoutes().get(Id.create("U2---17514_400_14", TransitLine.class));
		u2Transitline.removeRoute(u2GamedayRoute5);
		u2Transitline.removeRoute(u2GamedayRoute14);


		//Adjust Route1
		{ //remove Depature
			TransitRoute u2GamedayRoute1 = u2Transitline.getRoutes().get(Id.create("U2---17514_400_1", TransitRoute.class));

			List<Departure> departuresToRemove1 = new ArrayList<>(u2GamedayRoute1.getDepartures().values());

			for (Departure departure1 : departuresToRemove1) {
				u2GamedayRoute1.removeDeparture(departure1);
			}



			//create depatures
			int depatureCounter = 1;
			double interval = 180;
			double firstDepatureTime = 17 * 3600 + 2 * 60; //first Depature @ 17:02

			for (double depatureTime = firstDepatureTime; depatureTime < 30 * 3600; depatureTime += interval) {
				Departure departure = transitScheduleFactory.createDeparture(Id.create("950830_" + depatureCounter, Departure.class), depatureTime);
				Id<Vehicle> vehicleId = Id.createVehicleId("pt_U2---17514_400_1_" + depatureCounter);
				transitVehicles.getVehicles().get(vehicleId);
				if (transitVehicles.getVehicles().get(vehicleId) == null) {
					transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
						transitVehicles.getVehicleTypes().get(Id.create("U-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
					));
				}
				departure.setVehicleId(vehicleId);
				u2GamedayRoute1.addDeparture(departure);
				depatureCounter++;
			}
		}
		//Adjust Route28
		{ //remove Depature
			TransitRoute u2GamedayRoute28 = u2Transitline.getRoutes().get(Id.create("U2---17514_400_28", TransitRoute.class));

			List<Departure> departuresToRemove28 = new ArrayList<>(u2GamedayRoute28.getDepartures().values());

			for (Departure departure28 : departuresToRemove28) {
				u2GamedayRoute28.removeDeparture(departure28);
			}

			//create depatures
			int depatureCounter = 1;
			double interval = 180;
			double firstDepatureTime = 17 * 3600 + 2 * 60; //first Depature @ 17:02

			for (double depatureTime = firstDepatureTime; depatureTime < 30 * 3600; depatureTime += interval) {
				Departure departure = transitScheduleFactory.createDeparture(Id.create("950831_" + depatureCounter, Departure.class), depatureTime);
				Id<Vehicle> vehicleId = Id.createVehicleId("pt_U2---17514_400_28_" + depatureCounter);
				transitVehicles.getVehicles().get(vehicleId);
				if (transitVehicles.getVehicles().get(vehicleId) == null) {
					transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
						transitVehicles.getVehicleTypes().get(Id.create("U-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
					));
				}
				departure.setVehicleId(vehicleId);
				u2GamedayRoute28.addDeparture(departure);
				depatureCounter++;
			}
		}


		//remove Depature from 17:00-30:00
		TransitRoute u2transitRoute10 = u2Transitline.getRoutes().get(Id.create("U2---17514_400_10", TransitRoute.class));

		List<Departure> toRemove10 = new ArrayList<>();
		for (Departure departure : u2transitRoute10.getDepartures().values()) {
			if (departure.getDepartureTime() >= 17 * 3600 && departure.getDepartureTime() < 30 * 3600) {
				toRemove10.add(departure);
			}
		}

		for (Departure departure : toRemove10) {
			u2transitRoute10.removeDeparture(departure);
		}

		//remove Depature from 17:00-30:00
		TransitRoute u2transitRoute23 = u2Transitline.getRoutes().get(Id.create("U2---17514_400_23", TransitRoute.class));

		List<Departure> toRemove23 = new ArrayList<>();
		for (Departure departure : u2transitRoute23.getDepartures().values()) {
			if (departure.getDepartureTime() >= 17 * 3600 && departure.getDepartureTime() < 30 * 3600) {
				toRemove23.add(departure);
			}
		}

		for (Departure departure : toRemove23) {
			u2transitRoute23.removeDeparture(departure);
		}

	}
}
