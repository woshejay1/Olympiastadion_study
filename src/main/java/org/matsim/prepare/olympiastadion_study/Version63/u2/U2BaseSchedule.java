package org.matsim.prepare.olympiastadion_study.Version63.u2;

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

public class U2BaseSchedule {
	public static void prepare(Scenario scenario, TransitSchedule transitSchedule, Vehicles transitVehicles){
		// remove existing u2 lines
		TransitLine oldTransitLine = transitSchedule.getTransitLines().get(Id.create("U2---2874", TransitLine.class));
		transitSchedule.removeTransitLine(oldTransitLine);

		TransitScheduleFactory transitScheduleFactory = transitSchedule.getFactory();
		VehiclesFactory vehiclesFactory = transitVehicles.getFactory();

		// prepare u2 base schedule
		Id<TransitLine> u2TransitLineId = Id.create("U2---new", TransitLine.class);
		TransitLine u2TransitLine =transitScheduleFactory.createTransitLine(u2TransitLineId);

		// create route 01: U Ruhleben-S+U Pankow
		// create route ID
		Id<TransitRoute> u2StandardRoute01Id = Id.create("U2---new_01", TransitRoute.class);

		// create network routes
		NetworkRoute u2standardNetworkRoute01 = RouteUtils.createLinkNetworkRouteImpl(
			// the first link in the route is a loop
			Id.createLinkId("pt_46881"), //U Ruhleben Bstggl.2 pt_46881
			List.of(
				Id.createLinkId("pt_46882"), //U Ruhleben Bstggl.2-U Olympia-Stadion Bstggl.2 pt_46882
				Id.createLinkId("pt_46883"), //U Olympia-Stadion Bstggl.2-U Neu-Westend Bstggl.2 pt_46883
				Id.createLinkId("pt_46884"), //U Neu-Westend Bstggl.2-U Theodor-Heuss-Platz Bstggl.2 pt_46884
				Id.createLinkId("pt_46885"), //U Theodor-Heuss-Platz Bstggl.2-U Kaiserdamm Bstggl.2 pt_46885
				Id.createLinkId("pt_46886"), //U Kaiserdamm Bstggl.2-U Sophie-Charlotte-Platz Bstggl.2 pt_46886
				Id.createLinkId("pt_46887"), //U Sophie-Charlotte-Platz Bstggl.2-U Bismarckstr.(oben) Bstggl.2 pt_46887
				Id.createLinkId("pt_46888"), //U Bismarckstr.(oben) Bstggl.2-U Deutsche Oper Bstggl.2 pt_46888
				Id.createLinkId("pt_46889"), //U Deutsche Oper Bstggl.2-U Ernst-Reuter-Platz Bstggl.2 pt_46889
				Id.createLinkId("pt_46890"), //U Ernst-Reuter-Platz Bstggl.2-S+U Zoologischer Garten (U2) Bstggl.2 pt_46890
				Id.createLinkId("pt_46891"), //S+U Zoologischer Garten (U2) Bstggl.2-U Wittenbergplatz (U2) Bstggl.2 pt_46891
				Id.createLinkId("pt_46892"), //U Wittenbergplatz (U2) Bstggl.2-U Nollendorfplatz (oben) Bstggl.2 pt_46892
				Id.createLinkId("pt_46893"), //U Nollendorfplatz (oben) Bstggl.2-U Bülowstr. Bstggl.2 pt_46893
				Id.createLinkId("pt_46894"), //U Bülowstr. Bstggl.2-U Gleisdreieck (unten) Bstggl.2 pt_46894
				Id.createLinkId("pt_46895"), //U Gleisdreieck (unten) Bstggl.2-U Mendelssohn-Bartholdy-Park Bstggl.2 pt_46895
				Id.createLinkId("pt_46896"), //U Mendelssohn-Bartholdy-Park Bstggl.2-S+U Potsdamer Platz Bstggl.2 pt_46896
				Id.createLinkId("pt_46897"), //S+U Potsdamer Platz Bstggl.2-U Mohrenstr. Bstggl.2 pt_46897
				Id.createLinkId("pt_46898"), //U Mohrenstr. Bstggl.2-U Stadtmitte Bstggl.2 pt_46898
				Id.createLinkId("pt_46899"), //U Stadtmitte Bstggl.2-U Hausvogteiplatz Bstggl.2 pt_46899
				Id.createLinkId("pt_46900"), //U Hausvogteiplatz Bstggl.2-U Spittelmarkt Bstggl.2 pt_46900
				Id.createLinkId("pt_46901"), //U Spittelmarkt Bstggl.2-U Märkisches Museum Bstggl.2 pt_46901
				Id.createLinkId("pt_46902"), //U Märkisches Museum Bstggl.2-U Klosterstr. Bstggl.2 pt_46902
				Id.createLinkId("U2_pt_608245-pt_950826"), //U Klosterstr. Bstggl.2-S+U Alexanderplatz Bstggl.2 (U2) U2_pt_608245-pt_950826
				Id.createLinkId("U2_pt_950826-pt_950827"), //S+U Alexanderplatz Bstggl.2 (U2)-U Rosa-Luxemburg-Platz Bstggl.2 U2_pt_950826-pt_950827
				Id.createLinkId("U2_pt_950827-pt_203004"), //U Rosa-Luxemburg-Platz Bstggl.2-U Senefelderplatz Bstggl.2 U2_pt_950827-pt_203004
				Id.createLinkId("pt_46846"), //U Senefelderplatz Bstggl.2-U Eberswalder Str. Bstggl.2 pt_46846
				Id.createLinkId("pt_46847"), //U Eberswalder Str. Bstggl.2-S+U Schönhauser Allee Bstggl.2 pt_46847
				Id.createLinkId("pt_46848") //S+U Schönhauser Allee Bstggl.2-U Vinetastr. Bstggl.2 pt_46848
			),
			Id.createLinkId("pt_46849") //U Vinetastr. Bstggl.2-S+U Pankow Bstggl.2 pt_46849
			);

		// create stops
		List<TransitRouteStop> u2StandardStops01 = new ArrayList<>();
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("652554.1", TransitStopFacility.class),
				0.0d, 0.0d)); //U Ruhleben Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("327714", TransitStopFacility.class),
				120.0d, 120.0d)); //U Olympia-Stadion Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("245154", TransitStopFacility.class),
				180.0d, 180.0d)); //U Neu-Westend Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("445788", TransitStopFacility.class),
				300.0d, 300.0d)); //U Theodor-Heuss-Platz Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("106293", TransitStopFacility.class),
				420.0d, 420.0d)); //U Kaiserdamm Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("417732", TransitStopFacility.class),
				480.0d, 480.0d)); //U Sophie-Charlotte-Platz Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("567448", TransitStopFacility.class),
				600.0d, 600.0d)); //U Bismarckstr.(oben) Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("10580", TransitStopFacility.class),
				660.0d, 660.0d)); //U Deutsche Oper Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("309896", TransitStopFacility.class),
				780.0d, 780.0d)); //U Ernst-Reuter-Platz Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("220465", TransitStopFacility.class),
				840.0d, 840.0d)); //S+U Zoologischer Garten (U2) Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("593215", TransitStopFacility.class),
				1020.0d, 1020.0d)); //U Wittenbergplatz (U2) Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("83730", TransitStopFacility.class),
				1080.0d, 1080.0d)); //U Nollendorfplatz (oben) Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("623035", TransitStopFacility.class),
				1200.0d, 1200.0d)); //U Bülowstr. Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("118531", TransitStopFacility.class),
				1320.0d, 1320.0d)); //U Gleisdreieck (unten) Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("156853", TransitStopFacility.class),
				1380.0d, 1380.0d)); //U Mendelssohn-Bartholdy-Park Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("136004", TransitStopFacility.class),
				1500.0d, 1500.0d)); //S+U Potsdamer Platz Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("306663", TransitStopFacility.class),
				1560.0d, 1560.0d)); //U Mohrenstr. Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("574213", TransitStopFacility.class),
				1620.0d, 1620.0d)); //U Stadtmitte Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("349237", TransitStopFacility.class),
				1740.0d, 1740.0d)); //U Hausvogteiplatz Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("155890", TransitStopFacility.class),
				1860.0d, 1860.0d)); //U Spittelmarkt Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("380523", TransitStopFacility.class),
				1980.0d, 1980.0d)); //U Märkisches Museum Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("608245.1", TransitStopFacility.class),
				2040.0d, 2040.0d)); //U Klosterstr. Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("987654", TransitStopFacility.class),
				2160.0d, 2160.0d)); //S+U Alexanderplatz Bstggl.2 (U2)
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("123456", TransitStopFacility.class),
				2280.0d, 2280.0d)); //U Rosa-Luxemburg-Platz Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("203004", TransitStopFacility.class),
				2400.0d, 2400.0d)); //U Senefelderplatz Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("292118", TransitStopFacility.class),
				2520.0d, 2520.0d)); //U Eberswalder Str. Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("118148", TransitStopFacility.class),
				2640.0d, 2640.0d)); //S+U Schönhauser Allee Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("536323", TransitStopFacility.class),
				2760.0d, 2760.0d)); //U Vinetastr. Bstggl.2
		u2StandardStops01.add(createTransitRouteStop(scenario, Id.create("579874", TransitStopFacility.class),
				2820.0d, 2820.0d)); //S+U Pankow Bstggl.2

		// create complete route
		TransitRoute u2StandardRoute01 = transitScheduleFactory.createTransitRoute(u2StandardRoute01Id, u2standardNetworkRoute01, u2StandardStops01, "rail");

		// create departures
		{
			int departureCounter = 1;
			double interval = 600;
			double firstDepartureTime = 4 * 3600 + 23 * 60;  // first departure @ 04:23

			for (double departureTime = firstDepartureTime; departureTime < 30 * 3600; departureTime += interval) {
				Departure departure = transitScheduleFactory.createDeparture(Id.create("950826_" + departureCounter, Departure.class), departureTime);
				Id<Vehicle> vehicleId = Id.createVehicleId("pt_U2---new_01_" + departureCounter);
				transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
					transitVehicles.getVehicleTypes().get(Id.create("U-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
				));
				departure.setVehicleId(vehicleId);
				u2StandardRoute01.addDeparture(departure);
				departureCounter++;
			}
		}

        // create network routes(U2---S+U Pankow-U Ruhleben)
		Id<TransitRoute> u2StandardRoute02Id = Id.create("U2---new_02", TransitRoute.class);
		NetworkRoute u2standardNetworkRoute02 = RouteUtils.createLinkNetworkRouteImpl(
			// the first link in the route is a loop
			Id.createLinkId("pt_46854"), //S+U Pankow pt_46854
			List.of(
				Id.createLinkId("pt_46855"), //S+U Pankow Bstggl.1-U Vinetastr. Bstggl.1 pt_46855
				Id.createLinkId("pt_46856"), //U Vinetastr. Bstggl.1-S+U Schönhauser Allee Bstggl.1 pt_46856
				Id.createLinkId("pt_46857"), //S+U Schönhauser Allee Bstggl.1-U Eberswalder Str. Bstggl.1 pt_46857
				Id.createLinkId("U2_pt_651071-pt_635307"), //U Eberswalder Str. Bstggl.1-U Senefelderplatz Bstggl.1 U2_pt_651071-pt_635307
				Id.createLinkId("pt_46851"), //U Senefelderplatz Bstggl.1-U Rosa-Luxemburg-Platz Bstggl.1 pt_46851
				Id.createLinkId("pt_46852"), //U Rosa-Luxemburg-Platz Bstggl.1-S+U Alexanderplatz Bstggl.1 (U2) pt_46852
				Id.createLinkId("pt_46853"), //S+U Alexanderplatz Bstggl.1 (U2)-U Klosterstr. Bstggl.1 pt_46853
				Id.createLinkId("U2_pt_126113-pt_60578"), //U Klosterstr. Bstggl.1-U Märkisches Museum Bstggl.1 U2_pt_60578-pt_126113
				Id.createLinkId("pt_46861"), //U Märkisches Museum Bstggl.1-U Spittelmarkt Bstggl.1 pt_46861
				Id.createLinkId("pt_46862"), //U Spittelmarkt Bstggl.1-U Hausvogteiplatz Bstggl.1 pt_46862
				Id.createLinkId("pt_46863"), //U Hausvogteiplatz Bstggl.1-U Stadtmitte Bstggl.1 pt_46863
				Id.createLinkId("pt_46864"), //U Stadtmitte Bstggl.1-U Mohrenstr. Bstggl.1 pt_46864
				Id.createLinkId("pt_46865"), //U Mohrenstr. Bstggl.1-S+U Potsdamer Platz Bstggl.1 pt_46865
				Id.createLinkId("pt_46866"), //S+U Potsdamer Platz Bstggl.1-U Mendelssohn-Bartholdy-Park Bstggl.1 pt_46866
				Id.createLinkId("pt_46867"), //U Mendelssohn-Bartholdy-Park Bstggl.1-U Gleisdreieck (unten) Bstggl.1 pt_46867
				Id.createLinkId("pt_46868"), //U Gleisdreieck (unten) Bstggl.1-U Bülowstr. Bstggl.1 pt_46868
				Id.createLinkId("pt_46869"), //U Bülowstr. Bstggl.1-U Nollendorfplatz (oben) Bstggl.1 pt_46869
				Id.createLinkId("pt_46870"), //U Nollendorfplatz (oben) Bstggl.1-U Wittenbergplatz (U2) Bstggl.3 pt_46870
				Id.createLinkId("pt_46871"), //U Wittenbergplatz (U2) Bstggl.3-S+U Zoologischer Garten (U2) Bstggl.1 pt_46871
				Id.createLinkId("pt_46872"), //S+U Zoologischer Garten (U2) Bstggl.1-U Ernst-Reuter-Platz Bstggl.1 pt_46872
				Id.createLinkId("pt_46873"), //U Ernst-Reuter-Platz Bstggl.1-U Deutsche Oper Bstggl.1 pt_46873
				Id.createLinkId("pt_46874"), //U Deutsche Oper Bstggl.1-U Bismarckstr.(oben) Bstggl.1 pt_46874
				Id.createLinkId("pt_46875"), //U Bismarckstr.(oben) Bstggl.1-U Sophie-Charlotte-Platz Bstggl.1 pt_46875
				Id.createLinkId("pt_46876"), //U Sophie-Charlotte-Platz Bstggl.1-U Kaiserdamm Bstggl.1 pt_46876
				Id.createLinkId("pt_46877"), //U Kaiserdamm Bstggl.1-U Theodor-Heuss-Platz Bstggl.1 pt_46877
				Id.createLinkId("pt_46878"), //U Theodor-Heuss-Platz Bstggl.1-U Neu-Westend Bstggl.1 pt_46878
				Id.createLinkId("pt_46879")//U Neu-Westend Bstggl.1-U Olympia-Stadion Bstggl.1 pt_46879
			),
			Id.createLinkId("pt_46880") //U Olympia-Stadion Bstggl.1-U Ruhleben Bstggl.2 pt_46880
		);

		// create stops
		List<TransitRouteStop> u2StandardStops02 = new ArrayList<>();

		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("561514", TransitStopFacility.class),
			0.0d, 0.0d)); //S+U Pankow Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("500130", TransitStopFacility.class),
			60.0d, 60.0d)); //U Vinetastr. Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("466905", TransitStopFacility.class),
			180.0d, 180.0d)); //S+U Schönhauser Allee Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("651071", TransitStopFacility.class),
			300.0d, 300.0d)); //U Eberswalder Str. Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("635307", TransitStopFacility.class),
			420.0d, 420.0d)); //U Senefelderplatz Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("95385", TransitStopFacility.class),
			540.0d, 540.0d)); //U Rosa-Luxemburg-Platz Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("41263", TransitStopFacility.class),
			660.0d, 660.0d)); //S+U Alexanderplatz Bstggl.1 (U2)
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("126113", TransitStopFacility.class),
			780.0d, 780.0d)); //U Klosterstr. Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("60578", TransitStopFacility.class),
			840.0d, 840.0d)); //U Märkisches Museum Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("566884", TransitStopFacility.class),
			960d, 960d)); //U Spittelmarkt Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("515511", TransitStopFacility.class),
			1080.0d, 1080.0d)); //U Hausvogteiplatz Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("556900", TransitStopFacility.class),
			1200.0d, 1200.0d)); //U Stadtmitte Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("546773", TransitStopFacility.class),
			1260.0d, 1260.0d)); //U Mohrenstr. Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("36689", TransitStopFacility.class),
			1320.0d, 1320.0d)); //S+U Potsdamer Platz Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("347160", TransitStopFacility.class),
			1440.0d, 1440.0d)); //U Mendelssohn-Bartholdy-Park Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("258921", TransitStopFacility.class),
			1500.0d, 1500.0d)); //U Gleisdreieck (unten) Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("571681", TransitStopFacility.class),
			1620.0d, 1620.0d)); //U Bülowstr. Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("386305", TransitStopFacility.class),
			1740.0d, 1740.0d)); //U Nollendorfplatz (oben) Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("430150", TransitStopFacility.class),
			1800.0d, 1800.0d)); //U Wittenbergplatz (U2) Bstggl.3
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("38505", TransitStopFacility.class),
			1980d, 1980d)); //S+U Zoologischer Garten (U2) Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("643523", TransitStopFacility.class),
			2040.0d, 2040.0d)); //U Ernst-Reuter-Platz Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("80139", TransitStopFacility.class),
			2160.0d, 2160.0d)); //U Deutsche Oper Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("321269", TransitStopFacility.class),
			2220.0d, 2220.0d)); //U Bismarckstr.(oben) Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("496252", TransitStopFacility.class),
			2340.0d, 2340.0d)); //U Sophie-Charlotte-Platz Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("252817", TransitStopFacility.class),
			2400.0d, 2400.0d)); //U Kaiserdamm Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("618146", TransitStopFacility.class),
			2520.0d, 2520.0d)); //U Theodor-Heuss-Platz Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("603359", TransitStopFacility.class),
			2640.0d, 2640.0d)); //U Neu-Westend Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("337183", TransitStopFacility.class),
			2760.0d, 2760.0d)); //U Olympia-Stadion Bstggl.1
		u2StandardStops02.add(createTransitRouteStop(scenario, Id.create("652554", TransitStopFacility.class),
			2820.0d, 2820.0d)); //U Ruhleben Bstggl.2

		// create route
		TransitRoute u2StandardRoute02 =transitScheduleFactory.createTransitRoute(u2StandardRoute02Id, u2standardNetworkRoute02, u2StandardStops02, "rail");

		// create departures
		{
			int departureCounter = 1;
			double interval = 600;
			double firstDepartureTime = 4 * 3600 + 4 * 60;  // first departure @ 04:04

			for (double departureTime = firstDepartureTime; departureTime < 30 * 3600; departureTime += interval) {
				Departure departure = transitScheduleFactory.createDeparture(Id.create("950827_" + departureCounter, Departure.class), departureTime);
				Id<Vehicle> vehicleId = Id.createVehicleId("pt_U2---new_02_" + departureCounter);
				transitVehicles.addVehicle(vehiclesFactory.createVehicle(vehicleId,
					transitVehicles.getVehicleTypes().get(Id.create("U-Bahn_veh_type", org.matsim.vehicles.VehicleType.class))
				));
				departure.setVehicleId(vehicleId);
				u2StandardRoute02.addDeparture(departure);
				departureCounter++;
			}
		}

		u2TransitLine.addRoute(u2StandardRoute01);
		u2TransitLine.addRoute(u2StandardRoute02);
		scenario.getTransitSchedule().addTransitLine(u2TransitLine);
	}
}
