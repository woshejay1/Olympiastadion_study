package org.matsim.prepare.olympiastadion_study.Version63;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.api.core.v01.network.NetworkWriter;
import org.matsim.api.core.v01.network.Node;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.geometry.CoordUtils;
import org.matsim.pt.transitSchedule.api.*;

import java.util.Set;

public class PrepareNetworkAndStops {

	public static void main(String[] args) {
		// Create configurations and scenarios
		Config config = ConfigUtils.loadConfig("F:/matsim-berlin/input/v6.3/berlin-v6.3.config.xml");

		// Using the original network (read from SVN)
		String inputNetworkFile = "https://svn.vsp.tu-berlin.de/repos/public-svn/matsim/scenarios/countries/de/berlin/berlin-v6.3/input/berlin-v6.3-network-with-pt.xml.gz";
		config.network().setInputFile(inputNetworkFile);

		// Using the original transitSchedule (read from SVN)
		String inputTransitScheduleFile = "https://svn.vsp.tu-berlin.de/repos/public-svn/matsim/scenarios/countries/de/berlin/berlin-v6.3/input/berlin-v6.3-transitSchedule.xml.gz";
		config.transit().setTransitScheduleFile(inputTransitScheduleFile);

		// Using the original Plan-0.1pct (read from SVN)
		String inputPlansFile = "https://svn.vsp.tu-berlin.de/repos/public-svn/matsim/scenarios/countries/de/berlin/berlin-v6.3/input/berlin-v6.3-0.1pct.plans.xml.gz";
		config.plans().setInputFile(inputPlansFile);

		Scenario scenario = ScenarioUtils.loadScenario(config);
		Network network = scenario.getNetwork();
		TransitSchedule transitSchedule = scenario.getTransitSchedule();
		TransitScheduleFactory transitScheduleFactory = transitSchedule.getFactory();

		// Create missing Node for network
		Node nodeAlexanderplatzPl2 = NetworkUtils.createNode(Id.createNodeId("pt_950826"), new Coord(799428.0095169795, 5828233.230596523)); //S+U Alexanderplatz Bstggl.2 (U2)
		Node nodeRosaLuxemburgPlatzPl2 = NetworkUtils.createNode(Id.createNodeId("pt_950827"), new Coord(799134.6373820644, 5828881.412143952)); //U Rosa-Luxemburg-Platz Bstggl.2

		//Get Node from Network
		Node nodeOlympiaStadion = network.getNodes().get(Id.createNodeId("pt_647655"));
		Node nodeZoologischeGarten = network.getNodes().get(Id.createNodeId("pt_88875"));


		// Adding nodes to the network
		network.addNode(nodeAlexanderplatzPl2);
		network.addNode(nodeRosaLuxemburgPlatzPl2);

        //change linkId for stopfacility of new node
		//U Senefelderplatz Bstggl.2
		Id<TransitStopFacility> SenefelderPlatzBstg2StopFacilityId = Id.create("203004", TransitStopFacility.class);
		TransitStopFacility SenefelderPlatzBstg2stopFacility = scenario.getTransitSchedule().getFacilities().get(SenefelderPlatzBstg2StopFacilityId);
		SenefelderPlatzBstg2stopFacility.setLinkId(Id.createLinkId("U2_pt_950827-pt_203004"));

		//U Senefelderplatz Bstggl.1
		Id<TransitStopFacility> SenefelderPlatzBstg1StopFacilityId = Id.create("635307", TransitStopFacility.class);
		TransitStopFacility SenefelderPlatzBstg1stopFacility = scenario.getTransitSchedule().getFacilities().get(SenefelderPlatzBstg1StopFacilityId);
		SenefelderPlatzBstg1stopFacility.setLinkId(Id.createLinkId("U2_pt_651071-pt_635307"));

		//U Märkisches Museum Bstggl.1
		Id<TransitStopFacility> MaerkischesMuseumBstg1StopFacilityId = Id.create("60578", TransitStopFacility.class);
		TransitStopFacility MaerkischesMuseumBstg1stopFacility = scenario.getTransitSchedule().getFacilities().get(MaerkischesMuseumBstg1StopFacilityId);
		MaerkischesMuseumBstg1stopFacility.setLinkId(Id.createLinkId("U2_pt_126113-pt_60578"));




		// Add the transit stops corresponding to the above nodes to the transitSchedule
		transitSchedule.addStopFacility(createTransitStop("987654", nodeAlexanderplatzPl2.getCoord(), false, transitScheduleFactory, "S+U Alexanderplatz Bstggl.2 (U2)", "U2_pt_608245-pt_950826", null));
		transitSchedule.addStopFacility(createTransitStop("123456", nodeRosaLuxemburgPlatzPl2.getCoord(), false, transitScheduleFactory, "U Rosa-Luxemburg-Platz Bstggl.2", "U2_pt_950826-pt_950827", null));
		transitSchedule.addStopFacility(createTransitStop("647655.2", nodeOlympiaStadion.getCoord(), false, transitScheduleFactory, "S Olympiastadion", "pt_647655", "647655"));
		transitSchedule.addStopFacility(createTransitStop("88875.1", nodeZoologischeGarten.getCoord(), false, transitScheduleFactory, "S+U Zoologischer Garten Bhf", "pt_88875", "88875"));


		// Add missing pt link
		// Read the node that already exists in the original network
		// U-Bahn Stations
		Node nodeNeuWestendPl1 = network.getNodes().get(Id.createNodeId("pt_603359"));
		Node nodeOlypiastadionPl3 = network.getNodes().get(Id.createNodeId("pt_128281"));
		Node nodeKlosterstrPl2 = network.getNodes().get(Id.createNodeId("pt_608245"));
		Node nodeSenefelderplatzPl2 = network.getNodes().get(Id.createNodeId("pt_203004"));
		Node nodeEberswalderstrPl1 = network.getNodes().get(Id.createNodeId("pt_651071"));
		Node nodeSenefelderplatzPl1 = network.getNodes().get(Id.createNodeId("pt_635307"));
		Node nodeKlosterstrPl1 = network.getNodes().get(Id.createNodeId("pt_126113"));
		Node nodeMaerkischesMuseumPl1 = network.getNodes().get(Id.createNodeId("pt_60578"));




		//U-Bahn Link
		//U2 Neu Westend (platform 1) -> Olympiastadion (platform 3, middle track)
		network.addLink(createLink(nodeNeuWestendPl1, nodeOlypiastadionPl3, network, "U2_pt_603359-pt_128281"));
		//U2 U Klosterstr. Bstggl.2 -> S+U Alexanderplatz Bstggl.2 (U2)
		network.addLink(createLink(nodeKlosterstrPl2, nodeAlexanderplatzPl2, network, "U2_pt_608245-pt_950826"));
		//U2 S+U Alexanderplatz Bstggl.2 (U2) -> U Rosa-Luxemburg-Platz Bstggl.2
		network.addLink(createLink(nodeAlexanderplatzPl2, nodeRosaLuxemburgPlatzPl2, network, "U2_pt_950826-pt_950827"));
		//U2 U Rosa-Luxemburg-Platz Bstggl.2 -> U Senefelderplatz Bstggl.2
		network.addLink(createLink(nodeRosaLuxemburgPlatzPl2, nodeSenefelderplatzPl2, network, "U2_pt_950827-pt_203004"));
		//U2 U Eberswalder Str. Bstggl.1 -> U Senefelderplatz Bstggl.1
		network.addLink(createLink(nodeEberswalderstrPl1, nodeSenefelderplatzPl1, network, "U2_pt_651071-pt_635307"));
		//U2 U Märkisches Museum Bstggl.1 -> U Klosterstr. Bstggl.1
		network.addLink(createLink(nodeKlosterstrPl1,nodeMaerkischesMuseumPl1, network, "U2_pt_126113-pt_60578"));

		//S-Bahn Link
		//S Olympiastadion (loop)
		network.addLink(createLink(nodeOlympiaStadion, nodeOlympiaStadion, network, "pt_647655"));
		//S+U Zoologischer Garten Bhf (loop)
		network.addLink(createLink(nodeZoologischeGarten, nodeZoologischeGarten, network, "pt_88875"));




		// Remove Link U Eberswalder Str. Bstggl.1 -> U Senefelderplatz Bstggl.2
		network.removeLink(Id.createLinkId("pt_46858"));
		// Remove Link U Märkisches Museum Bstggl.1 -> U Klosterstr. Bstggl.2
		network.removeLink(Id.createLinkId("pt_46860"));
		// Save the updated road network and TransitSchedule to file
		String outputNetworkFilePath = "F:/Masterarbeit/Version 6.3/updated_network.xml";
		String outputTransitScheduleFilePath = "F:/Masterarbeit/Version 6.3/intermediate_transitSchedule.xml";
		new NetworkWriter(network).write(outputNetworkFilePath);
		new TransitScheduleWriter(transitSchedule).writeFile(outputTransitScheduleFilePath);

		System.out.println("New node added and updated network saved to " + outputNetworkFilePath);
	}

	private static Link createLink(Node fromNode, Node toNode, Network network, String linkId){
		double link1Length = CoordUtils.calcEuclideanDistance(fromNode.getCoord(), toNode.getCoord());
		Link link = NetworkUtils.createLink(Id.createLinkId(linkId), fromNode, toNode, network, link1Length, 9.786, 10000, 1);
		link.setAllowedModes(Set.of(TransportMode.pt));

		return link;
	}


	private static TransitStopFacility createTransitStop (String idString, Coord coord, boolean isBlocking,
														  TransitScheduleFactory transitScheduleFactory, String name, String linkIdStr, String stopAreaId){
		Id<TransitStopFacility> transitStopFacilityId = Id.create(idString, TransitStopFacility.class);
		TransitStopFacility stopFacility = transitScheduleFactory.createTransitStopFacility(transitStopFacilityId, coord, isBlocking);
		stopFacility.setName(name);
		stopFacility.setLinkId(Id.createLinkId(linkIdStr));

		//StopAreaId can be null
		if (stopAreaId != null) {
			Id<TransitStopArea> transitStopAreaId = Id.create(stopAreaId, TransitStopArea.class);
			stopFacility.setStopAreaId(transitStopAreaId);
		}





		return stopFacility;
	}



}
