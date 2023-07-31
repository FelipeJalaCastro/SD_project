package com.backendsd.backendsd.db;

import com.backendsd.backendsd.entity.Departure;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoRepo {

    public static final String DB = "exampledb";
    public static final String Collection = "departure";

    private MongoClient client;

    public List<String> getDepartures(){
        final List<String> list = new ArrayList<String>();
        final MongoCollection<Document> data = client.getDatabase(DB).getCollection(Collection);
        data.find().map(Document::toJson).forEach(list::add);
        return list;
    }
}
