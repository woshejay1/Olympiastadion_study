package org.matsim.prepare.olympiastadion_study.Version63.s5;

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

public class S5GamedaySchedule {

	public static void prepare(Scenario scenario, TransitSchedule transitSchedule, Vehicles transitVehicles){

		TransitScheduleFactory transitScheduleFactory = transitSchedule.getFactory();
		VehiclesFactory vehiclesFactory = transitVehicles.getFactory();

        // prepare s5 gameday schedule
		TransitLine s5Transitline = transitSchedule.getTransitLines().get(Id.create("S5---14397", TransitLine.class));

		//create route 39: S Strausberg Nord-S Olympia-Stadion
        Id<TransitRoute> s5GamedayRoute39Id = Id.create("S5---14397_39", TransitRoute.class);

		//create network routes
		NetworkRoute s5GamedayNetworkRoute39 = RouteUtils.createLinkNetworkRouteImpl(
				Id.createLinkId("pt_46658"), //S Strausberg Nord pt_46658
				List.of(
						Id.createLinkId("pt_46659"), //S Strausberg Nord-S Strausberg Stadt pt_46659
						Id.createLinkId("pt_46620"), //S Strausberg Stadt-S Hegermühle pt_46620
						Id.createLinkId("pt_46621"), //S Hegermühle-S Strausberg Bhf pt_46621
						Id.createLinkId("pt_46622"), //S Strausberg Bhf-S Petershagen Nord pt_46622
						Id.createLinkId("pt_46623"), //S Petershagen Nord-S Fredersdorf pt_46623
						Id.createLinkId("pt_46624"), //S Fredersdorf-S Neuenhagen pt_46624
						Id.createLinkId("pt_46625"), //S Neuenhagen-S Hoppegarten pt_46625
						Id.createLinkId("pt_46626"), //S Hoppegarten-S Birkenstein pt_46626
						Id.createLinkId("pt_46627"), //S Birkenstein-S Mahlsdorf pt_46627
						Id.createLinkId("pt_46628"), //S Mahlsdorf-S Kaulsdorf pt_46628
						Id.createLinkId("pt_46612"), //S Kaulsdorf-S+U Wuhletal pt_46612
						Id.createLinkId("pt_46613"), //S+U Wuhletal-S Biesdorf pt_46613
						Id.createLinkId("pt_46614"), //S Biesdorf-S Friedrichsfelde Ost pt_46614
						Id.createLinkId("pt_46615"), //S Friedrichsfelde Ost-S+U Lichtenberg Bhf pt_46615
						Id.createLinkId("pt_46616"), //S+U Lichtenberg Bhf-S Nöldnerplatz pt_46616
						Id.createLinkId("pt_46629"), //S Nöldnerplatz-S Ostkreuz pt_46629
						Id.createLinkId("pt_46432"), //S Ostkreuz-S+U Warschauer Str. pt_46432
						Id.createLinkId("pt_46433"), //S+U Warschauer Str.-S Ostbahnhof pt_46433
						Id.createLinkId("pt_46434"), //S Ostbahnhof-S+U Jannowitzbrücke pt_46434
						Id.createLinkId("pt_46435"), //S+U Jannowitzbrücke-S+U Alexanderplatz Bhf pt_46435
						Id.createLinkId("pt_46436"), //S+U Alexanderplatz Bhf-S Hackescher Markt pt_46436
						Id.createLinkId("pt_46437"), //S Hackescher Markt-S+U Friedrichstr. Bhf pt_46437
						Id.createLinkId("pt_46438"), //S+U Friedrichstr. Bhf-S Berlin Hbf pt_46438
						Id.createLinkId("pt_46439"), //S Berlin Hbf-S Bellevue pt_46439
						Id.createLinkId("pt_46440"), //S Bellevue-S Tiergarten pt_46440
						Id.createLinkId("pt_46441"), //S Tiergarten-S+U Zoologischer Garten Bhf pt_46441
						Id.createLinkId("pt_46442"), //S+U Zoologischer Garten Bhf-S Savignyplatz pt_46442
						Id.createLinkId("pt_46443"), //S Savignyplatz-S Charlottenburg Bhf pt_46443
						Id.createLinkId("pt_46444"), //S Charlottenburg Bhf-S Westkreuz pt_46444
					    Id.createLinkId("pt_46445"), //S Westkreuz-S Messe Süd pt_46445
					    Id.createLinkId("pt_46446") //S Messe Süd-S Heerstr pt_46446
				),
			      Id.createLinkId("pt_46447") //S Heerstr-S Olympiastadion pt_46447
			   // 直接连接
			   // Id.createLinkId("S5_pt_242258-pt_647655") //S Westkreuz- S Olympiastadion pt_46390
				);

		//create stops
        List<TransitRouteStop> s5GamedayStops39 = new ArrayList<>();
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("395141.1", TransitStopFacility.class),
		0.0d, 0.0d)); //S Strausberg Nord
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("450267.2", TransitStopFacility.class),
			180.0d, 180.0d)); //S Strausberg Stadt
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("193279", TransitStopFacility.class),
			420.0d, 420.0d)); //S Hegermühle
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("115806", TransitStopFacility.class),
			660.0d, 660.0d)); //S Strausberg Bhf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("422777", TransitStopFacility.class),
			900.0d, 900.0d)); //S Petershagen Nord
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("455543", TransitStopFacility.class),
			1080.0d, 1080.0d)); //S Fredersdorf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("538425", TransitStopFacility.class),
			1380.0d, 1380.0d)); //S Neuenhagen
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("485064", TransitStopFacility.class),
			1500.0d, 1500.0d)); //S Hoppegarten
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("472394", TransitStopFacility.class),
			1680.0d, 1680.0d)); //S Birkenstein
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("273406", TransitStopFacility.class),
			1860.0d, 1920.0d)); //S Mahlsdorf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("311696.1", TransitStopFacility.class),
			2100.0d, 2100.0d)); //S Kaulsdorf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("297414", TransitStopFacility.class),
			2220.0d, 2220.0d)); //S+U Wuhletal
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("92256", TransitStopFacility.class),
			2340.0d, 2340.0d)); //S Biesdorf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("134531", TransitStopFacility.class),
			2520.0d, 2520.0d)); //S Friedrichsfelde Ost
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("639641", TransitStopFacility.class),
			2700.0d, 2700.0d)); //S+U Lichtenberg Bhf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("635437", TransitStopFacility.class),
			2820.0d, 2820.0d)); //S Nöldnerplatz
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("386941.1", TransitStopFacility.class),
			2940.0d, 2940.0d)); //S Ostkreuz
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("301567.1", TransitStopFacility.class),
			3120.0d, 3120.0d)); //S+U Warschauer Str.
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("124965", TransitStopFacility.class),
			3240.0d, 3240.0d)); //S Ostbahnhof
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("367271", TransitStopFacility.class),
			3360.0d, 3360.0d)); //S+U Jannowitzbrücke
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("259936", TransitStopFacility.class),
			3540.0d, 3540.0d)); //S+U Alexanderplatz Bhf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("270627", TransitStopFacility.class),
			3600.0d, 3600.0d)); //S Hackescher Markt
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("490738", TransitStopFacility.class),
			3780.0d, 3780.0d)); //S+U Friedrichstr. Bhf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("612626", TransitStopFacility.class),
			3900.0d, 3900.0d)); //S Berlin Hbf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("302296", TransitStopFacility.class),
			4080.0d, 4080.0d)); //S Bellevue
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("376087", TransitStopFacility.class),
			4200.0d, 4200.0d)); //S Tiergarten
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("88875", TransitStopFacility.class),
			4260.0d, 4320.0d)); //S+U Zoologischer Garten Bhf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("455338.1", TransitStopFacility.class),
			4440.0d, 4440.0d)); //S Savignyplatz
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("389698", TransitStopFacility.class),
			4560.0d, 4560.0d)); //S Charlottenburg Bhf
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("64837", TransitStopFacility.class),
			4680.0d, 4740.0d)); //S Westkreuz
//		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("186494.1", TransitStopFacility.class),
//			0.0, 0.0)); //S Messe Süd
//		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("651501.1", TransitStopFacility.class),
//			0.0, 0.0)); //S Heerstr
		s5GamedayStops39.add(createTransitRouteStop(scenario, Id.create("647655.1", TransitStopFacility.class),
			5100.0d, 5100.0d)); //S Olympiastadion

		//create complete route
		TransitRoute s5GamedayRoute39 = transitScheduleFactory.createTransitRoute(s5GamedayRoute39Id, s5GamedayNetworkRoute39, s5GamedayStops39, "rail");

		//create depatures
		{
            int depatureCounter = 1;
			double interval = 600;
			double firstDepatureTime = 3 * 3600 + 49 * 60; //first Depature @ 03:49

			for (double depatureTime = firstDepatureTime; depatureTime < 30 * 3600; depatureTime += interval) {
				Departure departure = transitScheduleFactory.createDeparture(Id.create("950828_" + depatureCounter, Departure.class), depatureTime);
				Id<Vehicle> vehicleId = Id.createVehicleId("pt_S5---14397_39_" + depatureCounter);
				transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
					transitVehicles.getVehicleTypes().get(Id.create("S-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
				));
				departure.setVehicleId(vehicleId);
				s5GamedayRoute39.addDeparture(departure);
				depatureCounter++;
			}
		}

		//create network routes

		//create route 40: S Strausberg Nord-S Olympia-Stadion
		Id<TransitRoute> s5GamedayRoute40Id = Id.create("S5---14397_40", TransitRoute.class);

		//create network routes
		NetworkRoute s5GamedayNetworkRoute40 = RouteUtils.createLinkNetworkRouteImpl(
			Id.createLinkId("pt_647655"), //S Olympiastadion pt_647655
			List.of(
				Id.createLinkId("pt_46391"), //S Olympiastadion-S Heerstr pt_46391
				Id.createLinkId("pt_46392"), //S Heerstr-S Messe Süd pt_46392
				Id.createLinkId("pt_46393"), //S Messe Süd-S Westkreuz pt_46393

//				Id.createLinkId("S5_pt_647655-pt_45592"), //S Olympiastadion-S Westkreuz

				Id.createLinkId("pt_46394"), //S Westkreuz-S Charlottenburg Bhf
				Id.createLinkId("pt_46395"), //S Charlottenburg Bhf-S Savignyplatz pt_46395
				Id.createLinkId("pt_46396"), //S Savignyplatz-S+U Zoologischer Garten Bhf pt_46396
				Id.createLinkId("pt_46397"), //S+U Zoologischer Garten Bhf-S Tiergarten pt_46397
				Id.createLinkId("pt_46398"), //S Tiergarten-S Bellevue pt_46398
				Id.createLinkId("pt_46399"), //S Bellevue-S Berlin Hbf pt_46399
				Id.createLinkId("pt_46400"), //S Berlin Hbf-S+U Friedrichstr. Bhf pt_46400
				Id.createLinkId("pt_46401"), //S+U Friedrichstr. Bhf-S Hackescher Markt pt_46401
				Id.createLinkId("pt_46402"), //S Hackescher Markt-S+U Alexanderplatz Bhf pt_46402
				Id.createLinkId("pt_46403"), //S+U Alexanderplatz Bhf-S+U Jannowitzbrücke pt_46403
				Id.createLinkId("pt_46404"), //S+U Jannowitzbrücke-S Ostbahnhof pt_46404
				Id.createLinkId("pt_46405"), //S Ostbahnhof-S+U Warschauer Str. pt_46405
				Id.createLinkId("pt_46406"), //S+U Warschauer Str.-S Ostkreuz pt_46406
				Id.createLinkId("pt_46633"), //S Ostkreuz-S Nöldnerplatz pt_46633
				Id.createLinkId("pt_46604"), //S Nöldnerplatz-S+U Lichtenberg Bhf pt_46604
				Id.createLinkId("pt_46605"), //S+U Lichtenberg Bhf-S Friedrichsfelde Ost pt_46605
				Id.createLinkId("pt_46606"), //S Friedrichsfelde Ost-S Biesdorf pt_46606
				Id.createLinkId("pt_46607"), //S Biesdorf-S+U Wuhletal pt_46607
				Id.createLinkId("pt_46608"), //S+U Wuhletal-S Kaulsdorf pt_46608
				Id.createLinkId("pt_46634"), //S Kaulsdorf-S Mahlsdorf pt_46634
				Id.createLinkId("pt_46637"), //S Mahlsdorf-S Birkenstein pt_46637
				Id.createLinkId("pt_46638"), //S Birkenstein-S Hoppegarten pt_46638
				Id.createLinkId("pt_46639"), //S Hoppegarten-S Neuenhagen pt_46639
				Id.createLinkId("pt_46640"), //S Neuenhagen-S Fredersdorf pt_46640
				Id.createLinkId("pt_46641"), //S Fredersdorf-S Petershagen Nord pt_46641
				Id.createLinkId("pt_46642"), //S Petershagen Nord-S Strausberg Bhf pt_46642
				Id.createLinkId("pt_46643"), //S Strausberg Bhf-S Hegermühle pt_46643
				Id.createLinkId("pt_46644") //S Hegermühle-S Strausberg Stadt pt_46644
			),
			Id.createLinkId("pt_46645") //S Strausberg Stadt-S Strausberg Nord pt_46645
		);

		//create stops
		List<TransitRouteStop> s5GamedayStops40 = new ArrayList<>();
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("647655.2", TransitStopFacility.class),
			0.0d, 0.0d)); //S Olympiastadion
//		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("651501", TransitStopFacility.class),
//			0, 0)); //S Heerstr
//		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("186494", TransitStopFacility.class),
//			0, 0)); //S Messe Süd
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("254235", TransitStopFacility.class),
			360.0d, 360.0d)); //S Westkreuz
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("15532", TransitStopFacility.class),
			540.0d, 540.0d)); //S Charlottenburg Bhf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("455338", TransitStopFacility.class),
			660.0d, 660.0d)); //S Savignyplatz
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("458977", TransitStopFacility.class),
			720.0d, 780.0d)); //S+U Zoologischer Garten Bhf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("339035", TransitStopFacility.class),
			900.0d, 900.0d)); //S Tiergarten
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("375673", TransitStopFacility.class),
			1020.0d, 1020.0d)); //S Bellevue
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("525677", TransitStopFacility.class),
			1200.0d, 1200.0d)); //S Berlin Hbf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("598063", TransitStopFacility.class),
			1320.0d, 1320.0d)); //S+U Friedrichstr. Bhf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("388409", TransitStopFacility.class),
			1440.0d, 1440.0d)); //S Hackescher Markt
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("8565", TransitStopFacility.class),
			1560.0d, 1560.0d)); //S+U Alexanderplatz Bhf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("212432", TransitStopFacility.class),
			1680.0d, 1680.0d)); //S+U Jannowitzbrücke
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("152185", TransitStopFacility.class),
			1800.0d, 1860.0d)); //S Ostbahnhof
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("301567", TransitStopFacility.class),
			1980.0d, 1980.0d)); //S+U Warschauer Str.
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("335985", TransitStopFacility.class),
			2100.0d, 2160.0d)); //S Ostkreuz
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("535276.1", TransitStopFacility.class),
			2280.0d, 2280.0d)); //S Nöldnerplatz
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("662133", TransitStopFacility.class),
			2400.0d, 2400.0d)); //S+U Lichtenberg Bhf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("269128", TransitStopFacility.class),
			2520.0d, 2520.0d)); //S Friedrichsfelde Ost
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("63810", TransitStopFacility.class),
			2700.0d, 2700.0d)); //S Biesdorf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("604911", TransitStopFacility.class),
			2880.0d, 2880.0d)); //S+U Wuhletal
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("107064", TransitStopFacility.class),
			3000.0d, 3000.0d)); //S Kaulsdorf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("668428.1", TransitStopFacility.class),
			3060.0d, 3120.0d)); //S Mahlsdorf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("15057", TransitStopFacility.class),
			3360.0d, 3360.0d)); //S Birkenstein
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("188739", TransitStopFacility.class),
			3480.0d, 3480.0d)); //S Hoppegarten
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("538425.1", TransitStopFacility.class),
			3660.0d, 3660.0d)); //S Neuenhagen
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("376430", TransitStopFacility.class),
			3960.0d, 3960.0d)); //S Fredersdorf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("422777.1", TransitStopFacility.class),
			4140.0d, 4140.0d)); //S Petershagen Nord
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("115806.1", TransitStopFacility.class),
			4380.0d, 4380.0d)); //S Strausberg Bhf
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("193279.1", TransitStopFacility.class),
			4620.0d, 4620.0d)); //S Hegermühle
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("450267.1", TransitStopFacility.class),
			4860.0d, 4860.0d)); //S Strausberg Stadt
		s5GamedayStops40.add(createTransitRouteStop(scenario, Id.create("4188.1", TransitStopFacility.class),
			4980.0d, 4980.0d)); //S Strausberg Nord

		//create complete route
		TransitRoute s5GamedayRoute40 = transitScheduleFactory.createTransitRoute(s5GamedayRoute40Id, s5GamedayNetworkRoute40, s5GamedayStops40, "rail");

		//create depatures
		{
			int depatureCounter = 1;
			double interval = 600;
			double firstDepatureTime = 4 * 3600 + 1 * 60; //first Depature @ 04:01

			for (double depatureTime = firstDepatureTime; depatureTime < 30 * 3600; depatureTime += interval) {
				Departure departure = transitScheduleFactory.createDeparture(Id.create("950829_" + depatureCounter, Departure.class), depatureTime);
				Id<Vehicle> vehicleId = Id.createVehicleId("pt_S5---14397_40_" + depatureCounter);
				transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
					transitVehicles.getVehicleTypes().get(Id.create("S-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
				));
				departure.setVehicleId(vehicleId);
				s5GamedayRoute40.addDeparture(departure);
				depatureCounter++;
			}
		}

		s5Transitline.addRoute(s5GamedayRoute39);
		s5Transitline.addRoute(s5GamedayRoute40);




	}
}
