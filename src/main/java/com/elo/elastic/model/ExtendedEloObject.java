package com.elo.elastic.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * The official OIH Documents model + ELO ID/GUID + children for directories.
 * 
 * @author dagnelies
 *
 */
public class ExtendedEloObject extends EloObject {

	@JsonProperty("id")
	@JsonPropertyDescription("ELO Specific ID")
	public int id;
	
	@JsonProperty("guid")
	@JsonPropertyDescription("ELO Specific GUID")
	public String guid;
	
	@JsonProperty("children")
	@JsonPropertyDescription("Child entries")
	public List<ExtendedEloObject> children;
}
