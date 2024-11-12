package org.matsim.prepare.olympiastadion_study.Version63;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.prepare.olympiastadion_study.Version63.s3.S3GamedaySchedule;
import org.matsim.prepare.olympiastadion_study.Version63.s5.S5GamedaySchedule;
import org.matsim.prepare.olympiastadion_study.Version63.u2.U2BaseSchedule;
import org.matsim.pt.transitSchedule.api.TransitRouteStop;
import org.matsim.pt.transitSchedule.api.TransitSchedule;
import org.matsim.pt.transitSchedule.api.TransitScheduleWriter;
import org.matsim.pt.transitSchedule.api.TransitStopFacility;
import org.matsim.vehicles.MatsimVehicleWriter;
import org.matsim.vehicles.Vehicles;

public class PrepareBaseSchedule {
	public static void main(String[] args) {
		Config config = ConfigUtils.loadConfig("F:/matsim-berlin/input/v6.3/berlin-v6.3.config.xml");
		config.plans().setInputFile("https://svn.vsp.tu-berlin.de/repos/public-svn/matsim/scenarios/countries/de/berlin/berlin-v6.3/input/berlin-v6.3-0.1pct.plans.xml.gz");
		config.transit().setTransitScheduleFile("F:/Masterarbeit/Version 6.3/intermediate_transitSchedule.xml");
		config.network().setInputFile("F:/Masterarbeit/Version 6.3/updated_network.xml");
		Scenario scenario = ScenarioUtils.loadScenario(config);
		TransitSchedule transitSchedule = scenario.getTransitSchedule();
		Vehicles transitVehicles = scenario.getTransitVehicles();

		U2BaseSchedule.prepare(scenario, transitSchedule, transitVehicles);
		S5GamedaySchedule.prepare(scenario, transitSchedule, transitVehicles);
		S3GamedaySchedule.prepare(scenario, transitSchedule, transitVehicles);



		String outputTransitScheduleFilePath = "F:/Masterarbeit/Version 6.3/base_transitSchedule.xml";
		new TransitScheduleWriter(transitSchedule).writeFile(outputTransitScheduleFilePath);
		String outputTransitVehiclesFilePath = "F:/Masterarbeit/Version 6.3/base_transitVehicles.xml";
		new MatsimVehicleWriter(transitVehicles).writeFile(outputTransitVehiclesFilePath);

	}

	private static TransitRouteStop createTransitRouteStop(Scenario scenario, Id<TransitStopFacility> stop,
														   double arrivalOffset, double departureOffset) {
		TransitRouteStop transitRouteStop = scenario.getTransitSchedule().getFactory().createTransitRouteStop(
			scenario.getTransitSchedule().getFacilities().get(stop),
			arrivalOffset,
			departureOffset);
		transitRouteStop.setAwaitDepartureTime(true);
		return transitRouteStop;
	}


}
