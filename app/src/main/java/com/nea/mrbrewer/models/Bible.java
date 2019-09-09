package com.nea.mrbrewer.models;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bible {

@SerializedName("reference")
@Expose
private String reference;
@SerializedName("verses")
@Expose
private List<Verse> verses = null;
@SerializedName("text")
@Expose
private String text;
@SerializedName("translation_id")
@Expose
private String translationId;
@SerializedName("translation_name")
@Expose
private String translationName;
@SerializedName("translation_note")
@Expose
private String translationNote;

public Bible() {
}

public Bible(String reference, List<Verse> verses, String text, String translationId, String translationName, String translationNote) {
super();
this.reference = reference;
this.verses = verses;
this.text = text;
this.translationId = translationId;
this.translationName = translationName;
this.translationNote = translationNote;
}

public String getReference() {
return reference;
}

public void setReference(String reference) {
this.reference = reference;
}

public List<Verse> getVerses() {
return verses;
}

public void setVerses(List<Verse> verses) {
this.verses = verses;
}

public String getText() {
return text;
}

public void setText(String text) {
this.text = text;
}

public String getTranslationId() {
return translationId;
}

public void setTranslationId(String translationId) {
this.translationId = translationId;
}

public String getTranslationName() {
return translationName;
}

public void setTranslationName(String translationName) {
this.translationName = translationName;
}

public String getTranslationNote() {
return translationNote;
}

public void setTranslationNote(String translationNote) {
this.translationNote = translationNote;
}

}

