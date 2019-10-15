package com.elo.elastic.model;

// Generated from: https://github.com/openintegrationhub/Data-and-Domain-Models/blob/master/src/main/schema/documents/extended/Object.json
// Using: http://www.jsonschema2pojo.org/
// NOTE: "policies" was removed from the definition

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
* Object
* <p>
* Objects describe base properties that are used by documents, folders or additional implementations.
*
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"label",
"description",
"baseType",
"parentUid",
"path",
"metadata"
})
public class EloObject {

/**
* Name of the object
*
*/
@JsonProperty("label")
@JsonPropertyDescription("Name of the object")
private String label;
/**
* Additional information describing the object
*
*/
@JsonProperty("description")
@JsonPropertyDescription("Additional information describing the object")
private String description;
/**
* Base type of the object
*
*/
@JsonProperty("baseType")
@JsonPropertyDescription("Base type of the object")
private EloObject.BaseType baseType;
/**
* Id of the parent element if hierarchically organized
*
*/
@JsonProperty("parentUid")
@JsonPropertyDescription("Id of the parent element if hierarchically organized")
private String parentUid;
/**
* Path from root to the objects parent
*
*/
@JsonProperty("path")
@JsonPropertyDescription("Path from root to the objects parent")
private String path;
/**
* Map that contains all metadata as specified by: specification of generic metadata.
*
*/
@JsonProperty("metadata")
@JsonPropertyDescription("Map that contains all metadata as specified by: specification of generic metadata.")
private Metadata metadata;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* Name of the object
*
*/
@JsonProperty("label")
public String getLabel() {
return label;
}

/**
* Name of the object
*
*/
@JsonProperty("label")
public void setLabel(String label) {
this.label = label;
}

/**
* Additional information describing the object
*
*/
@JsonProperty("description")
public String getDescription() {
return description;
}

/**
* Additional information describing the object
*
*/
@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

/**
* Base type of the object
*
*/
@JsonProperty("baseType")
public EloObject.BaseType getBaseType() {
return baseType;
}

/**
* Base type of the object
*
*/
@JsonProperty("baseType")
public void setBaseType(EloObject.BaseType baseType) {
this.baseType = baseType;
}

/**
* Id of the parent element if hierarchically organized
*
*/
@JsonProperty("parentUid")
public String getParentUid() {
return parentUid;
}

/**
* Id of the parent element if hierarchically organized
*
*/
@JsonProperty("parentUid")
public void setParentUid(String parentUid) {
this.parentUid = parentUid;
}

/**
* Path from root to the objects parent
*
*/
@JsonProperty("path")
public String getPath() {
return path;
}

/**
* Path from root to the objects parent
*
*/
@JsonProperty("path")
public void setPath(String path) {
this.path = path;
}

/**
* Map that contains all metadata as specified by: specification of generic metadata.
*
*/
@JsonProperty("metadata")
public Metadata getMetadata() {
return metadata;
}

/**
* Map that contains all metadata as specified by: specification of generic metadata.
*
*/
@JsonProperty("metadata")
public void setMetadata(Metadata metadata) {
this.metadata = metadata;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

public enum BaseType {

DOCUMENT("document"),
FOLDER("folder");
private final String value;
private final static Map<String, EloObject.BaseType> CONSTANTS = new HashMap<String, EloObject.BaseType>();

static {
for (EloObject.BaseType c: values()) {
CONSTANTS.put(c.value, c);
}
}

private BaseType(String value) {
this.value = value;
}

@Override
public String toString() {
return this.value;
}

@JsonValue
public String value() {
return this.value;
}

@JsonCreator
public static EloObject.BaseType fromValue(String value) {
EloObject.BaseType constant = CONSTANTS.get(value);
if (constant == null) {
throw new IllegalArgumentException(value);
} else {
return constant;
}
}

}

}
