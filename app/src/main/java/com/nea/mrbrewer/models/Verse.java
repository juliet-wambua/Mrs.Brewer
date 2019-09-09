package com.nea.mrbrewer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Verse {

    @SerializedName("book_id")
    @Expose
    private String bookId;
    @SerializedName("book_name")
    @Expose
    private String bookName;
    @SerializedName("chapter")
    @Expose
    private Integer chapter;
    @SerializedName("verse")
    @Expose
    private Integer verse;
    @SerializedName("text")
    @Expose
    private String text;

    public Verse(String bookId, String bookName, Integer chapter, Integer verse, String text) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.chapter = chapter;
        this.verse = verse;
        this.text = text;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public Integer getVerse() {
        return verse;
    }

    public void setVerse(Integer verse) {
        this.verse = verse;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}