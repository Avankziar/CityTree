package main.java.de.avankziar.citytree.spigot.interfaces.guirelevant;

import java.util.ArrayList;

import org.bukkit.inventory.Inventory;

public class Gui //Das eigentliche Gui, um Inventare(Gui) sofort beziehen zu können
{
	private String title; //Inventar name ohne eingesetzte replacer
	private Type guiType;
	private Inventory inventory;
	private ArrayList<GuiFunction> guiFunction;
	public static ArrayList<Gui> allGui;
	
	public Gui(String title, Type guiType, Inventory inventory, ArrayList<GuiFunction> guiFunction)
	{
		setTitle(title);
		setGuiType(guiType);
		setInventory(inventory);
		setGuiFunction(guiFunction);
	}
	
	public static Gui getGui(Type guiType)
	{
		Gui g = null;
		for(Gui gui : allGui)
		{
			if(gui.getGuiType() == gui.getGuiType())
			{
				g = gui;
				break;
			}
		}
		return g;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Inventory getInventory()
	{
		return inventory;
	}

	public void setInventory(Inventory inventory)
	{
		this.inventory = inventory;
	}

	public ArrayList<GuiFunction> getGuiFunction()
	{
		return guiFunction;
	}

	public void setGuiFunction(ArrayList<GuiFunction> guiFunction)
	{
		this.guiFunction = guiFunction;
	}

	public Type getGuiType()
	{
		return guiType;
	}

	public void setGuiType(Type guiType)
	{
		this.guiType = guiType;
	}
	
	public enum Type
	{
		//* = Nur für Eigentümer (Owner, CoOwner, Supremelandlord, landlord) sichtbar
		//+ = Nur für Staff (Teammitglieder mit perm x.y.z) sichtbar
		//CE = Geht in einen ChatEditor rein
		//NG = Geht in ein neues Gui rein
		
		NONE, 
		// => Keins
		CITYTREE_MAIN, 
		/* => /stadt
		 * GUI: Globale StadtÜbersicht NG, Freie Grundstücke NG, Deine Städte NG, Deine Propertys NG,
		 * Vermessungsmodus de-aktivieren(Für Districte, Propertys), Stadt an der location xy, etc.
		 */
		CITY_GLOBALLIST, 
		/* Globale Städteliste
		 * GUI: City xy NG,
		 * Vorherige Seite, Zurück, Nächste Seite
		 */
		CITY_MAIN, 
		/*
		 * Die Stadtübersicht der Stadt x: 
		 * GUI: Info(Icon[als ItemStack], Id, Name, Creator, Owner, Citylevel, Fläche, Eckpunkte,
		 * Gründungszeit, KannImLevelAufsteigenWahrheitswert),
		 * Info(TotalPreis), Info(HatExtensions), Info(StockPile)*,
		 * Ändern des Namen*+ CE, Icon ändern* CE, StadtImLevelAufsteigenLassen, StadtVergrößern NG, 
		 * DistrictKaufen(Anzahl) *NG, PropertyKaufen(Anzahl) *NG, TeleportKaufen(Anzahl) *NG, StadtÜbergeben CE, StadtLöschen CE, 
		 * CoOwnerliste NG, DistrictLordListe NG, TeleportListe NG, Marktschreierliste NG, Werbung anpassen *NG, Zurück
		 */
		CITY_OWNLIST, 
		/* Persönlich eigene Städte
		 * GUI: GUI: City xy NG,
		 * Vorherige Seite, Zurück, Nächste Seite
		 */
		CITY_BUYEXPANSION, //Das Gui für die Stadterweiterung, mit Knöpfe als Zahlen(Erhöhen und verkleinern)
		/*
		 * Name des Inventars: Erweiterung
		 * GUI: VerringernUm1, VerringernUm5, VerringernUm10,
		 * Bestätigen(Lore=BlockReihen,Kosten), Zurück
		 * ErhöhenUm1, ErhöhenUm5, ErhöhenUm10
		 */
		CITY_BUYDISTRICT,
		/*
		 * Name des Inventars: Erweiterung
		 * GUI: VerringernUm1, VerringernUm5, VerringernUm10,
		 * Bestätigen(Lore=Anzahl an Districte,Kosten), Zurück
		 * ErhöhenUm1, ErhöhenUm5, ErhöhenUm10
		 */
		CITY_BUYPROPERTY,
		/*
		 * Name des Inventars: Erweiterung
		 * GUI: VerringernUm1, VerringernUm5, VerringernUm10,
		 * Bestätigen(Lore=Anzahl an Propertys,Kosten), Zurück
		 * ErhöhenUm1, ErhöhenUm5, ErhöhenUm10
		 */
		CITY_BUYTELEPORT,
		/*
		 * Name des Inventars: Erweiterung
		 * GUI: VerringernUm1, VerringernUm5, VerringernUm10,
		 * Bestätigen(Lore=Anzahl an Teleports,Kosten), Zurück
		 * ErhöhenUm1, ErhöhenUm5, ErhöhenUm10
		 */
		CITY_BUYADVERTISMENT,
		/*
		 * Name des Inventars: Erweiterung
		 * GUI: VerringernUm1, VerringernUm5, VerringernUm10,
		 * Bestätigen(Lore=Anzahl an Teleports,Kosten), Zurück
		 * ErhöhenUm1, ErhöhenUm5, ErhöhenUm10
		 */
		CITY_DISTRICTLIST, 
		/* Alle Districte einer Stadt
		 * District xy NG,
		 * Vorherige Seite, Zurück, Neu hinzufügen*, nächste Seite
		 */
		CITY_PROPERTYLIST, 
		/* Alle Property einer Stadt
		 * Property xy NG,
		 * Vorherige Seite, Zurück, Neu hinzufügen*, nächste Seite
		 */
		CITY_TELEPORTLIST, 
		/* Alle Property einer Stadt
		 * Teleport xy(Linksklick teleport[+*], rechts nurFürCityStaff Toggle, shiftlinks Ändern*, drop löschen*),
		 * Vorherige Seite, Zurück, Neu hinzufügen*, nächste Seite
		 */
		CITY_BARKERLIST, 
		/* Alle Marktschreier
		 * GUI: Barker xy(links Gehaltanpassen NG, drop löschen),
		 * Vorherige Seite, Zurück, Neu hinzufügen*, nächste Seite
		 */
		CITY_ADVERTISMENTLIST,
		/* Alle StadtWerbungen
		 * GUI: Werbung xy(links werben, shiftlinks Ändern, drop löschen)*,
		 * Vorherige Seite, zurück, Neu hinzufügen*, nächste seite 
		 */
		DISTRICT_MAIN, 
		/* Die Districtübersicht des Districts y
		 * GUI: Namen ändern *CE, Positionen Ändern*, Districlords NG, Propertyliste NG, Löschen NG,
		 */
		CITY_EXTENSIONHASLIST, 
		/* Alle Extension, die die Stadt hat
		 * GUI: Extension xy,
		 * Vorherige Seite, Zurück, Nächste Seite
		 */
		CITY_EXTENSIONCANLIST, 
		/* Alle Extension, die die Stadt haben kann und noch nicht hat
		 * GUI: ExtensionList xy(links Extensionkaufen*),
		 * Vorherige Seite, Zurück, Nächste Seite
		 */
		CITY_COOWNERLIST, 
		/* Alle Coowner
		 * GUI: Coowner xy(links löschen*),
		 * Vorherige Seite, Zurück, Nächste Seite
		 */
		CITY_DISTRICTLORDLIST, 
		/* Alle Districtlords
		 * GUI: DistrictLord(links Gehaltanpassen NG, drop löschen),
		 * vorherige Seite, zurück, nächste seite
		 */
		//Keine Propertylandlords, da es ja die Propertylist gibt
		DISTRICT_DISTRICTLORDLIST,
		/* Liste Aller Districtlords von district
		 * GUI: Districtlord xy(
		 * vorherige Seite, neu hinzufügen *CE, nächste Seite
		 */
		DISTRICT_PROPERTYLIST, 
		/* Liste aller Propertys in dem District
		 * GUI: Property xy(),
		 * vorherige Seite, zurück, nächste seite
		 */
		
		PROPERTY_MAIN, 
		/* Das Hauptgui des Property
		 * GUI: 
		 */
		PROPERTY_GLOBALLIST, //Globale Grundstückliste, die miet oder kaufbar ist
		PROPERTY_OWNLIST, //Persönliche eigene Grundstücke (als Landlord , Roommate etc.)
		PROPERTY_LANDLORDLIST, //Vom Property die Liste aller Landlords
		PROPERTY_ROOMMATELIST, //Vom Property die liste aller Roommate
		
		CITYEXTENSIONLIST, //Auflistung aller möglichen Extension
		CIYTLEVELLIST, //Auflistung aller Citylevels
		
		
		BARKER_SALARY, //Anpassung des Gehalts des marktschreiers
		DISTRICTLORD_SALARY, //Anpassung des Gehalt des Districtlords
		
		PLAYER_GLOBALLIST, //Die Komplette Offline Spieler liste
		PLAYER_PERSONALLIST, //Die Schnellauswahlliste von Offlinespielern, per Mysql.
		MATERIAL_LIST, //Die Minecraft Materiallist
		
		ZONE_MAIN, //Zonen hauptgui
		
		CITY_LORE,
	}
}
