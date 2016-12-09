package fr.dao;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CostsDAO {

	@SuppressWarnings("unchecked")
	public static void getCosts() {
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("/assets/json/costs.json"));

			JSONObject jsonObject = (JSONObject) obj;

			String enclosureCosts_lion = (String) jsonObject.get("enclosureCosts_lion");
			String enclosureCosts_giraffe = (String) jsonObject.get("enclosureCosts_giraffe");
			String enclosureCosts_elephant = (String) jsonObject.get("enclosureCosts_elephant");
			String enclosureCosts_camel = (String) jsonObject.get("enclosureCosts_camel");
			String lionCosts = (String) jsonObject.get("lionCosts");
			String giraffeCosts = (String) jsonObject.get("giraffeCosts");
			String elephantCosts = (String) jsonObject.get("elephantCosts");
			String camelCosts = (String) jsonObject.get("camelCosts");

			System.out.println("Enclosure costs for a lion: " + enclosureCosts_lion);
			System.out.println("Enclosure costs for a giraffe: " + enclosureCosts_giraffe);
			System.out.println("Enclosure costs for an elephant: " + enclosureCosts_elephant);
			System.out.println("Enclosure costs for a camel: " + enclosureCosts_camel);
			System.out.println("Costs for a lion: " + lionCosts);
			System.out.println("Costs for a giraffe: " + giraffeCosts);
			System.out.println("Costs for an elephant: " + elephantCosts);
			System.out.println("Costs for a camel: " + camelCosts);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
