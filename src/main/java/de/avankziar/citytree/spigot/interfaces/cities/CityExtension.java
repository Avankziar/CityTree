package main.java.de.avankziar.citytree.spigot.interfaces.cities;

import main.java.de.avankziar.citytree.spigot.interfaces.settings.Cost;

public class CityExtension
{
	private String name;
	private CityExtension.Type cityExtensionType;
	private Cost costs;
	
	public CityExtension(String name, CityExtension.Type cityExtensionType, Cost costs)
	{
		setName(name);
		setCityExtensionType(cityExtensionType);
		setCosts(costs);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public CityExtension.Type getCityExtensionType()
	{
		return cityExtensionType;
	}

	public void setCityExtensionType(CityExtension.Type cityExtensionType)
	{
		this.cityExtensionType = cityExtensionType;
	}
	
	public Cost getCosts()
	{
		return costs;
	}

	public void setCosts(Cost costs)
	{
		this.costs = costs;
	}

	public enum Type 
	{
		DISTRICTRIGHT, PROPERTIYRENT, PROPERTYBUY,
		/*
		 * DISTRICTRIGHT = Das Recht, Distrikte zu erstellen und zu kaufen (Automatisch 1 Distrikt frei)
		 * PROPERTIYRENT = Das Recht, Grundstücke zu erstellen und zu vermieten
		 * PROPERTYBUY =  Das Recht, Grundstücke zu erstellen und zu verkaufen
		 */
		
		PLAYERVERSUSPLAYER, ENTITYVERSUSPLAYER, NOFALLDAMAGE, NOEXPLOSIONDAMAGE, NOFIREDAMAGE,
		/*
		 * PLAYERVERSUSPLAYER = Kein Schaden von Spieler zu Spieler
		 * PLAYERVERSUSENTITY = Kein Schaden von Entity zu Spieler
		 * NOFALLDAMAGE = Keinen Fallschaden am Spieler
		 * NOexpCostLOSIONDAMAGE = Keinen expCostlosionschade am Spieler
		 * NOFIREDAMAGE = Kein Feuerschaden am Spieler
		 */
		
		NOENDEREYES, NOCHORUSFRUITS, NOENDERPEARLS,
		/*
		 * NOENDEREYES = Man darf Enderaugen nicht benutzen
		 * NOCHORUSFRUITS = Man darf Chorusfrüchte nicht benutzen
		 * NOENDERPEARLS = Man darf keine Enderperlen nutzen
		 */
		
		NOSPAWNZOMBIE, NOSPAWNSKELETTON, NOSPAWNCREEPER, NOSPAWNENDERMAN, NOSPAWNWITCH, NOSPAWNPHANTOM, NOSPAWNSLIME,
		NOSPAWNSPIDER, NOSPAWNPILLAGER, NOSPAWNSILVERFISH, 
		/*
		 * NOSPAWN... bedeutet das nicht gespawnt wird
		 */
		
		ANIMALPROTECTION, ELYTRASTOPP, NOEXPLOSION, NOFIREIGNITE,
		/*
		 * ANIMALPROTECTION = Tiere können nur von Stadtmitglieder Schaden erhalten
		 * ELYTRASTOPP = Man kann keine Elytra benutzen
		 * NOexpCostLOSION = Durch explosionen können keine Blöcke mehr zerstört werden
		 * NOFIREIGNITE = Durch Blitze können keine Feuer mehr entstehen
		 * 
		 */
		
		RESTORATION, WORLDMARKER, WEATHERCONTROL, WELCOMEMESSAGE, LEAVEMESSAGE, CITYCHANNEL, TELEPORT, EFFECTCHARGE,
		DONATIONACCESS, BLACKLIST_ENTRANCE, BLACKLIST_RENTBUY, NOSNOW, NOSNOWSET, TRADERIGHT, FLY,
		ADVERTISEMENT;
		
		/*
		 * RESTORATION = Grundstück wiederherstellung
		 * WORLDMARKER = Dynmap Marker erstellen
		 * WEATHERCONTROL = Wetterkontrolle eventuell...
		 * WELCOMEMESSAGE = Beim betreten der Stadt eine Wilkommensnachricht
		 * LEAVEMESSAGE = Beim verlassen der Stadt eine Abschiedsnachricht
		 * CITYCHANNEL = Einen Eigenen Stadtchannel (Scc), mit Zeichen etc., 
		 * Tabelle in mysql citytree um zu tracken in welcher cchanel man ist
		 * TELEPORT = das Recht um Teleport Punkte zu errichten und kaufen zu können (1 bekommt man frei)
		 * EFFECTCHARGE = Die eigenschaft, dass man in der Stadt Effekte aufladen kann => PotionExtender
		 * DONATIONACCESS = man darf nun als Nicht Stadtowner der stadt spenden
		 * BLACKLIST_ENTRANCE =bann für das betreten der Stadt
		 * BLACKLIST_RENTBUY = verbot zum mieten oder kaufen innerhalb der stadt
		 * NOSNOW = Eis schmlizt und Schnee bleibt nicht liegen
		 * NOSNOWSET = Eis schmilzt nicht, und Schnee bleibt liegen
		 * TRADERIGHT = Man kann Handelskisten ausstellen 
		 * (Durch Permission in der Config, kann man die Perms eintragen, die man braucht um Kisten zu erstellen)
		 * FLY = Man kann auf seiner Stadt / Bezirk / Grundstück fliegen
		 * ADVERTISEMENT = Werbung kaufen
		 */
	}
}
