package org.matsim.prepare.olympiastadion_study.Version63;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.pt.transitSchedule.api.*;
import org.matsim.vehicles.Vehicle;
import org.matsim.vehicles.VehicleType;
import org.matsim.vehicles.Vehicles;
import org.matsim.vehicles.VehiclesFactory;

public class Utilities {
	public static TransitRouteStop createTransitRouteStop(Scenario scenario, Id<TransitStopFacility> stop,
														   double arrivalOffset, double departureOffset) {


		TransitRouteStop transitRouteStop = scenario.getTransitSchedule().getFactory().createTransitRouteStop(
			scenario.getTransitSchedule().getFacilities().get(stop),
			arrivalOffset,
			departureOffset);
		transitRouteStop.setAwaitDepartureTime(true);
		return transitRouteStop;
	}

	public static void createDepartures(TransitRoute transitRoute, TransitSchedule transitSchedule, Vehicles transitVehicles,
										double firstDepartureTime, double lastDepartureTime, double interval,
										String departureIdCommonPart, String vehicleIdCommonPart, String vehicleTypeIdString ) {
		// create departures
		TransitScheduleFactory transitScheduleFactory = transitSchedule.getFactory();
		VehiclesFactory vehiclesFactory = transitVehicles.getFactory();

		int departureCounter = 1;
		for (double departureTime = firstDepartureTime; departureTime <= lastDepartureTime; departureTime += interval) {
			Departure departure = transitScheduleFactory.createDeparture(Id.create(departureIdCommonPart + departureCounter, Departure.class), departureTime);
			Id<Vehicle> vehicleId = Id.createVehicleId(vehicleIdCommonPart + departureCounter);
			vehiclesFactory.createVehicle(vehicleId,
				transitVehicles.getVehicleTypes().get(Id.create(vehicleTypeIdString, VehicleType.class))
			);
			departure.setVehicleId(vehicleId);
			transitRoute.addDeparture(departure);
			departureCounter++;
		}

	}


}
