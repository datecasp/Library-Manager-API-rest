package dev.datecasp.libraryManager.helpers;

public class Enumerations
{
    /**
     * Enumeration of the categories a book can be in
     * To add, update or remove categories you can modify
     * the enum, but this could have colateral effects
     * in the database at the memometn
     */
    public enum categories
    {
        HISTORY,
        NATURALS,
        TECHNICAL,
        BESTSELLER,
        SCIFI,
        YOUTH
    }
}
