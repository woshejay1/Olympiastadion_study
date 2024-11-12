package org.matsim.prepare.olympiastadion_study.Version60;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.prepare.olympiastadion_study.Version60.s3.S3GamedaySchedule;
import org.matsim.prepare.olympiastadion_study.Version60.s5.S5GamedaySchedule;
import org.matsim.prepare.olympiastadion_study.Version60.s9.S9GamedaySchedule;
import org.matsim.prepare.olympiastadion_study.Version60.u2.U2GamedaySchedule;
import org.matsim.pt.transitSchedule.api.TransitSchedule;
import org.matsim.pt.transitSchedule.api.TransitScheduleWriter;
import org.matsim.vehicles.MatsimVehicleWriter;
import org.matsim.vehicles.Vehicles;

public class PrepareBaseSchedule {public static void main(String[] args) {
	Config config = ConfigUtils.loadConfig("F:/matsim-berlin/input/v6.3/berlin-v6.3.config.xml");
	config.plans().setInputFile("https://svn.vsp.tu-berlin.de/repos/public-svn/matsim/scenarios/countries/de/berlin/berlin-v6.0/input/berlin-v6.0-0.1pct.plans-initial.xml.gz");
	config.transit().setTransitScheduleFile("F:/Masterarbeit/Version6.0/intermediate_transitSchedule.xml");
	config.transit().setVehiclesFile("https://svn.vsp.tu-berlin.de/repos/public-svn/matsim/scenarios/countries/de/berlin/berlin-v6.0/input/berlin-v6.0-transitVehicles.xml.gz");
	config.network().setInputFile("F:/Masterarbeit/Version6.0/updated_network.xml");
	Scenario scenario = ScenarioUtils.loadScenario(config);
	TransitSchedule transitSchedule = scenario.getTransitSchedule();
	Vehicles transitVehicles = scenario.getTransitVehicles();

	U2GamedaySchedule.prepare(transitSchedule, transitVehicles);
	S3GamedaySchedule.prepare(scenario, transitSchedule, transitVehicles);
	S5GamedaySchedule.prepare(scenario, transitSchedule, transitVehicles);
	S9GamedaySchedule.prepare(transitSchedule, transitVehicles);



	String outputTransitScheduleFilePath = "F:/Masterarbeit/Version6.0/base_transitSchedule.xml";
	new TransitScheduleWriter(transitSchedule).writeFile(outputTransitScheduleFilePath);
	String outputTransitVehiclesFilePath = "F:/Masterarbeit/Version6.0/base_transitVehicles.xml";
	new MatsimVehicleWriter(transitVehicles).writeFile(outputTransitVehiclesFilePath);

}


}
