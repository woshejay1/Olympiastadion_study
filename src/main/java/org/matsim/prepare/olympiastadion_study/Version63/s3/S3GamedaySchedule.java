package org.matsim.prepare.olympiastadion_study.Version63.s3;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.population.routes.NetworkRoute;
import org.matsim.core.population.routes.RouteUtils;
import org.matsim.pt.transitSchedule.api.*;
import org.matsim.vehicles.Vehicle;
import org.matsim.vehicles.Vehicles;
import org.matsim.vehicles.VehiclesFactory;

import java.util.ArrayList;
import java.util.List;

import static org.matsim.prepare.olympiastadion_study.Version63.Utilities.createTransitRouteStop;

public class S3GamedaySchedule {
	public static void prepare(Scenario scenario, TransitSchedule transitSchedule, Vehicles transitVehicles){

		TransitScheduleFactory transitScheduleFactory = transitSchedule.getFactory();
		VehiclesFactory vehiclesFactory = transitVehicles.getFactory();

		// prepare s3 gameday schedule
		TransitLine s3Transitline = transitSchedule.getTransitLines().get(Id.create("S3---9439", TransitLine.class));

		//create route 28: S+U Zoologischer Garten Bhf-S Olympia-Stadion
		Id<TransitRoute> s3GamedayRoute28Id = Id.create("S3---9439_28", TransitRoute.class);

		//create network routes
		NetworkRoute s3GamedayNetworkRoute28 = RouteUtils.createLinkNetworkRouteImpl(
			Id.createLinkId("pt_88875"), //S+U Zoologischer Garten Bhf pt_88875
			List.of(
				Id.createLinkId("pt_46442"), //S+U Zoologischer Garten Bhf-S Savignyplatz pt_46442
				Id.createLinkId("pt_46443"), //S Savignyplatz-S Charlottenburg Bhf pt_46443
				Id.createLinkId("pt_46444"), //S Charlottenburg Bhf-S Westkreuz pt_46444
				Id.createLinkId("pt_46445"), //S Westkreuz-S Messe Süd pt_46445
				Id.createLinkId("pt_46446") //S Messe Süd-S Heerstr pt_46446
			),
			Id.createLinkId("pt_46447") //S Heerstr-S Olympia-Stadion pt_46447
		);


        //create stops
		List<TransitRouteStop> s3GamedayStops28 = new ArrayList<>();
		s3GamedayStops28.add(createTransitRouteStop(scenario, Id.create("88875.1", TransitStopFacility.class),
			0.0d, 0.0d)); //S+U Zoologischer Garten Bhf
		s3GamedayStops28.add(createTransitRouteStop(scenario, Id.create("455338.1", TransitStopFacility.class),
			60.0d, 60.0d)); //S Savignyplatz
		s3GamedayStops28.add(createTransitRouteStop(scenario, Id.create("389698", TransitStopFacility.class),
			180.0d, 180.0d)); //S Charlottenburg Bhf
		s3GamedayStops28.add(createTransitRouteStop(scenario, Id.create("64837", TransitStopFacility.class),
			300.0d, 360.0d)); //S Westkreuz
		s3GamedayStops28.add(createTransitRouteStop(scenario, Id.create("186494.1", TransitStopFacility.class),
			0.0d, 0.0d)); //S Messe Süd
		s3GamedayStops28.add(createTransitRouteStop(scenario, Id.create("651501.1", TransitStopFacility.class),
			0.0d, 0.0d)); //S Heerstr
		s3GamedayStops28.add(createTransitRouteStop(scenario, Id.create("647655.1", TransitStopFacility.class),
			720.0d, 720.0d)); //S Olympia-Stadion

		//create complete route
		TransitRoute s3GamedayRoute28 = transitScheduleFactory.createTransitRoute(s3GamedayRoute28Id, s3GamedayNetworkRoute28, s3GamedayStops28, "rail");

		//create depatures
		{
			int depatureCounter = 1;
			double interval = 600;
			double firstDepatureTime = 4 * 3600 + 56 * 60; //first Depature @ 04:56

			for (double depatureTime = firstDepatureTime; depatureTime < 30 * 3600; depatureTime += interval) {
				Departure departure = transitScheduleFactory.createDeparture(Id.create("950830_" + depatureCounter, Departure.class), depatureTime);
				Id<Vehicle> vehicleId = Id.createVehicleId("pt_S3---9439_28_" + depatureCounter);
				transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
					transitVehicles.getVehicleTypes().get(Id.create("S-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
				));
				departure.setVehicleId(vehicleId);
				s3GamedayRoute28.addDeparture(departure);
				depatureCounter++;
			}
		}

		//create route 29: S Olympia-Stadion-S+U Zoologischer Garten Bhf
		Id<TransitRoute> s3GamedayRoute29Id = Id.create("S3---9439_29", TransitRoute.class);

		//create network routes
		NetworkRoute s3GamedayNetworkRoute29 = RouteUtils.createLinkNetworkRouteImpl(
			Id.createLinkId("pt_647655"), //S Olympia-Stadion pt_647655
			List.of(
				Id.createLinkId("pt_46391"), //S Olympiastadion-S Heerstr pt_46391
				Id.createLinkId("pt_46392"), //S Heerstr-S Messe Süd pt_46392
				Id.createLinkId("pt_46393"), //S Messe Süd-S Westkreuz pt_46393
				Id.createLinkId("pt_46394"), //S Westkreuz-S Charlottenburg Bhf pt_46394
				Id.createLinkId("pt_46395") //S Charlottenburg Bhf-S Savignyplatz pt_46395
			),
			Id.createLinkId("pt_46396") //S Savignyplatz-S+U Zoologischer Garten Bhf pt_46396
		);


		//create stops
		List<TransitRouteStop> s3GamedayStops29 = new ArrayList<>();
		s3GamedayStops29.add(createTransitRouteStop(scenario, Id.create("647655.2", TransitStopFacility.class),
			0.0d, 0.0d)); //S Olympia-Stadion
		s3GamedayStops29.add(createTransitRouteStop(scenario, Id.create("651501", TransitStopFacility.class),
			0.0d, 0.0d)); //S Heerstr
		s3GamedayStops29.add(createTransitRouteStop(scenario, Id.create("186494", TransitStopFacility.class),
			0, 0)); //S Messe Süd
		s3GamedayStops29.add(createTransitRouteStop(scenario, Id.create("254235", TransitStopFacility.class),
			360.0d, 420.0d)); //S Westkreuz
		s3GamedayStops29.add(createTransitRouteStop(scenario, Id.create("15532", TransitStopFacility.class),
			600.0d, 600.0d)); //S Charlottenburg Bhf
		s3GamedayStops29.add(createTransitRouteStop(scenario, Id.create("455338", TransitStopFacility.class),
			720.0d, 720.0d)); //S Savignyplatz
		s3GamedayStops29.add(createTransitRouteStop(scenario, Id.create("458977", TransitStopFacility.class),
			840.0d, 840.0d)); //S+U Zoologischer Garten Bhf

		//create complete route
		TransitRoute s3GamedayRoute29 = transitScheduleFactory.createTransitRoute(s3GamedayRoute29Id, s3GamedayNetworkRoute29, s3GamedayStops29, "rail");

		//create depatures
		{
			int depatureCounter = 1;
			double interval = 600;
			double firstDepatureTime = 3 * 3600 + 55 * 60; //first Depature @ 03:55

			for (double depatureTime = firstDepatureTime; depatureTime < 30 * 3600; depatureTime += interval) {
				Departure departure = transitScheduleFactory.createDeparture(Id.create("950831_" + depatureCounter, Departure.class), depatureTime);
				Id<Vehicle> vehicleId = Id.createVehicleId("pt_S3---9439_29_" + depatureCounter);
				transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
					transitVehicles.getVehicleTypes().get(Id.create("S-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
				));
				departure.setVehicleId(vehicleId);
				s3GamedayRoute29.addDeparture(departure);
				depatureCounter++;
			}
		}

		s3Transitline.addRoute(s3GamedayRoute28);
		s3Transitline.addRoute(s3GamedayRoute29);


	}

}
