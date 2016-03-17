package com.NathanMeyer.DataStorage;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class DataStorage{
    public static void main(String[]args){
        loadXml();
        parseXml();
        deleteXml();
    }
    public static loadXml(){
        DocumentBuilderFactory xmlBuilder = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = xmlBuilder.newDocumentBuilder();
    }
    public static parseXml(){
        // code
    }
    public static deleteXml(){
        // code
    }
}